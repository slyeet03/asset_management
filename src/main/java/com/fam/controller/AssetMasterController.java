package com.fam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import com.fam.entity.Auditlog;
import com.fam.entity.Paramast;
import com.fam.service.AssetCategoryMasterService;
import com.fam.service.AssetSubCategoryMasterService;
import com.fam.service.AssetMasterService;
import com.fam.entity.AssetCategoryMaster;
import com.fam.entity.AssetMaster;
import com.fam.entity.AssetSubCategoryMaster;
import com.fam.service.ParamastService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.JsonObject;

@Controller
public class AssetMasterController {

	@Autowired
	ParamastService paramastService;

	@Autowired
	AssetCategoryMasterService assetCategoryMasterService;

	@Autowired
	AssetSubCategoryMasterService assetSubCategoryMasterService;

	@Autowired
	AssetMasterService assetMasterService;

	@RequestMapping(value = "/AssetPurchaseView.htm", method = RequestMethod.GET)
	public ModelAndView AssetPurchaseView(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView mv = new ModelAndView("Transaction/AssetPurchase");
		AssetMaster assetMaster = new AssetMaster();
		Map<String, ?> redirectAttribute = RequestContextUtils.getInputFlashMap(request);
		String disable = "0", Update = "1";
		String recordid = "";
		String Userlevel = request.getSession().getAttribute("userlevel").toString();
		try {
			if ((Userlevel.equalsIgnoreCase("6"))) {
				try {
					recordid = redirectAttribute.get("recordid").toString();
				} catch (Exception e) {
					return mv = new ModelAndView("master/404");
				}
			} else if ((Userlevel.equalsIgnoreCase("5"))) {

				recordid = redirectAttribute.get("recordid").toString();

			}
			if (recordid != null && recordid.length() > 0) {
				String prev = redirectAttribute.get("prev").toString();
				String next = redirectAttribute.get("next").toString();
				String recstatus = redirectAttribute.get("recstatus").toString();
				if (recstatus.trim().equalsIgnoreCase(RecordStatus.MAKER)
						|| recstatus.trim().equalsIgnoreCase(RecordStatus.CHECKER)) {
					disable = "1";
					Update = "2";
				} else {
					disable = "0";
					Update = "1";
				}
				assetMaster = this.assetMasterService.getAsset(Long.parseLong(recordid));
				mv.addObject("assetid", assetMaster.getAssetid());
				mv.addObject("branchid", assetMaster.getBranchid());
				mv.addObject("prev", prev);
				mv.addObject("Update", Update);
				mv.addObject("next", next);
				mv.addObject("recstatus", recstatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String code = assetMasterService.getAssetId();
			mv.addObject("assetid", code);
			String branchid = assetMasterService.getBranchId();
			mv.addObject("branchid", branchid);
		}

		String[] data = new String[] { "DEPREMETH" };
		String[] paratype = new String[] { "ASSETTYPE" };

		String extras11 = null;
		String extra2 = null;
		List<Paramast> paramastlist = paramastService.getparamast(data, extras11);
		List<Paramast> paramastlist1 = paramastService.getparaname(paratype, extra2);

		Map<String, String> depremeth = new LinkedHashMap<>();
		for (Iterator<Paramast> iterator = paramastlist.iterator(); iterator.hasNext();) {
			Paramast paramast = iterator.next();
			if (paramast.getParatype().equalsIgnoreCase("DEPREMETH")) {
				depremeth.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getSdesc());
			}
		}
		Map<String, String> assettype = new LinkedHashMap<>();
		for (Iterator<Paramast> iterator = paramastlist1.iterator(); iterator.hasNext();) {
			Paramast paramast = iterator.next();
			if (paramast.getParatype().equalsIgnoreCase("ASSETTYPE")) {
				assettype.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getSdesc());
			}
		}
		List<AssetCategoryMaster> assetCatList = assetCategoryMasterService.getAssetCategorylist(RecordStatus.APPROVER);
		List<AssetSubCategoryMaster> assetSubCatlist = assetSubCategoryMasterService
				.getAssetSubCategorylist(RecordStatus.MAKER);
		mv.addObject("assetcatlist", assetCatList);
		mv.addObject("assetSubCatlist", assetSubCatlist);
		mv.addObject("Depremeth", depremeth);
		mv.addObject("assettype", assettype);
		mv.addObject("Assetmastercommandname", assetMaster);
		mv.addObject("disable", disable);
		return mv;
	}

	@RequestMapping(value = "/AssetPurchaseDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String AssetCategoryMasterDetail(@ModelAttribute AssetMaster assetMaster,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update;
		try {
			update = request.getParameter("Update");
			if (update != null && update.equalsIgnoreCase("1")) {
				try {
					assetMaster.setRecstatus(RecordStatus.MAKER);
					assetMaster.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					assetMaster.setMakerdate(new Date());
					assetMaster.setMakertime(simpleTimeFormat.format(new Date()));
					assetMaster.setMakerid(userId);
					assetMaster.setMakerip(userIp);
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					this.assetMasterService.updateAssetMaster(assetMaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg", Messages.RecordUpdation);
				} catch (Exception exception) {
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", Messages.RecordUnUpdation);
				}
			} else if (update.equalsIgnoreCase("2")) {

				String Action = request.getParameter("action");
				String prev = request.getParameter("prev");
				String next = request.getParameter("next");
				String recstatus;
				if (Action.equalsIgnoreCase("Approve")) {
					recstatus = next;
				} else {
					recstatus = prev;
				}
				String[] authorizedValue = request.getParameterValues("recordid");
				List<Long> recordids = new ArrayList<Long>();
				for (int i = 0; i < authorizedValue.length; i++) {
					recordids.add(Long.parseLong(authorizedValue[i]));
				}
				try {

					int numberOfRecordsUpdated = this.assetMasterService.updateAssetMaster(recordids, recstatus,
							new Date(), simpleTimeFormat.format(new Date()), userId, userIp,
							Integer.parseInt(request.getSession().getAttribute("userlevel").toString()));
					jsonObject.addProperty("SaveStatus", "1");
					if (Action.equalsIgnoreCase("reject")) {
						System.out.println("Number Of Records Rejected : " + numberOfRecordsUpdated);
						jsonObject.addProperty("successMsg", Messages.RecordRejected);
					} else if (Action.equalsIgnoreCase("Approve")) {
						System.out.println("Number Of Records Approved : " + numberOfRecordsUpdated);
						jsonObject.addProperty("successMsg", Messages.RecordApproved);
					}

				} catch (Exception e) {
					e.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", e.getMessage());
				}
			} else {
				try {

					assetMaster.setRecstatus(RecordStatus.MAKER);
					assetMaster.setRolename(request.getSession().getAttribute("role").toString());
					assetMaster.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					assetMaster.setMakerdate(new Date());
					assetMaster.setMakertime(simpleTimeFormat.format(new Date()));
					assetMaster.setAssetpodate(assetMaster.getAssetpodate());
					assetMaster.setAssetinvoicedate(assetMaster.getAssetinvoicedate());
					assetMaster.setMakerid(userId);
					assetMaster.setMakerip(userIp);
					this.assetMasterService.insertAssetMaster(assetMaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg", Messages.RecordInsertion);
				} catch (Exception exception) {
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", Messages.RecordUInsertion);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@RequestMapping(value = "/AssetMasterGrid.htm", method = RequestMethod.GET)
	public RedirectView AssetmasterGrid(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "Transaction/AssetMasterGrid");
		String recstatus = request.getParameter("recstatus");
		String prev = request.getParameter("prev");
		String next = request.getParameter("next");
		String Update = request.getParameter("Update");
		List<AssetMaster> ls_assetCat = assetMasterService.getAssetlist(recstatus);
		HashMap<String, AssetMaster> um_haHashMap = new HashMap<String, AssetMaster>();
		ls_assetCat.forEach(assetMast -> um_haHashMap.put(String.valueOf(assetMast.getRecordid()), assetMast));
		if (ls_assetCat.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, AssetMaster> map = new TreeMap<String, AssetMaster>(um_haHashMap);
		redirectAttributes.addFlashAttribute("list_vc", map);
		redirectAttributes.addFlashAttribute("prev", prev);
		redirectAttributes.addFlashAttribute("Update", Update);
		redirectAttributes.addFlashAttribute("next", next);
		redirectAttributes.addFlashAttribute("recstatus", recstatus);
		return rv;
	}

	@RequestMapping(value = "/UpdateAssetMaster.htm", method = RequestMethod.POST)
	public RedirectView UpdateAssetMaster(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		String recordid = request.getParameter("recordid");
		RedirectView rv = new RedirectView("AssetPurchaseView.htm");
		redirectAttributes.addFlashAttribute("recordid", recordid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}

}

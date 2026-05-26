package com.fam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.fam.entity.AssetCategoryMaster;
import com.fam.entity.Auditlog;
import com.fam.entity.Paramast;
import com.fam.service.AssetCategoryMasterService;
import com.fam.service.ParamastService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.JsonObject;

@Controller
public class AssetCategorymasterController {

	@Autowired
	AssetCategoryMasterService assetCategoryMasterService;

	@Autowired
	ParamastService paramastService;

	@SuppressWarnings("removal")
	@GetMapping(value = "/AssetCategoryMasterView.htm")
	public ModelAndView AssetCategoryMasterView(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/AssetCategorymaster");
		AssetCategoryMaster assetCategoryMaster = new AssetCategoryMaster();
		String extras1 = null;
		
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
				assetCategoryMaster = assetCategoryMasterService.getAssetCategory(new Long(recordid));
				mv.addObject("assetCategoryCode", assetCategoryMaster.getAssetcategorycode());
				mv.addObject("recordid", recordid);
				mv.addObject("prev", prev);
				mv.addObject("Update", Update);
				mv.addObject("next", next);
				mv.addObject("recstatus", recstatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String code = assetCategoryMasterService.getAssetCategoryCode();
			mv.addObject("assetCategoryCode", code);
		}
		String[] data = new String[] { "DEPREMETH" };
		List<Paramast> paramastlist = paramastService.getparamast(data, extras1);
		mv.addObject("Depremeth", paramastlist);
		mv.addObject("Assetcategorymastercommandname",assetCategoryMaster);
		mv.addObject("disable", disable);
		return mv;
	}
	@RequestMapping(value = "/AssetCategoryMasterDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String AssetCategoryMasterDetail(@ModelAttribute AssetCategoryMaster assetCategoryMaster, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update="";
		try {
			update = request.getParameter("Update");
			if (update != null && update.equalsIgnoreCase("1")) {
				try {
					assetCategoryMaster.setRecstatus(RecordStatus.MAKER);
					assetCategoryMaster.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					assetCategoryMaster.setMakerdate(new Date());
					assetCategoryMaster.setMakertime(simpleTimeFormat.format(new Date()));
					assetCategoryMaster.setMakerid(userId);
					assetCategoryMaster.setMakerip(userIp);					
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					assetCategoryMasterService.updateAssetCategory(assetCategoryMaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordUpdation );
				} catch (Exception exception) {
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", Messages.RecordUnUpdation);
				}
			} else if (update.equalsIgnoreCase("2")) {
				
				String Action = request.getParameter("action"), prev = request.getParameter("prev"),
						next = request.getParameter("next"), recstatus;
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
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					assetCategoryMasterService.updateAssetCategory(recordids, recstatus, new Date(),
							simpleTimeFormat.format(new Date()), userId, userIp,
							Integer.parseInt(request.getSession().getAttribute("userlevel").toString()));
					
					jsonObject.addProperty("SaveStatus", "1");
					if (Action.equalsIgnoreCase("reject")) {
						jsonObject.addProperty("successMsg", Messages.RecordRejected);
					} else if (Action.equalsIgnoreCase("Approve")) {
						jsonObject.addProperty("successMsg", Messages.RecordApproved);
					}
				} catch (Exception e) {
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", e.getMessage());
				}
			} else {
				try {
					assetCategoryMaster.setRecstatus(RecordStatus.MAKER);
					assetCategoryMaster.setRolename(request.getSession().getAttribute("role").toString());
					assetCategoryMaster.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					assetCategoryMaster.setMakerdate(new Date());
					assetCategoryMaster.setMakertime(simpleTimeFormat.format(new Date()));
					assetCategoryMaster.setMakerid(userId);
					assetCategoryMaster.setMakerip(userIp);
					//assetCategoryMaster.setAssetcategoryid(Long.parseLong(assetCategoryMaster.getAssetcategorycode()));
					assetCategoryMasterService.insertAssetCategory(assetCategoryMaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordInsertion );
				} catch (Exception exception) {
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", Messages.RecordUInsertion);
				}
			}
		} catch (Exception e) {
		}

		return jsonObject.toString();
	}

	@RequestMapping(value = "/UpdateAssetCategoryMaster.htm", method = RequestMethod.POST)
	public RedirectView UpdateAssetCategoryMaster(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		String recordid = request.getParameter("recordid");
		RedirectView rv = new RedirectView("AssetCategoryMasterView.htm");
		redirectAttributes.addFlashAttribute("recordid", recordid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}

	@RequestMapping(value = "/AssetCategoryMasterGrid.htm", method = RequestMethod.GET)
	public RedirectView AssetCategoryrmasterGrid(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "GeneralMasters/AssetCategoryMasterGrid");
		String recstatus = request.getParameter("recstatus");
		String prev = request.getParameter("prev");
		String next = request.getParameter("next");
		String Update = request.getParameter("Update");
		List<AssetCategoryMaster> ls_assetCat=assetCategoryMasterService.getAssetCategorylist(recstatus);
		HashMap<String,AssetCategoryMaster> um_haHashMap = new HashMap<String, AssetCategoryMaster>();
		ls_assetCat.forEach(assetCat -> um_haHashMap.put(String.valueOf(assetCat.getRecordid()), assetCat));
		if (ls_assetCat.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, AssetCategoryMaster> map = new TreeMap<String,AssetCategoryMaster>(um_haHashMap);
		redirectAttributes.addFlashAttribute("list_vc", map);
		redirectAttributes.addFlashAttribute("prev", prev);
		redirectAttributes.addFlashAttribute("Update", Update);
		redirectAttributes.addFlashAttribute("next", next);
		redirectAttributes.addFlashAttribute("recstatus", recstatus);
		return rv;
	}

}

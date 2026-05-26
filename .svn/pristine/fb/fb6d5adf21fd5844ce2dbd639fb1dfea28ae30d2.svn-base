package com.fam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.fam.entity.AssetDepartment;
import com.fam.entity.Auditlog;
import com.fam.entity.Branchmaster;
import com.fam.entity.CategoryAccountDetails;
import com.fam.service.AssetCategoryMasterService;
import com.fam.service.AssetDepartmentMasterService;
import com.fam.service.BGLMasterService;
import com.fam.service.BranchmasterService;
import com.fam.service.CategoryAccountDetailsService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class CategoryAccountDetailsController {

	@Autowired
	private BGLMasterService bglMasterService;

	@Autowired
	private BranchmasterService branchmasterService;

	@Autowired
	private AssetCategoryMasterService assetCategoryMasterService;

	@Autowired
	private CategoryAccountDetailsService categoryAccountDetailsService;

	@Autowired
	private AssetDepartmentMasterService assetDepartmentMasterService;

	@GetMapping(value = "/CategoryAccountDetailsView.htm")
	public ModelAndView CategoryAccountDetailsView(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/CategoryAccountDetails");
		CategoryAccountDetails categoryAccountDetails = new CategoryAccountDetails();

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
				System.out.println("RecordId:- " + Long.parseLong(recordid));
				categoryAccountDetails = this.categoryAccountDetailsService
						.getCategoryAccountDetails(Long.parseLong(recordid));
				mv.addObject("recordid", recordid);
				mv.addObject("prev", prev);
				mv.addObject("Update", Update);
				mv.addObject("next", next);
				mv.addObject("recstatus", recstatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		LinkedHashMap<String, String> Bgllst = new LinkedHashMap<String, String>();
		List<Object[]> bglparas = this.bglMasterService.getBGLMasterList("5");
		for (Object[] obj : bglparas) {
			Bgllst.put(obj[0].toString(), obj[1].toString());
		}
		List<Branchmaster> branchList = this.branchmasterService.getBranchmasterlist(RecordStatus.APPROVER);
		List<AssetDepartment> departmentList = this.assetDepartmentMasterService
				.getAssetDepartmentlist(RecordStatus.APPROVER);
		List<AssetCategoryMaster> assetCategoryList = this.assetCategoryMasterService
				.getAssetCategorylist(RecordStatus.APPROVER);
		mv.addObject("branchList", branchList);
		mv.addObject("departmentList", departmentList);
		mv.addObject("assetCategoryList", assetCategoryList);
		mv.addObject("CategoryAccountDetailscommandname", categoryAccountDetails);
		mv.addObject("Bgllst", Bgllst);
		mv.addObject("disable", disable);
		return mv;
	}

	@RequestMapping(value = "/CategoryAccountDetails.htm", method = RequestMethod.POST)
	public @ResponseBody String CategoryAccountDetail(@ModelAttribute CategoryAccountDetails categoryAccountDetails,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update = "";
		try {
			update = request.getParameter("Update");
			System.out.println("value of update" + update);
			if (update != null && update.equalsIgnoreCase("1")) {
				try {
					categoryAccountDetails.setRecstatus(RecordStatus.MAKER);
					categoryAccountDetails.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					categoryAccountDetails.setMakerdate(new Date());
					categoryAccountDetails.setMakertime(simpleTimeFormat.format(new Date()));
					categoryAccountDetails.setMakerid(userId);
					categoryAccountDetails.setMakerip(userIp);
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					categoryAccountDetailsService.updateCategoryAccountDetails(categoryAccountDetails);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg", Messages.RecordUpdation);
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
					categoryAccountDetailsService.updateCategoryAccountDetails(recordids, recstatus, new Date(),
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
					categoryAccountDetails.setRecstatus(RecordStatus.MAKER);
					categoryAccountDetails.setRolename(request.getSession().getAttribute("role").toString());
					categoryAccountDetails.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					categoryAccountDetails.setMakerdate(new Date());
					categoryAccountDetails.setMakertime(simpleTimeFormat.format(new Date()));
					categoryAccountDetails.setMakerid(userId);
					categoryAccountDetails.setMakerip(userIp);
					// categoryAccountDetails.setRecordid(categoryAccountDetails.getAccntdetailsid());
					categoryAccountDetailsService.insertCategoryAccountDetails(categoryAccountDetails);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg", Messages.RecordInsertion);
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

	@RequestMapping(value = "/UpdateCategoryAccountDetails.htm", method = RequestMethod.POST)
	public RedirectView UpdateCategoryAccountDetails(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		String recordid = request.getParameter("recordid");
		RedirectView rv = new RedirectView("CategoryAccountDetailsView.htm");
		redirectAttributes.addFlashAttribute("recordid", recordid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}

	@RequestMapping(value = "/CategoryAccountDetailsGrid.htm", method = RequestMethod.GET)
	public RedirectView CategoryAccountDetailsGrid(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "GeneralMasters/CategoryAccountDetailsGrid");
		String recstatus = request.getParameter("recstatus");
		String prev = request.getParameter("prev");
		String next = request.getParameter("next");
		String Update = request.getParameter("Update");
		List<CategoryAccountDetails> ls_assetCat = categoryAccountDetailsService
				.getCategoryAccountDetailslist(recstatus);
		HashMap<String, CategoryAccountDetails> um_haHashMap = new HashMap<String, CategoryAccountDetails>();
		ls_assetCat.forEach(assetCat -> um_haHashMap.put(String.valueOf(assetCat.getRecordid()), assetCat));
		if (ls_assetCat.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, CategoryAccountDetails> map = new TreeMap<String, CategoryAccountDetails>(um_haHashMap);
		map.forEach((r,v)->System.out.println("key id: "+r+" categoryid: "+v.getCategoryid()));
		redirectAttributes.addFlashAttribute("list_vc", map);
		redirectAttributes.addFlashAttribute("prev", prev);
		redirectAttributes.addFlashAttribute("Update", Update);
		redirectAttributes.addFlashAttribute("next", next);
		redirectAttributes.addFlashAttribute("recstatus", recstatus);
		return rv;
	}

	@RequestMapping(value = "/getCategoryByAssetBranch.json", method = RequestMethod.POST)
	public @ResponseBody String getCategoryByAssetBranch(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String branchcode = request.getParameter("branchcode");
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		List<AssetCategoryMaster> assetList = assetCategoryMasterService.getAssetCatByBranch(branchcode);
		JsonElement number = gson.toJsonTree(assetList);
		jsonObject.add("detail", number);
		return jsonObject.toString();
	}

}

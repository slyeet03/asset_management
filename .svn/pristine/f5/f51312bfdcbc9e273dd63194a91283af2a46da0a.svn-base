package com.fam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fam.entity.Organization;
import com.fam.entity.Paramast;
import com.fam.service.OrganizationService;
import com.fam.service.ParamastService;
import com.fam.values.RecordStatus;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.fam.filter.ASSET_MANAGEMENTConstants;

@Controller
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private ParamastService paramastService;

	@RequestMapping(value = "/OrganizationMasterEdit.htm", method = RequestMethod.GET)
	public ModelAndView OrganizationMasterEdit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/Organization");
		Organization organization = this.organizationService.getOrganizationDetail();
		String disable = "0", Update = "1";
		String UserLevel = request.getSession().getAttribute("userlevel").toString();
		if ((Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_1 && Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_5)
		   || (Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_21 && Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_25)) {
			disable = RecordStatus.ENABLE;
			Update = RecordStatus.UPDATE_EDIT;
		} else if ((Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_6 && Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_10)
				|| (Integer.parseInt(UserLevel) >= ASSET_MANAGEMENTConstants.userlevel_26 && Integer.parseInt(UserLevel) <= ASSET_MANAGEMENTConstants.userlevel_30)) {
			disable = RecordStatus.DISABLE;
			Update = RecordStatus.UPDATE_NOTEDIT;
		}
		mv.addObject("disable", disable);
		mv.addObject("Update", Update);
		List<Paramast> countryList = this.paramastService.getparamast(new String[] { "COUNTRY" }, null);
		List<Paramast> stateList = this.paramastService.getparamast(new String[] { "STATE" }, "1");
		List<Paramast> cityList = this.paramastService.getparamast(new String[] { "CITY" },
				organization.getState().toString());
		List<Paramast> allParamast = new ArrayList<Paramast>();
		allParamast.addAll(countryList);
		allParamast.addAll(stateList);
		allParamast.addAll(cityList);
		Map<String, String> stateHashMap = new LinkedHashMap<String, String>();
		Map<String, String> cityHashMap = new LinkedHashMap<String, String>();
		Map<String, String> countryHashMap = new LinkedHashMap<String, String>();
		for (Iterator<Paramast> iterator = allParamast.iterator(); iterator.hasNext();) {
			Paramast paramast = (Paramast) iterator.next();
			if (paramast.getParatype().equalsIgnoreCase("STATE")) {
				stateHashMap.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getLdesc());
			} else if (paramast.getParatype().equalsIgnoreCase("CITY")) {
				cityHashMap.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getLdesc());
			} else if (paramast.getParatype().equalsIgnoreCase("COUNTRY")) {
				countryHashMap.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getLdesc());
			}
		}
		mv.addObject("stateHashMap", stateHashMap);
		mv.addObject("cityHashMap", cityHashMap);
		mv.addObject("countryHashMap", countryHashMap);

		try {
			mv.addObject("Organization", organization);
		} catch (Exception e) {
			mv.addObject("Organization", new Organization());
		}
		return mv;
	}

	@RequestMapping(value = "/OrganizationMasterDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String OrganizationMasterDetail(@ModelAttribute Organization organization,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update;
		update = request.getParameter("Update");
		if (update.equalsIgnoreCase("1")) {
			try {
				organization.setRecstatus(RecordStatus.MAKER);
				organization.setMakerdate(new Date());
				organization.setMakertime(simpleTimeFormat.format(new Date()));
				organization.setMakerid(userId);
				organization.setMakerip(userIp);
				organization.setCountry("1");

				this.organizationService.updateOrganization(organization);
				// tushar start 11-04-2023
				String tranStatus = "";
				try {
					if (organization.getTransactions() != null
							&& organization.getTransactions().equalsIgnoreCase("1")) {
						tranStatus = "TRANSACTION IS ON";
					} else if (organization.getTransactions() == null) {
						tranStatus = "TRANSACTION IS OFF";
					}
				} catch (Exception exception) {
					tranStatus = "";
				}
				request.getSession().setAttribute("tranStatus", tranStatus);
				// tushar end 11-04-2023
				jsonObject.addProperty("tranStatus", tranStatus);
				jsonObject.addProperty("error", "0");
				jsonObject.addProperty("Msg", "Organization setup changed Successfully!!!");
			} catch (Exception exception) {
				exception.printStackTrace();
				jsonObject.addProperty("tranStatus", "");
				jsonObject.addProperty("error", "1");
				jsonObject.addProperty("Msg", exception.getMessage());
			}
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/getCityStatewise.json",method= RequestMethod.POST)
	public @ResponseBody String getCityStatewise(HttpServletRequest request,HttpServletResponse response){
	String extras1 = request.getParameter("state");
	if (extras1.length() > 0) {
		List<Paramast> city = paramastService.getCityStatewise(extras1);
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		JsonElement cities = gson.toJsonTree(city);
		jsonObject.add("city", cities);
		return jsonObject.toString();
	}else{
		return null;
	}
	}
}

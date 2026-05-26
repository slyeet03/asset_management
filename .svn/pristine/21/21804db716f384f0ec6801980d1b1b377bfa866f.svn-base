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

import com.fam.entity.Branchmaster;
import com.fam.entity.Paramast;
import com.fam.service.BranchmasterService;
import com.fam.service.ParamastService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.JsonObject;



@Controller
public class BranchmasterController {
	
	@Autowired
	private BranchmasterService branchmasterService;
	
	@Autowired
	private ParamastService paramastService;
	
	@RequestMapping(value = "/BranchMasterView.htm", method = RequestMethod.GET)
	public ModelAndView BranchMasterView(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/BranchMaster");
		Branchmaster branchmaster = new Branchmaster();
		Map<String,?> redirectAttribute = RequestContextUtils.getInputFlashMap(request);
		String disable="0",Update="1";
		
		String recordid = "";
		String Userlevel =  request.getSession().getAttribute("userlevel").toString();
		try{
			if((Userlevel.equalsIgnoreCase("6"))){
				try {
					recordid  = redirectAttribute.get("recordid").toString();
				} catch (Exception e) {
					return mv = new ModelAndView("master/404");
				}
			}else if((Userlevel.equalsIgnoreCase("5"))){
				recordid = redirectAttribute.get("recordid").toString();
			}
			if(recordid != null && recordid.toString().length() >0){

				String prev =redirectAttribute.get("prev").toString();
				String next = redirectAttribute.get("next").toString();
				String recstatus = redirectAttribute.get("recstatus").toString();
				
				if(recstatus.trim().equalsIgnoreCase(RecordStatus.MAKER)||recstatus.trim().equalsIgnoreCase(RecordStatus.CHECKER)){
					disable="1";
					Update="2";
				}
				else {disable="0";Update="1";}
				branchmaster =  this.branchmasterService.getBranchmaster(Long.parseLong(recordid));
				mv.addObject("branchcode", branchmaster.getBranchcode());
				mv.addObject("recordid", recordid);
				//mv.addObject("branchid",branchmaster.getBranchid());
				mv.addObject("prev", prev);	
				mv.addObject("Update", Update);
				mv.addObject("next", next);	
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("branchcode", branchmasterService.getBranchmasterCode());
		}
		String[] data = new String[] {"STATE","CITY"};
		String extras1 = null;
		List<Paramast> paramastlist = paramastService.getparamast(data, extras1);
		Map<String, String> state = new LinkedHashMap<String, String>();
		Map<String, String> city = new LinkedHashMap<String, String>();
		for (Iterator<Paramast> iterator = paramastlist.iterator(); iterator.hasNext();) {
			Paramast paramast = iterator.next();
			 if (paramast.getParatype().equalsIgnoreCase("STATE")) {
				state.put(paramast.getCode(),paramast.getCode() + "-" + paramast.getLdesc());
			} 
			else if (paramast.getParatype().equalsIgnoreCase("CITY")) {
				city.put(paramast.getCode(),paramast.getCode() + "-" + paramast.getLdesc());
			}
		}
		mv.addObject("stateHashMap", state);
		mv.addObject("cityHashMap", city);
		mv.addObject("BranchMasterCommandname", branchmaster);
		mv.addObject("disable", disable);	
		return mv;
	}
	
	
	@RequestMapping(value = "/BranchMasterDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String BranchMasterDetail(@ModelAttribute Branchmaster branchmaster, HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("====");
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update;
		try {
			update = request.getParameter("Update");
			if(update != null  && update.equalsIgnoreCase("1")){
				try{
					branchmaster.setRecstatus(RecordStatus.MAKER);
					branchmaster.setMakerdate(new Date());
					branchmaster.setMakertime(simpleTimeFormat.format(new Date()));
					branchmaster.setMakerid(userId);
					branchmaster.setMakerip(userIp);
					branchmaster.setCountry("1");
				
					this.branchmasterService.updateBranchmaster(branchmaster);	
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordUpdation );
				}catch(Exception exception){
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");	
					jsonObject.addProperty("errorMsg",Messages.RecordUnUpdation);
				}
			}else if(update.equalsIgnoreCase("2")){
				String Action=request.getParameter("action"),prev = request.getParameter("prev"), next = request.getParameter("next"),recstatus;
				if(Action.equalsIgnoreCase("Approve")){
					recstatus=next;
				}else {
					recstatus=prev;
				}
				String[] authorizedValue =request.getParameterValues("recordid");
				List<Long> recordids = new ArrayList<Long>();
				for (int i = 0; i < authorizedValue.length; i++) {
					recordids.add(Long.parseLong(authorizedValue[i]));
				}
				try{
				
					int numberOfRecordsUpdated = this.branchmasterService.updateBranchmaster(recordids,recstatus,new Date(),
							simpleTimeFormat.format(new Date()),
							userId,userIp, Integer.parseInt(request.getSession().getAttribute("userlevel").toString()));
					jsonObject.addProperty("SaveStatus", "1");
					if(Action.equalsIgnoreCase("reject")){
						System.out.println("Number Of Records Rejected : "+numberOfRecordsUpdated);
						jsonObject.addProperty("successMsg",Messages.RecordRejected);	
					}else if(Action.equalsIgnoreCase("Approve")){
						System.out.println("Number Of Records Approved : "+numberOfRecordsUpdated);
						jsonObject.addProperty("successMsg",Messages.RecordApproved);
					}
					
				}catch(Exception e){
					e.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg",e.getMessage());
				}
			}
			else {
				try{
					
					branchmaster.setRecstatus(RecordStatus.MAKER);
					branchmaster.setMakerdate(new Date());
					branchmaster.setMakertime(simpleTimeFormat.format(new Date()));
					branchmaster.setMakerid(userId);
					branchmaster.setMakerip(userIp);
					branchmaster.setCountry("1");
					//branchmaster.setBranchid(Long.parseLong(branchmaster.getBranchcode()));
					this.branchmasterService.insertBranchmaster(branchmaster);	
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordInsertion);
				}catch(Exception exception){
					exception.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");	
					jsonObject.addProperty("errorMsg",Messages.RecordUInsertion);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/BranchMasterGrid.htm", method = RequestMethod.GET)
	public RedirectView BranchMasterGrid(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "GeneralMasters/BranchMasterGrid");
		String recstatus=request.getParameter("recstatus");
		String prev=request.getParameter("prev");
		String next=request.getParameter("next");
		String Update = request.getParameter("Update");
		List<Branchmaster> ls_branchgrid =  this.branchmasterService.getBranchmasterlist(recstatus);
		ls_branchgrid.forEach(s-> System.out.println(s));
		HashMap<String,Branchmaster> um_haHashMap = new HashMap<String, Branchmaster>();
		ls_branchgrid.forEach(assetCat -> um_haHashMap.put(String.valueOf(assetCat.getRecordid()), assetCat));
		if (ls_branchgrid.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, Branchmaster> map = new TreeMap<String, Branchmaster>(um_haHashMap);
		redirectAttributes.addFlashAttribute("list_pm", map);
		redirectAttributes.addFlashAttribute("prev",prev);
		redirectAttributes.addFlashAttribute("Update",Update);
		redirectAttributes.addFlashAttribute("next",next);
		redirectAttributes.addFlashAttribute("recstatus",recstatus);
 		return rv;
	}

	
	@RequestMapping(value = "/UpdateBranchMaster.htm", method = RequestMethod.POST)
	public RedirectView UpdateBranchMaster(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
		String recordid = request.getParameter("recordid");
		RedirectView rv = new RedirectView("BranchMasterView.htm");
		redirectAttributes.addFlashAttribute("recordid", recordid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}
	
	
}

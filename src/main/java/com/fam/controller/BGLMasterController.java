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

import com.fam.entity.Bglpara;
import com.fam.entity.Paramast;
import com.fam.service.BGLMasterService;
import com.fam.service.ParamastService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



@Controller
public class BGLMasterController {
	
	@Autowired
	private BGLMasterService bglMasterService;
	
	@Autowired
	private ParamastService paramastService;
	
	
	@RequestMapping(value = "/BGLMasterView.htm", method = RequestMethod.GET)
	public ModelAndView BGLMasterView(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/BGLMaster");
		Bglpara bglpara = new Bglpara();
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
				bglpara =  this.bglMasterService.getBGLMaster(Long.parseLong(recordid));
				mv.addObject("recordid", recordid);
				mv.addObject("prev", prev);	
				mv.addObject("Update", Update);
				mv.addObject("next", next);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Map<String, String> relation = new LinkedHashMap<String, String>();
		
		
		String[] data = new String[] {"RELATION"};
		String extras1 = null;
		List<Paramast> paramastlist = paramastService.getparamast(data, extras1);
		
		for (Iterator<Paramast> iterator = paramastlist.iterator(); iterator.hasNext();) {
			Paramast paramast = iterator.next();
			if (paramast.getParatype().equalsIgnoreCase("RELATION")) {
				relation.put(paramast.getCode(),paramast.getCode() + "-" + paramast.getLdesc());
			} 
		}
		mv.addObject("Paramast_reporela", relation);
		mv.addObject("BGLMasterCommandname", bglpara);
		mv.addObject("disable", disable);	
		return mv;
	}
	
	
	@RequestMapping(value = "/BGLMasterDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String BGLMasterDetail(@ModelAttribute Bglpara bglpara, HttpServletRequest request,HttpServletResponse response) throws Exception {
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
					bglpara.setRecstatus(RecordStatus.MAKER);
					bglpara.setRolename(request.getSession().getAttribute("role").toString());
					bglpara.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					bglpara.setMakerdate(new Date());
					bglpara.setMakertime(simpleTimeFormat.format(new Date()));
					bglpara.setMakerid(userId);
					bglpara.setMakerip(userIp);
					//String procode = this.productMasterService.getproductmaster(prodmast.getRecordid()).getProductCode();
				
					this.bglMasterService.update_bglmaster(bglpara);	
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordUpdation + ", For Product "+bglpara.getBglnumb());
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
				
					int numberOfRecordsUpdated = this.bglMasterService.updatebglmaster(recordids,recstatus,new Date(),
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
					
					bglpara.setRecstatus(RecordStatus.MAKER);
					bglpara.setRolename(request.getSession().getAttribute("role").toString());
					bglpara.setUserlevel(request.getSession().getAttribute("userlevel").toString());
					bglpara.setMakerdate(new Date());
					bglpara.setMakertime(simpleTimeFormat.format(new Date()));
					bglpara.setMakerid(userId);
					bglpara.setMakerip(userIp);
					
					
					this.bglMasterService.save(bglpara);	
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",Messages.RecordInsertion +" BGL Number is "+bglpara.getBglnumb());
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
	
	@RequestMapping(value = "/BGLMasterGrid.htm", method = RequestMethod.GET)
	public RedirectView BGLMasterGrid(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "GeneralMasters/BGLMasterGrid");
		String recstatus=request.getParameter("recstatus");
		String prev=request.getParameter("prev");
		String next=request.getParameter("next");
		String Update = request.getParameter("Update");
		List<Object[]> ls_bglgrid =  this.bglMasterService.getBGLMasterList(recstatus);
		HashMap<String, String[]> pm_haHashMap = new HashMap<String, String[]>();
		for (Iterator<Object[]> iterator = ls_bglgrid.iterator(); iterator.hasNext();) {
			Object[] object =  iterator.next();
			String Listdata[] = new String[3];
			Listdata[0] = object[0].toString();
			Listdata[1] = object[1].toString();
			Listdata[2] = object[2].toString();
			
			pm_haHashMap.put("" + object[2], Listdata);
		}
		if (ls_bglgrid.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, String[]> map = new TreeMap<String, String[]>(pm_haHashMap);
		redirectAttributes.addFlashAttribute("list_pm", map);
		redirectAttributes.addFlashAttribute("prev",prev);
		redirectAttributes.addFlashAttribute("Update",Update);
		redirectAttributes.addFlashAttribute("next",next);
		redirectAttributes.addFlashAttribute("recstatus",recstatus);
 		return rv;
	}

	
	@RequestMapping(value = "/UpdateBGLMaster.htm", method = RequestMethod.POST)
	public RedirectView UpdateBGLMaster(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
		String recordid = request.getParameter("recordid");
		RedirectView rv = new RedirectView("BGLMasterView.htm");
		redirectAttributes.addFlashAttribute("recordid", recordid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}
	
	@RequestMapping(value = "/checkbgl.htm", method = RequestMethod.POST)        
	public @ResponseBody String CheckBGLNumber(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String bgl =request.getParameter("bgl");
		Gson gson = new Gson();
		JsonObject jsonObject= new JsonObject();
		boolean b =this.bglMasterService.getBGLNumber(bgl);
		JsonElement number = gson.toJsonTree(b);
		jsonObject.add("bglNum", number);
		return jsonObject.toString();       
	}
      //end
}

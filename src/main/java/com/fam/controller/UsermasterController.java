package com.fam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.fam.entity.Usermaster;
import com.fam.service.ParamastService;
import com.fam.service.UsermasterService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.JsonObject;

@Controller
public class UsermasterController {
	@Autowired
	private UsermasterService usermasterService;

	@Autowired
	private ParamastService paramastService;

	@RequestMapping(value = "/Usermaster.htm", method = RequestMethod.GET)
	public ModelAndView showUsermaster(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView mv = new ModelAndView("GeneralMasters/Usermaster");
		Usermaster usermaster = new Usermaster();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Map<String, ?> redirectAttribute = RequestContextUtils.getInputFlashMap(request);
		String disable = "0", Update = "1";
		String userid = "";
		String Userlevel = request.getSession().getAttribute("userlevel").toString();
		try {
			if ((Userlevel.equalsIgnoreCase("6"))) {
				try {
					userid = redirectAttribute.get("userid").toString();
				} catch (Exception e) {
					return mv = new ModelAndView("master/404");
				}
			} else if ((Userlevel.equalsIgnoreCase("5"))) {
				userid = redirectAttribute.get("userid").toString();
			} 
			if (userid != null && userid.length() > 0) {
				usermaster = this.usermasterService.getUserMaster(userid);

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
				String locked = null, Pwdchangedate = null, logoutdate = null, pwdexpirydate = null,
						lockedreason = null;
				try {
					if (usermaster.getLocked().equals('1')) {
						locked = "Locked";
					} else {
						locked = "Open";
					}
				} catch (Exception e) {
					locked = "N/A";
				}
				try {
					if (!(usermaster.getPwdchangedate().equals(null))) {
						Pwdchangedate = sdf.format(usermaster.getPwdchangedate());
					}
				} catch (Exception e) {
					Pwdchangedate = "N/A";
				}
				try {
					if (!(usermaster.getLogoutdate().equals(null))) {
						logoutdate = sdf.format(usermaster.getLogoutdate());
					}
				} catch (Exception e) {
					logoutdate = "N/A";
				}
				try {
					if (!(usermaster.getPwdexpirydate().equals(null))) {
						pwdexpirydate = sdf.format(usermaster.getPwdexpirydate());
					}
				} catch (Exception e) {
					pwdexpirydate = "N/A";
				}
				try {
					if (!(usermaster.getLockedreason().equals(null))) {
						lockedreason = sdf.format(usermaster.getLockedreason());
					}
				} catch (Exception e) {
					lockedreason = "N/A";
				}

				mv.addObject("Logoutdate", logoutdate);
				mv.addObject("Pwdchangedate", Pwdchangedate);
				mv.addObject("Locked", locked);
				mv.addObject("Lockedreason", lockedreason);
				mv.addObject("Pwdexpirydate", pwdexpirydate);
				mv.addObject("userid", userid);
				mv.addObject("prev", prev);
				mv.addObject("Update", Update);
				mv.addObject("next", next);
				mv.addObject("recstatus", recstatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> Rolename = new HashMap<String, String>();

		String[] data = new String[] { "USERLEVEL", "ROLE" };
		String extras1 = null;
		List<Paramast> paramastlist = paramastService.getparamast(data, extras1);
		for (Iterator<Paramast> iterator = paramastlist.iterator(); iterator.hasNext();) {
			Paramast paramast = iterator.next();
			if (paramast.getParatype().equalsIgnoreCase("ROLE")) {
				Rolename.put(paramast.getCode(), paramast.getLdesc());
			}
		}
		mv.addObject("Paramast_Rolename", Rolename);
		mv.addObject("unlist", this.usermasterService.getuserid());
		mv.addObject("Usermastercommandname", usermaster);
		mv.addObject("disable", disable);
		return mv;
	}

	@RequestMapping(value = "/UserMasterDetail.htm", method = RequestMethod.POST)
	public @ResponseBody String UserMasterDetail(@ModelAttribute Usermaster usermaster, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonObject jsonObject = new JsonObject();
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String userId = request.getSession().getAttribute("userId").toString();
		String userIp = request.getSession().getAttribute("ip").toString();
		String update;
		try {
			update = request.getParameter("Update");
			if (update != null && update.equalsIgnoreCase("1")) {
				try {
					usermaster.setRecstatus(RecordStatus.MAKER);
					usermaster.setUserlevel(request.getParameter("userlevel").toString());
					usermaster.setMakerdate(new Date());
					usermaster.setMakertime(simpleTimeFormat.format(new Date()));
					usermaster.setMakerid(userId);
					usermaster.setMakerip(userIp);
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					cal.setTime(date);
					cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH) + 6));
					Date exprdate = cal.getTime();
					usermaster.setPwdexpirydate(exprdate);
					usermaster.setPwdchangedate(exprdate);
					usermaster.setPwd("password");
					usermaster.setEmpcode(usermaster.getUserid());
					DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
					Date date1 = new Date();
					String SysTime = timeFormat.format(date1);
					usermaster.setLoggedin('0');// Set it to 1 to lock user
					usermaster.setLogindate(date1);
					usermaster.setLogintime(SysTime);
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					this.usermasterService.updateUserMaster(usermaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",
							Messages.RecordUpdation + ", For Userid " + usermaster.getUserid());
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
				String[] authorizedValue = request.getParameterValues("userid");

				List<String> recordids = new ArrayList<String>();
				for (int i = 0; i < authorizedValue.length; i++) {
					recordids.add(authorizedValue[i]);
				}
				try {
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					usermasterService.updateUserMaster(recordids, recstatus, new Date(),
							simpleTimeFormat.format(new Date()), userId, userIp,
							Integer.parseInt(request.getSession().getAttribute("userlevel").toString()));
					jsonObject.addProperty("SaveStatus", "1");
					if (Action.equalsIgnoreCase("reject")) {
						jsonObject.addProperty("successMsg", Messages.RecordRejected);
					} else if (Action.equalsIgnoreCase("Approve")) {
						jsonObject.addProperty("successMsg", Messages.RecordApproved);
					}
				} catch (Exception e) {
					e.printStackTrace();
					jsonObject.addProperty("SaveStatus", "0");
					jsonObject.addProperty("errorMsg", e.getMessage());
				}
			} else {
				try {
					usermaster.setRecstatus(RecordStatus.MAKER);
					usermaster.setUserid(usermaster.getUserid());
					usermaster.setMakerdate(new Date());
					usermaster.setMakertime(simpleTimeFormat.format(new Date()));
					usermaster.setMakerid(userId);
					usermaster.setMakerip(userIp);
					usermaster.setPwd("password");
					usermaster.setEmpcode(usermaster.getUserid());
					Calendar cal = Calendar.getInstance();
					Date date = cal.getTime();
					cal.setTime(date);
					cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH) + 6));
					Date exprdate = cal.getTime();
					usermaster.setPwdexpirydate(exprdate);
					usermaster.setPwdchangedate(exprdate);
					DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
					Date date1 = new Date();
					String SysTime = timeFormat.format(date1);
					usermaster.setLoggedin('0');// Set it to 1 to lock user
					usermaster.setLogindate(date);
					usermaster.setLogintime(SysTime);
					Auditlog auditlog = new Auditlog();
					auditlog.urlDesc = request.getRequestURL().toString();
					this.usermasterService.insertUserMaster(usermaster);
					jsonObject.addProperty("SaveStatus", "1");
					jsonObject.addProperty("successMsg",
							Messages.RecordInsertion + " Userid is " + usermaster.getUserid());
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

	@RequestMapping(value = "/UpdateUsermaster.htm", method = RequestMethod.POST)
	public RedirectView UpdateUsermaster(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		String userid = request.getParameter("userid");
		RedirectView rv = new RedirectView("Usermaster.htm");
		redirectAttributes.addFlashAttribute("userid", userid);
		redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
		redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
		redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
		redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
		return rv;
	}

	@RequestMapping(value = "/UsermasterGrid.htm", method = RequestMethod.GET)
	public RedirectView UsermasterGrid(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		RedirectView rv = new RedirectView("GridView.htm");
		redirectAttributes.addFlashAttribute("page", "GeneralMasters/UserGrid");
		String recstatus = request.getParameter("recstatus");
		String prev = request.getParameter("prev");
		String next = request.getParameter("next");
		String Update = request.getParameter("Update");
		List<Object[]> ls_usergrid = this.usermasterService.getUserMasterlist(recstatus);
		HashMap<String, String[]> um_haHashMap = new HashMap<String, String[]>();
		for (Iterator<Object[]> iterator = ls_usergrid.iterator(); iterator.hasNext();) {
			Object[] obj = iterator.next();
			String Listdata[] = new String[4];
			Listdata[0] = obj[0].toString();
			Listdata[1] = obj[1].toString();
			Listdata[2] = obj[2].toString();
			um_haHashMap.put(obj[0].toString(), Listdata);
		}
		if (ls_usergrid.size() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
		}
		Map<String, String[]> map = new TreeMap<String, String[]>(um_haHashMap);
		redirectAttributes.addFlashAttribute("list_vc", map);
		redirectAttributes.addFlashAttribute("prev", prev);
		redirectAttributes.addFlashAttribute("Update", Update);
		redirectAttributes.addFlashAttribute("next", next);
		redirectAttributes.addFlashAttribute("recstatus", recstatus);
		return rv;
	}

}

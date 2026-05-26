package com.fam.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fam.entity.Usermaster;
import com.fam.service.UsermasterService;

@Controller
public class LoginController {
	@Autowired
	UsermasterService usermasterService;
	
	
	private String validateUser(Usermaster ls, String inputPwd) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar expiryDate = Calendar.getInstance();
		try{
			expiryDate.setTime(dateFormat.parse("04/07/2071"));
		}catch(Exception e){}
		Date currnet = new Date();
		try {
			if (!(ls.getRecstatus().equals("5"))) {
				return "User Yet to Approved ";
			}
			if (currnet.after(ls.getPwdexpirydate())) {
				return "Password Expired";
			}
			if (ls.getLocked() != null && Integer.parseInt(ls.getLocked().toString()) != 0) {
				return ls.getLockedreason();
			}
			if (ls.getLoggedin() == '1') {
				return "User Already Logged In.";
			}
			if(expiryDate.getTime().before(currnet)){
				return "UAT Session Expired";
			}
			if (ls.getPwd().equals(inputPwd)) {
				return "-1";
			}
			
		} catch (IndexOutOfBoundsException i) {
			return "The Username or Password you entered is incorrect.";
		}
		return "The Username or Password you entered is incorrect.";
	}
	
	
	
	@GetMapping(value = "/")
		public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mv = new ModelAndView("master/index");
			return mv;
	}
		
		@GetMapping(value = "/ProcessLogin.htm")
		public ModelAndView Processlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mv = new ModelAndView("master/ProcessLogin");
//			String url = request.getRequestURL().toString();
//			String BankShortCode = url.split("/")[3];		
//			String statusCheck = request.getParameter("statusCheck");
//			try{
//				if (statusCheck.equalsIgnoreCase("sessionexpired")) {
//					mv.addObject("msg", "Session Expired !!!");
//			}
//			}catch(NullPointerException ne){}
			return mv;
			
		}
	
		@PostMapping(value = "/checkCredentials.htm")
		public ModelAndView checkCredentials(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String userId = request.getParameter("userid");
			String password = request.getParameter("password");
			ModelAndView mv = new ModelAndView("master/ProcessLogin");
			boolean isPwdExpired = false;
			String url = request.getRequestURL().toString();
			String BankShortCode = url.split("/")[3];
			String msg = "";
				try{
					Usermaster usermaster = usermasterService.getUserMaster(userId);
					msg = validateUser(usermaster, password);
					if (usermaster != null && (msg.equals("-1") )) {
						DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
						Date date = new Date();
						String SysTime = timeFormat.format(date);
						String lastLoginTime = "";
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
						try{
							lastLoginTime = dateFormat.format(usermaster.getLogindate())+" "+usermaster.getLogintime();
						}catch (Exception e) {
							lastLoginTime = dateFormat.format(new Date())+" "+SysTime;
						}
						usermasterService.releaseAllUsers();
						//usermaster.setLoggedin('1');// Set it to 1 to lock user
						usermaster.setLogindate(date);
						usermaster.setLogintime(SysTime);
						
						this.usermasterService.updateUserMaster(usermaster);
						request.getSession().setAttribute("userId", userId);
						request.getSession().setAttribute("ip", request.getRemoteAddr());				
						request.getSession().setAttribute("userName", usermaster.getUsername());
						request.getSession().setAttribute("passKey", usermaster.getPwd());
						request.getSession().setAttribute("userlevel", usermaster.getUserlevel());
						request.getSession().setAttribute("role", usermaster.getRolename());
						request.getSession().setAttribute("empcode", usermaster.getRolename());
						request.getSession().setAttribute("lastLoginTime", lastLoginTime);
						request.getSession().setAttribute("BankShortCode", BankShortCode);

						if(usermaster.getPwd().equalsIgnoreCase("password") || usermaster.getPwd().equalsIgnoreCase("password@123")){
							mv = new ModelAndView("master/ChangePassword");
							mv.addObject("user", userId.trim());
							mv.addObject("passKey", password);
						}else{
							try {
								response.sendRedirect(request.getContextPath() + "/Dashboard.htm");
								return null;
							} catch (Exception e) {}					
						}
					}
					if(!usermaster.getPwd().equalsIgnoreCase("password") && !usermaster.getPwd().equalsIgnoreCase("password@123")){
						if (msg == "Invalid User") {
							mv = new ModelAndView("master/ProcessLogin");
						} else if (msg.equalsIgnoreCase("Password Expired")) {
							isPwdExpired = true;
							mv = new ModelAndView("master/ChangePassword");
						} else {
							mv = new ModelAndView("master/ProcessLogin");
						}
						if (isPwdExpired) {
							mv.addObject("user", userId.trim());
							mv.addObject("passKey", password);
						} else {
							mv.addObject("loginStatus", "invalid");
							mv.addObject("errorMsg", msg);
						}
					}
					return mv;
				}catch (IndexOutOfBoundsException e) {
					mv = new ModelAndView("master/ProcessLogin");
					return mv;
				}
							
		}
		@RequestMapping(value="/GridView.htm",method = RequestMethod.GET)
		public ModelAndView GridView(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes){
			try{
				Map<String,?>data =  RequestContextUtils.getInputFlashMap(request);
				String page = data.get("page").toString();
				ModelAndView mv = new ModelAndView(page);
				for (Iterator<String> iterator = data.keySet().iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					mv.addObject(key, data.get(key));
				}
				return mv;
			}catch (Exception e) {
				String page = "/Dashboard.htm";
				try{
					page = request.getSession().getAttribute("previousPage").toString().trim();
					request.getSession().removeAttribute("previousPage");
				}catch (Exception e2) {}
				
				try{
					response.sendRedirect(request.getContextPath() + page);
				}catch (Exception e1) {}
				
				return null;
				
			}
		}
		@GetMapping(value = "/logout.htm")
		public void logout(HttpServletRequest request, HttpServletResponse response) {
			String userId = request.getSession().getAttribute("userId").toString();
			Usermaster usermaster = usermasterService.getUserMaster(userId);
			usermaster.setLoggedin('0');
			usermaster.setLogoutdate(new Date());
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			usermaster.setLogouttime(timeFormat.format(new Date()));
			usermasterService.updateUserMaster(usermaster);
			request.getSession().invalidate();
			try {
				response.sendRedirect(request.getContextPath() + "/ProcessLogin.htm");
			} catch (IOException e) {}
		}	
		
		
		@GetMapping(value = "/Dashboard.htm")
		public ModelAndView Succes(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mv = new ModelAndView("master/Dashboard");
			return mv;
		}


}
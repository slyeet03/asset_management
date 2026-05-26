package com.fam.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class AssetDisposalController {
	
	@RequestMapping(value = "/AssetDisposalView.htm",method = RequestMethod.GET)
	public ModelAndView AssetDisposalView(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView mv = new ModelAndView("Transaction/AssetDisposalView");
		return mv;
	}
	
}

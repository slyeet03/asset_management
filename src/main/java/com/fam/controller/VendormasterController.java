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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.fam.entity.VendorMaster;
import com.fam.service.ParamastService;
import com.fam.service.VendorMasterService;
import com.fam.values.Messages;
import com.fam.values.RecordStatus;
import com.google.gson.JsonObject;

@Controller
public class VendormasterController {

  @Autowired
  private VendorMasterService vendorMasterService;

  @Autowired
  private ParamastService paramastService;

  @GetMapping(value = "/VendorMasterView.htm")
  public ModelAndView VendorMasterView(HttpServletRequest request, HttpServletRequest responce,
      RedirectAttributes redirectAttributes) throws Exception {
    ModelAndView mv = new ModelAndView("GeneralMasters/VendorMaster");
    VendorMaster vendorMaster = new VendorMaster();
    Map<String, ?> redirectAttribute = RequestContextUtils.getInputFlashMap(request);
    String disable = "0", Update = "1";

    String recordid = "";
    String Userlevel = request.getSession().getAttribute("userlevel").toString();
    System.out.println("UserLevel: " + Userlevel);

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
      if (recordid != null && recordid.toString().length() > 0) {
        System.out.println("Record Id: " + redirectAttribute.get("recordid").toString());
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
        vendorMaster = this.vendorMasterService.getVendorMaster(Long.parseLong(recordid));
        mv.addObject("recordid", recordid);
        mv.addObject("prev", prev);
        mv.addObject("Update", Update);
        mv.addObject("next", next);
      }
    } catch (Exception e) {
      mv.addObject("vendorcode", vendorMasterService.getVendorMasterCode());
    }

    String[] data = new String[] { "STATE", "CITY" };
    String extras1 = null;
    List<Paramast> paramastlist = paramastService.getparamast(data, extras1);
    Map<String, String> state = new LinkedHashMap<String, String>();
    Map<String, String> city = new LinkedHashMap<String, String>();
    for (Iterator<Paramast> iterator = paramastlist.iterator(); iterator.hasNext();) {
      Paramast paramast = iterator.next();
      if (paramast.getParatype().equalsIgnoreCase("STATE")) {
        state.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getLdesc());
      } else if (paramast.getParatype().equalsIgnoreCase("CITY")) {
        city.put(paramast.getCode(), paramast.getCode() + "-" + paramast.getLdesc());
      }
    }

    mv.addObject("stateHashMap", state);
    mv.addObject("cityHashMap", city);
    mv.addObject("VendorMasterCommandname", vendorMaster);
    mv.addObject("disable", disable);
    return mv;
  }

  @RequestMapping(value = "/VendorMasterDetail.htm", method = RequestMethod.POST)
  public @ResponseBody String VendorMasterDetail(@ModelAttribute VendorMaster vendorMaster,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    JsonObject jsonObject = new JsonObject();

    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
    String userId = request.getSession().getAttribute("userId").toString();
    String userIp = request.getSession().getAttribute("ip").toString();
    String update;

    try {
      update = request.getParameter("Update");
      System.out.println(update);
      if (update != null && update.equalsIgnoreCase("1")) {
        try {
          vendorMaster.setRecstatus(RecordStatus.MAKER);
          vendorMaster.setMakerdate(new Date());
          vendorMaster.setMakertime(simpleTimeFormat.format(new Date()));
          vendorMaster.setMakerid(userId);
          vendorMaster.setMakerip(userIp);
          vendorMaster.setCountry("1");
          this.vendorMasterService.updateVendorMaster(vendorMaster);
          jsonObject.addProperty("SaveStatus", "1");
          jsonObject.addProperty("successMsg", Messages.RecordUpdation);
        } catch (Exception exception) {
          exception.printStackTrace();
          jsonObject.addProperty("SaveStatus", "0");
          jsonObject.addProperty("errorMsg", Messages.RecordUnUpdation);
        }
      } else if (update != null && update.equalsIgnoreCase("2")) {
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
          int numberOfRecordsUpdated = this.vendorMasterService.updateVranchMaster(recordids, recstatus,
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
          System.out.println(vendorMaster.getPincode());
          vendorMaster.setRecstatus(RecordStatus.MAKER);
          vendorMaster.setMakerdate(new Date());
          vendorMaster.setMakertime(simpleTimeFormat.format(new Date()));
          vendorMaster.setMakerid(userId);
          vendorMaster.setMakerip(userIp);
          vendorMaster.setCountry("1");
          // branchmaster.setBranchid(Long.parseLong(branchmaster.getBranchcode()));
          this.vendorMasterService.insertBranchmaster(vendorMaster);
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

  @RequestMapping(value = "/VendorMasterGrid.htm", method = RequestMethod.GET)
  public RedirectView VendorMasterGrid(HttpServletRequest request, HttpServletResponse response,
      RedirectAttributes redirectAttributes) throws Exception {
    RedirectView rv = new RedirectView("GridView.htm");
    redirectAttributes.addFlashAttribute("page", "GeneralMasters/VendorMasterGrid");
    String recstatus = request.getParameter("recstatus");
    System.out.println("RecStatus: " + recstatus);
    String prev = request.getParameter("prev");
    String next = request.getParameter("next");
    String Update = request.getParameter("Update");
    List<VendorMaster> ls_vendorgrid = this.vendorMasterService.getVendormasterlist(recstatus);
    ls_vendorgrid.forEach(s -> System.out.println(s));
    HashMap<String, VendorMaster> um_haHashMap = new HashMap<String, VendorMaster>();
    ls_vendorgrid.forEach(assetCat -> um_haHashMap.put(String.valueOf(assetCat.getRecordid()), assetCat));
    if (ls_vendorgrid.size() <= 0) {
      redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
    }
    Map<String, VendorMaster> map = new TreeMap<String, VendorMaster>(um_haHashMap);
    redirectAttributes.addFlashAttribute("list_pm", map);
    redirectAttributes.addFlashAttribute("prev", prev);
    redirectAttributes.addFlashAttribute("Update", Update);
    redirectAttributes.addFlashAttribute("next", next);
    redirectAttributes.addFlashAttribute("recstatus", recstatus);
    return rv;
  }

  @RequestMapping(value = "/VendorEditGrid.htm", method = RequestMethod.GET)
  public RedirectView VendorEditGrid(HttpServletRequest request, HttpServletResponse response,
      RedirectAttributes redirectAttributes) throws Exception {
    RedirectView rv = new RedirectView("GridView.htm");
    redirectAttributes.addFlashAttribute("page", "maker/VendorEditGrid");
    String recstatus = request.getParameter("recstatus");
    System.out.println("RecStatus: " + recstatus);
    String prev = request.getParameter("prev");
    String next = request.getParameter("next");
    String Update = request.getParameter("Update");
    List<VendorMaster> ls_vendorgrid = this.vendorMasterService.getVendormasterlist(recstatus);
    ls_vendorgrid.forEach(s -> System.out.println(s));
    HashMap<String, VendorMaster> um_haHashMap = new HashMap<String, VendorMaster>();
    ls_vendorgrid.forEach(assetCat -> um_haHashMap.put(String.valueOf(assetCat.getRecordid()), assetCat));
    if (ls_vendorgrid.size() <= 0) {
      redirectAttributes.addFlashAttribute("msg", "*** No Data Available ****");
    }
    Map<String, VendorMaster> map = new TreeMap<String, VendorMaster>(um_haHashMap);
    redirectAttributes.addFlashAttribute("list_pm", map);
    redirectAttributes.addFlashAttribute("prev", prev);
    redirectAttributes.addFlashAttribute("Update", Update);
    redirectAttributes.addFlashAttribute("next", next);
    redirectAttributes.addFlashAttribute("recstatus", recstatus);
    return rv;
  }

  @RequestMapping(value = "/UpdateVendorMaster.htm", method = RequestMethod.POST)
  public RedirectView UpdateBranchMaster(HttpServletRequest request, HttpServletResponse response,
      RedirectAttributes redirectAttributes) throws Exception {
    String recordid = request.getParameter("recordid");
    RedirectView rv = new RedirectView("VendorMasterView.htm");
    redirectAttributes.addFlashAttribute("recordid", recordid);
    redirectAttributes.addFlashAttribute("prev", request.getParameter("prev"));
    redirectAttributes.addFlashAttribute("next", request.getParameter("next"));
    redirectAttributes.addFlashAttribute("recstatus", request.getParameter("recstatus"));
    redirectAttributes.addFlashAttribute("Update", request.getParameter("Update"));
    return rv;
  }

}

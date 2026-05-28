package com.fam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Entity
@Table(name = "vendormast", schema = "public")
public class VendorMaster implements java.io.Serializable {
  @Id
  @SequenceGenerator(name = "vendormast_sequence_generator", sequenceName = "vendormast_recordid_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendormast_sequence_generator")
  private long recordid;
  private String vendortype;
  private String vendorcode;
  private String entityname;
  private String contactname;
  private String gstin;
  private String address;
  private String city;
  private int pincode;
  private String state;
  private String country;
  private String category;
  private String businesstype;
  private String bank;
  private String ifscno;
  private String acctnumb;
  private String email;
  private String website;
  private String phone1;
  private String phone2;
  private String remark;
  private String extra1;
  private String extra2;
  private String extra3;
  private String recstatus;
  private String userlevel;
  private String rolename;
  private String makerid;
  private Date makerdate;
  private String makertime;
  private String makerip;
  private String checkerid;
  private Date checkerdate;
  private String checkertime;
  private String checkerip;
  private String approverid;
  private Date approverdate;
  private String approvertime;
  private String approverip;
  private Integer salestax;
  private Integer servicetax;
  private Integer tantax;
  private Integer vattax;

  public VendorMaster(long recordid, String vendortype, String vendorcode, String entityname, String contactname,
      String gstin, String address, String city, int pincode, String state, String country, String category,
      String businesstype, String bank, String ifscno, String acctnumb, String email, String website,
      String phone1, String phone2, String remark, String extra1, String extra2, String extra3, String recstatus,
      String userlevel, String rolename, String makerid, Date makerdate, String makertime, String makerip,
      String checkerid, Date checkerdate, String checkertime, String checkerip, String approverid,
      Date approverdate, String approvertime, String approverip, Integer salestax, Integer servicetax, Integer tantax,
      Integer vattax) {
    super();
    this.recordid = recordid;
    this.vendortype = vendortype;
    this.vendorcode = vendorcode;
    this.entityname = entityname;
    this.contactname = contactname;
    this.gstin = gstin;
    this.address = address;
    this.city = city;
    this.pincode = pincode;
    this.state = state;
    this.country = country;
    this.category = category;
    this.businesstype = businesstype;
    this.bank = bank;
    this.ifscno = ifscno;
    this.acctnumb = acctnumb;
    this.email = email;
    this.website = website;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.remark = remark;
    this.extra1 = extra1;
    this.extra2 = extra2;
    this.extra3 = extra3;
    this.recstatus = recstatus;
    this.userlevel = userlevel;
    this.rolename = rolename;
    this.makerid = makerid;
    this.makerdate = makerdate;
    this.makertime = makertime;
    this.makerip = makerip;
    this.checkerid = checkerid;
    this.checkerdate = checkerdate;
    this.checkertime = checkertime;
    this.checkerip = checkerip;
    this.approverid = approverid;
    this.approverdate = approverdate;
    this.approvertime = approvertime;
    this.approverip = approverip;
    this.salestax = salestax;
    this.servicetax = servicetax;
    this.tantax = tantax;
    this.vattax = vattax;
  }

  public VendorMaster() {

  }

  public long getRecordid() {
    return recordid;
  }

  public void setRecordid(long recordid) {
    this.recordid = recordid;
  }

  public String getVendortype() {
    return vendortype;
  }

  public void setVendortype(String vendortype) {
    this.vendortype = vendortype;
  }

  public String getVendorcode() {
    return vendorcode;
  }

  public void setVendorcode(String vendorcode) {
    this.vendorcode = vendorcode;
  }

  public String getEntityname() {
    return entityname;
  }

  public void setEntityname(String entityname) {
    this.entityname = entityname;
  }

  public String getContactname() {
    return contactname;
  }

  public void setContactname(String contactname) {
    this.contactname = contactname;
  }

  public String getGstin() {
    return gstin;
  }

  public void setGstin(String gstin) {
    this.gstin = gstin;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPincode() {
    return pincode;
  }

  public void setPincode(int pincode) {
    this.pincode = pincode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getBusinesstype() {
    return businesstype;
  }

  public void setBusinesstype(String businesstype) {
    this.businesstype = businesstype;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public String getIfscno() {
    return ifscno;
  }

  public void setIfscno(String ifscno) {
    this.ifscno = ifscno;
  }

  public String getAcctnumb() {
    return acctnumb;
  }

  public void setAcctnumb(String acctnumb) {
    this.acctnumb = acctnumb;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getExtra1() {
    return extra1;
  }

  public void setExtra1(String extra1) {
    this.extra1 = extra1;
  }

  public String getExtra2() {
    return extra2;
  }

  public void setExtra2(String extra2) {
    this.extra2 = extra2;
  }

  public String getExtra3() {
    return extra3;
  }

  public void setExtra3(String extra3) {
    this.extra3 = extra3;
  }

  public String getRecstatus() {
    return recstatus;
  }

  public void setRecstatus(String recstatus) {
    this.recstatus = recstatus;
  }

  public String getUserlevel() {
    return userlevel;
  }

  public void setUserlevel(String userlevel) {
    this.userlevel = userlevel;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public String getMakerid() {
    return makerid;
  }

  public void setMakerid(String makerid) {
    this.makerid = makerid;
  }

  public Date getMakerdate() {
    return makerdate;
  }

  public void setMakerdate(Date makerdate) {
    this.makerdate = makerdate;
  }

  public String getMakertime() {
    return makertime;
  }

  public void setMakertime(String makertime) {
    this.makertime = makertime;
  }

  public String getMakerip() {
    return makerip;
  }

  public void setMakerip(String makerip) {
    this.makerip = makerip;
  }

  public String getCheckerid() {
    return checkerid;
  }

  public void setCheckerid(String checkerid) {
    this.checkerid = checkerid;
  }

  public Date getCheckerdate() {
    return checkerdate;
  }

  public void setCheckerdate(Date checkerdate) {
    this.checkerdate = checkerdate;
  }

  public String getCheckertime() {
    return checkertime;
  }

  public void setCheckertime(String checkertime) {
    this.checkertime = checkertime;
  }

  public String getCheckerip() {
    return checkerip;
  }

  public void setCheckerip(String checkerip) {
    this.checkerip = checkerip;
  }

  public String getApproverid() {
    return approverid;
  }

  public void setApproverid(String approverid) {
    this.approverid = approverid;
  }

  public Date getApproverdate() {
    return approverdate;
  }

  public void setApproverdate(Date approverdate) {
    this.approverdate = approverdate;
  }

  public String getApprovertime() {
    return approvertime;
  }

  public void setApprovertime(String approvertime) {
    this.approvertime = approvertime;
  }

  public String getApproverip() {
    return approverip;
  }

  public void setApproverip(String approverip) {
    this.approverip = approverip;
  }

  public Integer getSalestax() {
    return salestax;
  }

  public void setSalestax(Integer salestax) {
    this.salestax = salestax;
  }

  public Integer getServicetax() {
    return servicetax;
  }

  public void setServicetax(Integer servicetax) {
    this.servicetax = servicetax;
  }

  public Integer getTantax() {
    return tantax;
  }

  public void setTantax(Integer tantax) {
    this.tantax = tantax;
  }

  public Integer getVattax() {
    return vattax;
  }

  public void setVattax(Integer vattax) {
    this.vattax = vattax;
  }

}

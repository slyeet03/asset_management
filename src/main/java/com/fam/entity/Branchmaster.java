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
@Entity
@Component
@Table(name = "branchmaster", schema = "public")
public class Branchmaster implements java.io.Serializable{
	@Id
	@SequenceGenerator(name = "branchmaster_sequence_generator", sequenceName = "branchmaster_recordid_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchmaster_sequence_generator")
	private Long recordid;
	//private Long branchid;
	private String branchcode;
	private String branchname; 
	private String firstaddress;
	private String lastaddress;  
	private String city; 
	private String pin; 
	private String state;
	private String country;
	private String email;
	private String contactperson;
	private String conpersonphoneno;
	private String remark;
	private String extra1;
	private String extra2;
	private String recstatus;
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
	
	
	public Branchmaster() {
	}
	
	public Branchmaster(Long recordid,
			/* Long branchid, */ String branchcode, String branchname, String firstaddress,
			String lastaddress, String city, String pin, String state, String country, String email,
			String contactperson, String conpersonphoneno, String remark, String extra1, String extra2,
			String recstatus, String makerid, Date makerdate, String makertime, String makerip, String checkerid,
			Date checkerdate, String checkertime, String checkerip, String approverid, Date approverdate,
			String approvertime, String approverip) {
		this.recordid = recordid;
		//this.branchid = branchid;
		this.branchcode = branchcode;
		this.branchname = branchname;
		this.firstaddress = firstaddress;
		this.lastaddress = lastaddress;
		this.city = city;
		this.pin = pin;
		this.state = state;
		this.country = country;
		this.email = email;
		this.contactperson = contactperson;
		this.conpersonphoneno = conpersonphoneno;
		this.remark = remark;
		this.extra1 = extra1;
		this.extra2 = extra2;
		this.recstatus = recstatus;
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
	}
	public Long getRecordid() {
		return recordid;
	}
	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}

	/*
	 * public Long getBranchid() { return branchid; } public void setBranchid(Long
	 * branchid) { this.branchid = branchid; }
	 */
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getFirstaddress() {
		return firstaddress;
	}
	public void setFirstaddress(String firstaddress) {
		this.firstaddress = firstaddress;
	}
	public String getLastaddress() {
		return lastaddress;
	}
	public void setLastaddress(String lastaddress) {
		this.lastaddress = lastaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getConpersonphoneno() {
		return conpersonphoneno;
	}
	public void setConpersonphoneno(String conpersonphoneno) {
		this.conpersonphoneno = conpersonphoneno;
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
	public String getRecstatus() {
		return recstatus;
	}
	public void setRecstatus(String recstatus) {
		this.recstatus = recstatus;
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
	
	
	
}

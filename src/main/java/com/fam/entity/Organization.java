package com.fam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "organization", schema = "public")
public class Organization implements java.io.Serializable {
@Id
	private long recordid;
	private String shortcode;
	private String bank;
	private String address;
	private String pin;
	private String city;
	private String state;
	private String country;
	private String phone1;
	private String phone2;
	private String email;
	private Date finyrfrom;
	private Date finyrto;
	private String depreapplied;
	private String minvalasset;
	private String deprefreq;
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
	private String transactions;

	public Organization() {
	}

	public Organization(long recordid) {
		this.recordid = recordid;
	}


	public Organization(long recordid, String shortcode, String bank, String address, String pin, String city,
			String state, String country, String phone1, String phone2, String email, Date finyrfrom, Date finyrto,
			String depreapplied, String minvalasset, String deprefreq, String remark, String extra1, String extra2,
			String recstatus, String makerid, Date makerdate, String makertime, String makerip, String checkerid,
			Date checkerdate, String checkertime, String checkerip, String approverid, Date approverdate,
			String approvertime, String approverip, String transactions) {
		super();
		this.recordid = recordid;
		this.shortcode = shortcode;
		this.bank = bank;
		this.address = address;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.finyrfrom = finyrfrom;
		this.finyrto = finyrto;
		this.depreapplied = depreapplied;
		this.minvalasset = minvalasset;
		this.deprefreq = deprefreq;
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
		this.transactions = transactions;
	}

	@Id
	@Column(name = "recordid", unique = true, nullable = false)
	public long getRecordid() {
		return this.recordid;
	}
	
	public void setRecordid(long recordid) {
		this.recordid = recordid;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	@Column(name = "bank", length = 100)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "pin", length = 9)
	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", length = 20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone1", length = 20)
	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Column(name = "phone2", length = 20)
	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "finyrfrom", length = 13)
	public Date getFinyrfrom() {
		return finyrfrom;
	}

	public void setFinyrfrom(Date finyrfrom) {
		this.finyrfrom = finyrfrom;
	}
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "finyrto", length = 13)
	public Date getFinyrto() {
		return finyrto;
	}

	public void setFinyrto(Date finyrto) {
		this.finyrto = finyrto;
	}
	@Column(name = "depreapplied", length = 100)
	public String getDepreapplied() {
		return depreapplied;
	}

	public void setDepreapplied(String depreapplied) {
		this.depreapplied = depreapplied;
	}
	@Column(name = "minvalasset", length = 10)
	public String getMinvalasset() {
		return minvalasset;
	}

	public void setMinvalasset(String minvalasset) {
		this.minvalasset = minvalasset;
	}
	@Column(name = "deprefreq", length = 100)
	public String getDeprefreq() {
		return deprefreq;
	}

	public void setDeprefreq(String deprefreq) {
		this.deprefreq = deprefreq;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "extra1", length = 20)
	public String getExtra1() {
		return this.extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	@Column(name = "extra2", length = 50)
	public String getExtra2() {
		return this.extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	@Column(name = "recstatus", length = 1)
	public String getRecstatus() {
		return this.recstatus;
	}

	public void setRecstatus(String recstatus) {
		this.recstatus = recstatus;
	}

	@Column(name = "makerid", length = 10)
	public String getMakerid() {
		return this.makerid;
	}

	public void setMakerid(String makerid) {
		this.makerid = makerid;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "makerdate", length = 13)
	public Date getMakerdate() {
		return this.makerdate;
	}

	public void setMakerdate(Date makerdate) {
		this.makerdate = makerdate;
	}

	@Column(name = "makertime", length = 8)
	public String getMakertime() {
		return this.makertime;
	}

	public void setMakertime(String makertime) {
		this.makertime = makertime;
	}

	@Column(name = "makerip", length = 15)
	public String getMakerip() {
		return this.makerip;
	}

	public void setMakerip(String makerip) {
		this.makerip = makerip;
	}

	@Column(name = "checkerid", length = 10)
	public String getCheckerid() {
		return this.checkerid;
	}

	public void setCheckerid(String checkerid) {
		this.checkerid = checkerid;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "checkerdate", length = 13)
	public Date getCheckerdate() {
		return this.checkerdate;
	}

	public void setCheckerdate(Date checkerdate) {
		this.checkerdate = checkerdate;
	}

	@Column(name = "checkertime", length = 8)
	public String getCheckertime() {
		return this.checkertime;
	}

	public void setCheckertime(String checkertime) {
		this.checkertime = checkertime;
	}

	@Column(name = "checkerip", length = 15)
	public String getCheckerip() {
		return this.checkerip;
	}

	public void setCheckerip(String checkerip) {
		this.checkerip = checkerip;
	}

	@Column(name = "approverid", length = 10)
	public String getApproverid() {
		return this.approverid;
	}

	public void setApproverid(String approverid) {
		this.approverid = approverid;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "approverdate", length = 13)
	public Date getApproverdate() {
		return this.approverdate;
	}

	public void setApproverdate(Date approverdate) {
		this.approverdate = approverdate;
	}

	@Column(name = "approvertime", length = 8)
	public String getApprovertime() {
		return this.approvertime;
	}

	public void setApprovertime(String approvertime) {
		this.approvertime = approvertime;
	}

	@Column(name = "approverip", length = 15)
	public String getApproverip() {
		return this.approverip;
	}

	public void setApproverip(String approverip) {
		this.approverip = approverip;
	}


	@Column(name = "transactions", length = 1)
	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}

	
}

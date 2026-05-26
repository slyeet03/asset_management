package com.fam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "bglpara", schema = "public")
public class Bglpara implements java.io.Serializable {
	@Id
	@SequenceGenerator(name = "bglpara_sequence_generator", sequenceName = "bglpara_recordid_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bglpara_sequence_generator")
	private long recordid;
	private String bglnumb;
	private String bgldesc;
	private String reporela;
	private String apprvr1;
	private String recstatus1;
	private String apprvr2;
	private String recstatus2;
	private String apprvr3;
	private String recstatus3;
	private String currapprvr;
	private String currrecstatus;
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

	public Bglpara() {
	}

	public Bglpara(long recordid) {
		this.recordid = recordid;
	}

	public Bglpara(long recordid, String bglnumb, String bgldesc, String reporela, String apprvr1, String recstatus1,
			String apprvr2, String recstatus2, String apprvr3, String recstatus3, String currapprvr,
			String currrecstatus, String remark, String extra1, String extra2, String extra3, String recstatus,
			String userlevel, String rolename, String makerid, Date makerdate, String makertime, String makerip,
			String checkerid, Date checkerdate, String checkertime, String checkerip, String approverid,
			Date approverdate, String approvertime, String approverip) {
		this.recordid = recordid;
		this.bglnumb = bglnumb;
		this.bgldesc = bgldesc;
		this.reporela = reporela;
		this.apprvr1 = apprvr1;
		this.recstatus1 = recstatus1;
		this.apprvr2 = apprvr2;
		this.recstatus2 = recstatus2;
		this.apprvr3 = apprvr3;
		this.recstatus3 = recstatus3;
		this.currapprvr = currapprvr;
		this.currrecstatus = currrecstatus;
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
	}

	
	@Column(name = "recordid", unique = true, nullable = false)
	public long getRecordid() {
		return this.recordid;
	}

	public void setRecordid(long recordid) {
		this.recordid = recordid;
	}

	@Column(name = "bglnumb", length = 20)
	public String getBglnumb() {
		return this.bglnumb;
	}

	public void setBglnumb(String bglnumb) {
		this.bglnumb = bglnumb;
	}

	@Column(name = "bgldesc", length = 50)
	public String getBgldesc() {
		return this.bgldesc;
	}

	public void setBgldesc(String bgldesc) {
		this.bgldesc = bgldesc;
	}

	@Column(name = "reporela", length = 10)
	public String getReporela() {
		return this.reporela;
	}

	public void setReporela(String reporela) {
		this.reporela = reporela;
	}

	@Column(name = "apprvr1", length = 20)
	public String getApprvr1() {
		return this.apprvr1;
	}

	public void setApprvr1(String apprvr1) {
		this.apprvr1 = apprvr1;
	}

	@Column(name = "recstatus1", length = 2)
	public String getRecstatus1() {
		return this.recstatus1;
	}

	public void setRecstatus1(String recstatus1) {
		this.recstatus1 = recstatus1;
	}

	@Column(name = "apprvr2", length = 20)
	public String getApprvr2() {
		return this.apprvr2;
	}

	public void setApprvr2(String apprvr2) {
		this.apprvr2 = apprvr2;
	}

	@Column(name = "recstatus2", length = 2)
	public String getRecstatus2() {
		return this.recstatus2;
	}

	public void setRecstatus2(String recstatus2) {
		this.recstatus2 = recstatus2;
	}

	@Column(name = "apprvr3", length = 20)
	public String getApprvr3() {
		return this.apprvr3;
	}

	public void setApprvr3(String apprvr3) {
		this.apprvr3 = apprvr3;
	}

	@Column(name = "recstatus3", length = 2)
	public String getRecstatus3() {
		return this.recstatus3;
	}

	public void setRecstatus3(String recstatus3) {
		this.recstatus3 = recstatus3;
	}

	@Column(name = "currapprvr", length = 20)
	public String getCurrapprvr() {
		return this.currapprvr;
	}

	public void setCurrapprvr(String currapprvr) {
		this.currapprvr = currapprvr;
	}

	@Column(name = "currrecstatus", length = 2)
	public String getCurrrecstatus() {
		return this.currrecstatus;
	}

	public void setCurrrecstatus(String currrecstatus) {
		this.currrecstatus = currrecstatus;
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

	@Column(name = "extra3", length = 100)
	public String getExtra3() {
		return this.extra3;
	}

	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}

	@Column(name = "recstatus", length = 1)
	public String getRecstatus() {
		return this.recstatus;
	}

	public void setRecstatus(String recstatus) {
		this.recstatus = recstatus;
	}

	@Column(name = "userlevel", length = 10)
	public String getUserlevel() {
		return this.userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}

	@Column(name = "rolename", length = 10)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "makerid", length = 10)
	public String getMakerid() {
		return this.makerid;
	}

	public void setMakerid(String makerid) {
		this.makerid = makerid;
	}

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

}

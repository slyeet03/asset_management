package com.fam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "usermaster", schema = "public")
public class Usermaster implements java.io.Serializable {

@Id
	private String userid;
	private String username;
	private String empcode;
	private String userlevel;
	private String rolename;
	private String pwd;
	private Date pwdexpirydate;
	private Date pwdchangedate;
	private Character locked;
	private String lockedreason;
	private Character loggedin;
	private Date logindate;
	private String logintime;
	private Date logoutdate;
	private String logouttime;
	private Byte attempcount;
	private Byte attempallowed;
	private Character thumbcheck;
	private Date createdate;
	private Character multiplelogin;
	private Character interBrhTrans;
	private Character iscashier;
	private String cashuser;
	private Date cashiersince;
	private String status;
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
	private String extras1;
	private String branch;
	private String coaccnumb;

	
	public Usermaster() {
	}

	public Usermaster(String userid) {
		this.userid = userid;
	}

	public Usermaster(String userid, String username, String empcode, String userlevel, String rolename, String pwd,
			Date pwdexpirydate, Date pwdchangedate, Character locked, String lockedreason, Character loggedin,
			Date logindate, String logintime, Date logoutdate, String logouttime, Byte attempcount, Byte attempallowed,
			Character thumbcheck, Date createdate, Character multiplelogin, Character interBrhTrans,
			Character iscashier, String cashuser, Date cashiersince, String status, String recstatus, String makerid,
			Date makerdate, String makertime, String makerip, String checkerid, Date checkerdate, String checkertime,
			String checkerip, String approverid, Date approverdate, String approvertime, String approverip,
			String extras1, String branch, String coaccnumb) {
		this.userid = userid;
		this.username = username;
		this.empcode = empcode;
		this.userlevel = userlevel;
		this.rolename = rolename;
		this.pwd = pwd;
		this.pwdexpirydate = pwdexpirydate;
		this.pwdchangedate = pwdchangedate;
		this.locked = locked;
		this.lockedreason = lockedreason;
		this.loggedin = loggedin;
		this.logindate = logindate;
		this.logintime = logintime;
		this.logoutdate = logoutdate;
		this.logouttime = logouttime;
		this.attempcount = attempcount;
		this.attempallowed = attempallowed;
		this.thumbcheck = thumbcheck;
		this.createdate = createdate;
		this.multiplelogin = multiplelogin;
		this.interBrhTrans = interBrhTrans;
		this.iscashier = iscashier;
		this.cashuser = cashuser;
		this.cashiersince = cashiersince;
		this.status = status;
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
		this.extras1 = extras1;
		this.branch = branch;
		this.coaccnumb = coaccnumb;
	}

	@Column(name = "userid", unique = true, nullable = false, length = 10)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "empcode", length = 10)
	public String getEmpcode() {
		return this.empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
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

	@Column(name = "pwd", length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pwdexpirydate", length = 13)
	public Date getPwdexpirydate() {
		return this.pwdexpirydate;
	}

	public void setPwdexpirydate(Date pwdexpirydate) {
		this.pwdexpirydate = pwdexpirydate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pwdchangedate", length = 13)
	public Date getPwdchangedate() {
		return this.pwdchangedate;
	}

	public void setPwdchangedate(Date pwdchangedate) {
		this.pwdchangedate = pwdchangedate;
	}

	@Column(name = "locked", length = 1)
	public Character getLocked() {
		return this.locked;
	}

	public void setLocked(Character locked) {
		this.locked = locked;
	}

	@Column(name = "lockedreason", length = 50)
	public String getLockedreason() {
		return this.lockedreason;
	}

	public void setLockedreason(String lockedreason) {
		this.lockedreason = lockedreason;
	}

	@Column(name = "loggedin", length = 1)
	public Character getLoggedin() {
		return this.loggedin;
	}

	public void setLoggedin(Character loggedin) {
		this.loggedin = loggedin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "logindate", length = 13)
	public Date getLogindate() {
		return this.logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

	@Column(name = "logintime", length = 8)
	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "logoutdate", length = 13)
	public Date getLogoutdate() {
		return this.logoutdate;
	}

	public void setLogoutdate(Date logoutdate) {
		this.logoutdate = logoutdate;
	}

	@Column(name = "logouttime", length = 8)
	public String getLogouttime() {
		return this.logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	@Column(name = "attempcount", precision = 2, scale = 0)
	public Byte getAttempcount() {
		return this.attempcount;
	}

	public void setAttempcount(Byte attempcount) {
		this.attempcount = attempcount;
	}

	@Column(name = "attempallowed", precision = 2, scale = 0)
	public Byte getAttempallowed() {
		return this.attempallowed;
	}

	public void setAttempallowed(Byte attempallowed) {
		this.attempallowed = attempallowed;
	}

	@Column(name = "thumbcheck", length = 1)
	public Character getThumbcheck() {
		return this.thumbcheck;
	}

	public void setThumbcheck(Character thumbcheck) {
		this.thumbcheck = thumbcheck;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", length = 13)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "multiplelogin", length = 1)
	public Character getMultiplelogin() {
		return this.multiplelogin;
	}

	public void setMultiplelogin(Character multiplelogin) {
		this.multiplelogin = multiplelogin;
	}

	@Column(name = "inter_brh_trans", length = 1)
	public Character getInterBrhTrans() {
		return this.interBrhTrans;
	}

	public void setInterBrhTrans(Character interBrhTrans) {
		this.interBrhTrans = interBrhTrans;
	}

	@Column(name = "iscashier", length = 1)
	public Character getIscashier() {
		return this.iscashier;
	}

	public void setIscashier(Character iscashier) {
		this.iscashier = iscashier;
	}

	@Column(name = "cashuser", length = 10)
	public String getCashuser() {
		return this.cashuser;
	}

	public void setCashuser(String cashuser) {
		this.cashuser = cashuser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cashiersince", length = 29)
	public Date getCashiersince() {
		return this.cashiersince;
	}

	public void setCashiersince(Date cashiersince) {
		this.cashiersince = cashiersince;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Column(name = "extras1", length = 100)
	public String getExtras1() {
		return this.extras1;
	}

	public void setExtras1(String extras1) {
		this.extras1 = extras1;
	}

	@Column(name = "branch", length = 10)
	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "coaccnumb", length = 20)
	public String getCoaccnumb() {
		return this.coaccnumb;
	}

	public void setCoaccnumb(String coaccnumb) {
		this.coaccnumb = coaccnumb;
	}

	@Override
	public String toString() {
		return "Usermaster [userid=" + userid + ", username=" + username + ", empcode="
				+ empcode + ", userlevel=" + userlevel + ", rolename=" + rolename + ", pwd=" + pwd + ", pwdexpirydate="
				+ pwdexpirydate + ", pwdchangedate=" + pwdchangedate + ", locked=" + locked + ", lockedreason="
				+ lockedreason + ", loggedin=" + loggedin + ", logindate=" + logindate + ", logintime=" + logintime
				+ ", logoutdate=" + logoutdate + ", logouttime=" + logouttime + ", attempcount=" + attempcount
				+ ", attempallowed=" + attempallowed + ", thumbcheck=" + thumbcheck + ", createdate=" + createdate
				+ ", multiplelogin=" + multiplelogin + ", interBrhTrans=" + interBrhTrans + ", iscashier=" + iscashier
				+ ", cashuser=" + cashuser + ", cashiersince=" + cashiersince + ", status=" + status + ", recstatus="
				+ recstatus + ", makerid=" + makerid + ", makerdate=" + makerdate + ", makertime=" + makertime
				+ ", makerip=" + makerip + ", checkerid=" + checkerid + ", checkerdate=" + checkerdate
				+ ", checkertime=" + checkertime + ", checkerip=" + checkerip + ", approverid=" + approverid
				+ ", approverdate=" + approverdate + ", approvertime=" + approvertime + ", approverip=" + approverip
				+ ", extras1=" + extras1 + ", branch=" + branch + ", coaccnumb=" + coaccnumb + "]";
	}

	
	
}

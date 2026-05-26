package com.fam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "auditlog", schema = "public")
public class Auditlog implements java.io.Serializable{
	@Id
			public  long recordid = 0;
			public  String userid = "";
			public  String userlevel = "";
			public  Date logdate = new Date();
			public  String logtime = "";
			public  String logip = "";
			public  String urlDesc = "";
			public  String formname = "";
			public  String eventname = "";
			public  String tablename = "";
			public  String param = "";
			public  String qry = "";
			public  String remarks = "";
			
			
			@Override
			public String toString() {
				return "Auditlog [recordid=" + recordid + ", userid=" + userid + ", userlevel=" + userlevel
						+ ", logdate=" + logdate + ", logtime=" + logtime + ", logip=" + logip + ", urlDesc=" + urlDesc
						+ ", formname=" + formname + ", eventname=" + eventname + ", tablename=" + tablename
						+ ", param=" + param + ", qry=" + qry + ", remarks=" + remarks + "]";
			}

}

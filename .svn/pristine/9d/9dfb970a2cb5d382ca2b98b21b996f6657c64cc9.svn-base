package com.fam.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.Auditlog;
import com.fam.entity.Organization;


@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;
	
	@Override
	public Organization getOrganizationDetail() {
		Organization organization = (Organization) entityManager.createQuery("From Organization").getResultList().get(0);
		return organization;
	}

	@Transactional
	@Override
	public void updateOrganization(Organization organization) {
		entityManager.merge(organization);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = organization.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = organization.getMakerdate();
		auditlog.logtime = organization.getMakertime();
		auditlog.logip = organization.getMakerip();
		auditlog.formname = "Organization Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "organization";
		auditlog.qry = "Update organization";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Override
	public void updateorganizationresctatus(String recstatus, Date date, String time, String userId, String userIp) {
		
		String HSQL = "Update Organization set recstatus=:recstatus,checkerdate=:currentDate,checkertime=:currentTime,checkerip=:userIp,checkerid=:userId";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		query.setParameter("currentDate", date);
		query.setParameter("currentTime", time);
		query.setParameter("userIp", userIp);
		query.setParameter("userId", userId);
        query.executeUpdate();
	    Auditlog auditlog = new Auditlog();		
		auditlog.userid = userId;
		auditlog.userlevel = "Checker";
		auditlog.logdate  = date;
		auditlog.logtime = time;
		auditlog.logip = userIp;
		auditlog.formname = "Organization Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "organization";
		auditlog.qry = "Update recstatus in organization";
		auditlog.param = "recstatus="+recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}
	
}

package com.fam.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.AssetCategoryMaster;
import com.fam.entity.Auditlog;
import com.fam.entity.Branchmaster;
import com.fam.values.ASSET_MANAGEMENTConstants;
@Repository
public class BranchMasterDaoImpl implements BranchMasterDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;
	
	@Override
	public Branchmaster getBranchmaster(long recordid) {
		String HSQL = "From Branchmaster where recordid=:recordid";
		Query query= entityManager.createQuery(HSQL);
		query= query.setParameter("recordid", recordid);
		List<Branchmaster> ls = query.getResultList();
		return ls.get(0);
	}

	@Transactional
	@Override
	public void insertBranchmaster(Branchmaster branchmaster) {
		entityManager.persist(branchmaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = branchmaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = branchmaster.getMakerdate();
		auditlog.logtime = branchmaster.getMakertime();
		auditlog.logip = branchmaster.getMakerip();
		auditlog.formname = "Branchmaster Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "branchmaster";
		auditlog.qry = "Insert into branchmaster";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

	@Transactional
	@Override
	public void updateBranchmaster(Branchmaster branchmaster) {
		entityManager.merge(branchmaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = branchmaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = branchmaster.getMakerdate();
		auditlog.logtime = branchmaster.getMakertime();
		auditlog.logip = branchmaster.getMakerip();
		auditlog.formname = "Branchmaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "branchmaster";
		auditlog.qry = "Update branchmaster";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}
  
	@Override
	public List<Branchmaster> getBranchmasterlist(String recstatus) {
		String HSQL = "from Branchmaster where recstatus=:recstatus";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<Branchmaster> ls = query.getResultList();
		return ls;
	}
	@Transactional
	@Override
	public int updateBranchmaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		String HSQL = "Update Branchmaster set recstatus=:recstatus,";
		if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_1 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_5)|| 
				(userlevel >= ASSET_MANAGEMENTConstants.userlevel_21 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_25))
		{
			HSQL = HSQL+"makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		}
		else if((userlevel >= ASSET_MANAGEMENTConstants.userlevel_6 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_10)|| 
				 (userlevel >= ASSET_MANAGEMENTConstants.userlevel_26 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_30))
		{
			HSQL = HSQL+"checkerdate=:currentDate,checkertime=:currentTime,checkerip=:userIp,checkerid=:userId";
		}
		else{
			HSQL = HSQL+"makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		}
		HSQL = HSQL +" where recordid in :recordid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		query.setParameter("currentDate", date);
		query.setParameter("currentTime", time);
		query.setParameter("userIp", userIp);
		query.setParameter("userId", userId);
		query.setParameter("recordid", recordids);
	    int numberOFRecordsUpdated=query.executeUpdate();
	    Auditlog auditlog = new Auditlog();		
		auditlog.userid = userId;
		auditlog.userlevel = "Checker";
		auditlog.logdate  = date;
		auditlog.logtime = time;
		auditlog.logip = userIp;
		auditlog.formname = "Branchmaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "branchmaster";
		auditlog.qry = "Update recstatus in branchmaster";
		auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	}

	@Override
	public String getBranchmasterCode() {
		String HSQL = "select COALESCE(max(CAST(branchcode as numeric)),0)+1  as branchmastercode from branchmaster";
		String maxcode =  entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}



}

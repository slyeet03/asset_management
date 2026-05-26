package com.fam.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.AssetDepartment;
import com.fam.entity.Auditlog;
import com.fam.values.ASSET_MANAGEMENTConstants;

@SuppressWarnings({"static-access","unchecked"})
@Repository
public class AssetDepartmentMasterDaoImpl implements  AssetDepartmentMasterDao {


	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;
	
	@Override
	public AssetDepartment getAssetDepartment(long recordid) {
		String HSQL = "from AssetDepartment where recordid=:recordid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recordid", recordid);
	 return (AssetDepartment) query.getResultList().get(0);
	}

	@Transactional
	@Override
	public void insertAssetDepartment(AssetDepartment assetDepartment) {
		entityManager.persist(assetDepartment);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = assetDepartment.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = assetDepartment.getMakerdate();
		auditlog.logtime = assetDepartment.getMakertime();
		auditlog.logip = assetDepartment.getMakerip();
		auditlog.formname = "AssetDepartment Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "assetdepartment";
		auditlog.qry = "Insert into assetdepartment";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

	@Transactional
	@Override
	public void updateAssetDepartment(AssetDepartment assetDepartment) {
		entityManager.merge(assetDepartment);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = assetDepartment.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = assetDepartment.getMakerdate();
		auditlog.logtime = assetDepartment.getMakertime();
		auditlog.logip = assetDepartment.getMakerip();
		auditlog.formname = "AssetDepartment Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "assetdepartment";
		auditlog.qry = "Update assetdepartment";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

	@Override
	public List<AssetDepartment> getAssetDepartmentlist(String recstatus) {
		String HSQL = "from AssetDepartment where recstatus=:recstatus";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<AssetDepartment> ls = query.getResultList();
		return ls;
	}

	@Transactional
	@Override
	public int updateAssetDepartment(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
			String HSQL = "Update AssetDepartment set recstatus=:recstatus,";
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
			auditlog.formname = "AssetDepartment Master";
			auditlog.eventname = "Update";
			auditlog.tablename = "assetdepartment";
			auditlog.qry = "Update recstatus in assetdepartment";
			auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
			auditlog.remarks = "";
			auditLogDaoImpl.addAuditLog(auditlog);
			return numberOFRecordsUpdated;
	}

	
	@Override
	public String getDepartmentcode() {
		String HSQL = "select COALESCE(max(CAST(departmentcode as numeric)),0)+1  as assetdeptcode from assetdepartment";
		String maxcode =  entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}

}

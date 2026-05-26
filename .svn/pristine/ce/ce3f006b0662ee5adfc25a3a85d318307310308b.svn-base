package com.fam.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.AssetSubCategoryMaster;
import com.fam.entity.Auditlog;
import com.fam.values.ASSET_MANAGEMENTConstants;

@SuppressWarnings({"static-access","unchecked"})
@Repository
public class AssetSubCategoryMasterDaoImpl implements AssetSubCategoryMasterDao{

	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;
	
	@Override
	public AssetSubCategoryMaster getAssetSubCategory(long recordid) {
		String HSQL = "from AssetSubCategoryMaster where recordid=:recordid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recordid", recordid);
	 return (AssetSubCategoryMaster) query.getResultList().get(0);
	}

	@Transactional
	@Override
	public void insertAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster) {
		entityManager.persist(assetSubCategoryMaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = assetSubCategoryMaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = assetSubCategoryMaster.getMakerdate();
		auditlog.logtime = assetSubCategoryMaster.getMakertime();
		auditlog.logip = assetSubCategoryMaster.getMakerip();
		auditlog.formname = "AssetSubCategoryMaster Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "subcatmast";
		auditlog.qry = "Insert into subcatmast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Transactional
	@Override
	public void updateAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster) {
		entityManager.merge(assetSubCategoryMaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = assetSubCategoryMaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = assetSubCategoryMaster.getMakerdate();
		auditlog.logtime = assetSubCategoryMaster.getMakertime();
		auditlog.logip = assetSubCategoryMaster.getMakerip();
		auditlog.formname = "AssetSubCategoryMaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "subcatmast";
		auditlog.qry = "Update subcatmast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

	@Override
	public List<AssetSubCategoryMaster> getAssetSubCategorylist(String recstatus) {
		String HSQL = "from AssetSubCategoryMaster where recstatus=:recstatus";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<AssetSubCategoryMaster> ls = query.getResultList();
		return ls;
	}

	@Transactional
	@Override
	public int updateAssetSubCategory(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
			String HSQL = "Update AssetSubCategoryMaster set recstatus=:recstatus,";
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
				auditlog.formname = "AssetSubCategoryMaster Master";
				auditlog.eventname = "Update";
				auditlog.tablename = "catmast";
				auditlog.qry = "Update recstatus in subcatmast";
				auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
				auditlog.remarks = "";
				auditLogDaoImpl.addAuditLog(auditlog);
				return numberOFRecordsUpdated;
	}

	@Override
	public String getAssetSubCategoryCode() {
		String HSQL = "select COALESCE(max(CAST(subcategorycode as numeric)),0)+1  as subcategorycode from subcatmast";
		String maxcode =  entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}


}

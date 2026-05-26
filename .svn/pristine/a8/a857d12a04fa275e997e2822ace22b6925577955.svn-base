package com.fam.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fam.entity.Auditlog;
import com.fam.entity.CategoryAccountDetails;
import com.fam.values.ASSET_MANAGEMENTConstants;

@Repository
public class CategoryAccountDetailsDaoImpl implements CategoryAccountDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;

	@Override
	public CategoryAccountDetails getCategoryAccountDetails(long recordid) {
		String HSQL = "from CategoryAccountDetails where recordid=:recordid";
		Query query = entityManager.createQuery(HSQL);
		query = query.setParameter("recordid", recordid);
		List<CategoryAccountDetails> resultList = query.getResultList();
		return resultList.get(0);
	}

	@Transactional
	@Override
	public void insertCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails) {
		entityManager.persist(categoryAccountDetails);
		Auditlog auditlog = new Auditlog();
		auditlog.userid = categoryAccountDetails.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate = categoryAccountDetails.getMakerdate();
		auditlog.logtime = categoryAccountDetails.getMakertime();
		auditlog.logip = categoryAccountDetails.getMakerip();
		auditlog.formname = "CategoryAccountDetails Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "categoryaccntdetails";
		auditlog.qry = "Insert into categoryaccntdetails";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Transactional
	@Override
	public void updateCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails) {
		entityManager.merge(categoryAccountDetails);
		Auditlog auditlog = new Auditlog();
		auditlog.userid = categoryAccountDetails.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate = categoryAccountDetails.getMakerdate();
		auditlog.logtime = categoryAccountDetails.getMakertime();
		auditlog.logip = categoryAccountDetails.getMakerip();
		auditlog.formname = "CategoryAccountDetails Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "categoryaccntdetails";
		auditlog.qry = "Update categoryaccntdetails";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);

	}

	@Override
	public List<CategoryAccountDetails> getCategoryAccountDetailslist(String recstatus) {
		String HSQL = "from CategoryAccountDetails where recstatus=:recstatus";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<CategoryAccountDetails> ls = query.getResultList();
		return ls;
	}

	@Transactional
	@Override
	public int updateCategoryAccountDetails(List<Long> recordids, String recstatus, Date date, String time,
			String userId, String userIp, int userlevel) {
		String HSQL = "Update CategoryAccountDetails set recstatus=:recstatus,";
		if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_1 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_5)
				|| (userlevel >= ASSET_MANAGEMENTConstants.userlevel_21
						&& userlevel <= ASSET_MANAGEMENTConstants.userlevel_25)) {
			HSQL = HSQL + "makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		} else if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_6
				&& userlevel <= ASSET_MANAGEMENTConstants.userlevel_10)
				|| (userlevel >= ASSET_MANAGEMENTConstants.userlevel_26
						&& userlevel <= ASSET_MANAGEMENTConstants.userlevel_30)) {
			HSQL = HSQL + "checkerdate=:currentDate,checkertime=:currentTime,checkerip=:userIp,checkerid=:userId";
		} else {
			HSQL = HSQL + "makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		}
		HSQL = HSQL + " where recordid in :recordid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		query.setParameter("currentDate", date);
		query.setParameter("currentTime", time);
		query.setParameter("userIp", userIp);
		query.setParameter("userId", userId);
		query.setParameter("recordid", recordids);
		int numberOFRecordsUpdated = query.executeUpdate();
		Auditlog auditlog = new Auditlog();
		auditlog.userid = userId;
		auditlog.userlevel = "Checker";
		auditlog.logdate = date;
		auditlog.logtime = time;
		auditlog.logip = userIp;
		auditlog.formname = "CategoryAccountDetails Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "categoryaccntdetails";
		auditlog.qry = "Update recstatus in categoryaccntdetails";
		auditlog.param = "recordids=" + recordids + ",recstatus=" + recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	}

	@Override
	public String getCategoryAccountDetailsCode() {
		String HSQL = "select COALESCE(max(accntdetailsid),0)+1  as catacctdetailscode from categoryaccntdetails";
		String maxcode = entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}

}

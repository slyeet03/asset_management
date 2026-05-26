package com.fam.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.Auditlog;
import com.fam.entity.Branchmaster;
import com.fam.entity.VendorMaster;
import com.fam.values.ASSET_MANAGEMENTConstants;

@NamedQuery(name = "findDataFromTwoTables", query = "SELECT e1, e2 FROM VendorMaster e1 JOIN Branchmaster e2 ON e1.city = e2.city")
@Repository
public class VenorMasterDaoImpl implements VendorMasterDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;

	@Transactional
	@Override
	public void insertVendorMaster(VendorMaster vendorMaster) {
		System.out.println("Insert Vendor Master");
		entityManager.persist(vendorMaster);
		Auditlog auditlog = new Auditlog();
		auditlog.userid = vendorMaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate = vendorMaster.getMakerdate();
		auditlog.logtime = vendorMaster.getMakertime();
		auditlog.logip = vendorMaster.getMakerip();
		auditlog.formname = "VendorMaster Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "vendormast";
		auditlog.qry = "Insert into vendormast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Transactional
	@Override
	public void updateVendorMaster(VendorMaster vendorMaster) {

		entityManager.merge(vendorMaster);
		Auditlog auditlog = new Auditlog();
		auditlog.userid = vendorMaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate = vendorMaster.getMakerdate();
		auditlog.logtime = vendorMaster.getMakertime();
		auditlog.logip = vendorMaster.getMakerip();
		auditlog.formname = "VendorMaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "vendormast";
		auditlog.qry = "Update vendormast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Override
	public VendorMaster getVendorMaster(long recordid) {
		String HSQL = "From VendorMaster where recordid=:recordid";
		Query query = entityManager.createQuery(HSQL);
		query = query.setParameter("recordid", recordid);
		List<VendorMaster> ls = query.getResultList();
		return ls.get(0);
	}

	@Override
	public String getVendorMasterCode() {
		String HSQL = "select COALESCE(max(CAST(vendorcode as numeric)),0)+1  as vendorcode from vendormast";
		String maxcode = entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}

	@Transactional
	@Override
	public int updateVendorMaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {

		String HSQL = "Update VendorMaster set recstatus=:recstatus,";
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
		auditlog.formname = "VendorMaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "vendormast";
		auditlog.qry = "Update recstatus in vendormast";
		auditlog.param = "recordids=" + recordids + ",recstatus=" + recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	}

	@Override
	public List<VendorMaster> getVendorMasterlist(String recstatus) {
		String HSQL = "from VendorMaster where recstatus=:recstatus";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<VendorMaster> ls = query.getResultList();
		System.out.println("getVendorMasterlist: " + ls);
		return ls;
	}

	@Override
	public List<Object> findDataFrom2Tables() {
		TypedQuery<Object> query = entityManager.createNamedQuery("findDataFromTwoTables", Object.class);
		return query.getResultList();
	}


}

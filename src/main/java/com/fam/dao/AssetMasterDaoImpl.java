package com.fam.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.AssetMaster;
import com.fam.entity.Auditlog;
import com.fam.values.ASSET_MANAGEMENTConstants;

@Repository
public class AssetMasterDaoImpl implements AssetMasterDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  AuditLogDaoImpl auditLogDaoImpl;

  @Override
  public AssetMaster getAsset(long recordid) {
    String HSQL = "from AssetMaster where recordid=:recordid";
    Query query = entityManager.createQuery(HSQL);
    query = query.setParameter("recordid", recordid);
    List<AssetMaster> result = query.getResultList();
    return result.get(0);
  }

  @Transactional
  @Override
  public void insertAssetMaster(AssetMaster assetMaster) {
    entityManager.persist(assetMaster);
    Auditlog auditlog = new Auditlog();
    auditlog.userid = assetMaster.getMakerid();
    auditlog.userlevel = "Maker";
    auditlog.logdate = assetMaster.getMakerdate();
    auditlog.logtime = assetMaster.getMakertime();
    auditlog.logip = assetMaster.getMakerip();
    auditlog.formname = "AssetMaster Master";
    auditlog.eventname = "Insert";
    auditlog.tablename = "assetmaster";
    auditlog.qry = "Insert into assetmaster";
    auditlog.param = "";
    auditlog.remarks = "";
    auditLogDaoImpl.addAuditLog(auditlog);

  }

  @Transactional
  @Override
  public void updateAssetMaster(AssetMaster assetMaster) {
    entityManager.merge(assetMaster);
    Auditlog auditlog = new Auditlog();
    auditlog.userid = assetMaster.getMakerid();
    auditlog.userlevel = "Maker";
    auditlog.logdate = assetMaster.getMakerdate();
    auditlog.logtime = assetMaster.getMakertime();
    auditlog.logip = assetMaster.getMakerip();
    auditlog.formname = "AssetMaster Master";
    auditlog.eventname = "Update";
    auditlog.tablename = "assetmaster";
    auditlog.qry = "Update assetmaster";
    auditlog.param = "";
    auditlog.remarks = "";
    auditLogDaoImpl.addAuditLog(auditlog);

  }

  @Override
  public List<AssetMaster> getAssetlist(String recstatus) {
    String HSQL = "from AssetMaster where recstatus=:recstatus";
    Query query = entityManager.createQuery(HSQL);
    query.setParameter("recstatus", recstatus);
    List<AssetMaster> ls = query.getResultList();
    return ls;
  }

  @Transactional
  @Override
  public int updateAssetMaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
      String userIp, int userlevel) {
    String HSQL = "Update AssetMaster set recstatus=:recstatus,";
    if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_1 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_5)
        || (userlevel >= ASSET_MANAGEMENTConstants.userlevel_21
            && userlevel <= ASSET_MANAGEMENTConstants.userlevel_25)) {
      HSQL = HSQL + "makerdate=:Date,makertime=:Time,makerip=:userIp,makerid=:userId";
    } else if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_6
        && userlevel <= ASSET_MANAGEMENTConstants.userlevel_10)
        || (userlevel >= ASSET_MANAGEMENTConstants.userlevel_26
            && userlevel <= ASSET_MANAGEMENTConstants.userlevel_30)) {
      HSQL = HSQL + "checkerdate=:Date,checkertime=:Time,checkerip=:userIp,checkerid=:userId";
    } else {
      HSQL = HSQL + "makerdate=:Date,makertime=:Time,makerip=:userIp,makerid=:userId";
    }
    HSQL = HSQL + " where recordid in :recordid";
    Query query = entityManager.createQuery(HSQL);
    query.setParameter("recstatus", recstatus);
    query.setParameter("Date", date);
    query.setParameter("Time", time);
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
    auditlog.formname = "AssetMaster Master";
    auditlog.eventname = "Update";
    auditlog.tablename = "assetmaster";
    auditlog.qry = "Update recstatus in assetmaster";
    auditlog.param = "recordids=" + recordids + ",recstatus=" + recstatus;
    auditlog.remarks = "";
    auditLogDaoImpl.addAuditLog(auditlog);
    return numberOFRecordsUpdated;
  }

  @Override
  public String getAssetId() {
    String HSQL = "select COALESCE(max(CAST(assetid as numeric)),0)+1  as assetmasterid from assetmaster ";
    String maxcode = entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
    return maxcode;
  }

  @Override
  public String getBranchId() {
    String HSQL = "select COALESCE(max(CAST(branchid as numeric)),0)+1  as assetmasterid from assetmaster ";
    Query query = entityManager.createNativeQuery(HSQL);
    String id = query.getResultList().get(0).toString();
    return id;
  }

  // for the dashboard
  @Override
  public Object[] getAssetSummary(String branchid, String categoryid,
      String subcategoryid, String assetid) {

    String HSQL = "select count(*), " +
        "COALESCE(sum(poamount),0), " +
        "COALESCE(sum(bookvalue),0), " +
        "COALESCE(sum(totaldepreciation),0) " +
        "from AssetMaster where recstatus='5'";

    if (branchid != null && !branchid.isEmpty()) {
      HSQL += " and branchid=:branchid";
    }

    if (categoryid != null && !categoryid.isEmpty()) {
      HSQL += " and categoryid=:categoryid";
    }

    if (subcategoryid != null && !subcategoryid.isEmpty()) {
      HSQL += " and subcategoryid=:subcategoryid";
    }

    if (assetid != null && !assetid.isEmpty()) {
      HSQL += " and assetid=:assetid";
    }

    Query query = entityManager.createQuery(HSQL);

    if (branchid != null && !branchid.isEmpty()) {
      query.setParameter("branchid", branchid);
    }

    if (categoryid != null && !categoryid.isEmpty()) {
      query.setParameter("categoryid", categoryid);
    }

    if (subcategoryid != null && !subcategoryid.isEmpty()) {
      query.setParameter("subcategoryid", subcategoryid);
    }

    if (assetid != null && !assetid.isEmpty()) {
      query.setParameter("assetid", assetid);
    }

    return (Object[]) query.getSingleResult();
  }

  @Override
  public Map<String, String> getBranches() {

    Map<String, String> map = new LinkedHashMap<>();

    String sql = "select distinct branchid from assetmaster order by branchid";

    List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();

    for (Object[] obj : list) {
      map.put(obj[0].toString(), obj[1].toString());
    }

    return map;
  }

  @Override
  public Map<String, String> getCategories() {

    Map<String, String> map = new LinkedHashMap<>();

    String sql = "select distinct categoryid from assetmaster order by categoryid";

    List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();

    for (Object[] obj : list) {
      map.put(obj[0].toString(), obj[1].toString());
    }

    return map;
  }

  @Override
  public Map<String, String> getSubCategories() {

    Map<String, String> map = new LinkedHashMap<>();

    String sql = "select distinct subcategoryid from assetmaster order by subcategoryid";

    List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();

    for (Object[] obj : list) {
      map.put(obj[0].toString(), obj[1].toString());
    }

    return map;
  }

  @Override
  public Map<String, String> getAssets() {

    Map<String, String> map = new LinkedHashMap<>();

    String sql = "select distinct assetid from assetmaster order by assetid";

    List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();

    for (Object[] obj : list) {
      map.put(obj[0].toString(), obj[1].toString());
    }

    return map;
  }

}

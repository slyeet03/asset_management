package com.fam.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fam.entity.Auditlog;
import com.fam.entity.Paramast;
import com.fam.filter.ASSET_MANAGEMENTConstants;

@SuppressWarnings({"static-access","unchecked"})
@Repository
public class ParamastDaoImpl implements ParamastDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;
	
	@Override
	public List<Paramast> getparamast(String[] paratype, String extras1)
			throws Exception {
		String HSQL = "";
		if (extras1 == null) {
			HSQL = "From Paramast where trim(UPPER(paratype)) in :list and recstatus = '5' and allowuser='1' order by to_number(code,'99999') ASC";
		}
		else {
			HSQL = "From Paramast where trim(UPPER(paratype)) in :list and extras1 = :extras1 and recstatus = '5' and allowuser='1' order by to_number(code,'99999') ASC";
		}
		Query query = entityManager.createQuery(HSQL);
		query = query.setParameter("list", Arrays.asList(paratype));
		if (extras1 != null) {
			query = query.setParameter("extras1", extras1);
		}
		List<Paramast> ls = query.getResultList();
		return ls;
	}

	@Override
	public Paramast getparamast(Long recordid) {
		String HSQL = "From Paramast where recordid=? ";
		Query query = entityManager.createQuery(HSQL);
		query = query.setParameter(0, recordid);
		Paramast ls = (Paramast) query.getResultList().get(0);		
		return ls;
	}

	
	@Override
	public List<Paramast> getparamaster() {
		String HSQL = "select distinct Upper(paraname) as paraname,Upper(paratype) as paratype From Paramast where recstatus='5' and allowuser='1' order by paraname ";
		List<Paramast> ls =entityManager.createNativeQuery(HSQL).getResultList();
		return ls;
	}
	
	private class paraMapping implements ResultTransformer{

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("rawtypes")
		@Override
		public List transformList(List data) {
			return data;
		}

		@Override
		public Object transformTuple(Object[] object, String[] header) {
			Paramast paramast = new Paramast();
			try{
				paramast.setParatype(object[1].toString());
			}catch(NullPointerException ne){}
			try{
				paramast.setParaname(object[0].toString());
			}catch(NullPointerException ne){}
			return paramast;
		}
		
	}
	
	@Override
	public String getcode(String paratype) {
		
		String HSQL = "select COALESCE(max(CAST(code as numeric)),0)+1 from Paramast where paratype=?";
		Query query = entityManager.createNativeQuery(HSQL);
		query = query.setParameter(0, paratype);
		String code =  query.getResultList().get(0).toString();		
		return code;
	}

	@Override
	public void update(Paramast paramast) {
		entityManager.merge(paramast);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = paramast.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = paramast.getMakerdate();
		auditlog.logtime = paramast.getMakertime();
		auditlog.logip = paramast.getMakerip();
		auditlog.formname = "Parameter Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "paramast";
		auditlog.qry = "Update paramast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Override
	public int updateparamaster(List<Long> recordids, String recstatus,
			Date date, String time, String userId, String userIp, int userlevel) {
		String HSQL = "Update Paramast set recstatus=?,";
		if ((userlevel >= ASSET_MANAGEMENTConstants.userlevel_1 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_5)|| 
				(userlevel >= ASSET_MANAGEMENTConstants.userlevel_21 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_25))
		{
			HSQL = HSQL+"makerdate=?,makertime=?,makerip=?,makerid=?";
		}
		else if((userlevel >= ASSET_MANAGEMENTConstants.userlevel_6 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_10)|| 
				 (userlevel >= ASSET_MANAGEMENTConstants.userlevel_26 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_30)) {
			HSQL = HSQL+"checkerdate=?,checkertime=?,checkerip=?,checkerid=?";
		}
		else if(userlevel >= ASSET_MANAGEMENTConstants.userlevel_11 && userlevel <= ASSET_MANAGEMENTConstants.userlevel_15){
			HSQL = HSQL+"approverdate=?,approvertime=?,approverip=?,approverid=?";
		}
		else{
			HSQL = HSQL+"makerdate=?,makertime=?,makerip=?,makerid=?";
		}
		HSQL = HSQL +" where recordid in :recordid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter(0, recstatus);
		query.setParameter(1, date);
		query.setParameter(2, time);
		query.setParameter(3, userIp);
		query.setParameter(4, userId);
		query.setParameter("recordid", recordids);
		int numberOFRecordsUpdated = query.executeUpdate();
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = userId;
		auditlog.userlevel = "Checker";
		auditlog.logdate  = date;
		auditlog.logtime = time;
		auditlog.logip = userIp;
		auditlog.formname = "Parameter Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "paramast";
		auditlog.qry = "Update recstatus in paramast";
		auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	}
	@Override
	public void save(Paramast paramast) {
	
		entityManager.persist(paramast);	
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = paramast.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = paramast.getMakerdate();
		auditlog.logtime = paramast.getMakertime();
		auditlog.logip = paramast.getMakerip();
		auditlog.formname = "Parameter Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "paramast";
		auditlog.qry = "Insert into paramast";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);	}

	@Override
	public List<Object[]> getparamasterlist(String recstatus,String paratype) {
		String HSQL;
		if(paratype==null || paratype.length()<=0){
			HSQL = "select '<div class=\"checkbox check-primary\"><input type=\"checkbox\" id=\"'|| recordid||'\" name=\"recordid\" value=\"'|| recordid||'\" /> <label for=\"'|| recordid||'\" style=\"position: static;\"></label></div>' as checkbox,code,paraname,ldesc,remarks from Paramast where recstatus=? order by recordid";	
		}else{
			HSQL = "select '<div><input type=\"hidden\" id=\"'|| recordid||'\" name=\"recordid\" value=\"'|| recordid||'\" />'||row_number() over(order by recordid)||'</div>' ,code,paraname,ldesc,remarks from Paramast where recstatus=? and paratype =? order by recordid";
		}
		Query query = entityManager.createNativeQuery(HSQL);
		query.setParameter(0, recstatus);
		if(paratype.length()>0){
			query.setParameter(1, paratype);
		}
		List<Object[]> ls = query.getResultList();
		return ls;
	}

	@Override
	public Paramast getParamast(String paratype, String code) throws Exception {
		
		Query query = entityManager.createQuery("From Paramast where paratype=:paratype and code=:code");
		query.setParameter("paratype", paratype);
		query.setParameter("code", code);
		List<Paramast> paramasts = query.getResultList();
		if(paramasts!=null && paramasts.size()>0){
			return paramasts.get(0);
		}else{
			throw new Exception("No Such Parameter!!");
		}
		
	}

	@Override
	public void vaidateParaList(HashMap<String, Boolean> paraList,String paratype) {
		Query query = entityManager.createNativeQuery("select code from paramast where paratype= :paratype and code in :codeList");
		query.setParameter("paratype", paratype);
		query.setParameter("codeList", paraList.keySet());
		List<String> codeList = query.getResultList();
		for (Iterator<String> iterator = codeList.iterator(); iterator.hasNext();) {
			String code = (String) iterator.next();
			paraList.put(code, true);
		}
	}

	@Override
	public List<Paramast> getDistinctParatypeParaname() {
		
		Query query = entityManager.createQuery("select distinct paratype,paraname from Paramast");
		List<Paramast> paramastList = query.getResultList();
		
		return paramastList;
	}

	@Override
	public List<Paramast> getparamast(String[] paratype) throws Exception {
		
		Query query = null;
		if(paratype != null && paratype.length >0){
			query = entityManager.createQuery("From Paramast where paratype in :paralist order by to_number(code,'9999999999')");
			query.setParameter("paralist", paratype);
		}else{
			query = entityManager.createQuery("From Paramast");
		}
		List<Paramast> paramasts = query.getResultList();
		return paramasts;
	}

	@Override
	public List<Paramast> getcertficatetype(String trantype) {
	
		String HSQL = "From Paramast where paratype=:paratype and extras2=:trantype";
		Query query= entityManager.createQuery(HSQL);
		query= query.setParameter("paratype", "CERTTRNTyp");
		query= query.setParameter("trantype", trantype);
		List<Paramast> ls = query.getResultList();
		return ls;
	}

	@Override
	public List<Paramast> getkyctype(String kyccate) {
		String HSQL =""; 
		Query query = null;
		if(kyccate.equalsIgnoreCase("1")){
			HSQL =	"From Paramast where paratype=:paratype order by to_number(code,'99999') ASC";
			query = entityManager.createQuery(HSQL);
			query= query.setParameter("paratype", "KYCTYPEID");
		}
		else{
			HSQL =	"From Paramast where paratype=:paratype order by to_number(code,'99999') ASC";
			query = entityManager.createQuery(HSQL);
			query= query.setParameter("paratype", "KYCTYPEAD");
		}
		List<Paramast> ls = query.getResultList();
		return ls;
	}
	
	@Override
	public List<Paramast> getCityStatewise(String extras1) {
		Query query=entityManager.createQuery("From Paramast where paratype='CITY' and extras1=:extras1");
	    query.setParameter("extras1", extras1);
	List<Paramast> paramasts = query.getResultList();
	return paramasts;
	}

	@Override
	public List<Paramast> getparaname(String[] paratype, String extras2) {
		String HSQL = "";
		if (extras2 == null) {
			HSQL = "From Paramast where trim(UPPER(paratype)) in :paratype and recstatus = '5' and allowuser='1' order by to_number(code,'99999') ASC";
		}
		else {
			HSQL = "From Paramast where trim(UPPER(paratype)) in :paratype and extras2 = :extras2 and recstatus = '5' and allowuser='1' order by to_number(code,'99999') ASC";
		}
		Query query = entityManager.createQuery(HSQL);
		query = query.setParameter("paratype", Arrays.asList(paratype));
		if (extras2 != null) {
			query = query.setParameter("extras2", extras2);
		}
		List<Paramast> ls = query.getResultList();
		return ls;
	}
	
}

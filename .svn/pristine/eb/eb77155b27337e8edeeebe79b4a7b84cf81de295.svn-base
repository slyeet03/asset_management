package com.fam.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fam.entity.Auditlog;
@Repository
public class AuditLogDaoImpl implements AuditLogDao{
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("removal")
	@Override
	public void addAuditLog(Auditlog auditlog) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");

		String HSQL = "select COALESCE(max(recordid),1) +1 from auditlog ";
		Date dt = new Date();
		try{
			auditlog.recordid = new Long(entityManager.createNativeQuery(HSQL).getResultList().get(0).toString());
		}catch(Exception exception){}
		HSQL = "Insert into auditlog (RECORDID, USERID, USERLEVEL, LOGDATE, LOGTIME, LOGIP, URL_DESC, FORMNAME, EVENTNAME, TABLENAME, PARAM, QRY, REMARKS) ";
		HSQL = HSQL+" Values("+auditlog.recordid+",'"+auditlog.userid+"','"+auditlog.userlevel+"', '"+simpleDateFormat.format(dt)+"', '"+simpleTimeFormat.format(dt)+"','"+auditlog.logip+"','"+auditlog.urlDesc+"','"+auditlog.formname+"','"+auditlog.eventname+"','"+auditlog.tablename+"','"+auditlog.param+"','"+auditlog.qry+"','"+auditlog.remarks+"')";
		entityManager.createNativeQuery(HSQL).executeUpdate();

		
	}

}

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
import com.fam.entity.Bglpara;
import com.fam.values.ASSET_MANAGEMENTConstants;

@Repository 
public class BGLMasterDaoImpl  implements BGLMasterDao {
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;

	
	@Override
	public Bglpara getBGLMaster(Long recordid) {
		String HSQL = "From Bglpara where recordid=:recordid ";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recordid", recordid);
		return (Bglpara) query.getResultList().get(0);
	}

	@Override
	public String getcode() {
		String HSQL = "select COALESCE(max(CAST(bglnumb as numeric)),0)+1  as bank from Bglpara";
		String maxcode =entityManager.createNativeQuery(HSQL).getResultList().get(0).toString();
		return maxcode;
	}

	@Transactional
	@Override
	public void update_bglmaster(Bglpara bglpara) {
		entityManager.merge(bglpara);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = bglpara.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = bglpara.getMakerdate();
		auditlog.logtime = bglpara.getMakertime();
		auditlog.logip = bglpara.getMakerip();
		auditlog.formname = "BGL Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "bglpara";
		auditlog.qry = "Update bglpara";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Transactional
	@Override
	public int updatebglmaster(List<Long> recordids, String recstatus,
			Date date, String time, String userId, String userIp, int userlevel) {
		String HSQL = "Update Bglpara set recstatus=:recstatus,";
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
		auditlog.formname = "AssetCategory Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "catmast";
		auditlog.qry = "Update recstatus in catmast";
		auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	}

	@Transactional
	@Override
	public void save(Bglpara bglpara) {
		entityManager.persist(bglpara);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = bglpara.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = bglpara.getMakerdate();
		auditlog.logtime = bglpara.getMakertime();
		auditlog.logip = bglpara.getMakerip();
		auditlog.formname = "BGL Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "bglpara";
		auditlog.qry = "Insert into bglpara";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);	
	}

	@Override
	public List<Object[]> getBGLMasterList(String recstatus) {
		String HSQL = "select * FROM \"bglpara\" bm WHERE bm.recstatus=:recstatus order by bm.bglnumb";
		Query query = entityManager.createNativeQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		Object s=query.getResultList();
		System.out.println(s);
		return query.getResultList();
	}

	@Override
	public Bglpara getBGLData(String BglId) {
		String HSQL = "From Bglpara where bglnumb=:BglId ";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("BglId", BglId);
		List<Bglpara> l =  query.getResultList();
		if(l != null && l.size() > 0)
		{
			return (Bglpara) query.getResultList().get(0);
			
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public boolean getBGLNumData(String bgl)
	{
	 String HQL="from Bglpara where bglnumb=:x ";
		Query query = entityManager.createQuery(HQL);
        query.setParameter("x", bgl);
        List<Bglpara> l =query.getResultList();
       if( l.size()>0)
       {
    	   return true;
       }else
       {
    	  return false;  
       }
        
		
	}
}

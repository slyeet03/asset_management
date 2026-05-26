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
import com.fam.entity.Usermaster;

@Repository
public class UserMasterDaoImpl implements UserMasterDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	AuditLogDaoImpl auditLogDaoImpl;

	@Override
	public Usermaster getUserMaster(String userId) {
		String HSQL = "From Usermaster where trim(UPPER(userid))=trim(UPPER(:userId))";
		Query query= entityManager.createQuery(HSQL);
		query= query.setParameter("userId", userId);
		List<Usermaster> ls = query.getResultList();
		return ls.get(0);
	}
	@Transactional
	@Override
	public void insertUserMaster(Usermaster usermaster) {
		entityManager.persist(usermaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = usermaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = usermaster.getMakerdate();
		auditlog.logtime = usermaster.getMakertime();
		auditlog.logip = usermaster.getMakerip();
		auditlog.formname = "Usermaster Master";
		auditlog.eventname = "Insert";
		auditlog.tablename = "usermaster";
		auditlog.qry = "Insert into usermaster";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
	}

	@Transactional
	@Override
	public void updateUserMaster(Usermaster usermaster) {
		entityManager.merge(usermaster);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = usermaster.getMakerid();
		auditlog.userlevel = "Maker";
		auditlog.logdate  = usermaster.getMakerdate();
		auditlog.logtime = usermaster.getMakertime();
		auditlog.logip = usermaster.getMakerip();
		auditlog.formname = "Usermaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "usermaster";
		auditlog.qry = "Update usermaster";
		auditlog.param = "";
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

	@Override
	public String getPassword(String userid) {
		String HSQL = "From Usermaster where trim(UPPER(userid))=trim(UPPER('" + userid + "'))";
		Usermaster user = (Usermaster) entityManager.createQuery(HSQL).getResultList().get(0);
		return user.getPwd();
	}

    @Transactional
	@Override
	public void saveNewPassword(String userid, String password, Date date, String time, String Id, String Ip,
			String Role) {
		Usermaster passwordUpdate = (Usermaster) entityManager.createQuery("From Usermaster where trim(upper(userid)) = '" + userid.toUpperCase() + "'").getResultList().get(0);
		passwordUpdate.setPwd(password.toString());
		entityManager.merge(passwordUpdate);
		Auditlog auditlog = new Auditlog();		
		auditlog.userid = userid;
		auditlog.userlevel = "";
		auditlog.logdate  = date;
		auditlog.logtime = time;
		auditlog.logip = Ip;
		auditlog.formname = "Reset Password";
		auditlog.eventname = "Update";
		auditlog.tablename = "usermaster";
		auditlog.qry = "Update password in usermaster";
		auditlog.param = "Password="+password.toString();
		auditlog.remarks = "Save new Password";
		auditLogDaoImpl.addAuditLog(auditlog);
		
	}

    @Transactional
	@Override
	public int releaseAllUsers() {
		String queryString = new String("Update usermaster set loggedin=:zero");
		Query query = entityManager.createNativeQuery(queryString);
		query.setParameter("zero", '0');
		int i =query.executeUpdate();
		return i;
	}


	@Override
	public List<Object[]> getUserMasterlist(String recstatus) {
		String HSQL = "select u.userid,u.username,u.rolename,p.ldesc from Usermaster u , Paramast p where u.recstatus=:recstatus" +
				" and p.code = u.userlevel and p.paratype='ROLE' order by userid";
		Query query = entityManager.createQuery(HSQL);
		query.setParameter("recstatus", recstatus);
		List<Object[]> ls = query.getResultList();
		return ls;
	}


	@Override
	public List<String> getuserid() {
		String HSQL = "select userid from Usermaster";
		Query query = entityManager.createNativeQuery(HSQL);
		List<String> ls = query.getResultList();
		return ls;
	}

	@Transactional
	@Override
	public String resetPassword(String userID, String password, Date date, String time, String id, String userIp,
			String role) {
		String HSQL = "update \"usermaster\" set pwd='"+password+"',locked=NULL,lockedreason=NULL,loggedin=0,attempcount=NULL,recstatus=5,makerid='"+id+"',makerdate='"+date+"',makertime='"+time+"',makerip='"+userIp+"' where userid='"+userID+"'";
		Query query = entityManager.createNativeQuery(HSQL);
		query.executeUpdate();
		String ls = entityManager.createNativeQuery(HSQL).toString();
		return ls;
	}

	@Transactional
	@Override
	public String UnLockUser(String userID, Date date, String time, String id, String userIp, String role) {
		String HSQL = "UPDATE \"usermaster\" SET locked=NULL,lockedreason=NULL,loggedin=0,attempcount=NULL,recstatus=5,makerid='"+id+"',makerdate='"+date+"',makertime='"+time+"',makerip='"+userIp+"' where userid='"+userID+"'";
		Query query = entityManager.createNativeQuery(HSQL);
		query.executeUpdate();
		String ls = entityManager.createNativeQuery(HSQL).toString();
		return ls;
	}

	@Transactional
	@Override
	public int updateUserMaster(List<String> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		String HSQL = "Update Usermaster set recstatus=:recstatus,";
		if ("maker".equalsIgnoreCase("maker"))
		{
			HSQL = HSQL+"makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		}
		else if("checker".equalsIgnoreCase("checker")) {
			HSQL = HSQL+"checkerdate=:currentDate,checkertime=:currentTime,checkerip=:userIp,checkerid=:userId";
		}
		else if("approver".equalsIgnoreCase("approver")){
			HSQL = HSQL+"approverdate=:currentDate,approvertime=:currentTime,approverip=:userIp,approverid=:userId";
		}
		else{
			HSQL = HSQL+"makerdate=:currentDate,makertime=:currentTime,makerip=:userIp,makerid=:userId";
		}
		HSQL = HSQL +" where userid in :recordid";
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
		auditlog.formname = "Usermaster Master";
		auditlog.eventname = "Update";
		auditlog.tablename = "usermaster";
		auditlog.qry = "Update recstatus in usermaster";
		auditlog.param = "recordids="+recordids+",recstatus="+recstatus;
		auditlog.remarks = "";
		auditLogDaoImpl.addAuditLog(auditlog);
		return numberOFRecordsUpdated;
	
	}
	
	
}

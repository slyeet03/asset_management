package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.UserMasterDao;
import com.fam.entity.Usermaster;

@Service
public class UsermasterServiceImpl implements UsermasterService{

	@Autowired
	UserMasterDao userMasterDao;
	
	
	@Override
	public void insertUserMaster(Usermaster usermaster) {
		userMasterDao.insertUserMaster(usermaster);
		
	}
	@Override
	public void updateUserMaster(Usermaster usermaster) {
		userMasterDao.updateUserMaster(usermaster);
	}

	@Override
	public Usermaster getUserMaster(String userId) {
		
		return userMasterDao.getUserMaster(userId);
	}

	@Override
	public String getPassword(String userid) {
		return userMasterDao.getPassword(userid);
	}

	@Override
	public void saveNewPassword(String userid, String password, Date date, String time, String Id, String Ip,
			String Role) {
		userMasterDao.saveNewPassword(userid, password, date, time, Id, Ip, Role);
		
	}

	@Override
	public int releaseAllUsers() {
		
		return userMasterDao.releaseAllUsers();
	}

	@Override
	public List<Object[]> getUserMasterlist(String recstatus) {
		return userMasterDao.getUserMasterlist(recstatus);
	
	}

	@Override
	public List<String> getuserid() {
		
		return userMasterDao.getuserid();
	}

	@Override
	public String resetPassword(String userID, String password, Date date, String time, String id, String userIp,
			String role) {
		return userMasterDao.resetPassword(userID, password, date, time, id, userIp, role);
	}

	@Override
	public String UnLockUser(String userID, Date date, String time, String id, String userIp, String role) {
		return userMasterDao.UnLockUser(userID, date, time, id, userIp, role);
	}

	@Override
	public int updateUserMaster(List<String> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		return userMasterDao.updateUserMaster(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	

	
}

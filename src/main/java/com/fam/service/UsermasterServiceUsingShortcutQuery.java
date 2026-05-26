//package com.fam.service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fam.dao.UserMasterDaoUsingShortcutQuery;
//import com.fam.entity.Usermaster;
//
//@Service
//public class UsermasterServiceUsingShortcutQuery implements UsermasterService{
//
//	@Autowired
//	UserMasterDaoUsingShortcutQuery userMasterDao;
//	
//	@Override
//	public Usermaster getUserMaster(String userid) {
//		return userMasterDao.findByUserid(userid);
//	}
//
//	@Override
//	public void updateUserMaster(Usermaster usermaster) {
//		userMasterDao.save(usermaster);
//		
//	}
//
//	@Override
//	public void insertUserMaster(Usermaster usermaster) {
//		userMasterDao.save(usermaster);
//	}
//
//	@Override
//	public String getPassword(String userid) {
//	Usermaster user=userMasterDao.findByUserid(userid);
//		return user.getPwd();
//	}
//
//	@Override
//	public void saveNewPassword(String userid, String password, Date date, String time, String Id, String Ip,
//			String Role) {
//		Usermaster user=userMasterDao.findByUserid(userid);
//		user.setPwd(password);
//		user.setPwdchangedate(date);
//		userMasterDao.save(user);
//	}
//
//	@Override
//	public List<Usermaster> getUserMasterlist(String recstatus) {
//		return userMasterDao.findByRecstatus(recstatus);
//	}
//
//	@Override
//	public List<String> getuserid() {
//		List<String>list= new ArrayList<String>();
//		List<Usermaster>user= userMasterDao.findAll();
//		user.forEach(s ->  list.add(s.getUserid()));
//		return list;
//	}
//
//	@Override
//	public int releaseAllUsers() {
//		int record=userMasterDao.releaseAllUsers('0');
//		return record;
//	}
//
//	@Override
//	public int UnLockUser(String userID, Date date, String time, String Id, String userIp, String role) {
//		int record=userMasterDao.UnLockUser(date, time, userIp, userID);
//		return record;
//	}
//
//	@Override
//	public int resetPassword(String userID, String password, Date date, String time, String Id, String userIp,
//			String role) {
//		int record=userMasterDao.resetPassword(password, date, time, userIp, userID);
//		return record;
//	}
//
//
//}

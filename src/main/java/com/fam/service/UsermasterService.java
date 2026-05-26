package com.fam.service;

import java.util.Date;
import java.util.List;

import com.fam.entity.Usermaster;

public interface UsermasterService {
	
	public Usermaster getUserMaster(String userId);
	public void insertUserMaster(Usermaster usermaster);
	public void updateUserMaster(Usermaster usermaster);
	public String getPassword(String userid);
	public void saveNewPassword(String userid, String password,Date date, String time,String Id,String Ip,String Role);
	public int releaseAllUsers();
	public List<Object[]> getUserMasterlist(String recstatus);
	public List<String> getuserid();
	public String resetPassword(String userID, String password, Date date, String time, String id, String userIp,
			String role);
	public String UnLockUser(String userID, Date date, String time, String id, String userIp, String role);
	public int updateUserMaster(List<String> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	
	//not Mandatory
//	public void save(Usermaster usermaster);
//	public String getcode();
//	public void validateuserid(HashMap<String, Boolean> primaryKeys);
//	public List<Object[]> getUserList(String userID);
}

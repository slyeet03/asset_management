package com.fam.dao;

import java.util.Date;
import java.util.List;

import com.fam.entity.Branchmaster;

public interface BranchMasterDao {
	public Branchmaster getBranchmaster(long recordid);
	public void insertBranchmaster(Branchmaster branchmaster);
	public void updateBranchmaster(Branchmaster branchmaster);
	public List<Branchmaster> getBranchmasterlist(String recstatus);
	public int updateBranchmaster(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	public String getBranchmasterCode();
}

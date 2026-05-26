package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.BranchMasterDao;
import com.fam.entity.Branchmaster;

@Service
public class BranchmasterServiceImpl implements BranchmasterService{

	@Autowired
	BranchMasterDao branchMasterDao;
	
	@Override
	public Branchmaster getBranchmaster(long recordid) {
		return branchMasterDao.getBranchmaster(recordid);
	}

	@Override
	public void insertBranchmaster(Branchmaster branchmaster) {
		branchMasterDao.insertBranchmaster(branchmaster);
	}

	@Override
	public void updateBranchmaster(Branchmaster branchmaster) {
		branchMasterDao.updateBranchmaster(branchmaster);
		
	}

	@Override
	public List<Branchmaster> getBranchmasterlist(String recstatus) {
		return branchMasterDao.getBranchmasterlist(recstatus);
	}

	@Override
	public int updateBranchmaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		return branchMasterDao.updateBranchmaster(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	@Override
	public String getBranchmasterCode() {
		return branchMasterDao.getBranchmasterCode();
	}


}

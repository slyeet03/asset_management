package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.VenorMasterDaoImpl;
import com.fam.entity.Branchmaster;
import com.fam.entity.VendorMaster;

@Service
public class VendorMasterServiceImpl implements VendorMasterService {

	@Autowired
	VenorMasterDaoImpl venorMasterDaoImpl;

	@Override
	public VendorMaster getVendorMaster(long recordid) {
		return venorMasterDaoImpl.getVendorMaster(recordid);
	}

	@Override
	public String getVendorMasterCode() {
		return venorMasterDaoImpl.getVendorMasterCode();
	}

	@Override
	public int updateVranchMaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		return venorMasterDaoImpl.updateVendorMaster(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	@Override
	public void updateVendorMaster(VendorMaster vendorMaster) {
		venorMasterDaoImpl.updateVendorMaster(vendorMaster);
	}

	@Override
	public void insertBranchmaster(VendorMaster vendorMaster) {
		venorMasterDaoImpl.insertVendorMaster(vendorMaster);
	}


	@Override
	public List<VendorMaster> getVendormasterlist(String recstatus) {
		return venorMasterDaoImpl.getVendorMasterlist(recstatus);
	}

	@Override
	public List<Object> findDataFrom2Tables() {
		// TODO Auto-generated method stub
		return venorMasterDaoImpl.findDataFrom2Tables();
	}

	

}

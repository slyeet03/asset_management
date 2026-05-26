package com.fam.service;

import java.util.Date;
import java.util.List;

import com.fam.entity.Branchmaster;
import com.fam.entity.VendorMaster;


public interface VendorMasterService {
	public VendorMaster getVendorMaster(long recordid);

	public String getVendorMasterCode();
	
	public void updateVendorMaster(VendorMaster vendorMaster);
	
	public int updateVranchMaster(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	
	public void insertBranchmaster(VendorMaster vendorMaster);
	
	public List<VendorMaster> getVendormasterlist(String recstatus);
	
	public List<Object> findDataFrom2Tables();
}

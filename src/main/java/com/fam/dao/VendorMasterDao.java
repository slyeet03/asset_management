package com.fam.dao;

import java.util.Date;
import java.util.List;

import com.fam.entity.Branchmaster;
import com.fam.entity.VendorMaster;

public interface VendorMasterDao {
	public void insertVendorMaster(VendorMaster vendorMaster);
	
	public void updateVendorMaster(VendorMaster vendorMaster);

	public VendorMaster getVendorMaster(long recordid);

	public String getVendorMasterCode();
	
	public int updateVendorMaster(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	
	public List<VendorMaster> getVendorMasterlist(String recstatus);
	
	public List<Object> findDataFrom2Tables();
}

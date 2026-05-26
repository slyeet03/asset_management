package com.fam.service;

import java.util.Date;
import java.util.List;
import com.fam.entity.AssetDepartment;

public interface AssetDepartmentMasterService {
	public AssetDepartment getAssetDepartment(long recordid);
	public void insertAssetDepartment(AssetDepartment assetDepartment);
	public void updateAssetDepartment(AssetDepartment assetDepartment);
	public List<AssetDepartment> getAssetDepartmentlist(String recstatus);
	public int updateAssetDepartment(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	public String getDepartmentcode();
}

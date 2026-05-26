package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.AssetDepartmentMasterDao;
import com.fam.entity.AssetDepartment;

@Service
public class AssetDepartmentMasterServiceImpl implements AssetDepartmentMasterService {


	@Autowired
	AssetDepartmentMasterDao assetDepartmentMasterDao;
	
	@Override
	public AssetDepartment getAssetDepartment(long recordid) {
		
		return assetDepartmentMasterDao.getAssetDepartment(recordid);
	}

	@Override
	public void insertAssetDepartment(AssetDepartment assetDepartment) {
		assetDepartmentMasterDao.insertAssetDepartment(assetDepartment);
		
	}

	@Override
	public void updateAssetDepartment(AssetDepartment assetDepartment) {
		assetDepartmentMasterDao.updateAssetDepartment(assetDepartment);
		
	}

	@Override
	public List<AssetDepartment> getAssetDepartmentlist(String recstatus) {
		return assetDepartmentMasterDao.getAssetDepartmentlist(recstatus);
	}

	@Override
	public int updateAssetDepartment(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		return assetDepartmentMasterDao.updateAssetDepartment(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	@Override
	public String getDepartmentcode() {
		
		return assetDepartmentMasterDao.getDepartmentcode();
	}



}

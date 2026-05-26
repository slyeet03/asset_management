package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.AssetSubCategoryMasterDao;
import com.fam.entity.AssetSubCategoryMaster;

@Service
public class AssetSubCategoryMasterServiceImpl implements AssetSubCategoryMasterService{

	@Autowired
	AssetSubCategoryMasterDao assetSubCategoryMasterDao;

	@Override
	public AssetSubCategoryMaster getAssetSubCategory(long recordid) {
		return assetSubCategoryMasterDao.getAssetSubCategory(recordid);
	}

	@Override
	public void insertAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster) {
		assetSubCategoryMasterDao.insertAssetSubCategory(assetSubCategoryMaster);
		
	}

	@Override
	public void updateAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster) {
		assetSubCategoryMasterDao.updateAssetSubCategory(assetSubCategoryMaster);
		
	}

	@Override
	public List<AssetSubCategoryMaster> getAssetSubCategorylist(String recstatus) {
		return assetSubCategoryMasterDao.getAssetSubCategorylist(recstatus);
	}

	@Override
	public int updateAssetSubCategory(List<Long> recordids, String recstatus, Date date, String time, String userId,
			String userIp, int userlevel) {
		return assetSubCategoryMasterDao.updateAssetSubCategory(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	@Override
	public String getAssetSubCategoryCode() {
		return assetSubCategoryMasterDao.getAssetSubCategoryCode();
	}
}

package com.fam.service;

import java.util.Date;
import java.util.List;

import com.fam.entity.AssetSubCategoryMaster;

public interface AssetSubCategoryMasterService {
	public AssetSubCategoryMaster getAssetSubCategory(long recordid);
	public void insertAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster);
	public void updateAssetSubCategory(AssetSubCategoryMaster assetSubCategoryMaster);
	public List<AssetSubCategoryMaster> getAssetSubCategorylist(String recstatus);
	public int updateAssetSubCategory(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	public String getAssetSubCategoryCode();
}

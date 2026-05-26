package com.fam.dao;

import java.util.Date;
import java.util.List;

import com.fam.entity.AssetCategoryMaster;

public interface AssetCategoryMasterDao {
	public AssetCategoryMaster getAssetCategory(long recordid);
	public void insertAssetCategory(AssetCategoryMaster assetCategoryMaster);
	public void updateAssetCategory(AssetCategoryMaster assetCategoryMaster);
	public List<AssetCategoryMaster> getAssetCategorylist(String recstatus);
	public int updateAssetCategory(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	public String getAssetCategoryCode();
	public List<AssetCategoryMaster> getAssetCatByBranch(String branchcode);
}

package com.fam.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fam.entity.AssetMaster;

public interface AssetMasterService {
  public AssetMaster getAsset(long recordid);

  public void insertAssetMaster(AssetMaster assetMaster);

  public void updateAssetMaster(AssetMaster assetMaster);

  public List<AssetMaster> getAssetlist(String recstatus);

  public int updateAssetMaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
      String userIp, int userlevel);

  public String getAssetId();

  public String getBranchId();

  public Object[] getAssetSummary(String branchid, String categoryid, String subcategoryid, String assetid);

  public Map<String, String> getBranches();

  public Map<String, String> getCategories();

  public Map<String, String> getSubCategories();

  public Map<String, String> getAssets();
}

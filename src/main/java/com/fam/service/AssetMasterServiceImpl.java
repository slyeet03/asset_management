package com.fam.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.AssetMasterDao;
import com.fam.entity.AssetMaster;

@Service
public class AssetMasterServiceImpl implements AssetMasterService {

  @Autowired
  AssetMasterDao assetMasterDao;

  @Override
  public AssetMaster getAsset(long recordid) {

    return assetMasterDao.getAsset(recordid);
  }

  @Override
  public void insertAssetMaster(AssetMaster assetMaster) {
    assetMasterDao.insertAssetMaster(assetMaster);

  }

  @Override
  public void updateAssetMaster(AssetMaster assetMaster) {
    assetMasterDao.updateAssetMaster(assetMaster);

  }

  @Override
  public List<AssetMaster> getAssetlist(String recstatus) {
    return assetMasterDao.getAssetlist(recstatus);
  }

  @Override
  public int updateAssetMaster(List<Long> recordids, String recstatus, Date date, String time, String userId,
      String userIp, int userlevel) {
    return assetMasterDao.updateAssetMaster(recordids, recstatus, date, time, userId, userIp, userlevel);
  }

  @Override
  public String getAssetId() {

    return assetMasterDao.getAssetId();
  }

  @Override
  public String getBranchId() {

    return assetMasterDao.getBranchId();
  }

  // for dashboard
  @Override
  public Object[] getAssetSummary(String branchid, String categoryid, String subcategoryid, String assetid) {
    return assetMasterDao.getAssetSummary(branchid, categoryid, subcategoryid, assetid);
  }

  @Override
  public Map<String, String> getBranches() {
    return assetMasterDao.getBranches();
  }

  @Override
  public Map<String, String> getCategories() {
    return assetMasterDao.getCategories();
  }

  @Override
  public Map<String, String> getSubCategories() {
    return assetMasterDao.getSubCategories();
  }

  @Override
  public Map<String, String> getAssets() {
    return assetMasterDao.getAssets();
  }

}

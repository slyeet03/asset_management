package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.BGLMasterDao;
import com.fam.entity.Bglpara;

@Service
public class BGLMasterServiceImpl implements BGLMasterService {

	@Autowired
	BGLMasterDao bglMasterDao;

	@Override
	public Bglpara getBGLMaster(Long recordid) {
		return this.bglMasterDao.getBGLMaster(recordid);
	}

	@Override
	public String getcode() {
		return this.bglMasterDao.getcode();
	}

	@Override
	public void update_bglmaster(Bglpara bglpara) {
		this.bglMasterDao.update_bglmaster(bglpara);
	}

	@Override
	public int updatebglmaster(List<Long> recordids, String recstatus,
			Date date, String time, String userId, String userIp, int userlevel) {
		return this.bglMasterDao.updatebglmaster(recordids, recstatus,date,time,userId,userIp,userlevel);
	}

	@Override
	public void save(Bglpara bglpara) {
		this.bglMasterDao.save(bglpara);
	}

	@Override
	public List<Object[]> getBGLMasterList(String recstatus) {
		return this.bglMasterDao.getBGLMasterList(recstatus);
	}

	@Override
	public Bglpara getBGLData(String BglId) {
		return this.bglMasterDao.getBGLData(BglId);
	}
	
	@Override
	public boolean getBGLNumber(String bglnum) {   
		return this.bglMasterDao.getBGLNumData(bglnum);
	}


}

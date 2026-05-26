package com.fam.service;

import java.util.Date;
import java.util.List;

import com.fam.entity.Bglpara;


public interface BGLMasterService {

	public Bglpara getBGLMaster(Long recordid);

	public String getcode();

	public void update_bglmaster(Bglpara bglpara);

	public int updatebglmaster(List<Long> recordids, String recstatus,
			Date date, String time, String userId, String userIp, int userlevel);

	public void save(Bglpara bglpara);

	public List<Object[]> getBGLMasterList(String recstatus);
	
	public Bglpara getBGLData(String BglId);
	
	public boolean getBGLNumber(String bglnum); 
}

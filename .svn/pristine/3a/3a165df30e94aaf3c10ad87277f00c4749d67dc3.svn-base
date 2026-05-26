package com.fam.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.ParamastDao;
import com.fam.entity.Paramast;



@Service
public class ParamastServiceImpl implements ParamastService{

	@Autowired
	private ParamastDao paramastDao;

	@Override
	public List<Paramast> getparamast(String[] paratype,String extras1) throws Exception {
		return paramastDao.getparamast(paratype,extras1);
	}

	@Override
	public Paramast getparamast(Long recordid) {
		return paramastDao.getparamast(recordid);
	}

	@Override
	public List<Paramast> getparamaster() {
		return this.paramastDao.getparamaster();
	}

	@Override
	public String getcode(String paratype) {
		return this.paramastDao.getcode(paratype);
	}

	@Override
	public void save(Paramast paramast) {
		this.paramastDao.save(paramast);
		
	}

	@Override
	public int updateparamaster(List<Long> recordids, String recstatus,
			Date date, String time, String userId, String userIp, int userlevel) {
		return this.paramastDao.updateparamaster(recordids,recstatus,date,time,userId,userIp,userlevel);
	}

	@Override
	public void update(Paramast paramast) {
		this.paramastDao.update(paramast);
	}

	@Override
	public List<Object[]> getparamasterlist(String recstatus,String paratype) {
		return this.paramastDao.getparamasterlist(recstatus,paratype);
	}

	@Override
	public Paramast getParamast(String paratype, String code) throws Exception {
		
		return this.paramastDao.getParamast(paratype, code);
	}

	@Override
	public void vaidateParaList(HashMap<String,Boolean> paraList,String Paratype) {
		this.paramastDao.vaidateParaList(paraList,Paratype);
		
	}

	@Override
	public List<Paramast> getDistinctParatypeParaname() {
		return this.paramastDao.getDistinctParatypeParaname();
	}

	@Override
	public List<Paramast> getparamast(String[] paratype) throws Exception {
		
		return this.paramastDao.getparamast(paratype);
	}

	@Override
	public List<Paramast> getcertficatetype(String trantype) {
		return this.paramastDao.getcertficatetype(trantype);
	}

	@Override
	public List<Paramast> getkyctype(String kyccate) {
		return this.paramastDao.getkyctype(kyccate);
	}

	@Override
	public List<Paramast> getCityStatewise(String extras1) {
		return this.paramastDao.getCityStatewise(extras1);
	}

	@Override
	public List<Paramast> getparaname(String[] paratype, String extras2) {
		return this.paramastDao.getparaname(paratype,extras2);
	}

	
}

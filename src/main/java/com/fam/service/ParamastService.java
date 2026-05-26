package com.fam.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fam.entity.Paramast;

public interface ParamastService {

	public List<Paramast> getparamast(String[] data,String extras1) throws Exception;

	public Paramast getparamast(Long long1);

	public List<Paramast> getparamaster();

	public String getcode(String paratype);

	public void save(Paramast paramast);

	public int updateparamaster(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);

	public void update(Paramast paramast);

	public List<Object[]> getparamasterlist(String recstatus,String paratype);
	
	public Paramast getParamast(String paratype,String code)throws Exception;
	
	public void vaidateParaList(HashMap<String,Boolean> paraList,String Paratype);

	public List<Paramast> getDistinctParatypeParaname();
	
	public List<Paramast> getparamast(String[] paratype) throws Exception;

	public List<Paramast> getcertficatetype(String trantype);

	public List<Paramast> getkyctype(String kyccate);
	
	public List<Paramast> getCityStatewise(String extras1);
	
	public List<Paramast> getparaname(String[] paratype,String extras22);

}

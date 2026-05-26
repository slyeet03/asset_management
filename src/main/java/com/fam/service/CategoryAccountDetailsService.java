package com.fam.service;

import java.util.Date;
import java.util.List;

import com.fam.entity.CategoryAccountDetails;

public interface CategoryAccountDetailsService {
	public CategoryAccountDetails getCategoryAccountDetails(long recordid);
	public void insertCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails);
	public void updateCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails);
	public List<CategoryAccountDetails> getCategoryAccountDetailslist(String recstatus);
	public int updateCategoryAccountDetails(List<Long> recordids, String recstatus,Date date, String time, String userId, String userIp, int userlevel);
	public String getCategoryAccountDetailsCode();
}

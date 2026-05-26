package com.fam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.CategoryAccountDetailsDao;
import com.fam.entity.CategoryAccountDetails;

@Service
public class CategoryAccountDetailsServiceImpl implements CategoryAccountDetailsService{

	@Autowired
	CategoryAccountDetailsDao categoryAccountDetailsDao;

	@Override
	public CategoryAccountDetails getCategoryAccountDetails(long recordid) {
		return categoryAccountDetailsDao.getCategoryAccountDetails(recordid);
	}

	@Override
	public void insertCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails) {
		categoryAccountDetailsDao.insertCategoryAccountDetails(categoryAccountDetails);		
	}

	@Override
	public void updateCategoryAccountDetails(CategoryAccountDetails categoryAccountDetails) {
		categoryAccountDetailsDao.updateCategoryAccountDetails(categoryAccountDetails);		
	}

	@Override
	public List<CategoryAccountDetails> getCategoryAccountDetailslist(String recstatus) {
		return categoryAccountDetailsDao.getCategoryAccountDetailslist(recstatus);
	}

	@Override
	public int updateCategoryAccountDetails(List<Long> recordids, String recstatus, Date date, String time,
			String userId, String userIp, int userlevel) {
		return categoryAccountDetailsDao.updateCategoryAccountDetails(recordids, recstatus, date, time, userId, userIp, userlevel);
	}

	@Override
	public String getCategoryAccountDetailsCode() {
		return categoryAccountDetailsDao.getCategoryAccountDetailsCode();
	}

}

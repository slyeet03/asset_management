package com.fam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.dao.OrganizationDao;
import com.fam.entity.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	@Override
	public Organization getOrganizationDetail() {
		return this.organizationDao.getOrganizationDetail();
	}

	@Override
	public void updateOrganization(Organization organization) {
		this.organizationDao.updateOrganization(organization);
	}

	@Override
	public void updateorganizationresctatus(String recstatus, Date date, String time, String userId, String userIp) {
		this.organizationDao.updateorganizationresctatus(recstatus, date, time, userId, userIp);
	}

}

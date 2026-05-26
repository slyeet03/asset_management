package com.fam.dao;

import java.util.Date;

import com.fam.entity.Organization;

public interface OrganizationDao {

	public Organization getOrganizationDetail();
	public void updateOrganization(Organization organization);
	public void updateorganizationresctatus(String recstatus,Date date, String time, String userId, String userIp);
}

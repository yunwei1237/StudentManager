package com.tcf.service;

import com.tcf.basebean.BaseService;
import com.tcf.entity.Personnel;

public interface PersonnelService extends BaseService<Personnel> {
	boolean checkAccount(String account);
}

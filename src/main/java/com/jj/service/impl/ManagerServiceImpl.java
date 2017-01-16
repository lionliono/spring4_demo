package com.jj.service.impl;

import com.jj.dao.ManagerDao;
import com.jj.domain.Manager;
import com.jj.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("usersService")
public class ManagerServiceImpl implements ManagerService {
	@Resource
	private ManagerDao managerDao;

	@Override
	public Manager getUserByManagerName(String managerName) {
		return managerDao.getUserByManagerName(managerName);
	}

	@Override
	public Manager query() {
		return managerDao.query();
	}


}

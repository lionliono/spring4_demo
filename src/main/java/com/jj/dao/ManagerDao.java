package com.jj.dao;

import com.jj.domain.Manager;


public interface ManagerDao {

	public Manager getUserByManagerName(String managerName);

	Manager query();
}

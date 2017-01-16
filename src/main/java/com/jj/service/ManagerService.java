package com.jj.service;

import com.jj.domain.Manager;

public interface ManagerService {

	/**
	 *
	 * @方法功能说明：根据用户名获取管理员信息
	 * @修改者名字：yuqz
	 * @修改时间：2016年5月17日下午2:17:52
	 * @修改内容：
	 * @参数：@param managerName
	 * @参数：@return
	 * @return:Manager
	 * @throws
	 */
	public Manager getUserByManagerName(String managerName);


	Manager query();
}

package com.jj.pojo.command.manager;

import com.jj.pojo.command.BaseCommand;

@SuppressWarnings("serial")
public class ManagerLoginCommand extends BaseCommand{
	private String mangerName;

	private String password;

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


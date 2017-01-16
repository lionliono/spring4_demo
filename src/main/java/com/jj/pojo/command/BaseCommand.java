package com.jj.pojo.command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseCommand implements Serializable{
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

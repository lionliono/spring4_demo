package com.jj.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：竞技世界
 * @部门：技术部
 * @作者：yuqz
 * @创建时间：2016年5月12日下午3:28:33
 * @版本：V1.0
 *
 */
public class BaseController {

	/**
	 * 将str打印给响应对象
	 * @param response
	 * @param str
	 */
	protected void print(HttpServletResponse response, String str){
		try {
			response.getWriter().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动将yyyy-MM-dd格式的参数转换成Date型参数
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/**
	 * 直接获取请求参数
	 *
	 * @param request
	 * @param name
	 * @return
	 */
	public String getParam(HttpServletRequest request, String name) {
		return request.getParameter(name);
	}

//	/**
//	 * @方法功能说明: 获取当前登录的管理员
//	 * @param session
//	 * @return
//	 */
//	@ModelAttribute
//	public AuthUser getAuthUser(HttpSession session){
//		Object obj = session.getAttribute(SecurityConstants.SESSION_USER_KEY);
//		if(null == obj || !(obj instanceof AuthUser))
//			return null;
//		return (AuthUser)obj;
//	}


}

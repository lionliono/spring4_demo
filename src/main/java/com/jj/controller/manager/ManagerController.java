package com.jj.controller.manager;

import com.alibaba.fastjson.JSON;
import com.jj.controller.BaseController;
import com.jj.domain.Manager;
import com.jj.pojo.command.manager.ManagerLoginCommand;
import com.jj.pojo.dto.BaseDTO;
import com.jj.pojo.util.EncryptionDecryption;
import com.jj.pojo.util.StatusCodeConstants;
import com.jj.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController{
	@Resource
	private ManagerService managerService;
	/**
	 *
	 * @方法功能说明：登录
	 * @修改者名字：yuqz
	 * @修改时间：2016年5月13日下午3:18:27
	 * @修改内容：
	 * @参数：@param request
	 * @参数：@param managerLoginCommand
	 * @参数：@return
	 * @return:String
	 * @throws
	 */
	@RequestMapping("/login")
	@ResponseBody
	public BaseDTO login(HttpServletRequest request, @ModelAttribute ManagerLoginCommand managerLoginCommand){
		BaseDTO baseDTO = new BaseDTO();
		if(managerLoginCommand == null || managerLoginCommand.getMangerName() == null || managerLoginCommand.getPassword() == null){
			baseDTO.setStatusCode(StatusCodeConstants.ERROR);
			baseDTO.setMessage("用户名或密码输入不完整");
			return baseDTO;
		}
		try {
		Manager nowManager = managerService.getUserByManagerName(managerLoginCommand.getMangerName());

		if(nowManager == null){
			baseDTO.setStatusCode(StatusCodeConstants.ERROR);
			baseDTO.setMessage("登录失败,用户名不存在");
			return baseDTO;
		}

			EncryptionDecryption ed = new EncryptionDecryption();

			if(nowManager.getManagerName().equals(managerLoginCommand.getMangerName()) && nowManager.getPassword().equals(ed.encrypt(managerLoginCommand.getPassword()))){
				baseDTO.setStatusCode(StatusCodeConstants.SUCCESS);
				baseDTO.setMessage("登录成功");
				nowManager.setPassword("");
				request.getSession().setAttribute("sessionManager", nowManager);
			}else{
				baseDTO.setStatusCode(StatusCodeConstants.ERROR);
				baseDTO.setMessage("登录失败,用户名或密码输入不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			baseDTO.setStatusCode(StatusCodeConstants.ERROR);
			baseDTO.setMessage("登录失败");
		}
		return baseDTO;
	}

	/**
	 *
	 * @方法功能说明：注销
	 * @修改者名字：yuqz
	 * @修改时间：2016年6月15日下午2:59:53
	 * @修改内容：
	 * @参数：@param request
	 * @参数：@return
	 * @return:String
	 * @throws
	 */
	@RequestMapping("/loginOut")
	@ResponseBody
	public String loginOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("sessionManager");
		return "";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request){
		Manager manager = null;
		try {
			 manager = managerService.query();
		}catch (Exception e){
			e.printStackTrace();
		}

		return JSON.toJSONString(manager);
	}

}

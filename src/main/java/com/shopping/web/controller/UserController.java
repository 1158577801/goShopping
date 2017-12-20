package com.shopping.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shopping.web.bootCore.ShoppingConfigurerAdapter;
import com.shopping.web.common.Result;
import com.shopping.web.service.UserService;
import com.shopping.web.util.consts.AuthUtil;
import com.shopping.web.util.consts.Base64Util;
import com.shopping.web.util.consts.Md5Util;
import com.shopping.web.util.consts.UUIDUtil;
import com.shopping.web.util.mail.MailUtil;
import com.shopping.web.util.mail.MimeMessageVo;
import com.shopping.web.vo.UserVo;

@Controller
public class UserController {
	@Value("${email.user}")
	private String emailUser;
	@Value("${email.pwd}")
	private String emailPwd;
	private final static String title="系统注册用户通知";
	
	@Autowired
	private UserService userService;

	/**
	 * 去登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String toLoginPage() {
		return "login";
	}

	
	@ResponseBody
	@RequestMapping("/getUserInfoAll")
	public String getUserInfoAll() {
		return JSON.toJSONString(userService.getUserInfoAllService());
	}

	/**
	 * 登录
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping("/getLogin")
	public String getUserInfoByAPService(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String accountNumber = httpServletRequest.getParameter("accountNumber");
		String passWord = httpServletRequest.getParameter("passWord");
		if (StringUtils.isBlank(accountNumber) || StringUtils.isBlank(passWord)) {
			return "login";
		}
		UserVo userVo = userService.getUserInfoByAPService(accountNumber, Md5Util.hmacSign(passWord,accountNumber));
		if (null != userVo) {
			if(!"yes".equals(userVo.getActivation())) {
				httpServletRequest.setAttribute("errorMessage", "用户未激活");
				return "login";
			}
			httpServletRequest.getSession().setAttribute(ShoppingConfigurerAdapter.SESSION_KEY, userVo);
			return "main";
		} else {
			httpServletRequest.setAttribute("errorMessage", "用户名或者密码错误");
			return "login";
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/register")
	public String toRegisterPage() {
		return "register";
	}
	
	@ResponseBody
	@RequestMapping("/toRegister")
	public Result toRegister(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String accountNumber=httpServletRequest.getParameter("accountNumber").trim();
		String passWord=httpServletRequest.getParameter("passWord");
		String nickName=httpServletRequest.getParameter("nickName");
		String email=httpServletRequest.getParameter("email");
		UserVo userVo = userService.getUserInfoByIdService(accountNumber);
		if(null!=userVo) {
			return new Result("用户名已存在");
		}
		userVo=new UserVo();
		userVo.setUid(UUIDUtil.getUUID());
		userVo.setAccountNumber(accountNumber);
		userVo.setEmail(email);
		userVo.setNickName(nickName);
		userVo.setPassWord(Md5Util.hmacSign(passWord,accountNumber));
		if(userService.saveUserService(userVo)>0) {
			boolean b=MailUtil.sendEmail(
					new MimeMessageVo(emailUser, emailPwd, email, title, userService.createMailTemplate(accountNumber,httpServletRequest)));
			if(!b) {
				return new Result("邮箱发送失败");
			}
			return new Result("注册成功，请去邮箱激活","success");
		}
		return new Result("注册失败");
		
	}

	
	@ResponseBody
	@RequestMapping("/checkActivation")
	public String checkActivation(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String parameter=Base64Util.decode(httpServletRequest.getParameter("parameter"));
		String [] cp=parameter.split("&");
		String signature="";
		String timestamp="";
		String nonce="";
		String app_token="";
		for(String c:cp) {
			if(c.indexOf("=")>0 && "signature".equals(c.split("=")[0])) {
				signature=c.split("=")[1];
			}else if(c.indexOf("=")>0 && "timestamp".equals(c.split("=")[0])) {
				timestamp=c.split("=")[1];
			}else if(c.indexOf("=")>0 && "nonce".equals(c.split("=")[0])) {
				nonce=c.split("=")[1];
			}else if(c.indexOf("=")>0 && "app_token".equals(c.split("=")[0])) {
				app_token=c.split("=")[1];
			}
		}
		if(AuthUtil.validateSignature(signature, timestamp, nonce, app_token)) {
			UserVo userVo=new UserVo();
				   userVo.setAccountNumber(app_token);
			if(userService.updateUserService(userVo)>0) {
				return "激活成功，谢谢使用";
			}else {
				return "已激活，不需要重复操作";
			}
		}else {
			return "激活失败，已超时";
		}
		
	}

}

package com.shopping.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.web.vo.UserVo;

public interface UserService {
	public List<UserVo> getUserInfoAllService();
	public UserVo getUserInfoByAPService(String accountNumber,String passWord);
	public int saveUserService(UserVo userVo);
	public UserVo getUserInfoByIdService(String accountNumber);
	public String createMailTemplate(String accountNumber,HttpServletRequest httpServletRequest);
	public int updateUserService(UserVo userVo);
}

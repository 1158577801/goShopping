package com.shopping.web.service;

import java.util.List;

import com.shopping.web.vo.UserVo;

public interface UserService {
	public List<UserVo> getUserInfoAllService();
	public UserVo getUserInfoByAPService(String accountNumber,String passWord);
}

package com.shopping.web.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shopping.web.mapper.UserMapper;
import com.shopping.web.util.consts.AuthUtil;
import com.shopping.web.util.consts.Base64Util;
import com.shopping.web.util.consts.UUIDUtil;
import com.shopping.web.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<UserVo> getUserInfoAllService() {
		return jdbcTemplate.query("select uid,nickName,passWord,accountNumber from user where delFlag=0", new RowMapper<UserVo>() {

			@Override
			public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserVo userVo=new UserVo();
				userVo.setNickName(rs.getString("nickName"));
				userVo.setUid(rs.getString("uid"));
				userVo.setPassWord(rs.getString("passWord"));
				userVo.setAccountNumber(rs.getString("accountNumber"));
				return userVo;
			}
			
		});
	}
	@Override
	public UserVo getUserInfoByAPService(String accountNumber, String passWord) {
		RowMapper<UserVo> rm = BeanPropertyRowMapper.newInstance(UserVo.class);
		List<UserVo> list=jdbcTemplate.query("select uid,nickName,passWord,accountNumber,activation,email from user where delFlag=0 and accountNumber=? and passWord=?",rm,accountNumber,passWord);
		if(null!=list && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public int saveUserService(UserVo userVo) {
		// TODO Auto-generated method stub
		return userMapper.saveUser(userVo);
	}
	@Override
	public UserVo getUserInfoByIdService(String accountNumber) {
		// TODO Auto-generated method stub
		return userMapper.getUserInfoById(accountNumber);
	}
	
	@Override
	public String createMailTemplate(String accountNumber,HttpServletRequest request) {
		String timestamp=System.currentTimeMillis()+"";
		String nonce=UUIDUtil.getUUID();
		String signature=AuthUtil.generateSignature(accountNumber, timestamp, nonce);
		
		StringBuffer url = request.getRequestURL();  
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString(); 
		
		String parameter="signature="+signature+"&timestamp="+timestamp+"&nonce="+nonce+"&app_token="+accountNumber;
		
		String responseUrl=tempContextUrl+"checkActivation?parameter="+Base64Util.encoded(parameter);
		String html="<label style='font-size:25px;font-color:red;'>点击下面链接激活账号["+accountNumber+"]</label></br><h3><a href='"+responseUrl+"'>点此击激活</a></h3>";
		return html;
	}
	@Override
	public int updateUserService(UserVo userVo) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(userVo);
	}
	
}

package com.shopping.web.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shopping.web.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		return jdbcTemplate.query("select uid,nickName,passWord,accountNumber from user where delFlag=0 and accountNumber=? and passWord=?",rm,accountNumber,passWord).get(0);
	}
	
}

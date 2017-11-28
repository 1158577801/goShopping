package com.shopping.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.shopping.web.vo.UserVo;
@Mapper
public interface UserMapper {
   public UserVo getUserInfoById(String accountNumber);
}

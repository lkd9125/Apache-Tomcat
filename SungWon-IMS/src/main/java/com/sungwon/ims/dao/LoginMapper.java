package com.sungwon.ims.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sungwon.ims.vo.UserVO;

@Mapper
public interface LoginMapper {
    
    public UserVO getUserInfo(String username);
}

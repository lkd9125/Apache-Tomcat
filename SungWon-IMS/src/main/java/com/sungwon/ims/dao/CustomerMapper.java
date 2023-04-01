package com.sungwon.ims.dao;

import java.util.ArrayList;

import com.sungwon.ims.vo.CustomerVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    
    public ArrayList<CustomerVO> getCustomerList();

    public boolean insertCustomer(CustomerVO vo);

    public CustomerVO getCustomerDetail(int idx);    

}

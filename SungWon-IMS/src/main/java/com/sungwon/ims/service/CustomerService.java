package com.sungwon.ims.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungwon.ims.vo.CustomerVO;
import com.sungwon.ims.vo.ProductVO;
import com.sungwon.ims.dao.CustomerMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
    
    @Autowired
    private CustomerMapper customerMapper;
    
    public ArrayList<CustomerVO> getCustomerList() {
        log.info("CustomerService - getgetCustomerList()");
        
        ArrayList<CustomerVO> list = customerMapper.getCustomerList();

        return list;
    }

    public String insertCustomer(CustomerVO vo){
        log.info("CustomerService - insertCustomer()");
        String msg = "";

        if(!customerMapper.insertCustomer(vo)) msg = "거래처 추가에 실패했습니다. 문의해주세요";

        return msg;
    }

    public CustomerVO getCustomerDetail(int idx){
        log.info("CustomerService - getCustomerDetail()");

        CustomerVO vo = customerMapper.getCustomerDetail(idx);

        return vo;
    }

    
    

}

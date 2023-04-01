package com.sungwon.ims.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungwon.ims.dao.SpecificationMapper;
import com.sungwon.ims.vo.SpecificationVO;

import groovy.util.logging.Slf4j;

@Service
@Slf4j
public class SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;


    public ArrayList<SpecificationVO> specificationData() {

        return specificationMapper.specificationData();
    }
    

}

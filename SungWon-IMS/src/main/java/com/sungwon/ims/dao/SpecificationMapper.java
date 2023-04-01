package com.sungwon.ims.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.sungwon.ims.vo.SpecificationVO;

@Mapper
public interface SpecificationMapper {
    
    public ArrayList<SpecificationVO> specificationData();

}

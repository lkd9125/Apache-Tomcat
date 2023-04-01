package com.sungwon.ims.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.sungwon.ims.vo.ProductVO;

@Mapper
public interface ProductMapper {
    
    public ArrayList<ProductVO> getProductList(int customer_idx);

    public boolean insertProduct(ProductVO vo);

}

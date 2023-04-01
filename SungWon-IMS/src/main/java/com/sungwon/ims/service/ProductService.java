package com.sungwon.ims.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungwon.ims.dao.ProductMapper;
import com.sungwon.ims.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
    
    @Autowired
    private ProductMapper productMapper;

    public ArrayList<ProductVO> getProductList(int customer_idx){
        log.info("ProductService - getProductList()");

        ArrayList<ProductVO> list = productMapper.getProductList(customer_idx);

        return list;
    }

    public String insertProduct(ProductVO vo) {
        log.info("ProductService - insertProduct()");
        String msg = "";

        if(!productMapper.insertProduct(vo)){
            msg = "제품 추가에 실패했습니다. 관리자에게 문의해주세요.";
        }

        return msg;    
    }
}

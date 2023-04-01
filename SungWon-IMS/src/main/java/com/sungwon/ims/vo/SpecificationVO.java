package com.sungwon.ims.vo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecificationVO {
    private int idx;
    private int customer_idx;    
    private String create_date;

    private String customer_name;
    private ArrayList<ProductVO> product_name;
}

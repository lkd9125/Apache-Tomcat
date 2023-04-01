package com.sungwon.ims.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
    private int idx; // 품목번호
    private int customer_idx; // 거래처 번호
    private String customer_name; // 제품 소유 회사명  ex -> (아이콘 - CS테크)
    private String name; // 품목이름
    private int price; // 품목가격
    
    private int ea; // 수량
    private String description; // 설명

}

package com.sungwon.ims.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {
    private String idx; // 구분 번호
    private String company_number; // 사업자번호
    private String ceo; // 대표
    private String name; // 업체명
    private String tel; // 전화번호
    private String address; // 주소
    private String email; // 이메일

    private String business; // 업태
    private String sectors; //업종
}

package com.sungwon.ims.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    private String username; // 아이디
    private String password; // 암호
    private String email; // 이메일
    private int customer_idx; // 본인 회사 번호

    private boolean enable; //활성화
    
    private String role; //이름

}

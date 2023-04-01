package com.sungwon.ims.vo;

import java.security.PrivateKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsaVO {
    private PrivateKey privateKey;
    private String modulus;
    private String exponent;

    public RsaVO() {
    }

    public RsaVO(PrivateKey privateKey, String modulus, String exponent) {
        this.privateKey = privateKey;
        this.modulus = modulus;
        this.exponent = exponent;
    }

   
}

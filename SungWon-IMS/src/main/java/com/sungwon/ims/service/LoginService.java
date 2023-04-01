package com.sungwon.ims.service;

import java.security.PrivateKey;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sungwon.ims.dao.CustomerMapper;
import com.sungwon.ims.dao.LoginMapper;
import com.sungwon.ims.util.RSAsecurityUtil;
import com.sungwon.ims.vo.CustomerVO;
import com.sungwon.ims.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private CustomerMapper customerMapper;
    
    @Autowired
    private RSAsecurityUtil rsAsecurityUtil;

    @Autowired
    private HttpSession session;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${privateKey}")
    private String rsaSecretkey;

    public String loginProc(UserVO vo) throws Exception {
        log.info("LoginService - loginProc()");
        String msg = "";

        String pass = rsAsecurityUtil.getDecryptText((PrivateKey)session.getAttribute(rsaSecretkey), vo.getPassword());        

        vo = loginMapper.getUserInfo(vo.getUsername());

        if(vo == null){            
            msg = "로그인 정보를 다시 입력해주세요.";
            return msg;
        }

        CustomerVO cvo = customerMapper.getCustomerDetail(vo.getCustomer_idx());

        if(bCryptPasswordEncoder.matches(pass,vo.getPassword())){
            session.removeAttribute("login");            
            session.setAttribute("login", vo);
            session.setAttribute("company", cvo);
        } else {            
            msg = "로그인 정보를 다시 입력해주세요.";
        }

        return msg;
    }
    

}

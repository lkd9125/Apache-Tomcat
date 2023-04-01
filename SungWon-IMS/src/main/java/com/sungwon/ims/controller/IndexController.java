package com.sungwon.ims.controller;

import java.net.URLEncoder;
import java.security.PrivateKey;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sungwon.ims.service.LoginService;
import com.sungwon.ims.util.RSAsecurityUtil;
import com.sungwon.ims.vo.RsaVO;
import com.sungwon.ims.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private HttpSession session;

    @Autowired
    private RSAsecurityUtil rsAsecurityUtil;

    @Autowired
    private LoginService loginService;

    @Value("${privateKey}")
    private String rsaSecretkey;

    private ModelAndView mv;

    @GetMapping("/")
    public ModelAndView root(@RequestParam(required = false) String msg, RedirectAttributes rttr){
        log.info("IndexController - root()");
        mv = new ModelAndView();

        if(msg != null && !msg.equals("rttr")) rttr.addFlashAttribute("msg", msg);

        boolean loginCheck = session.getAttribute("login") == null ? false:true;

        if(loginCheck) mv.setViewName("redirect:dashboard");
        else mv.setViewName("redirect:login");

        return mv;
    } 

    @GetMapping("/login")
    public ModelAndView loginPage(){
        log.info("IndexController - loginPage()");
        mv = new ModelAndView();        

        if((PrivateKey)session.getAttribute(rsaSecretkey) != null){
            session.removeAttribute(rsaSecretkey);
        }
        
        RsaVO rsa = rsAsecurityUtil.createRSA();

        mv.addObject("modulus", rsa.getModulus());
        mv.addObject("exponent", rsa.getExponent());

        session.setAttribute(rsaSecretkey, rsa.getPrivateKey());

        mv.setViewName("login/login");

        return mv;
    }

    @PostMapping("/login")
    public ModelAndView loginProc(@ModelAttribute UserVO vo) throws Exception{
        log.info("IndexController - loginProc()");

        String msg = loginService.loginProc(vo);
        
        mv = new ModelAndView("redirect:/?msg=" + URLEncoder.encode(msg, "UTF-8"));        

        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        log.info("IndexController - logout()");

        session.removeAttribute("login");
        session.removeAttribute("company");

        mv = new ModelAndView("redirect:/");

        return mv;
    }


}

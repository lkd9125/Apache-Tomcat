package com.sungwon.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sungwon.ims.service.CustomerService;
import com.sungwon.ims.vo.CustomerVO;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    private ModelAndView mv;

    @GetMapping("/customer")
    public ModelAndView customerMain(){
        log.info("CustomerController - customerMain()");

        mv = new ModelAndView("customer/list");

        return mv;
    }

    @GetMapping("/customer/insert")
    public ModelAndView insertPage(){
        log.info("CustomerController - insertPage()");

        mv = new ModelAndView("customer/insert");

        return mv;
    }

    @PostMapping("/customer/insert")
    public ModelAndView insertCustomer(@ModelAttribute CustomerVO vo, RedirectAttributes rttr){
        log.info("CustomerController - insertCustomer()");

        String msg = customerService.insertCustomer(vo);

        rttr.addFlashAttribute("msg", msg);

        mv = new ModelAndView("redirect:/customer");

        return mv;
    }

    @GetMapping("/customer/detail/{idx}")
    public ModelAndView detailPage(@PathVariable int idx){
        log.info("CustomerController - detailPage()");        
        
        CustomerVO vo = customerService.getCustomerDetail(idx);

        mv = new ModelAndView();

        mv.addObject("vo", vo);
        mv.setViewName("customer/detail");

        return mv;
    }


    @GetMapping("/customer/data")
    @ResponseBody
    public HashMap<String, Object> data(){
        log.info("CustomerController - data()");
        HashMap<String, Object> result = new HashMap<String, Object>();

        ArrayList<CustomerVO> list = customerService.getCustomerList();

        result.put("data", list);
        result.put("length", list.size());

        return result;
    }

    
}

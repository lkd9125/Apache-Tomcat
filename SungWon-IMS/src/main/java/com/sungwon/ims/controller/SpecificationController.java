package com.sungwon.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sungwon.ims.service.CustomerService;
import com.sungwon.ims.service.SpecificationService;
import com.sungwon.ims.vo.CustomerVO;
import com.sungwon.ims.vo.SpecificationVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SpecificationController {
    
    private ModelAndView mv;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/specification")
    public ModelAndView specificationMain(){
        log.info("SpecificationController - specificationMain()");
                
        mv = new ModelAndView("specification/list");

        return mv;
    }

    @GetMapping("/specification/insert")
    public ModelAndView insertPage(){
        log.info("SpecificationController - insertPage()");

        ArrayList<CustomerVO> list = customerService.getCustomerList();

        mv = new ModelAndView("specification/insert");

        mv.addObject("list", list);

        return mv;
    }

    @GetMapping("/specification/data")
    @ResponseBody
    public HashMap<String, Object> specificationData(){
        log.info("CustomerController - productData()");        

        ArrayList<SpecificationVO> list = specificationService.specificationData();
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        result.put("data", list);
        result.put("length", list.size());

        return result;
    }

    
}

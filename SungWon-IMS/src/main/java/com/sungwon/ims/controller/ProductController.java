package com.sungwon.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sungwon.ims.service.ProductService;
import com.sungwon.ims.service.CustomerService;
import com.sungwon.ims.vo.CustomerVO;
import com.sungwon.ims.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class ProductController {
    
    private ModelAndView mv;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/product")
    public ModelAndView productMain(){
        log.info("ProductController - productMain()");
        
        mv = new ModelAndView("product/list");

        return mv;
    }

    @GetMapping("/product/insert")
    public ModelAndView insertPage(@RequestParam(required = false)Integer customer_idx){
        log.info("ProductController - insertPage()");        

        ArrayList<CustomerVO> list = customerService.getCustomerList();
        CustomerVO vo = null;
        if(customer_idx != null) vo = customerService.getCustomerDetail(customer_idx);
        
        mv = new ModelAndView("product/insert");

        mv.addObject("vo", vo);
        mv.addObject("list", list);

        return mv;
    }

    @PostMapping("/product/insert")
    public ModelAndView insertProduct(@ModelAttribute ProductVO vo){
        log.info("ProductController - insertProduct()");

        String msg = productService.insertProduct(vo);

        mv = new ModelAndView("redirect:/");

        return mv;
    }

    @GetMapping("/product/data")
    @ResponseBody
    public HashMap<String, Object> productData(@RequestParam(required = false) Integer customer_idx){
        log.info("CustomerController - productData()");        

        HashMap<String, Object> result = new HashMap<String, Object>();

        if(customer_idx == null) customer_idx = -1;

        ArrayList<ProductVO> list = productService.getProductList(customer_idx);

        result.put("data", list);
        result.put("length", list.size());

        return result;
    }
}

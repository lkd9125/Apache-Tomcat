package com.sungwon.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DashboardController {
    
    private ModelAndView mv;

    @GetMapping("dashboard")
    public ModelAndView dashboardPage(){
        log.info("DashbaordController - dashboardPage()");
        mv = new ModelAndView();

        mv.setViewName("dashboard/dashboard");

        return mv;
    }
}

package com.example.demo.demo2.runtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RuntestController {

    @Autowired
    RuntestService  runtestService;


    public String getMsg(){
        String msg = runtestService.getMsg();
        return msg;
    }
}

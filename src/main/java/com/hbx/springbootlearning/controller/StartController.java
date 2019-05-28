package com.hbx.springbootlearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartController {


    @RequestMapping("/start")
    @ResponseBody
    public String start(){
        return "start";

    }

}

package com.msg.duanxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author quanmin
 * @create 2019-12-02 17:37
 */
@Controller
public class PageController {

    @RequestMapping("")
    public String index(){
        return "index";
    }
}

package com.tianling.house.web.controller;

import com.tianling.house.common.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author tianling
 * @create 2020/9/20
 **/
@Controller
public class HomepageController {

    @RequestMapping("/index")
    public String accountsRegister(ModelMap modelMap){
        return "/homepage/index";
    }


    @RequestMapping("")
    public String index(ModelMap modelMap){
        return "redirect:/index";
    }
}

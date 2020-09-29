package com.tianling.house.web.controller;

import com.tianling.house.biz.service.HouseService;
import com.tianling.house.common.model.House;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author tianling
 * @create 2020/9/22
 **/
@Controller
public class HouseController {
    @Resource
    private HouseService houseService;

    @RequestMapping("/house/list")
    public String houseList(Integer pageSize, Integer pageNum, House query, ModelMap map){
        return null;
    }

}

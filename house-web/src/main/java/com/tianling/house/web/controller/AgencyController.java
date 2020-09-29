package com.tianling.house.web.controller;


import com.tianling.house.biz.service.AgencyService;
import com.tianling.house.common.model.Agency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 经纪人表(Agency)表控制层
 *
 * @author makejava
 * @since 2020-09-16 20:28:31
 *
 */
@RestController
@RequestMapping("agency")
public class AgencyController {
    /**
     * 服务对象
     */
    @Resource
    private AgencyService agencyService;



}
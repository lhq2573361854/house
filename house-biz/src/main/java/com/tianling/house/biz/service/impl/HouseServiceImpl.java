package com.tianling.house.biz.service.impl;

import com.tianling.house.biz.dao.HouseDao;
import com.tianling.house.biz.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tianling
 * @create 2020/9/22
 **/
@Service("HouseService")
public class HouseServiceImpl implements HouseService {
    @Resource
    private HouseDao houseDao;
}

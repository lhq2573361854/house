package com.tianling.house.biz.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tianling.house.biz.dao.AgencyDao;
import com.tianling.house.biz.service.AgencyService;
import com.tianling.house.common.model.Agency;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 经纪人表(Agency)表服务实现类
 *
 * @author makejava
 * @since 2020-09-16 20:28:31
 */
@Service("agencyService")
public class AgencyServiceImpl implements AgencyService {
    @Resource
    private AgencyDao agencyDao;


    @Override
    public List<Agency> queryAllAgency() {
        return this.agencyDao.selectList(null);
    }
}
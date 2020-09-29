package com.tianling.house.biz.service;


import com.tianling.house.common.model.Agency;

import java.util.List;

/**
 * 经纪人表(Agency)表服务接口
 *
 * @author makejava
 * @since 2020-09-16 20:28:31
 */
public interface AgencyService {
    /**
     * 查询所有的符合条件的Agency
     * @return
     */
    List<Agency> queryAllAgency();

}
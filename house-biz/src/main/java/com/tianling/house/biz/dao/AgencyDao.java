package com.tianling.house.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianling.house.common.model.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 经纪人表(Agency)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-16 20:28:30
 */
@Mapper
public interface AgencyDao extends BaseMapper<Agency> {

}
package com.tianling.house.biz.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianling.house.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-16 20:32:02
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select(" SELECT id,name FROM user")
    IPage<User> selectPageVo(Page<User> page);

}
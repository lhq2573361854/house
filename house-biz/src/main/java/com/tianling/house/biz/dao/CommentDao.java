package com.tianling.house.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianling.house.common.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论表(Comment)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-16 20:28:31
 */
@Mapper
public interface CommentDao extends BaseMapper<Comment> {

}
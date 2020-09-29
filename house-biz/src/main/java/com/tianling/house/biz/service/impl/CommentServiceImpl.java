package com.tianling.house.biz.service.impl;

import com.tianling.house.biz.dao.CommentDao;
import com.tianling.house.biz.service.CommentService;
import com.tianling.house.common.model.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-09-16 20:28:31
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

}
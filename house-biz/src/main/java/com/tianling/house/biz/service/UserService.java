package com.tianling.house.biz.service;


import com.tianling.house.common.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2020-09-16 20:32:02
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过账号添加用户
     * @param account
     * @return
     */
    boolean addAccount(User account, List<MultipartFile> files);

    /**
     * 判断本地缓存中key是否可以用
     * @param key
     * @return
     */
    boolean enable(String key);

    /**
     * 密码校验
     * @param username
     * @param password
     * @return
     */
    User auth(String username, String password);

    /**
     * 通过email 更新用户数据
     * @param user
     * @param email
     * @return
     */
    User updateByEmail(User user,String email);
}
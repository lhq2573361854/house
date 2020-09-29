package com.tianling.house.biz.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.tianling.house.biz.dao.UserDao;
import com.tianling.house.biz.service.FileService;
import com.tianling.house.biz.service.MailService;
import com.tianling.house.biz.service.UserService;
import com.tianling.house.common.model.User;
import com.tianling.house.common.utils.BeanHelper;
import com.tianling.house.common.utils.HashUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2020-09-16 20:32:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private FileService fileService;

    @Resource
    private MailService mailService;

    @Value("${file.prefix}")
    private String filePrefix;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return (User) this.userDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.last("limit "+offset+","+limit);
        return this.userDao.selectList(wrapper);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.updateById(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 通过账号添加账户
     * @param account
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addAccount(User account, List<MultipartFile> files) {
        String s = HashUtils.encryPassword(account.getPasswd());
        account.setPasswd(s);
        fileService.getImagePath(Lists.newArrayList(files));
        BeanHelper.setDefaultProp(account,User.class);
        BeanHelper.onInsert(account);
        account.setEnable(0);
        userDao.insert(account);
        mailService.registerNotify(account.getEmail());
        return true;
    }

    /**
     * 对一个key 进行校验
     * @param key
     * @return
     */
    @Override
    public boolean enable(String key) {
        return mailService.enable(key);
    }

    /**
     * 密码校验
     * @param username
     * @param password
     * @return
     */
    @Override
    public User auth(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("email",username);
        map.put("passwd",HashUtils.encryPassword(password));
        map.put("enable",Integer.valueOf(1));
        wrapper.allEq(map);
        User demo = userDao.selectOne(wrapper);
        if(demo != null) {
            String avatar = demo.getAvatar();
            demo.setAvatar(filePrefix+avatar);
        }
        return demo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateByEmail(User user, String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        int update = userDao.update(user, queryWrapper);
        return this.queryById((long)update);
    }


}
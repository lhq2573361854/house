package com.tianling.house.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Objects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.tianling.house.biz.dao.UserDao;
import com.tianling.house.biz.service.MailService;
import com.tianling.house.common.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tianling
 * @create 2020/9/19
 **/
@Service
public class MailServiceImpl implements MailService {
    private Logger log = LoggerFactory.getLogger(MailServiceImpl.class);
    @Resource
    private UserDao userDao;
    /**
     * 本地缓存 缓存用户的注册的key
     *
     */
    private final Cache<String,String> registerCache = CacheBuilder.newBuilder().maximumSize(100)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .removalListener(new RemovalListener<String, String>() {
                @Override
                public void onRemoval(RemovalNotification<String, String> removalNotification) {
                    QueryWrapper wrapper = new QueryWrapper<User>();
                    wrapper.eq("email",removalNotification.getValue());
                    List<User> list = userDao.selectList(wrapper);
                    if (!list.isEmpty() && Objects.equal(list.get(0).getEnable(), 0)) {
                        userDao.delete(wrapper);
                    }
                }
            }).build();

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${domain.name}")
    private String domain;

    /**
     *  给一个邮箱发送一个邮件
     * @param title
     * @param url
     * @param mail
     */
    @Async
    @Override
    public void sendMail(String title, String url, String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mail);
        message.setText(url);
        message.setSubject(title);
        javaMailSender.send(message);
    }

    /**
     *  通知用户激活的url
     * @param email
     */
    @Override
    @Async
    public void registerNotify(String email) {
        String randomKey = RandomStringUtils.randomAlphabetic(10);
        registerCache.put(randomKey, email);
        String url = "http://"+domain+"/accounts/verify?key=" + randomKey;
        log.info(url);
        sendMail("房产平台激活邮件", url, email);
    }

    /**
     * 判断激活的url的key是否可以用
     * @param key
     * @return
     */
    @Override
    public boolean enable(String key) {
        String email = registerCache.getIfPresent(key);
        if (StringUtils.isBlank(email)) {
            return false;
        }
        User updateUser = new User();
        updateUser.setEnable(1);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        userDao.update(updateUser,wrapper); // 今日做到这里
        registerCache.invalidate(key);
        return true;
    }


}

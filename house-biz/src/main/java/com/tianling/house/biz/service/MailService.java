package com.tianling.house.biz.service;

/**
 * @author tianling
 * @create 2020/9/19
 **/
public interface MailService {
    /**
     *  给一个邮箱发送一个邮件
     * @param title
     * @param url
     * @param mail
     */
    public void sendMail(String title,String url,String mail);

    /**
     *  通知用户激活的url
     * @param email
     */
    void registerNotify(String email);

    /**
     * 判断激活的url的key是否可以用
     * @param key
     * @return
     */
    boolean enable(String key);
}

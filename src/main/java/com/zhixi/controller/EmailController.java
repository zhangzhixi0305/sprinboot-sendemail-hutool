package com.zhixi.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * @ClassName EmaileController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-3-4 23:13
 * @Version 1.0
 */
@Controller
public class EmailController {
    /**
     * 推荐创建不可变静态类成员变量
     */
    private static final Log log = LogFactory.get();

    /**
     * 发送邮件的方法
     *
     * @param addresseeEmail 收件人的邮箱
     * @param emailTitle     邮件标题
     * @param emailContent   邮件内容
     */
    @PostMapping("/sendEmail")
    public String senEmailTest(String addresseeEmail, String emailTitle, String emailContent) {
        log.info("**************begin**************");
//        ArrayList<String> tos = CollUtil.newArrayList("1820712542@qq.com", "1477964823@qq.com", "1416318100@qq.com", "948513919@qq.com", "358944439@qq.com");
        /*1、给谁发送邮件*/
        ArrayList<String> tos = CollUtil.newArrayList(addresseeEmail);
        /*收件人、标题、正文、是否为HTML*/
        MailUtil.send(tos, emailTitle, emailContent, false);
        log.info("**************end**************");
        return "success";
    }
}

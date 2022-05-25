package com.community;

import com.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author XD
 * @create 2022-05-20 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine engine;

    private String to = "1096871337@qq.com";

    @Test
    public void testString() {
        String subject = "hello, it is a string";
        String content = "ok";
        mailClient.sendMail(to, subject, content);
    }

    @Test
    public void testHTML() {
        Context context = new Context();
        String subject = "test html";
        String content = engine.process("/mail/activation", context);
        mailClient.sendMail(to, subject, content);
    }
}

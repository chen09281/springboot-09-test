package com.chen.springboot09test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {

        // 一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("陈你好啊~");
        mailMessage.setText("谢谢你的支持！");
        mailMessage.setTo("weifengchen198@gmail.com","1219853295@qq.com");
        mailMessage.setFrom("1219853295@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads1() throws MessagingException {

        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        // 正文
        helper.setSubject("陈你好啊~plus");
        helper.setText("<p style='color:red'>谢谢你的支持</p>",true);

        // 附件
        helper.addAttachment("レイラ.jpg",new File("C:\\Users\\1\\Desktop\\レイラ.jpg"));
        helper.addAttachment("birth.png",new File("C:\\Users\\1\\Desktop\\birth.png"));

        helper.setTo("1219853295@qq.com");
        helper.setFrom("1219853295@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     * @Author chen
     */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException{

        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        // 正文
        helper.setSubject(subject);
        helper.setText(text,true);

        // 附件
        helper.addAttachment("レイラ.jpg",new File("C:\\Users\\1\\Desktop\\レイラ.jpg"));
        helper.addAttachment("birth.png",new File("C:\\Users\\1\\Desktop\\birth.png"));

        helper.setTo("1219853295@qq.com");
        helper.setFrom("1219853295@qq.com");
        mailSender.send(mimeMessage);
    }

}

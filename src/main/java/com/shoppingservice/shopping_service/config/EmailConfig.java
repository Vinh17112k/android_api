package com.shoppingservice.shopping_service.config;
import com.shoppingservice.shopping_service.utils.Constants;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
//  @Bean
//  public JavaMailSender getJavaMailSender() {
//    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//    mailSender.setHost(Constants.MAIL_SENDER_HOST);
//    mailSender.setPort(Constants.MAIL_SENDER_POST);
//
//    mailSender.setUsername(Constants.EMAIL_SENDER);
//    mailSender.setPassword(Constants.EMAIL_SENDER_PASSWORD);
//
//    Properties props = mailSender.getJavaMailProperties();
//    props.put("mail.transport.protocol", "smtp");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "true");
//    props.put("mail.debug", "true");
//
//    return mailSender;
//  }
}

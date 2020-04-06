package com.hendisantika.sendemailthymeleaftemplatespringboot.service;

import com.hendisantika.sendemailthymeleaftemplatespringboot.model.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

/**
 * Created by IntelliJ IDEA.
 * Project : send-email-thymeleaf-template-spring-boot
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/04/20
 * Time: 05.51
 */
@Service
public class MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    public ResponseEntity<?> sendMail(Mail mail) {
        send(mail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

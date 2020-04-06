package com.hendisantika.sendemailthymeleaftemplatespringboot.controller;

import com.hendisantika.sendemailthymeleaftemplatespringboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : send-email-thymeleaf-template-spring-boot
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/04/20
 * Time: 05.53
 */
@RestController
@RequestMapping("api/send/mail")
@CrossOrigin("*")
public class MailRestController {

    @Autowired
    private MailService mailService;
}

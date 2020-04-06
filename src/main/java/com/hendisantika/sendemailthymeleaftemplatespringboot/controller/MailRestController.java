package com.hendisantika.sendemailthymeleaftemplatespringboot.controller;

import com.hendisantika.sendemailthymeleaftemplatespringboot.model.Mail;
import com.hendisantika.sendemailthymeleaftemplatespringboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @PostMapping
    public ResponseEntity<?> sendMail(@Valid @RequestBody Mail mail, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return mailService.sendMail(mail);
    }
}

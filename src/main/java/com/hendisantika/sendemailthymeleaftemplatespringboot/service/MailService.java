package com.hendisantika.sendemailthymeleaftemplatespringboot.service;

import com.hendisantika.sendemailthymeleaftemplatespringboot.model.Mail;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

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
@Log4j2
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

    public void send(Mail mail) {
        final Context context = new Context();
        context.setVariable("message", mail.getMessage());
        context.setVariable("createdOn", mail.getCreatedOn());
        String body = templateEngine.process("email/email-template", context);
        sendPreparedMail(mail.getEmail(), mail.getSubject(), body, true);
    }

    private void sendPreparedMail(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mail);
            log.info("Email Sent! {}", LocalDateTime.now());
        } catch (Exception e) {
            LOGGER.error("Problem with sending email to: {}, error message: {}", to, e.getMessage());
        }
    }
}

package co.istad.sm.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.naming.Context;

@Component
@RequiredArgsConstructor
public class MailUtil {

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public void sendMail() throws MessagingException {

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage);

//        1. Prepare template for send mail

        helper.setText("auth/verify", true);
//        2. Prepare mail information
//        3. Send mail
        javaMailSender.send(mimeMailMessage);

    }
}

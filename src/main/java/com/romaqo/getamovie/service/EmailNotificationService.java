package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.MeetingInvitation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationService {

    private static final String MESSAGE_TEMPLATE = "%s invites you to watch awesome movie '%s'!\n" +
                                                   "%s \n" +
                                                   "When: %s\n" +
                                                   "Where: %s\n" +
                                                   "\nThank you, \nget-a-movie";

    private static final String SUBJECT = "Lets watch some movie!";

    private final JavaMailSender mailSender;
    private final String userEmail;

    @Autowired
    public EmailNotificationService(JavaMailSender mailSender,
                                    @Value("${spring.mail.username}") String userEmail) {
        this.mailSender = mailSender;
        this.userEmail = userEmail;
    }

    public void sendInvitation(MeetingInvitation invitation) {
        String messageBody = prepareMessageBody(invitation);
        invitation.getEmailsTo().forEach(recipientMail -> sendMessage(recipientMail, messageBody));
    }

    private void sendMessage(String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userEmail);
        message.setTo(to);
        message.setSubject(SUBJECT);
        message.setText(text);
        mailSender.send(message);
        log.info("Email sent to: " + to);
    }

    private String prepareMessageBody(MeetingInvitation i) {
        return String.format(MESSAGE_TEMPLATE, i.getFrom(), i.getMovie(),
                             i.getMessage(), i.getDateTime(), i.getLocationInfo());
    }
}

package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.MeetingInvitation;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
class EmailNotificationServiceTest {

    private static String SYSTEM_MAIL = "system@mail.com";

    @Mock
    JavaMailSender mailSender;

    EmailNotificationService emailService = new EmailNotificationService(mailSender, SYSTEM_MAIL);

    @Test
    void testSendsMailWithCorrectData() {
        MeetingInvitation invitation = MeetingInvitation.builder()
                                                        .dateTime("Today")
                                                        .emailsTo(Arrays.asList("test@test.com"))
                                                        .from("Test")
                                                        .movie("Prestige")
                                                        .locationInfo("Room 12")
                                                        .message("Hello")
                                                        .build();

        emailService.sendInvitation(invitation);
    }
}
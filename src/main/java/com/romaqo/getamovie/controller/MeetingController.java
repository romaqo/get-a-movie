package com.romaqo.getamovie.controller;

import com.romaqo.getamovie.entity.MeetingInvitation;
import com.romaqo.getamovie.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meeting")
public class MeetingController {

    private final EmailNotificationService notificationService;

    @Autowired
    public MeetingController(EmailNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("setup")
    public void getRandomMovie(@RequestBody MeetingInvitation invitation) {
        notificationService.sendInvitation(invitation);
    }
}

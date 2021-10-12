package com.romaqo.getamovie.entity;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeetingInvitation {
    private List<String> emailsTo;
    private String from;
    private String movie;
    private String dateTime;
    private String locationInfo;
    private String message;
}


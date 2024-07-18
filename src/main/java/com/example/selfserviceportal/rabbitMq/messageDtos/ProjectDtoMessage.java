package com.example.selfserviceportal.rabbitMq.messageDtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProjectDtoMessage {
    private Long id;
    private String title;
    private String description;

}

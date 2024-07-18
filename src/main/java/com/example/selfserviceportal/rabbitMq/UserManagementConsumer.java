package com.example.selfserviceportal.rabbitMq;

import com.example.selfserviceportal.dtos.UserDto;
import com.example.selfserviceportal.rabbitMq.messageDtos.ProjectDtoMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserManagementConsumer {

    @RabbitListener(queues = "selfServiceRatingQueue")
    public void consumeMessage(ProjectDtoMessage projectDtoMessage){
        System.out.println(projectDtoMessage);
    }

    @RabbitListener(queues = "userManagementService")
    public void toDto(UserDto userDto){
    }
}

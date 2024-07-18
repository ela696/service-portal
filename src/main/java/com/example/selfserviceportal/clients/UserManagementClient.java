package com.example.selfserviceportal.clients;

import com.example.selfserviceportal.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-MANAGEMENT", url = "${user-service.url}")
public interface UserManagementClient {

    @GetMapping("/admin/realms/analytix/users/{userId}")
    UserDto toDto(@PathVariable("userId") String userId);

}

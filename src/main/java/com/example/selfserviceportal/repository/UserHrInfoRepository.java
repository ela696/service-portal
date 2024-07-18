package com.example.selfserviceportal.repository;

import com.example.selfserviceportal.entities.UserHRInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserHrInfoRepository extends JpaRepository<UserHRInfo, Long> {
    Optional<UserHRInfo> findByUserId(String userId);
    List<UserHRInfo> findByUserIdIn(List<String> userIds);



}

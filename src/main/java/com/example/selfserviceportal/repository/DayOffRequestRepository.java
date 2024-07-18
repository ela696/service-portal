package com.example.selfserviceportal.repository;

import com.example.selfserviceportal.entities.DayoffRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayOffRequestRepository extends JpaRepository<DayoffRequest, Long> {
        List<DayoffRequest> findAllByEmployeeId(String userId);
}

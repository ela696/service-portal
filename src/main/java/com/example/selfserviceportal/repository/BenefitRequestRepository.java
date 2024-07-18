package com.example.selfserviceportal.repository;

import com.example.selfserviceportal.entities.BenefitRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BenefitRequestRepository extends JpaRepository<BenefitRequest, Long> {
    List<BenefitRequest> findAllByEmployeeId(String employeeId);
    List<BenefitRequest> findAllByManagerId(String managerId);
}

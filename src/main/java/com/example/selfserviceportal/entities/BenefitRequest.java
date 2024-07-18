package com.example.selfserviceportal.entities;

import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "benefit_request")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BenefitRequest extends AbstractEntity {
    private String employeeId;
    private String managerId;
    private String motivation;
    @ManyToOne
    private Benefit benefit;
}

package com.example.selfserviceportal.entities;

import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Benefit extends AbstractEntity {
    private BenefitType type;
    private String name;
    private String backgroundImageUri;
    private String description;
}

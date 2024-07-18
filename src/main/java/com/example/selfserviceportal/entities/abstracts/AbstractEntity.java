package com.example.selfserviceportal.entities.abstracts;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationTime;

    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false)
    private LocalDate updatedTime;
}

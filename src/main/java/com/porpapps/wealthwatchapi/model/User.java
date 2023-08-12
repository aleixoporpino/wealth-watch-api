package com.porpapps.wealthwatchapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            columnDefinition = "INT",
            nullable = false,
            updatable = false)
    private Integer id;

    @Column(name = "name",
            columnDefinition = "VARCHAR(60)",
            nullable = false,
            unique = true)
    private String name;

    @Column(name = "password",
            columnDefinition = "VARCHAR(20)",
            nullable = false)
    private String password;

    @Column(name = "email",
            columnDefinition = "VARCHAR(200)",
            nullable = false,
            unique = true)
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
}








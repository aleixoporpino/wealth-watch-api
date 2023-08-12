package com.porpapps.wealthwatchapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            columnDefinition = "INT",
            nullable = false,
            updatable = false)
    private Integer id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            columnDefinition = "INT",
            nullable = false,
            updatable = false)
    private User user;

    @Column(name = "name",
            columnDefinition = "VARCHAR(50)",
            nullable = false,
            unique = true)
        private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

}








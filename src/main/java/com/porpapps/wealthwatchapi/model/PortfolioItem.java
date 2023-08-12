package com.porpapps.wealthwatchapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "portfolio_item")
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            columnDefinition = "INT",
            nullable = false,
            updatable = false)
    private Integer id;

    @ManyToOne( targetEntity = Portfolio.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id",
            referencedColumnName = "id",
            columnDefinition = "INT",
            nullable = false,
            updatable = false)
    private Portfolio portfolio;

    @Column(name = "symbol",
            columnDefinition = "VARCHAR(20)",
            nullable = false)
    private String symbol;

    @Column(name = "shares", columnDefinition = "INT")
    private Integer shares;

    @Temporal(TemporalType.DATE)
    @Column(name = "trade_date")
    private LocalDate tradeDate;

    @Column(name = "cost_share", columnDefinition = "DECIMAL(4, 2)")
    private BigDecimal costShare;

    @Column(name = "day_gain", columnDefinition = "DECIMAL(3, 2)")
    private BigDecimal dayGain;

    @Column(name = "total_gain", columnDefinition = "DECIMAL(5, 2)")
    private BigDecimal totalGain;

    @Column(name = "high_limit", columnDefinition = "DECIMAL(4, 2)")
    private BigDecimal highLimit;

    @Column(name = "low_limit", columnDefinition = "DECIMAL(4, 2)")
    private BigDecimal lowLimit;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
}

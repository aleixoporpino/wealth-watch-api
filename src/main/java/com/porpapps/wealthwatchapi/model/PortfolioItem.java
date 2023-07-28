package com.porpapps.wealthwatchapi.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PortfolioItem {
    private Integer id;
    private Portfolio portfolio;
    private String symbol;
    private Integer shares;
    private LocalDate tradeDate;
    private BigDecimal costShare;
    private BigDecimal dayGain;
    private BigDecimal totalGain;
    private BigDecimal highLimit;
    private BigDecimal lowLimit;
    private LocalDateTime created;
    private LocalDateTime updated;
}

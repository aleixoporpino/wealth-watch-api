package com.porpapps.wealthwatchapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Portfolio {
    private Integer id;
    private User user;
    private String name;
    private Enum currency;
    private LocalDateTime created;
    private LocalDateTime updated;

}

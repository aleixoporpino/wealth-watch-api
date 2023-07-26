package com.porpapps.wealthwatchapi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Portfolio {
    private Integer id;
    private User user;
    private String name;
    private Enum currency;
    private LocalDate created;
    private LocalDate updated;

}

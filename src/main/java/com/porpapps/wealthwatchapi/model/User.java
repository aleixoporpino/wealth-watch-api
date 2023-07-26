package com.porpapps.wealthwatchapi.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private LocalDate created;
    private LocalDate updated;
}

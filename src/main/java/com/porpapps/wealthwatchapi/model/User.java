package com.porpapps.wealthwatchapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
}

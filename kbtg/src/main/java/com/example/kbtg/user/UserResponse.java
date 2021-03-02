package com.example.kbtg.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class UserResponse {

    private int id;
    private String name;
    private int age;

}

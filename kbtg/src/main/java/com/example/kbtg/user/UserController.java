package com.example.kbtg.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserInfoById (@PathVariable int id) {
        return new UserResponse(id, "bamnich", 25);
    }

}

package com.example.kbtg.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserResponse getUserInfoById (@PathVariable int id) {
        UserResponse userResponse = userService.getInfo(id);
        return userResponse;
    }

}

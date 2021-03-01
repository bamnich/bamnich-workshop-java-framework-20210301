package com.example.kbtg.user;

import org.sptringframework.web.bind.annotation.RestController;
import org.sptringframework.web.bind.annotation.PathVariable;
import org.sptringframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserInfoById (@PathVariable int id) {
        return new UserResponse(7, "bamnich", 25);
    }

}

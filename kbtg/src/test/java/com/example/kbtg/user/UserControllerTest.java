package com.example.kbtg.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void clearData(){
        userRepository.deleteAll();
    }

    @Test
    public void success_get_user_id_1() {
        // Prepare
        MyUser bamnich = new MyUser();
        bamnich.setName("bamnich");
        bamnich.setAge(25);
        userRepository.save(bamnich);

        UserResponse response = restTemplate.getForObject("/users/1", UserResponse.class);

        assertEquals(1, response.getId());
        assertEquals("bamnich", response.getName());
        assertEquals(25, response.getAge());

        UserResponse expected = new UserResponse(1, "bamnich", 25);
        assertEquals(expected, response);
    }

    @Test
    public void user_not_found_with_user_id_15() {
        // TODO
        ErrorResponse response = restTemplate.getForObject("/users/15", ErrorResponse.class);
        assertEquals(1234, response.getCode());
        assertEquals("User not found id: 15", response.getMessage());
    }

}

package com.example.kbtg.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserController2Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void success_get_user_id_1() {
        // Prepare
        MyUser bamnich = new MyUser();
        bamnich.setId(1);
        bamnich.setName("bamnich");
        bamnich.setAge(25);
        when(userRepository.findById(1)).thenReturn(Optional.of(bamnich));

        UserResponse response = restTemplate.getForObject("/users/1", UserResponse.class);

        assertEquals(1, response.getId());
        assertEquals("bamnich", response.getName());
        assertEquals(25, response.getAge());

        UserResponse expected = new UserResponse(1, "bamnich", 25);
        assertEquals(expected, response);
    }

}

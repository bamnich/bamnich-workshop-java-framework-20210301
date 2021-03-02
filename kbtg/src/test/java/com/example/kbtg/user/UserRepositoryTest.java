package com.example.kbtg.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    public void found_get_user_by_id(){
        // Prepare
        MyUser bamnich = new MyUser();
        bamnich.setName("bamnich");
        bamnich.setAge(25);
        userRepository.save(bamnich);

        Optional<MyUser> user = userRepository.findById(1);
        assertTrue(user.isPresent());

        MyUser expected = new MyUser(1, "bamnich", 25);
        assertEquals(expected, user.get());

    }

    @Test
    public void not_found_get_user_by_id() {
        // Act
        Optional<MyUser> user = userRepository.findById(1);
        // Assert
        assertFalse(user.isPresent());
    }
}
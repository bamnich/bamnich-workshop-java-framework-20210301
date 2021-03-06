package com.example.kbtg.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void found_user_by_id_1() {
        // Prepare
        MyUser bamnich = new MyUser();
        bamnich.setId(1);
        bamnich.setName("bamnich");
        bamnich.setAge(25);
        when(userRepository.findById(1)).thenReturn(Optional.of(bamnich));

        UserService userService = new UserService(userRepository);
        UserResponse response = userService.getInfo(1);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("bamnich", response.getName());
        assertEquals(25, response.getAge());
    }

    @Test
    public void user_not_found_with_id_15_should_throw_exception() {
        // TODO
        // Prepare
        when(userRepository.findById(15)).thenReturn(Optional.empty());
        //Act
        Exception exception = assertThrows(RuntimeException.class, () -> {
            UserService userService = new UserService(userRepository);
            userService.getInfo(15);
        });
        assertEquals("User not found id: 15", exception.getMessage());
    }

}

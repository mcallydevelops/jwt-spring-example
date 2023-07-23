package com.mcallydevelops;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void register() {
        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);
        User expected = new User(UUID.randomUUID(), "username", "password");
        assertEquals(expected.getUsername(), userController.register(expected).getUsername());
        Optional<User> byUsername = userRepository.findByUsername(expected.getUsername());
        assertEquals(expected.getUsername(), byUsername.get().getUsername());
    }

    @Test
    void login() throws Exception {
        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);
        User loginUser = userController.register(new User(UUID.randomUUID(), "username", "password"));
        assertNotNull(userController.login(loginUser));
    }

    @Test
    void loginIncorrectPassword() {
        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);
        userController.register(new User(UUID.randomUUID(), "username", "password"));
        assertThrows(Exception.class, () -> userController.login(new User(UUID.randomUUID(), "username", "not_password")));
    }
}
package com.mcallydevelops;

import java.util.UUID;

public class User extends DataRecord {
    private final String username;
    private String password;

    public User(UUID id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    static User fromRequest(User request) {
        return new User(UUID.randomUUID(), request.getUsername(), request.getPassword());
    }
}

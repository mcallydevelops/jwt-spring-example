package com.mcallydevelops;

import java.util.Optional;

public class UserRepository extends Repository<User> {
    public UserRepository() {
        super();
    }

    public Optional<User> findByUsername(String username) {
        return this.list().stream().filter(user -> username.equals(user.getUsername())).findFirst();
    }
}

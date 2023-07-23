package com.mcallydevelops;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User request) {
        return userRepository.save(User.fromRequest(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody User login) throws Exception {
        return userRepository.findByUsername(login.getUsername())
                .flatMap(user -> {
                    if(login.getPassword().equals(user.getPassword())) {
                        return Optional.of(Jwts.builder()
                                .setSubject(user.getId().toString())
                                .setIssuedAt(new Date())
                                .signWith(SignatureAlgorithm.HS256, "secret").compact());
                    }
                    return Optional.empty();
                }).orElseThrow(Exception::new);
    }
}

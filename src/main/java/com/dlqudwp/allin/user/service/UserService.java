package com.dlqudwp.allin.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlqudwp.allin.common.Argon2Encryptor;
import com.dlqudwp.allin.user.domain.User;
import com.dlqudwp.allin.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Argon2Encryptor argon2Encryptor;

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUser(String loginId, String password) {
        User user = userRepository.findByLoginId(loginId).orElse(null);
        if (user != null && argon2Encryptor.verifyPassword(user.getPassword(), password)) {
            return user;
        }
        return null;
    }

    public boolean isDuplicateId(String loginId) {
        return userRepository.countByLoginId(loginId) > 0;
    }

    public User addUser(String loginId, String password, String name, String email) {
        String hashedPassword = argon2Encryptor.hashPassword(password);
        User newUser = User.builder()
                .loginId(loginId)
                .password(hashedPassword)
                .name(name)
                .email(email)
                .build();
        return userRepository.save(newUser);
    }
}


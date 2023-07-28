package com.example.tamagotchibackend.Service;

import com.example.tamagotchibackend.Domain.User;
import com.example.tamagotchibackend.Domain.Status;
import com.example.tamagotchibackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (Objects.equals(user.getPassword(), password)) {
            return user;
        }
        else {
            return null;
        }
    }

    public Status getStatus(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        return new Status(user.getHunger(), user.getHappiness());
    }

    public Status updateStatus(Status status, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("getStatus: No such user!"));
        user.setHappiness(status.getHappiness());
        user.setHunger(status.getHunger());
        userRepository.save(user);
        return new Status(user.getHunger(), user.getHappiness());
    }
}

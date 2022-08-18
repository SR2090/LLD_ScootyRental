package com.wisetap.scootyrental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wisetap.scootyrental.entities.User;

public class UserService {
    private List<User> userRepository;

    public UserService(){
        userRepository = new ArrayList<>();
    }

    public void createUser(String userName, Integer XCoordinate, Integer YCoordinate) {
        userRepository.add(new User(userName, XCoordinate, YCoordinate));
    }

    public Optional<User> getUser(String userName) {
        return userRepository.stream().filter(user -> user.getUserName().equalsIgnoreCase(userName)
        ).findFirst();
    }
}

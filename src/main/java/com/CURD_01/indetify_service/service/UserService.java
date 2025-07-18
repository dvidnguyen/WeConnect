package com.CURD_01.indetify_service.service;

import com.CURD_01.indetify_service.entity.User;
import com.CURD_01.indetify_service.repository.UserRepository;
import dto.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id"));
    }
    public User updateUser(String id,UserCreationRequest request){
        User user = getUser(id);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
}
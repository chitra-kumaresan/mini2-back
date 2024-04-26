package com.example.mini2_backend.service;


import com.example.mini2_backend.dto.JwtAuthResponse;
import com.example.mini2_backend.dto.LoginDto;
import com.example.mini2_backend.dto.RegisterDto;
import com.example.mini2_backend.entity.User;

import java.util.List;

public interface AuthService {
    String register(RegisterDto registerDto);


    JwtAuthResponse login(LoginDto loginDto);

    User getUser(String name);
    boolean oldPasswordIsValid(User user, String oldPassword);
    void changePassword(User user,String newPassword);
    void deleteById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User getById(Long id);



}
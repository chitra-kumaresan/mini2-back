package com.example.mini2_backend.controller;

import com.example.mini2_backend.dto.JwtAuthResponse;
import com.example.mini2_backend.dto.LoginDto;
import com.example.mini2_backend.dto.RegisterDto;
import com.example.mini2_backend.entity.User;
import com.example.mini2_backend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private AuthService authService;

    //controller endpoints for login and register form
    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto) {
        String response1 = authService.register(registerDto);
        return response1;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
//get BY EMAIL API
    @GetMapping("email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = authService.getUserByEmail(email);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
//GET BY USERNAME API
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {
        User user = authService.getUser(username);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
//GET BY GIVING  USER ID
    @GetMapping("id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = authService.getById(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
//GET ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = authService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        authService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
//// update new password api
//    @PostMapping("/update")
//    public String passwordChange(@RequestBody PasswordRequestUtil passwordRequestUtil) {
//        User response = authService.getUser(passwordRequestUtil.getUsername());
//        if (!authService.oldPasswordIsValid(response, passwordRequestUtil.getOldPassword())) {
//            return "InCorrect Old Password";
//        } else {
//            authService.changePassword(response, passwordRequestUtil.getNewPassword());
//            return "Password changed successfully";
//        }
//    }





}
package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.JwtAuthResponse;
import com.example.mini2_backend.dto.LoginDto;
import com.example.mini2_backend.dto.RegisterDto;
import com.example.mini2_backend.entity.Role;
import com.example.mini2_backend.entity.User;
import com.example.mini2_backend.exception.ResourceNotFoundException;
import com.example.mini2_backend.exception.ToDoApiException;
import com.example.mini2_backend.repo.RoleRepo;
import com.example.mini2_backend.repo.UserRepo;
import com.example.mini2_backend.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepo userRepository;
    private RoleRepo roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @Override
    public String register(RegisterDto registerDto) {

        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new ToDoApiException(HttpStatus.BAD_REQUEST, "UserName already exists");
        }
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new ToDoApiException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered successfully!!";

    }

    @Override
    public JwtAuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generate(loginDto.getUsername());
        Optional<User> userOptional = userRepository.findByUsernameOrEmail(loginDto.getUsername(), loginDto.getUsername());
        String role = null;

        if (userOptional.isPresent()) {
            User loggedUser = userOptional.get();
            //Optional<Role> optionalRole=loggedUser.getRoles().stream().findFirst();
            List<Role> roleList = loggedUser.getRoles().stream()
                    .filter(_role -> _role.getName().equalsIgnoreCase("ROLE_ADMIN"))
                    .collect(Collectors.toList());
            if (roleList.size() > 0) {
                Role dbrole = roleList.get(0);
                role = dbrole.getName();

            } else {
                Role userRole = loggedUser.getRoles().stream().findFirst().get();
                role = userRole.getName();
            }
        }
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setRole(role);
        jwtAuthResponse.setAccessToken(token);
        return jwtAuthResponse;
    }


    @Override
    public User getUser(String name) {

        User user=userRepository.findByUsername(name)
                .orElseThrow(()->new ResourceNotFoundException("User not exist"));
                return user;
    }

    @Override
    public boolean oldPasswordIsValid(User user, String oldPassword) {

        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public void changePassword(User user, String newPassword) {
      user.setPassword(passwordEncoder.encode(newPassword));
    }


    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getUserByEmail(String email) {
       User user= userRepository.findByEmail(email);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList=userRepository.findAll();
        return userList;
    }

    @Override
    public User getById(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","id",id));
        return user;
    }
}
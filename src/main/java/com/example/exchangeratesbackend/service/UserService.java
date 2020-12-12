package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User register(NewUserDto newUserDto){
        User existingUser = userRepository.getByLogin(newUserDto.getName());

        if(existingUser != null){
            throw new ResourceConflict();
        }

        User user = new User();

        String password = passwordEncoder.encode(newUserDto.getPassword());

        user.setActive(true);
        user.setLastName(newUserDto.getLastName());
        user.setName(newUserDto.getName());
        user.setLogin(newUserDto.getLogin());
        user.setRole("USER");
        user.setPassword(password);

        userRepository.save(user);

        user.setPassword("");

        return user;
    }

}

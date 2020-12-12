package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewActiveDto;
import com.example.exchangeratesbackend.dto.NewRoleDto;
import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.dto.UserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.error.ResourceNotFound;
import com.example.exchangeratesbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userRepository.findAll().stream().filter(user -> {user.setPassword(""); return true;}).collect(Collectors.toList());
    }

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

    public void changeRole(Long userId, NewRoleDto newRoleDto){
        User user = userRepository.getById(userId);

        if(user == null){
            throw new ResourceNotFound();
        }

        if(!isKnownRole(newRoleDto.getRole())){
            throw new ResourceNotFound();
        }

        user.setRole(newRoleDto.getRole());
        userRepository.save(user);
    }

    public void deleteUser(Long userId){
        User user = userRepository.getById(userId);

        if(user == null){
            throw new ResourceNotFound();
        }

        userRepository.delete(user);
    }

    public void changeActive(Long userId, NewActiveDto newActiveDto) {
        User user = userRepository.getById(userId);

        if(user == null){
            throw new ResourceNotFound();
        }

        user.setActive(newActiveDto.isActive());
        userRepository.save(user);
    }

    private boolean isKnownRole(String role){
        if(!role.equals("USER") && !role.equals("ADMIN")){
            return false;
        }
        return true;
    }

}

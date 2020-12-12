package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewRoleDto;
import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.error.ResourceNotFound;
import com.example.exchangeratesbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    private boolean isKnownRole(String role){
        if(!role.equals("USER") && !role.equals("ADMIN")){
            return false;
        }
        return true;
    }

}

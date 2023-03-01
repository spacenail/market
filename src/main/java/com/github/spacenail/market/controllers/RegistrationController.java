package com.github.spacenail.market.controllers;

import com.github.spacenail.market.model.NewUser;
import com.github.spacenail.market.model.User;
import com.github.spacenail.market.repo.RoleRepo;
import com.github.spacenail.market.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {
    private RoleRepo roleRepo;
    private UserRepo userRepo;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private void setRoleRepo(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    @Autowired
    private void setUserRepo(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Autowired
    private void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    public boolean addNewUser(@RequestBody NewUser newUser){
        if(userRepo.findByName(newUser.getName()).isPresent()){
            return false;
        }
        User user = new User();
        user.setName(newUser.getName());
        user.setPassword(passwordEncoder.encode(
                newUser.getPlainTextPassword()
        ));
        user.setRoles(Arrays.asList(roleRepo.findByName("ROLE_USER")));
        userRepo.save(user);
        return true;
    }
}

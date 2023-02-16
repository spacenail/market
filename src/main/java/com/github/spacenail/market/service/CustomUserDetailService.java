package com.github.spacenail.market.service;

import com.github.spacenail.market.Model.Role;
import com.github.spacenail.market.Model.User;
import com.github.spacenail.market.repo.RoleRepo;
import com.github.spacenail.market.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetailService implements UserDetailsService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
@Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
@Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByName(username).
            orElseThrow(()-> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(), getAuthority(user.getRoles()));

    }

    private List<SimpleGrantedAuthority> getAuthority(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

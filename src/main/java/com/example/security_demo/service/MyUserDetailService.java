package com.example.security_demo.service;

import com.example.security_demo.model.User;
import com.example.security_demo.model.UserPrincipal;
import com.example.security_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            System.out.println("User not found "+username);
            throw new UsernameNotFoundException("User Not Found");
        }
        System.out.println("User found "+username);
        return new UserPrincipal(user);
    }
}

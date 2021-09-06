package com.quintet.todoapp.security;

import com.quintet.todoapp.model.User;
import com.quintet.todoapp.repository.UserMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private User user;
    @Autowired
    private UserMongoRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user = userRepo.findByEmail(email);
        return new ApplicationUserDetails(user);
    }
}

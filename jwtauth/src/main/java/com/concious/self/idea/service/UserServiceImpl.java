package com.concious.self.idea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.concious.self.idea.jpa.model.User;
import com.concious.self.idea.repository.UserStore;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserStore userStore;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUserName(String userName) {
        Optional<User> entity = userStore.findByUserName(userName);
        return entity.get();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userStore.save(user);
    }

}

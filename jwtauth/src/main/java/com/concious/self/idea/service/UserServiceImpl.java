package com.concious.self.idea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.concious.self.idea.exception.EntityNotFoundException;
import com.concious.self.idea.exception.NotFoundException;
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
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new EntityNotFoundException(userName, NotFoundException.class);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userStore.save(user);
    }

    @Override
    public User findByUserId(Long id) {
        Optional<User> entity = userStore.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new EntityNotFoundException(String.valueOf(id), NotFoundException.class);
    }

}

package com.concious.self.idea.service;

import com.concious.self.idea.jpa.model.User;

public interface UserService {
    User findByUserName(String userName);

    User saveUser(User user);
}

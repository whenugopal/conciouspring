package com.concious.self.idea.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.concious.self.idea.jpa.model.User;

public interface UserStore extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}

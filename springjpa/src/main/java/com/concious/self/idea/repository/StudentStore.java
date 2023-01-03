package com.concious.self.idea.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.concious.self.idea.jpa.model.Student;

public interface StudentStore extends CrudRepository<Student, Long> {

    Optional<Student> findByStudentName(String studentName);

    Optional<Student> findById(Long id);
}

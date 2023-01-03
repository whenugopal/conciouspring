package com.concious.self.idea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concious.self.idea.jpa.model.Grade;
import com.concious.self.idea.jpa.model.Student;
import com.concious.self.idea.repository.GradeStore;
import com.concious.self.idea.repository.StudentStore;

@RestController
public class StudentController {

    private GradeStore gradeStore;

    private StudentStore studentStore;

    @Autowired
    public void RestController(GradeStore gradeStore, StudentStore studentStore) {
        this.gradeStore = gradeStore;
        this.studentStore = studentStore;
    }

    @PostMapping(value = "/addStudent")
    public Student postMethodName(@RequestBody Student entity) {
        return studentStore.save(entity);
    }

    @PostMapping(value = "/student/{id}/addGrade")
    public Grade postMethodName(@PathVariable Long id, @RequestBody Grade entity) {
        entity.setStudent(studentStore.findById(id).get());
        return gradeStore.save(entity);
    }

}

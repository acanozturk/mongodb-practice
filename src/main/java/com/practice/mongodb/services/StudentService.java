package com.practice.mongodb.services;

import com.practice.mongodb.entities.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);
    Student getStudent(String id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(String id);
}

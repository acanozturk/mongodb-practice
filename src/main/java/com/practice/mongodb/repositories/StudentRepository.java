package com.practice.mongodb.repositories;

import com.practice.mongodb.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findStudentById(String id);
    Student findStudentByEmail(String email);

}

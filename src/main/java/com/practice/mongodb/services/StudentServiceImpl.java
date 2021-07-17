package com.practice.mongodb.services;

import com.practice.mongodb.entities.Student;
import com.practice.mongodb.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void createStudent(final Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(final String id) {

        return studentRepository.findStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(final Student student) {
        final String email = student.getEmail();

        if(email == null) {
            createStudent(student);
        }

        final Student studentByEmail = studentRepository.findStudentByEmail(email);
        final String id = studentByEmail.getId();

        student.setId(id);

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(final String id) {
        final Student student = studentRepository.findStudentById(id);

        studentRepository.delete(student);
    }
}

package com.practice.mongodb.services;

import com.practice.mongodb.entities.Student;
import com.practice.mongodb.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void createStudent(final Student student) {
        if(doesStudentExists(student)) {
            throw new IllegalArgumentException("Student already exists");
        }

        studentRepository.save(student);
    }

    @Override
    public Student getStudentWithId(final String id) {

        return studentRepository.findStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(final Student student) {
        if(!doesStudentExists(student)) {
            throw new NullPointerException("Student does not exits");
        }

        student.setId(getStudentId(student));

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(final String id) {
        final Student student = studentRepository.findStudentById(id);

        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAllStudentsPaginated(final int pageNo, final int pageSize) {
        final Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllStudentsSorted(final String sortBy, final String direction) {
        final Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);

        return studentRepository.findAll(sort);
    }

    private boolean doesStudentExists(final Student student) {
        final String email = student.getEmail();

        return studentRepository.findStudentByEmail(email) != null;
    }

    private String getStudentId(final Student student) {
        final String email = student.getEmail();
        final Student studentByEmail = studentRepository.findStudentByEmail(email);

        return studentByEmail.getId();
    }

}

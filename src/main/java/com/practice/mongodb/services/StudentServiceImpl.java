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
    public void updateStudent(final Student student) throws NullPointerException {
        final String email = student.getEmail();
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
}

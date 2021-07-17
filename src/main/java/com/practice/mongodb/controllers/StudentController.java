package com.practice.mongodb.controllers;

import com.practice.mongodb.api.responses.*;
import com.practice.mongodb.entities.Student;
import com.practice.mongodb.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("api/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCreateResponse createStudentRequest(@RequestBody final Student student) {
        studentService.createStudent(student);

        final StudentCreateResponse response = new StudentCreateResponse();

        response.setMessage("Student created.");

        return response;
    }

    @GetMapping("api/students/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetResponse getStudentRequest(@PathVariable final String id) {
        final Student student = studentService.getStudent(id);

        final StudentGetResponse response = new StudentGetResponse();

        response.setStudent(student);

        return response;
    }

    @GetMapping("api/students/get/all")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetAllResponse getAllStudentsRequest() {
        final List<Student> students = studentService.getAllStudents();

        final StudentGetAllResponse response = new StudentGetAllResponse();

        response.setStudents(students);

        return response;
    }

    @PutMapping("api/students/update")
    @ResponseStatus(HttpStatus.OK)
    public StudentUpdateResponse updateStudentRequest(@RequestBody final Student student) {
        studentService.updateStudent(student);

        final StudentUpdateResponse response = new StudentUpdateResponse();

        response.setMessage("Student updated.");

        return response;
    }

    @DeleteMapping("api/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDeleteResponse deleteStudentRequest(@PathVariable final String id) {
        studentService.deleteStudent(id);

        final StudentDeleteResponse response = new StudentDeleteResponse();

        response.setMessage("Student deleted.");

        return response;
    }
}

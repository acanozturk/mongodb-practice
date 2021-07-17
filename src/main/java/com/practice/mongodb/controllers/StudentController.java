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
    public StudentGetWithIdResponse getStudentWithIdRequest(@PathVariable final String id) {
        final Student student = studentService.getStudentWithId(id);

        final StudentGetWithIdResponse response = new StudentGetWithIdResponse();

        response.setStudent(student);

        return response;
    }

    @GetMapping("api/students/get/all")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetAllResponse getAllStudentsRequest() {
        final List<Student> students = studentService.getAllStudents();

        final StudentGetAllResponse response = new StudentGetAllResponse();

        response.setCount(students.size());
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

    @GetMapping("api/students/get/all-paginated")
    @ResponseStatus(HttpStatus.OK)
    public StudentsGetAllPaginatedResponse getAllStudentsPaginatedRequest(@RequestParam final int pageNo,
            @RequestParam final int pageSize) {

        final List<Student> studentsPaginated = studentService.getAllStudentsPaginated(pageNo, pageSize);

        final StudentsGetAllPaginatedResponse response = new StudentsGetAllPaginatedResponse();

        response.setCount(studentsPaginated.size());
        response.setStudents(studentsPaginated);

        return response;
    }

    @GetMapping("api/students/get/all-sorted")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetAllSortedResponse getAllStudentsSortedRequest(@RequestParam final String sortBy,
            @RequestParam final String direction) {

        final List<Student> studentsSorted = studentService.getAllStudentsSorted(sortBy, direction);

        final StudentGetAllSortedResponse response = new StudentGetAllSortedResponse();

        response.setCount(studentsSorted.size());
        response.setStudents(studentsSorted);

        return response;
    }

}

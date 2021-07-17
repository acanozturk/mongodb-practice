package com.practice.mongodb.api.responses;

import com.practice.mongodb.entities.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentGetAllResponse {

    private List<Student> students;

}

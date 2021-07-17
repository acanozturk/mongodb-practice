package com.practice.mongodb.api.responses;

import com.practice.mongodb.entities.Student;
import lombok.Data;

@Data
public class StudentGetWithIdResponse {

    private Student student;

}

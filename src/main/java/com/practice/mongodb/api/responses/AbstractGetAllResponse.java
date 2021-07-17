package com.practice.mongodb.api.responses;

import com.practice.mongodb.entities.Student;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractGetAllResponse {

    private int count;
    private List<Student> students;

}

package com.practice.mongodb.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Subject {

    @Field(name = "code")
    private String code;

    @Field(name = "grade")
    private String grade;
}

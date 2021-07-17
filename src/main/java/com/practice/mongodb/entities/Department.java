package com.practice.mongodb.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Department {

    @Field(name = "departmentName")
    private String departmentName;

    @Field(name = "location")
    private String location;
}

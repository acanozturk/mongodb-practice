package com.practice.mongodb.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    @Field(name = "name")
    @NotBlank
    private String name;

    @Field(name = "email")
    @Email
    private String email;

    @Field(name = "department")
    private Department department;

    @Field(name = "subjects")
    private Set<Subject> subjects;

}

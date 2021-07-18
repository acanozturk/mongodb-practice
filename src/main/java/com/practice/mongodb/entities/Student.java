package com.practice.mongodb.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "students")
public class Student extends AbstractBaseEntity {

    @Field(name = "name")
    @NotNull(message = "Field cannot be null.")
    private String name;

    @Field(name = "email")
    @Email(message = "Please enter a valid email.")
    private String email;

    @Field(name = "department")
    private Department department;

    @Field(name = "subjects")
    private Set<Subject> subjects;

}

package com.practice.mongodb.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class AbstractBaseEntity {

    @Id
    private String id;

}

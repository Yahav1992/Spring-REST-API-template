package com.example.demo.model;

import lombok.*;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    private String name;
    private String password;
    private String email;
    // constructors, getters and setters generated by lombok.
}
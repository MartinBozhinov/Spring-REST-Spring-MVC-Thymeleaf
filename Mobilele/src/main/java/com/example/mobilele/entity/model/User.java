package com.example.mobilele.entity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private


}

package com.example.mobilele.entity.model;


import com.example.mobilele.entity.model.enums.UserRoles;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {

    private Long id;
    private UserRoles userRoles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Enumerated(EnumType.STRING)
    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", userRoles=" + userRoles +
                '}';
    }
}

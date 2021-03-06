package com.example.pathfinder_app.entity;

import com.example.pathfinder_app.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private RoleName role;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}

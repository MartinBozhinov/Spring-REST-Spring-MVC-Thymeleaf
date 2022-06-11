package com.example.mobilele.entity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private List<UserRoleEntity> userRole = new ArrayList<>();
    private String imageUrl;

    public UserEntity() {
    }
   @Column(name = "email",nullable = false)
    public String getEmail() {
        return email;
    }


    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }


    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }


    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }


    @Column(name = "is_active",nullable = false)
    public Boolean getActive() {
        return isActive;
    }



    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }


   @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UserEntity setUserRole(List<UserRoleEntity> userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserEntity addRole(UserRoleEntity userRole){
        this.userRole.add(userRole);
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", userRole=" + userRole +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

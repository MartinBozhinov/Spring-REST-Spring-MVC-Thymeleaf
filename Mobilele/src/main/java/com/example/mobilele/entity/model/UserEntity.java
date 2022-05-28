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

    public void setEmail(String username) {
        this.email = username;
    }
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "is_active",nullable = false)
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Column(name = "image_url",nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
   @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        this.userRole = userRole;
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

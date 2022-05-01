package com.example.battleships.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{

    private String name;
    private Integer health;
    private Integer power;
    private LocalDateTime created;
    private Category category;
    private User user;

    public Ship() {
    }
    @Column(name = "name",unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     @Column(name = "health")
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
    @Column(name = "power")
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

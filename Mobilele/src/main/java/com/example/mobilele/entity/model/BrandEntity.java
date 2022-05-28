package com.example.mobilele.entity.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{


    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;
    private List<ModelEntity> models = new ArrayList<>();

    public BrandEntity() {
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}

package com.example.mobilele.entity.model;

import com.example.mobilele.entity.model.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    private String name;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    private BrandEntity brand;

    public ModelEntity() {
    }
    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column(name = "start_year")
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }
    @Column(name = "end_year")
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
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
    @ManyToOne
    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}

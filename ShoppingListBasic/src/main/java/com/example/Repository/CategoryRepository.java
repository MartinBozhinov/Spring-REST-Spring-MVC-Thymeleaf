package com.example.Repository;

import com.example.model.entity.Category;
import com.example.model.entity.CategoryName;
import com.example.model.entity.Product;
import com.example.model.entity.User;
import com.example.model.service.CategoryServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<CategoryServiceModel> findByName(CategoryName categoryName);
}

package com.example.Repository;

import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}

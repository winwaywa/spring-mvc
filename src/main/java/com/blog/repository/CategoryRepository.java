package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}

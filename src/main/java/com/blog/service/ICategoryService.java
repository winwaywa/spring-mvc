package com.blog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.blog.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll(Pageable pageable);

	int getTotalItem();

}

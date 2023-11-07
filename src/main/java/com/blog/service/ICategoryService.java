package com.blog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.blog.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll(Pageable pageable);

	int getTotalItem();

	CategoryDTO findById(long id);

	CategoryDTO save(CategoryDTO dto);

	void delete(long[] ids);
}

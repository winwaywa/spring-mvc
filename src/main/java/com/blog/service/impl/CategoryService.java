package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.dto.CategoryDTO;
import com.blog.entity.CategoryEntity;
import com.blog.repository.CategoryRepository;
import com.blog.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item : entities) {
			CategoryDTO CategoryDTO = new CategoryDTO();
			CategoryDTO.setCode(item.getCode());
			CategoryDTO.setName(item.getName());
			models.add(CategoryDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}
}

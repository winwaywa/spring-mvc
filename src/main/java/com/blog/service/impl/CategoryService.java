package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.converter.CategoryConverter;
import com.blog.dto.CategoryDTO;
import com.blog.entity.CategoryEntity;
import com.blog.repository.CategoryRepository;
import com.blog.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item : entities) {
			models.add(categoryConverter.toDto(item));
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity entity = categoryRepository.findOne(id);
		return categoryConverter.toDto(entity);
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(dto.getId());
			entity = categoryConverter.toEntity(oldCategory, dto);
		} else {
			entity = categoryConverter.toEntity(dto);
		}
		return categoryConverter.toDto(categoryRepository.save(entity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryRepository.delete(id);
		}
	}
}

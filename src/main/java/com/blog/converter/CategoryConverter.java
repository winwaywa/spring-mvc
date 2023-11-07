package com.blog.converter;

import org.springframework.stereotype.Component;

import com.blog.dto.CategoryDTO;
import com.blog.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());

		result.setCreatedAt(entity.getCreatedDate());
		result.setCreatedBy(entity.getCreatedBy());
		result.setUpdatedAt(entity.getModifiedDate());
		result.setUpdatedBy(entity.getModifiedBy());
		return result;
	}

	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		return result;
	}

	public CategoryEntity toEntity(CategoryEntity oldCategory, CategoryDTO dto) {
		oldCategory.setCode(dto.getCode());
		oldCategory.setName(dto.getName());
		return oldCategory;
	}

}
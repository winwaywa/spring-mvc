package com.blog.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDTO;
import com.blog.service.impl.CategoryService;

@RestController(value = "categoryAPIOfAdmin")
public class CategoryAPI {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/api/admin/category")
	public CategoryDTO create(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}

	@PutMapping("/api/admin/category")
	public CategoryDTO update(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}

	@DeleteMapping("/api/admin/category")
	public int delete(@RequestBody long[] ids) {
		categoryService.delete(ids);
		return 0;
	}
}

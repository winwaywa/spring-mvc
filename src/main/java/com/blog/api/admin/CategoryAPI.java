package com.blog.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDTO;

@RestController(value = "categoryAPIOfAdmin")
public class CategoryAPI {

	@PostMapping("/api/category")
	public CategoryDTO create(@RequestBody CategoryDTO categoryDTO) {
		return categoryDTO;
	}

	@PutMapping("/api/category")
	public CategoryDTO update(@RequestBody CategoryDTO categoryDTO) {
		return categoryDTO;
	}

	@DeleteMapping("/api/category")
	public void delete(@RequestBody long[] ids) {
		System.out.println("OK");
	}
}

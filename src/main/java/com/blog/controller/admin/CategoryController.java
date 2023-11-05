package com.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.CategoryDTO;
import com.blog.service.impl.CategoryService;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/admin/category/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {

		CategoryDTO model = new CategoryDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/category/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(categoryService.findAll(pageable));
		model.setTotalItem(categoryService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/category/edit", method = RequestMethod.GET)
	public ModelAndView editCategory() {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		return mav;
	}
}

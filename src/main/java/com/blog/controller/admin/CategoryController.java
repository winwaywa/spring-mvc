package com.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.CategoryModel;
import com.blog.paging.PageRequest;
import com.blog.paging.Pageble;
import com.blog.service.impl.CategoryService;
import com.blog.sorter.Sorter;

@Controller(value="categoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/admin/category/list", method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute("model") CategoryModel model) {
		
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortValue()));
		model.setDataList(categoryService.findAll(pageble));
		model.setTotalItems(categoryService.getTotalItems());
		model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));
		
		ModelAndView mav = new ModelAndView("admin/category/list");
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/admin/category/edit", method = RequestMethod.GET)
	public ModelAndView editCategory() {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		return mav;
	}
}

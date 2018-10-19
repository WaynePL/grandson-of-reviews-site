package org.wecancodeit.sonofreviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;

@Controller
@RequestMapping("/category")
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("categories")
	public String listCourses(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("categories/{id}")
	public String listPerson(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		return "category";
	}

	@GetMapping("/reviews")
	public String getContacts(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@GetMapping("/reviews/{id}")
	public String getContact(@PathVariable(value = "id") Long id, Model model) {
		System.out.println(id);
		model.addAttribute("review", reviewRepo.findById(id).get());
		return "review";
	}
}

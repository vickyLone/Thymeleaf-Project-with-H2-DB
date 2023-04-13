package com.vicky.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicky.entity.Products;
import com.vicky.repo.ProductRepositary;

@Controller
public class ProductController {

	@Autowired
	private ProductRepositary repo;

	@GetMapping("/")
	public String loadIndexPage(Model model) {

		model.addAttribute("products", new Products());

		return "index";
	}

	@PostMapping("/save")
	public String handleSubmitBtn(@Valid @ModelAttribute("products") Products products,BindingResult result, Model model) {
         if(result.hasErrors()) {
        	 return "index";
         }
		
		products = repo.save(products);

		if (products.getId() != null) {
			model.addAttribute("msg", "Product Data Saved...!");
		}

		return "index";

	}

	@GetMapping("/records")
	public String viewProducts(Model model) {

		model.addAttribute("records", repo.findAll());

		return "fetch";

	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") Integer id, Model model) {
		repo.deleteById(id);
		model.addAttribute("records", repo.findAll());
		model.addAttribute("msg", "Product Data Deleted....!");


		return "fetch";
	}
	
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam("id")Integer id, Model model) {
		
		Optional<Products> findById = repo.findById(id);
		
		if(findById.isPresent()) {
			
			model.addAttribute("products", findById);
			
		}

		return "index";
		
		
	}

}

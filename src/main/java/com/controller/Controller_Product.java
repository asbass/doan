package com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.service.SessionService;
import com.service.Service_Product;

@Controller
@RequestMapping("product")
public class Controller_Product {
	@Autowired private Service_Product productService;
	   @Autowired
	    SessionService session;
	@GetMapping("list")
	public String list(Model model,@RequestParam(value="cid",defaultValue = "null")Optional<String>cid, 
			@RequestParam("page")Optional<Integer>p,
			@RequestParam(value="sortBy",defaultValue = "null")Optional<String>sort
			,@RequestParam(value="keywords",defaultValue = "null") Optional<String> kw) {
		//Pageable
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		Page<Product> list = null;
		Sort sortOption = null;
		//sort by search
        if(cid.get().equals("null") && sort.get().equals("null")&& !kw.get().equals("null")) {
            list = productService.findByKeywords("%"+kw.get()+"%",pageable);
            model.addAttribute("items", list);
            model.addAttribute("keywords", kw.get());
        }
		//sort by category
		if(!cid.get().equals("null") && sort.get().equals("null")&& kw.get().equals("null")) {
			list = productService.findByCategoryID(cid.get(),pageable);
			model.addAttribute("items", list);
			model.addAttribute("cateID", cid.get());
		}
		if(!cid.get().equals("null") && sort.get().equals("null")&& !kw.get().equals("null")) {
			list = productService.findByKeywordsandcate("%"+kw.get()+"%",pageable,cid.get());
			model.addAttribute("items", list);
			model.addAttribute("cateID", cid.get());
			model.addAttribute("keywords", kw.get());
		}
		//onload, no sort option
		if(cid.get().equals("null") && sort.get().equals("null")&& kw.get().equals("null")){
			list = productService.findAll(pageable);
			model.addAttribute("items", list);
		}
		//sort by price and date
		if(!sort.get().equals("null") && cid.get().equals("null")&& kw.get().equals("null")) {
			//Price down
			if(sort.get().equals("priceDown")) {
				sortOption = Sort.by(Direction.DESC, "price");
			}
			//price up
			if(sort.get().equals("priceUp")) {
				sortOption = Sort.by(Direction.ASC, "price");
			}
			//Date down
			if(sort.get().equals("dateDown")) {
				sortOption = Sort.by(Direction.DESC, "createDate");
			}
			//Date up
			if(sort.get().equals("dateUp")) {
				sortOption = Sort.by(Direction.ASC, "createDate");
				
			}
			pageable = PageRequest.of(p.orElse(0), 10, sortOption);
			list = productService.findAll(pageable);
			model.addAttribute("items", list);
		}
		
		if(!sort.get().equals("null") && !cid.get().equals("null")&& !kw.get().equals("null")) {
			//Price down
			if(sort.get().equals("priceDown")) {
				sortOption = Sort.by(Direction.DESC, "price");
			}
			//price up
			if(sort.get().equals("priceUp")) {
				sortOption = Sort.by(Direction.ASC, "price");
			}
			//Date down
			if(sort.get().equals("dateDown")) {
				sortOption = Sort.by(Direction.DESC, "createDate");
			}
			//Date up
			if(sort.get().equals("dateUp")) {
				sortOption = Sort.by(Direction.ASC, "createDate");
				
			}

			
			pageable = PageRequest.of(p.orElse(0), 10, sortOption);
			list = productService.findByCategoryID(cid.get(),pageable);
			list = productService.findByKeywords("%"+kw.get()+"%",pageable);
			model.addAttribute("items", list);
			model.addAttribute("keywords", kw.get());
			model.addAttribute("cateID", cid.get());
		}

		if(!sort.get().equals("null") && !cid.get().equals("null")&& kw.get().equals("null")) {
			//Price down
			if(sort.get().equals("priceDown")) {
				sortOption = Sort.by(Direction.DESC, "price");
			}
			//price up
			if(sort.get().equals("priceUp")) {
				sortOption = Sort.by(Direction.ASC, "price");
			}
			//Date down
			if(sort.get().equals("dateDown")) {
				sortOption = Sort.by(Direction.DESC, "createDate");
			}
			//Date up
			if(sort.get().equals("dateUp")) {
				sortOption = Sort.by(Direction.ASC, "createDate");
				
			}

			
			pageable = PageRequest.of(p.orElse(0), 10, sortOption);
			list = productService.findByCategoryID(cid.get(),pageable);
			model.addAttribute("items", list);
			model.addAttribute("cateID", cid.get());
		}

		if(!sort.get().equals("null") && cid.get().equals("null")&& !kw.get().equals("null")) {
			//Price down
			if(sort.get().equals("priceDown")) {
				sortOption = Sort.by(Direction.DESC, "price");
			}
			//price up
			if(sort.get().equals("priceUp")) {
				sortOption = Sort.by(Direction.ASC, "price");
			}
			//Date down
			if(sort.get().equals("dateDown")) {
				sortOption = Sort.by(Direction.DESC, "createDate");
			}
			//Date up
			if(sort.get().equals("dateUp")) {
				sortOption = Sort.by(Direction.ASC, "createDate");
				
			}
			pageable = PageRequest.of(p.orElse(0), 10, sortOption);
			list = productService.findByKeywords("%"+kw.get()+"%",pageable);
			model.addAttribute("items", list);
			model.addAttribute("keywords", kw.get());
		}
		int totalPages = list.getTotalPages();
		List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
				.boxed()
				.collect(Collectors.toList());
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("sort", sort.get());
		return "product/products";
	}

	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer productID) {
		Product item = productService.findById(productID);
		model.addAttribute("item", item);
		return "product/details";
	}
	
	@GetMapping("search")
	public String search(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p, @RequestParam(value="sortBy",defaultValue = "null")Optional<String>sort) {
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
	    String keywords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", keywords);
        Page<Product> page = productService.findByKeywords("%"+keywords+"%", pageable);
				int totalPages = page.getTotalPages();
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
				.boxed()
				.collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("items", page);
		model.addAttribute("keywords", keywords);
	    return "product/products";
	}
}

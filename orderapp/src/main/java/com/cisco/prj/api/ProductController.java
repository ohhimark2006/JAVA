package com.cisco.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private OrderService service;
	
	// http://localhost:8080/api/products?page=3&size=20
	// http://localhost:8080/api/products
	@GetMapping()
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "page", defaultValue = "-1") int page,
				@RequestParam(name="size", defaultValue = "0") int size) {
		if(page == -1 || size == 0) {
			return service.getProducts();
		} else {
			return service.paginatedProducts(page, size).getContent();
		}
	}
	
	//http://localhost:8080/api/products/3
	@GetMapping("/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") int id) {
		try {
			return service.getById(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("Product with id : " + id + " doesn't exist");
		}
	}
	
	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		p = service.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
		return service.modifyProduct(p.getPrice(), id);
	}
	
	
}

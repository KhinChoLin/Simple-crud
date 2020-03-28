package com.simple.crud.simplecrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.crud.simplecrud.model.Product;
import com.simple.crud.simplecrud.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productService.findAll());
		
	}

	@PostMapping("/product")
	public ResponseEntity create(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> stock = productService.findById(id);
		if (!stock.isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(stock.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product product) {
		if (!productService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(productService.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		productService.deleteById(id);

		return ResponseEntity.ok().build();
	}

}

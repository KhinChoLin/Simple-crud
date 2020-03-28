package com.simple.crud.simplecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple.crud.simplecrud.model.Product;
import com.simple.crud.simplecrud.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public Product save(Product stock) {
		return productRepository.save(stock);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}

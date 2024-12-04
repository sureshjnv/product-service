package com.automation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automation.app.entity.Product;
import com.automation.app.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts(){
		
		return productService.getAllProducts();
		
	}
	
	@GetMapping("products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id){
		
		return productService.getProduct(id);
		
	}
	
	@PostMapping("products")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@PutMapping("products")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		
		return productService.updateProduct(product);
		
	}
	
    @PutMapping("products/{id}/reduce-stock")
    ResponseEntity<Product> reduceStock(@PathVariable Integer id, @RequestParam int quantity) {
    	return productService.reduceStock(id,quantity);
    }
    
	@DeleteMapping("products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		
		return productService.deleteProduct(id);
		
	}
	
	
	
	
	
	
	
	

}

package com.automation.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.automation.app.dao.ProductDao;
import com.automation.app.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> products = productDao.findAll();
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	public ResponseEntity<Product> getProduct(Integer id) {
		
		Product product = productDao.findById(id).get();
		
		return new ResponseEntity<>(product,HttpStatus.OK);
	}

	public ResponseEntity<String> addProduct(Product product) {
		productDao.save(product);
		return new ResponseEntity<>("Product Added",HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateProduct(Product product) {
		productDao.save(product);
		return new ResponseEntity<>("Product Updated",HttpStatus.OK);
	}

	public ResponseEntity<String> deleteProduct(Integer id) {
		productDao.deleteById(id);
		return new ResponseEntity<>("Product Deleted",HttpStatus.OK);
	}
	

}

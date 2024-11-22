package com.automation.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automation.app.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}

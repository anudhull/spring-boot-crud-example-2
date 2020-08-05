package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);
	Product findByPrice(double price);
    
	String rawQuery = "select * from product_tbl where price = ?1 and quantity = ?2";

	@Query(nativeQuery = true, value=rawQuery)
	List<Product> findProductByPrice(int price,int quantity);
}

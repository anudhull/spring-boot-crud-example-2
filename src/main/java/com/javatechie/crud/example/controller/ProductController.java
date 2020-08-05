package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // By passing path param
    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    
// 	  How to pass query parameter
//    @GetMapping("/productByName")
//    public Product findProductByName(@RequestParam("name") String name) {
//        return service.getProductByName(name);
//    }
  
    // Checking if price > 1570 then only return object
    @GetMapping("/productByPrice/{price}")
    public Product findProductByPrice(@PathVariable double price) {
    	if(price > 1570)
    		return service.getProductByPrice(price);
    	else
    		return null;
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
    
    @GetMapping("/raw/product")
    public List<Product> getProductByPrice(@RequestParam int price,@RequestParam int quantity) {
    	return service.getProductByRawQuery(price,quantity);
    }

   
}
package com.shoppingservice.shopping_service.service;


import com.shoppingservice.shopping_service.model.entity.Product;

public interface ProductService {
  public Product createProduct(Product products);
  public Product updateProduct(Product products);
  public void deleteProduct(Long id);
}

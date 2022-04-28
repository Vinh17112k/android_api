package com.shoppingservice.shopping_service.service.serviceImpl;

import com.shoppingservice.shopping_service.model.entity.Category;
import com.shoppingservice.shopping_service.model.entity.Product;
import com.shoppingservice.shopping_service.repository.CategoryRepository;
import com.shoppingservice.shopping_service.repository.ProductRepository;
import com.shoppingservice.shopping_service.service.ProductService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  //	private final ProductService productService;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  CategoryRepository categoryRepository;

  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }
  public List<Product>getProductsByCategory(String product_id){
    return productRepository.getByCategoryId(product_id);
  }

  public List<Category>getAllCategory(){
    return categoryRepository.findAll();
  }

  public Product getProductsById(long productId) throws Exception {
    return productRepository.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
  }
  //
  @Override
  public Product createProduct(Product product) {
    productRepository.save(product);
    return product;
  }

  @Override
  public Product updateProduct(Product product) {
    Product updatedProduct = productRepository.findById(product.getId()).get();
    updatedProduct.setName(product.getName());
    updatedProduct.setPrice(product.getPrice());
    updatedProduct.setCategory_id(product.getCategory_id());
    updatedProduct.setDescription(product.getDescription());
    updatedProduct.setAdded_on(LocalDateTime.now().toString());
    productRepository.save(updatedProduct);
    return updatedProduct;
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}

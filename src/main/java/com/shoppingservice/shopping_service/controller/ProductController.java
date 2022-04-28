package com.shoppingservice.shopping_service.controller;

import com.shoppingservice.shopping_service.model.entity.Category;
import com.shoppingservice.shopping_service.model.entity.Product;
import com.shoppingservice.shopping_service.service.serviceImpl.ProductServiceImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@RequestMapping("getAll")
	public List<Product> getAllPRoducts(){
		return productServiceImpl.getAllProducts();
	}
	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory(){
		return productServiceImpl.getAllCategory();
	}
	@RequestMapping("getProductsByCategory")
	public List<Product> getProductsByCategory(@RequestBody HashMap<String,String> request){
		String category_id = request.get("cat_id");		
		return productServiceImpl.getProductsByCategory(category_id);
	}
	
	
	
	@GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	    InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}
	@PostMapping("create")
	public Product createProduct(@RequestBody Product product){
		return productServiceImpl.createProduct(product);
	}
	@PutMapping("updateProduct")
	public Product updateProduct(@RequestBody Product products){
		return productServiceImpl.updateProduct(products);
	}
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable long id) throws Exception{
		return productServiceImpl.getProductsById(id);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		productServiceImpl.deleteProduct(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

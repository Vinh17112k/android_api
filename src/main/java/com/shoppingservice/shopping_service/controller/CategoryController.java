package com.shoppingservice.shopping_service.controller;
import com.shoppingservice.shopping_service.model.entity.Category;
import com.shoppingservice.shopping_service.service.serviceImpl.CategoryServiceImpl;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {
  private final CategoryServiceImpl categoryServiceImpl;
  @PostMapping("create")
  public Category createProduct(@RequestBody Category category){
    return categoryServiceImpl.createCategory(category);
  }
  @PutMapping("updateProduct")
  public Category updateProduct(@RequestBody Category category){
    return categoryServiceImpl.updatedCategory(category);
  }
  @DeleteMapping("delete/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
    categoryServiceImpl.deleteCategory(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}

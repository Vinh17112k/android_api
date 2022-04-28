package com.shoppingservice.shopping_service.controller.admin;

import com.shoppingservice.shopping_service.model.entity.Category;
import com.shoppingservice.shopping_service.service.serviceImpl.CategoryServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryAdminController {
  private final CategoryServiceImpl categoryServiceImpl;
  @PostMapping("create")
  public Category createProduct(@RequestBody Category category){
    return categoryServiceImpl.createCategory(category);
  }
  @PutMapping("update")
  public Category updateProduct(@RequestBody Category category){
    return categoryServiceImpl.updatedCategory(category);
  }
  @GetMapping("getAll")
  public List<Category> getAllCategory(){
    return categoryServiceImpl.getAll();
  }
  @GetMapping("/{id}")
  public Category getCategory(@PathVariable Long id){
    return categoryServiceImpl.getById(id);
  }
  @DeleteMapping("delete/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
    categoryServiceImpl.deleteCategory(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}

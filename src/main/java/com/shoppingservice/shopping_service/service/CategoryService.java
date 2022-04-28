package com.shoppingservice.shopping_service.service;

import com.shoppingservice.shopping_service.model.entity.Category;
import java.util.List;

public interface CategoryService {
  Category createCategory(Category category);
  Category updatedCategory(Category category);
  void deleteCategory(Long id);
  List<Category> getAll();
  Category getById(Long id);
}
package com.shoppingservice.shopping_service.service.serviceImpl;

import com.shoppingservice.shopping_service.model.entity.Category;
import com.shoppingservice.shopping_service.repository.CategoryRepository;
import com.shoppingservice.shopping_service.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  @Override
  public Category createCategory(Category category) {
    categoryRepository.save(category);
    return category;
  }

  @Override
  public Category updatedCategory(Category category) {
    Category updateCategory = categoryRepository.findById(category.getId()).get();
    updateCategory.setName(category.getName());
    categoryRepository.save(updateCategory);
    return updateCategory;
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(Long id) {
    return categoryRepository.findById(id).get();
  }
}
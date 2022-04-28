package com.shoppingservice.shopping_service.repository;

import com.shoppingservice.shopping_service.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}

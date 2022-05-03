package com.shoppingservice.shopping_service.repository;

import com.shoppingservice.shopping_service.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}

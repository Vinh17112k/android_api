package com.shoppingservice.shopping_service.repository;

import com.shoppingservice.shopping_service.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByMobile(String mobile);
}
package com.shoppingservice.shopping_service.repository;

import com.shoppingservice.shopping_service.model.entity.CheckoutCart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutCartRepository  extends JpaRepository<CheckoutCart, Long> {
  @Query("Select checkCart  FROM CheckoutCart checkCart WHERE checkCart.user_id=:user_id")
  List<CheckoutCart> getByuserId(@Param("user_id")Long user_id);
}

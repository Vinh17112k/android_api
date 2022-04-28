package com.shoppingservice.shopping_service.service;

import com.shoppingservice.shopping_service.model.entity.Cart;
import com.shoppingservice.shopping_service.model.entity.CheckoutCart;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
  List<Cart> addCartbyUserIdAndProductId(long productId,long userId,int qty,double price) throws Exception;
  void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
  List<Cart> getCartByUserId(long userId);
  List<Cart> removeCartByUserId(long cartId,long userId);
  List<Cart> removeAllCartByUserId(Long userId);
  Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
  List<CheckoutCart> getAllCheckoutByUserId(Long userId);
  List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;


  //CheckOutCart
}
package com.shoppingservice.shopping_service.service.serviceImpl;

import com.shoppingservice.shopping_service.model.entity.Cart;
import com.shoppingservice.shopping_service.model.entity.CheckoutCart;
import com.shoppingservice.shopping_service.model.entity.Product;
import com.shoppingservice.shopping_service.repository.CartRepository;
import com.shoppingservice.shopping_service.repository.CheckoutCartRepository;
import com.shoppingservice.shopping_service.service.CartService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  CartRepository cartRepository;
  @Autowired
  CheckoutCartRepository checkoutCartRepository;
  @Autowired
  ProductServiceImpl productServiceImpl;
  private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

  @Override
  public List<Cart> addCartbyUserIdAndProductId(long productId, long userId,int qty,double price) throws Exception {
    try {
      if(cartRepository.getCartByProductIdAnduserId(userId, productId).isPresent()){
        throw new Exception("Product is already exist.");
      }
      Cart obj = new Cart();
      obj.setQty(qty);
      obj.setUser_id(userId);
      Product pro = productServiceImpl.getProductsById(productId);
      obj.setProduct(pro);
      //TODO price has to check with qty
      obj.setPrice(price);
      cartRepository.save(obj);
      return this.getCartByUserId(userId);
    }catch(Exception e) {
      e.printStackTrace();
      logger.error(""+e.getMessage());
      throw new Exception(e.getMessage());
    }

  }

  @Override
  public List<Cart> getCartByUserId(long userId) {
    return cartRepository.getCartByuserId(userId);
  }

  @Override
  public List<Cart> removeCartByUserId(long cartId, long userId) {
    cartRepository.deleteCartByIdAndUserId(userId, cartId);
    return this.getCartByUserId(userId);
  }

  @Override
  public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
    cartRepository.updateQtyByCartId(cartId,price,qty);
  }

  @Override
  public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
    double total_amount =cartRepository.getTotalAmountByUserId(userId);
    if(total_amount == totalAmount) {
      return true;
    }
    System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
    return false;
  }

  @Override
  public List<CheckoutCart> getAllCheckoutByUserId(Long userId) {
    return checkoutCartRepository.getByuserId(userId);
  }

  @Override
  public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
    try {
      long user_id = tmp.get(0).getUser_id();
      if(tmp.size() >0) {
        checkoutCartRepository.saveAll(tmp);
        this.removeAllCartByUserId(user_id);
        return this.getAllCheckoutByUserId(user_id);
      }
      else {
        throw  new Exception("Should not be empty");
      }
    }catch(Exception e) {
      throw new Exception("Error while checkout "+e.getMessage());
    }

  }

  @Override
  public List<Cart> removeAllCartByUserId(Long userId) {
    cartRepository.deleteAllCartByUserId(userId);
    return null;
  }

}

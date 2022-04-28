package com.shoppingservice.shopping_service.service;

import com.shoppingservice.shopping_service.model.entity.User;
import java.util.HashMap;

public interface UserService {
  User findByMobile(String mobile) throws Exception;
  User getUserDetailById(long userId) throws Exception;
  User signUpUser(HashMap<String,String> signupRequest) throws Exception;

}

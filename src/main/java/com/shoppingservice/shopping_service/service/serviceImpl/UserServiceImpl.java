package com.shoppingservice.shopping_service.service.serviceImpl;

import com.shoppingservice.shopping_service.model.entity.User;
import com.shoppingservice.shopping_service.repository.UserRepository;
import com.shoppingservice.shopping_service.service.UserService;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;
  @Override
  public User findByMobile(String mobile) throws Exception {
    return userRepository.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
  }

  @Override
  public User getUserDetailById(long userId) throws Exception {
    return userRepository.findById(userId).orElseThrow(()->new Exception("User Not found.."));
  }

  @Override
  public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
    try {
      if(userRepository.findByMobile(signupRequest.get("mobile")).isPresent()) {
        throw new Exception("User is already registered with Mobile No.");
      }
      User user = new User();
      user.setName(signupRequest.get("name"));
      user.setEmail(signupRequest.get("email"));
      user.setMobile(signupRequest.get("mobile"));
      user.setPassword(signupRequest.get("password"));
//      user.setRoles(Arrays.asList(roleRepository.findByName("CUSTOMER")));
      user.setType("CUSTOMER");
      user.setCreated_at(LocalDateTime.now().toString());
      userRepository.save(user);
      return user;
    }catch(Exception e) {
      throw new Exception(e.getMessage());
    }

  }
}
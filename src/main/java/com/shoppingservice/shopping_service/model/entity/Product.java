package com.shoppingservice.shopping_service.model.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
  @Id
  private Long id;
  private String name;
  private String price;
  private String added_on;
  private String category_id;
  private String description;
}
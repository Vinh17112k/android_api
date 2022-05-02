package com.shoppingservice.shopping_service.model.entity;


import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
@Builder
public class Product {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String price;
  private String added_on;
  private String category_id;
  private String description;
  private String image;
}
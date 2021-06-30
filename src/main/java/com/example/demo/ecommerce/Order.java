package com.example.demo.ecommerce;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="\"order\"")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name = "product_id",nullable = false)
  @OnDelete(action= OnDeleteAction.CASCADE)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("product_id")
  Product product;

  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name = "user_id",nullable = false)
  @OnDelete(action= OnDeleteAction.CASCADE)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("user_id")
  User user;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

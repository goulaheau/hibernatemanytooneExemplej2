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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class OrderLine {
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
  @JoinColumn(name = "order_id",nullable = false)
  @OnDelete(action= OnDeleteAction.CASCADE)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("order_id")
  Order order;

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

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}

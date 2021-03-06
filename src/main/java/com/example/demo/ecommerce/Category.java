package com.example.demo.ecommerce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import jdk.jfr.Enabled;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

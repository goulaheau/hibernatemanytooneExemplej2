package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Departement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;


  @NotBlank
  @Column
  String name;
}

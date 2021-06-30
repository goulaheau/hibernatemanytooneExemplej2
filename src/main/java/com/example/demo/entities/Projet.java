package com.example.demo.entities;

import com.example.demo.model.Post;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Projet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @NotBlank
  @Column
  String titre;

  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name = "chef_id",nullable = false)
  @OnDelete(action= OnDeleteAction.CASCADE)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("chef_id")
  Chef chef;
}

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="comments")
public class Comment extends AuditModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
@NotBlank
@Lob
private String texte;
//création de jointure
@ManyToOne(fetch =FetchType.LAZY,optional = false)
@JoinColumn(name = "post_id",nullable = false)

@OnDelete(action=OnDeleteAction.CASCADE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@JsonIdentityReference(alwaysAsId = true)
@JsonProperty("post_id")
private Post post;

}

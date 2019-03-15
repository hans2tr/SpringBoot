package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTHOR")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nameAu")
	private String nameAu;
	
	@OneToOne(mappedBy = "author")
	private Author author;

	public String getNameAu() {
		return nameAu;
	}

	public void setNameAu(String nameAu) {
		this.nameAu = nameAu;
	}

	public int getId() {
		return id;
	}
	
	
}

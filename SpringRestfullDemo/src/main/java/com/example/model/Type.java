package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TYPEBOOK")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nameTy")
	private String nameTy;
	
	@OneToOne(mappedBy = "type")
	private Book book;

	public String getNameTy() {
		return nameTy;
	}

	public void setNameTy(String nameTy) {
		this.nameTy = nameTy;
	}

	public int getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

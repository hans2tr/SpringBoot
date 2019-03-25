package com.example.springRestfull.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TYPEBOOK")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nameTy")
	private String nameTy;
	
	@OneToMany(mappedBy = "type",fetch = FetchType.EAGER)
	private List<Book> book;

	public String getNameTy() {
		return nameTy;
	}

	public void setNameTy(String nameTy) {
		this.nameTy = nameTy;
	}

	public int getId() {
		return id;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

}

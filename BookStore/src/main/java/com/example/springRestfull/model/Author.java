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
@Table(name="AUTHOR")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nameAu")
	private String nameAu;
	
	@OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
	private List<Book> book;

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

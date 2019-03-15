package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passwords")
	private String passwords;
	
	@OneToOne()
	@JoinColumn(name="idInfo")
	private InfoAcc infoAc;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Book> book;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public int getId() {
		return id;
	}

	public InfoAcc getInfoAc() {
		return infoAc;
	}

	public List<Book> getBook() {
		return book;
	}
	
	
	
}

package com.example.springRestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springRestfull.model.Type;
import com.example.springRestfull.serviceImpl.TypeServiceImpl;

@RestController
@RequestMapping("TypeBook")
public class MainPageController {
	
	@Autowired
	TypeServiceImpl typeBookServiceImpl;
	
	@GetMapping("/{id}")
	public Type getTypeBookById(@PathVariable int id){
		Type type = typeBookServiceImpl.getTypeBookById(id);
		return type;
	}

}

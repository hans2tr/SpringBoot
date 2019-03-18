package com.example.springRestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springRestfull.model.Type;
import com.example.springRestfull.serviceImpl.TypeServiceImpl;

@Controller
@RequestMapping("mainpage")
public class MainPageController {
	
	@Autowired
	TypeServiceImpl typeBookServiceImpl;
	
	@RequestMapping("/getTypeById/{id}")
	public ResponseEntity<Type> getTypeBookById(@PathVariable int id){
		Type type = typeBookServiceImpl.getTypeBookById(id);
		return new ResponseEntity<Type>(type,HttpStatus.OK);
	}

}

package com.example.springRestfull.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springRestfull.DAOImpl.TypeBookDaoImpl;
import com.example.springRestfull.model.Type;
import com.example.springRestfull.service.TypeService;

@Service
@Transactional
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	TypeBookDaoImpl typeBook;

	@Override
	public Type getTypeBookById(int id) {
		return typeBook.getTypeBookById(id);
	}
	
	
}

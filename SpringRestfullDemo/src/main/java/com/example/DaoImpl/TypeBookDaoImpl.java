package com.example.DaoImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Dao.TypeDao;
import com.example.model.Type;

public class TypeBookDaoImpl implements TypeDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public boolean createTypeBooḳ() {
		Criteria cri = session.getCurrentSession().createCriteria(Type.class);
		
		return false;
	}

	@Override
	public boolean getTypeBookById() {
		// TODO Auto-generated method stub
		return false;
	}

}

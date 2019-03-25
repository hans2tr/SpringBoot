package com.example.springRestfull.DAOImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springRestfull.DAO.TypeDao;
import com.example.springRestfull.model.Type;

@Repository
@Transactional
public class TypeBookDaoImpl implements TypeDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public boolean createTypeBooḳ() {
		Criteria cri = session.getCurrentSession().createCriteria(Type.class);
		
		return false;
	}

	@Override
	public Type getTypeBookById(int id) {
		Criteria cri = session.getCurrentSession().createCriteria(Type.class);
		cri.add(Restrictions.eq("id", id));
		
		return (Type)cri.uniqueResult();
	}

}

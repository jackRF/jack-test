package com.jack.test.repository.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoImpl {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Session getSession(){
		return sessionFactory.openSession();
	}

}

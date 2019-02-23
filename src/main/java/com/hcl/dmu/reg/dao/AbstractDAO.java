/**
 * 
 */
package com.hcl.dmu.reg.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sekhar.k
 *
 */
public abstract class AbstractDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Session session = null;
    protected Session getSession() {
    	
    	
    	return sessionFactory.getCurrentSession();
    }
}

package com.crm.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.crm.spring.entity.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO {

	//DI 
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		Session session=factory.getCurrentSession();
		
		Query<Customer> query=
				session.createQuery("from Customer",Customer.class);
		
		List<Customer> list=query.getResultList();
		
		return list;
	}

}

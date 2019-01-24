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

	// DI
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Customer> getCustomers() {
		Session session = factory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = factory.getCurrentSession();
		
		return session.get(Customer.class,id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = factory.getCurrentSession();
		
		//Customer customer=session.get(Customer.class,id);
		//session.delete(customer);
		
		Query<Customer> query=session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}

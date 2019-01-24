package com.crm.spring.dao;

import java.util.List;
import com.crm.spring.entity.Customer;


public interface ICustomerDAO {

	public List<Customer> getCustomers();
}

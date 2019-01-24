package com.crm.spring.service;

import java.util.List;

import com.crm.spring.entity.Customer;

public interface ICustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}

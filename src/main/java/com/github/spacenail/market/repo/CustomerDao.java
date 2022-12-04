package com.github.spacenail.market.repo;

import com.github.spacenail.market.Model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();
    Customer getCustomer(String name);
    Customer getCustomer(Long id);
    void deleteCustomer(Long id);
    void deleteCustomer(String name);
    void createCustomer(String name);
}

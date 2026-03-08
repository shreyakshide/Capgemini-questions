package com.entity;

import com.entity.CustomerDAOImpl;
import com.entity.Customer;
import com.entity.Order;
import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        CustomerDAOImpl dao = new CustomerDAOImpl();

        Order order = new Order(
                "ORD101",
                "Laptop",
                1,
                65000,
                LocalDate.now()
        );

        Customer customer = new Customer(
                "Rohan",
                "rohan@gmail.com",
                "Male",
                9876543210L,
                LocalDate.now(),
                order
        );

        dao.insertCustomer(customer);

        dao.updateCustomer(1,"newmail@gmail.com");

        dao.getCustomerById(1);

        dao.deleteCustomer(1);
    }
}
package com.entity;

import com.entity.Customer;
import jakarta.persistence.*;
import java.util.List;

public class CustomerDAOImpl {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");

    EntityManager em = emf.createEntityManager();

    public void insertCustomer(Customer customer) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(customer);
        tx.commit();

        System.out.println("Customer inserted successfully");
    }

    public void updateCustomer(int id, String newEmail) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = em.find(Customer.class, id);

        if(c != null) {
            c.setEmail(newEmail);
        }

        tx.commit();
    }

    public void deleteCustomer(int id) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = em.find(Customer.class, id);

        if(c != null) {
            em.remove(c);
        }

        tx.commit();
    }

    public Customer getCustomerById(int id) {

        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {

        TypedQuery<Customer> query =
                em.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }
}

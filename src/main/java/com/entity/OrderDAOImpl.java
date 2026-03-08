package com.entity;

import com.entity.Order;
import jakarta.persistence.*;

public class OrderDAOImpl {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");

    EntityManager em = emf.createEntityManager();

    public void updateOrder(int id, double newPrice) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Order order = em.find(Order.class, id);

        if(order != null) {
            order.setPrice(newPrice);
        }

        tx.commit();
    }

    public Order getOrderById(int id) {

        return em.find(Order.class, id);
    }
}

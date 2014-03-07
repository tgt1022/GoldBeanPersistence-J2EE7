/*Owner & Copyrights: Vance King Saxbe. A.*//* Copyright (c) <2014> Author Vance King Saxbe. A, and contributors Power Dominion Enterprise, Precieux Consulting and other contributors. Modelled, Architected and designed by Vance King Saxbe. A. with the geeks from GoldSax Consulting and GoldSax Technologies email @vsaxbe@yahoo.com. Development teams from Power Dominion Enterprise, Precieux Consulting. Project sponsored by GoldSax Foundation, GoldSax Group and executed by GoldSax Manager.*/package com.GoldSax.EJB3.03;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="CustomerOrderManager")
public class CustomerOrderManager
  implements CustOrderMgr
{
  @PersistenceContext(unitName = "GoldSax03-Unit")
  private EntityManager em;

  public CustomerOrderManager() {
  }

  public Object mergeEntity(Object entity) {
    return em.merge(entity);
  }

  public Object persistEntity(Object entity) {
    em.persist(entity);
    return entity;
  }

  /** <code>select o from Customer o</code> */
  public List<Customer> queryCustomerFindAll() {
    return em.createNamedQuery("Customer.findAll").getResultList();
  }

  public void removeCustomer(Customer customer) {
    customer = em.find(Customer.class, customer.getId());
    em.remove(customer);
  }

  /** <code>select o from CustomerOrder o</code> */
  public List<CustomerOrder> queryCustomerOrderFindAll() {
    return em.createNamedQuery("CustomerOrder.findAll").getResultList();
  }

  public void removeCustomerOrder(CustomerOrder customerOrder) {
    customerOrder = em.find(CustomerOrder.class, customerOrder.getId());
    em.remove(customerOrder);
  }

  /** <code>select o from Address o</code> */
  public List<Address> queryAddressFindAll() {
    return em.createNamedQuery("Address.findAll").getResultList();
  }

  public void removeAddress(Address address) {
    address = em.find(Address.class, address.getId());
    em.remove(address);
  }

  /** <code>select o from Customer o where email = :email</code> */
  public List<Customer> queryCustomerFindByEmail(Object email) {
    return em.createNamedQuery("Customer.findByEmail").setParameter("email", 
                                                                    email).getResultList();
  }
}
/*email to provide support at vancekingsaxbe@powerdominionenterprise.com, businessaffairs@powerdominionenterprise.com, For donations please write to fundraising@powerdominionenterprise.com*/
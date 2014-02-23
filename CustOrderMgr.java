/* Copyright (c) <2014> Author Vance King Saxbe. A, and contributors Power Dominion Enterprise, Precieux Consulting and other contributors. Modelled, Architected and designed by Vance King Saxbe. A. with the geeks from GoldSax Consulting and GoldSax Technologies email @vsaxbe@yahoo.com. Development teams from Power Dominion Enterprise, Precieux Consulting. Project sponsored by GoldSax Foundation, GoldSax Group and executed by GoldSax Manager.*/package com.GoldSax.EJB3.03;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CustOrderMgr
{
  Object mergeEntity(Object entity);

  Object persistEntity(Object entity);

  List<Customer> queryCustomerFindAll();

  void removeCustomer(Customer customer);

  List<CustomerOrder> queryCustomerOrderFindAll();

  void removeCustomerOrder(CustomerOrder customerOrder);

  List<Address> queryAddressFindAll();

  void removeAddress(Address address);

  List<Customer> queryCustomerFindByEmail(Object email);
}

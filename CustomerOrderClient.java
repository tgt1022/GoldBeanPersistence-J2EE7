/* Copyright (c) <2014> Author Vance King Saxbe. A, and contributors Power Dominion Enterprise, Precieux Consulting and other contributors. Modelled, Architected and designed by Vance King Saxbe. A. with the geeks from GoldSax Consulting and GoldSax Technologies email @vsaxbe@yahoo.com. Development teams from Power Dominion Enterprise, Precieux Consulting. Project sponsored by GoldSax Foundation, GoldSax Group and executed by GoldSax Manager.*/package com.GoldSax.EJB3.03.client;

import com.GoldSax.EJB3.03.Address;
import com.GoldSax.EJB3.03.CustOrderMgr;
import com.GoldSax.EJB3.03.Customer;
import javax.naming.Context;
import javax.naming.InitialContext;

public class CustomerOrderClient
{
  public static void main(String[] args) {
    try {
      final Context context = new InitialContext();
      CustOrderMgr custOrderMgr = 
        (CustOrderMgr)context.lookup("CustomerOrderManager");
      final Address address = new Address();
      address.setCity("San Mateo");
      address.setState("CA");
      address.setZipCode(94402L);
      final Customer customer = new Customer();
      customer.setEmail("wayzout@gmail.com");
      customer.setShippingAddress(address);
      custOrderMgr.persistEntity(customer);

      for (Customer cust: 
           custOrderMgr.queryCustomerFindByEmail("wayzout@gmail.com")) {
        System.out.println("Customer ID is " + cust.getId());
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

/*Owner & Copyrights: Vance King Saxbe. A.*//* Copyright (c) <2014> Author Vance King Saxbe. A, and contributors Power Dominion Enterprise, Precieux Consulting and other contributors. Modelled, Architected and designed by Vance King Saxbe. A. with the geeks from GoldSax Consulting and GoldSax Technologies email @vsaxbe@yahoo.com. Development teams from Power Dominion Enterprise, Precieux Consulting. Project sponsored by GoldSax Foundation, GoldSax Group and executed by GoldSax Manager.*/package com.GoldSax.EJB3.03;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CustOrderMgrClient
{
  public static void main(String [] args) {
    try {
      final Context context = getInitialContext();
      CustOrderMgr custOrderMgr = (CustOrderMgr)context.lookup("java:comp/env/ejb/CustomerOrderManager");
      // Call any of the Remote methods below to access the EJB
      // custOrderMgr.mergeEntity(  entity );
      // custOrderMgr.persistEntity(  entity );
      System.out.println( custOrderMgr.queryCustomerFindAll(  ) );
      // custOrderMgr.removeCustomer(  customer );
      System.out.println( custOrderMgr.queryCustomerOrderFindAll(  ) );
      // custOrderMgr.removeCustomerOrder(  customerOrder );
      System.out.println( custOrderMgr.queryAddressFindAll(  ) );
      // custOrderMgr.removeAddress(  address );
      // custOrderMgr.queryCustomerFindByEmail(  email );
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static Context getInitialContext()
    throws NamingException {
    Hashtable env = new Hashtable();
    //  Standalone OC4J connection details
    env.put( Context.INITIAL_CONTEXT_FACTORY, "oracle.j2ee.naming.ApplicationClientInitialContextFactory" );
    env.put( Context.SECURITY_PRINCIPAL, "oc4jadmin" );
    env.put( Context.SECURITY_CREDENTIALS, "welcome" );
    env.put(Context.PROVIDER_URL, "ormi://localhost:23791/PersistenceSamples");
    return new InitialContext( env );
  }
}
/*email to provide support at vancekingsaxbe@powerdominionenterprise.com, businessaffairs@powerdominionenterprise.com, For donations please write to fundraising@powerdominionenterprise.com*/
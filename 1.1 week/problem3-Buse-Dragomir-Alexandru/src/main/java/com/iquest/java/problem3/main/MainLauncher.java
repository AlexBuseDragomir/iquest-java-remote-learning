package com.iquest.java.problem3.main;

import com.iquest.java.problem3.domain.Customer;
import com.iquest.java.problem3.domain.Registrar;
import com.iquest.java.problem3.domain.Registry;
import com.iquest.java.problem3.domain.Reseller;
import com.iquest.java.problem3.domain.Domain;

import java.sql.SQLOutput;

public class MainLauncher {

    public static void main(String[] args) {

        String domainName = "iquest.group.com";
        String domainHost = "mxHost";
        String customerName = "Alexandru Dragomir";
        String resellerName = "HostLand";
        String registrarName = "Bluehost";
        String registryName = "VeriSign";

        Registry registry = new Registry(registryName);
        Registrar registrar = new Registrar(registrarName, registry);
        Reseller reseller = new Reseller(resellerName, registrar);
        Customer customer = new Customer(customerName, domainName, domainHost, reseller);

        Domain newDomainForCustomer;
        newDomainForCustomer = customer.getDomainFromReseller();
        System.out.println(newDomainForCustomer);

        Domain savedDomain;
        savedDomain = registry.getDomainFromDatabase(0);
        System.out.println("The following domain has been saved to the registry database: \n");
        System.out.println(savedDomain);
    }
}

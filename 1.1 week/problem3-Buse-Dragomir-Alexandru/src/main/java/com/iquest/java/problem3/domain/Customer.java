package com.iquest.java.problem3.domain;

public class Customer {

    private String customerName;
    private String desiredDomainName;
    private String desiredDomainHost;
    private Reseller reseller;

    public Customer(String customerName, String desiredDomainName,
                    String desiredDomainHost, Reseller reseller) {
        this.customerName = customerName;
        this.desiredDomainName = desiredDomainName;
        this.desiredDomainHost = desiredDomainHost;
        this.reseller = reseller;
    }

    public Domain getDomainFromReseller() {
        return this.reseller.getDomainFromRegistrar(this.desiredDomainName, this.customerName,
                                                    this.desiredDomainHost);
    }
}

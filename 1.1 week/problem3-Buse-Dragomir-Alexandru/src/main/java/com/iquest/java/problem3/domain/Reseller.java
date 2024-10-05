package com.iquest.java.problem3.domain;

public class Reseller {

    private String resellerName;
    private Registrar registrar;

    public Reseller(String resellerName, Registrar registrar) {
        this.resellerName = resellerName;
        this.registrar = registrar;
    }

    public Domain getDomainFromRegistrar(String domainName, String domainOwner,
                                       String domainHost) {
        return this.registrar.getDomainFromRegistry(domainName, domainOwner, domainHost);
    }

    public String toString() {
        return "Reseller name: " + this.resellerName;
    }
}

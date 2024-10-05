package com.iquest.java.problem3.domain;

public class Registrar {

    private String registrarName;
    private Registry registry;

    public Registrar(String registrarName, Registry registry) {
        this.registrarName = registrarName;
        this.registry = registry;
    }

    public Domain getDomainFromRegistry(String domainName, String domainOwner,
                                 String domainHost) {
        return this.registry.getNewDomain(domainName, domainOwner, domainHost);
    }

    public String toString() {
        return "Registrar name: " + this.registrarName;
    }
}

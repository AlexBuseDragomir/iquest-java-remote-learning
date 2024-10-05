package com.iquest.java.problem3.domain;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private String registryName;
    private Domain newDomain;
    private List<Domain> domainDatabase;

    public Registry(String registryName) {
        this.registryName = registryName;
        this.newDomain = new Domain();
        this.domainDatabase = new ArrayList<Domain>();
    }

    private boolean isDomainAvailable(Domain requestedDomain) {
        return ! this.domainDatabase.contains(requestedDomain);
    }

    public Domain getNewDomain(String domainName, String domainOwner,
                               String domainHost) {
        this.newDomain.setDomainName(domainName);
        this.newDomain.setHostName(domainHost);
        this.newDomain.setOwnerName(domainOwner);

        if (isDomainAvailable(this.newDomain)) {
            this.saveNewDomainEntry(this.newDomain);
            return this.newDomain;
        } else {
            System.err.println("ERROR: The domain is not available!");
            return null;
        }
    }

    public Domain getDomainFromDatabase(int requestedDomainPosition) {
        if (requestedDomainPosition >= this.domainDatabase.size()) {
            System.err.println("ERROR: There is no domain in the specified position");
            return null;
        }else {
            return this.domainDatabase.get(requestedDomainPosition);
        }
    }

    private void saveNewDomainEntry(Domain newDomain) {
        this.domainDatabase.add(newDomain);
    }

    public void removeDomainFromPosition(int domainToDeletePosition) {
        if (domainToDeletePosition >= this.domainDatabase.size()) {
            System.err.println("ERROR: The domain with this index does not exist!");
        }else {
            this.domainDatabase.remove(domainToDeletePosition);
        }
    }

    public String toString() {
        return "Registry name: " + this.registryName;
    }
}

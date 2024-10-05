package com.iquest.java.problem3.domain;

public class Domain {

    private String domainName;
    private String ownerName;
    private String hostName;

    public Domain() {
        this.domainName = null;
        this.ownerName = null;
        this.hostName = null;
    }

    public Domain(String domainName, String ownerName, String hostName) {
        this.domainName = domainName;
        this.ownerName = ownerName;
        this.hostName = hostName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String toString() {
        return "Domain name: " + this.domainName + "\n" +
                "Domain owner: " + this.ownerName + "\n" +
                "Domain host: " + this.hostName + "\n";
    }
}

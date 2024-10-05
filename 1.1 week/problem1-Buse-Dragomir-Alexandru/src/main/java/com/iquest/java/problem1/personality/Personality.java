package com.iquest.java.problem1.personality;

public class Personality {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;

    public Personality() {
        this.firstName = null;
        this.lastName = null;
        this.dateOfBirth = null;
        this.dateOfDeath = null;
    }

    public Personality(String firstName, String lastName,
                       String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
    }

    public Personality(String firstName, String lastName,
                       String dateOfBirth, String dateOfDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }

        Personality personality = (Personality) obj;

        if (this.hashCode() != personality.hashCode()) {
            return false;
        }else {
            if (this.dateOfDeath == null && personality.dateOfDeath != null) {
                return false;
            }

            if (this.dateOfDeath != null && personality.dateOfDeath == null) {
                return false;
            }

            return (personality.firstName.equals(this.firstName) && personality.lastName.equals(this.lastName) &&
                    personality.dateOfBirth.equals(this.dateOfBirth) &&
                    this.stringsEqualOrBothNull(this.dateOfDeath, personality.dateOfDeath));
        }
    }

    @Override
    public int hashCode() {
        if (this.dateOfDeath == null) {
            return 7919 + this.firstName.hashCode() + this.lastName.hashCode() +
                    this.dateOfBirth.hashCode();
        }else {
            return 7919 + this.firstName.hashCode() + this.lastName.hashCode() +
                    this.dateOfBirth.hashCode() + this.dateOfDeath.hashCode();
        }
    }

    public String toString() {
        if (this.dateOfDeath == null) {
            return this.firstName + " " + this.lastName + " " +
                   "( " + this.dateOfBirth + " - )";
        }else {
            return this.firstName + " " + this.lastName + " " +
                    "(" + this.dateOfBirth + "-" + this.dateOfDeath + ")";
        }
    }

    private boolean stringsEqualOrBothNull(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return true;
        }

        if(string1 == null || string2 == null) {
            return false;
        }

        return string1.equals(string2);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}

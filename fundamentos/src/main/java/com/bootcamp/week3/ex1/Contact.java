package com.bootcamp.week3.ex1;

import java.util.*;


public class Contact implements Comparable<Contact> {

    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() { 
        return name; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getPhone() { 
        return phone; 
    }

    // Orden natural por nombre (alfabético, case-insensitive)
    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // Igualdad basada en email (un email = un contacto único)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact c)) return false;
        return Objects.equals(this.email, c.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return String.format(
                "Contact{name='%s', email='%s', phone='%s'}",
                name, email, phone
        );
    }
}
package com.xideral.semana3.ejercicio1;

import java.util.*;

class ContactManager {

    private final Set<Contact> contacts = new TreeSet<>();

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public Optional<Contact> findByEmail(String email) {
        return contacts.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public List<Contact> findByNamePrefix(String prefix) {
        return contacts.stream()
                .filter(c -> c.getName()
                        .toLowerCase()
                        .startsWith(prefix.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contact> getAllSortedBy(Comparator<Contact> comp) {
        return contacts.stream()
                .sorted(comp)
                .collect(Collectors.toList());
    }

    public int size() {
        return contacts.size();
    }
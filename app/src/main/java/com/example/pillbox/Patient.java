package com.example.pillbox;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private String lastname;

    public Patient(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}

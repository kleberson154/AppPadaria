package com.kleberson.listadecursos.model;

public class Person {
    private String firstName;
    private String lastName;
    private String course;
    private String contact;

    public Person(String firstName, String lastName, String course, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public String getContact() {
        return contact;
    }
}

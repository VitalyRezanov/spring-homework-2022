package com.netcracker.model;

public class User {
    private String firstName;
    private String secondName;
    private String lastName;
    private long salary;
    private String email;
    private String jobPlace;

    public User() {
    }

    public User(String fN, String sN, String lN, long s, String e, String j ) {
        firstName = fN;
        secondName = sN;
        lastName = lN;
        salary = s;
        email = e;
        jobPlace = j;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

}

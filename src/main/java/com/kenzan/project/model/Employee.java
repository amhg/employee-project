package com.kenzan.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String middleInitial;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfEmployment;

    private String status = "ACTIVE";

    public Employee() { }

    public Employee(String firstName, String lastName, String middleInitial, Date dateOfBirth, Date dateOfEmployment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() { return middleInitial; }

    public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

/*
ID - Unique identifier for an employee
FirstName - Employees first name
MiddleInitial - Employees middle initial
LastName - Employeed last name
DateOfBirth - Employee birthday and year
DateOfEmployment - Employee start date
Status - ACTIVE or INACTIVE
*/
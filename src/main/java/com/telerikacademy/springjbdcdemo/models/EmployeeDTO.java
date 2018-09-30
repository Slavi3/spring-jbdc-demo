package com.telerikacademy.springjbdcdemo.models;

public class EmployeeDTO {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    private String lastName;

    public EmployeeDTO(String firstName, String lastName, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    private AddressDTO address;
}

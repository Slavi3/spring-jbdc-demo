package com.telerikacademy.springjbdcdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId")
    private int addressId;
    @Column(name = "AddressText")
    private String addressText;

    @OneToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public int getAddressId() {
        return addressId;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public Address() {

    }
}

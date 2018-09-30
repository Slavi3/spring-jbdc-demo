package com.telerikacademy.springjbdcdemo.models;

public class AddressDTO {
    public AddressDTO(String addressText) {
        AddressText = addressText;
    }

    public String getAddressText() {
        return AddressText;
    }

    public void setAddressText(String addressText) {
        AddressText = addressText;
    }

    private String AddressText;
}

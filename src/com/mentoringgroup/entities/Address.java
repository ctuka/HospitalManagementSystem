package com.mentoringgroup.entities;

public class Address {

    private int houseNumber;
    private String street;
    private String city;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    private String state;
    private int zipcode;

    public Address(int houseNumber, String street, String city, String state, int zipcode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    Address(){
        houseNumber =0;
        street="";
        city ="";
        state ="";
        zipcode =0;

    }
    void display(){
        System.out.println("HOUSE NUMBER : "+houseNumber);
        System.out.println("ADDRESS: ");
        System.out.println("STREET : "+this.street);
        System.out.println("CITY : "+this.city);
        System.out.println("STATE : "+this.state);
        System.out.println("ZIPCODE :"+this.zipcode);
    }

    @Override
    public String toString() {
        return "ADDRESS{" +
                "HOUSE NUMBER=" + houseNumber +
                ", STREET='" + street + '\'' +
                ", CİTY='" + city + '\'' +
                ", STATE='" + state + '\'' +
                ", ZİPCODE=" + zipcode +
                '}';
    }

}
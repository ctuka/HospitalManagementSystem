package com.mentoringgroup.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  class Patient {

    /*Patient
 • Fields:
 • String name
 • String surname
 • String idNumber
 • String address
 • String phoneNumber
 • String gender
 • private int priorityLevel
 • String diagnosis
 Patient List:
 ArrayList<Patient> patientList
 */



    private String patientName;
    private String patientSurname;
    private String patientIDNumber;
    private Address patientAddress;
    private int age;
    private String phoneNumber;
    private String gender;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientIDNumber() {
        return patientIDNumber;
    }

    public void setPatientIDNumber(String patientIDNumber) {
        this.patientIDNumber = patientIDNumber;
    }

    public Address getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(Address patientAddress) {
        this.patientAddress = patientAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    private int priorityLevel;
    String diagnosis;

    public int getAge() {
        if (age < 0) {
            System.out.println("You entered invalid age");
        } else {
            System.out.println("Your age : " + age);
        }

        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    /* Patient(String patientName, String patientSurname, String patientIDNumber, String patientAddress,
            int age, String phoneNumber, String gender, int priorityLevel, String diagnosis){
*/

    public Patient(String patientName, String patientSurname, String patientIDNumber, Address patientAddress, int age,
                   String phoneNumber, String gender, int priorityLevel, String diagnosis) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientIDNumber = patientIDNumber;
        this.patientAddress = new Address();
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.priorityLevel = priorityLevel;
        this.diagnosis = diagnosis;
    }

    Patient() {
        this.patientName = "".toUpperCase();
        this.patientSurname = "".toUpperCase();
        this.patientIDNumber = "";
        this.patientAddress = new Address();
        this.age = getAge();
        this.phoneNumber = getPhoneNumber();
        this.gender = "";
        this.priorityLevel = 0;
        this.diagnosis = "";

    }

    void display() {
        System.out.println("PATIENT NAME " + this.patientName);
        System.out.println("PATIENT SURNAME " + this.patientSurname);
        System.out.println("PATIENT ID NUMBER " + this.patientIDNumber);
        System.out.println("PATIENT ADDRESS " + this.patientAddress);
        System.out.println("AGE " + getAge());
        System.out.println("PHONE NUMBER " + phoneNumber);
        System.out.println("GENDER " + this.gender);
        System.out.println("PRIORITY LEVEL " + this.priorityLevel);
        System.out.println("DIAGNOSIS " + this.diagnosis);
    }
}
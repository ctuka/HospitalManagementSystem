package com.mentoringgroup.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Doctor {
    public static String name;
    public String surname;
    public String idNumber;
    public String address;
    public String phoneNumber;
    public String specialization;

    public Doctor(String name, String surname, String idNumber,
                  String address, String phoneNumber, String specialization) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }

    public String getIdNumber() {

        return idNumber;
    }


    public static void removedoc(ArrayList<Doctor> doclist, String idNumber) {
        doclist.removeIf(doc -> doc.idNumber.equals(idNumber));
    }

    public static void viewdocinfo(ArrayList<Doctor> doclist, String idNum) {
        for (Doctor doc : doclist) {
            if (doc.getIdNumber().equals(idNum)) {
                System.out.println("Doctor Information: ");
                System.out.println("Name: " + doc.name);
                System.out.println(" surname: " + doc.surname);
                System.out.println("ID Number: " + doc.idNumber);
                System.out.println("Address: " + doc.address);
                System.out.println("Doctor's Phone Number: " + doc.phoneNumber);
                System.out.println("Specialization of Doctor: " + doc.specialization);
                break;
            }
        }
    }

    public static void updateDocInfo(ArrayList<Doctor> doclist, String idNum, Scanner input) {
        for (Doctor doc : doclist) {
            if (doc.idNumber.equals(idNum)) {
                System.out.print("Enter new Name or press enter to skip: ");
                String name = input.nextLine();
                if (!name.isEmpty())
                    doc.name = name;

                System.out.print("Enter new Last Name or press enter to skip: ");
                String surname = input.nextLine();
                if (!surname.isEmpty())
                    doc.surname = surname;

                System.out.println("Enter new address or press enter to skip: ");
                String address = input.nextLine();
                if (!address.isEmpty())
                    doc.address = address;

                System.out.println("Enter new phone number or press enter to skip: ");
                String phoneNum = input.nextLine();
                if (!phoneNum.isEmpty())
                    doc.phoneNumber = phoneNum;

                System.out.println("Enter new specialization or press enter to skip: ");
                String specialization = input.nextLine();
                if (!specialization.isEmpty())
                    doc.specialization = specialization;

                System.out.println("Doctor information updated successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    public static void addDoc1(ArrayList<Doctor> doclist, Scanner input) {

        do {

            System.out.println("Name: ");
            String name = input.nextLine();
            //doc.name = name;

            System.out.println(" surname: ");
            String surname = input.nextLine();
            // doc.surname = surname;

            System.out.println("ID Number: ");
            String idNumber = input.nextLine();
            //  doc.idNumber = idNumber;

            System.out.println("Address: ");
            String address = input.nextLine();
            // doc.address = address;

            System.out.println("Phone Number: ");
            String phoneNumber = input.nextLine();
            //  doc.phoneNumber = phoneNumber;

            System.out.println("Specialization: ");
            String specialization = input.nextLine();
            // doc.specialization = specialization;
            return;
        } while (true);

    }

    public static void scanner() {
        ArrayList<Doctor> doclist = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("We" +
                "lcome to the Doctor Management System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new doctor ( press 1 )");
            System.out.println("2. Remove a doctor ( press 2 )");
            System.out.println("3. View doctor information ( press 3 )");
            System.out.println("4. Update information of a doctor ( press 4 )");
            System.out.println("5. Exit ( press 5 )");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter doctor details:");

                    addDoc1(doclist, input);
                    System.out.println("Doctor added successfully!");


                    break;
                case 2:
                    System.out.print("Enter doctor ID number to remove: ");
                    String idToRemove = input.nextLine();
                    Doctor.removedoc(doclist, idToRemove);
                    System.out.println("Doctor removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter doctor ID number to view information: ");
                    String idToView = input.nextLine();
                    Doctor.viewdocinfo(doclist, idToView);
                    break;
                case 4:
                    System.out.print("Enter doctor ID number to update information: ");
                    String idToUpdate = input.nextLine();
                    updateDocInfo(doclist, idToUpdate, input);
                    break;
                case 5:
                    System.out.println("Exiting Doctor Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }


    public static void main(String[] args) {
        Doctor.scanner();
    }
}




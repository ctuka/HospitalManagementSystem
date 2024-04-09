package com.mentoringgroup.app;

import com.mentoringgroup.entities.Address;
import com.mentoringgroup.entities.Doctor;
import com.mentoringgroup.entities.Patient;
import com.mentoringgroup.service.Prescription;

import javax.swing.text.html.HTMLDocument;
import java.util.Scanner;

import static com.mentoringgroup.entities.Admin.adminLogin;
import static com.mentoringgroup.entities.Doctor.scanner;

public class Starting {

    public static void start() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Doctor doc = new Doctor("Yns", "Kka", "7",
                "Mht 05", "927349", "Surgeon");
        Patient pat = new Patient("Sarah", "Kater", "9", new Address(17, "Mhm", "NYC", "NY", 12461), 27,
        "87325961", "Female", 9, "Fever");
        Prescription presc = new Prescription(doc, pat, "Fever");
        int select;
        boolean exit = true;
        do {
            System.out.println("----------- Welcome to Hospital Management System -----------");
            System.out.println("1- Admin\n" +
                    "2- Doctor\n" +
                    "3- Patient\n" +
                    "0-Exit");
            select = input.nextInt();
            switch (select){
                case 1:
                    adminLogin(); // you can call Admin page
                    break;
                case 2:
                    //Doctor.doctorLogin(); // you can call Doctor page
                    scanner();
                    break;
                case 3:
                    System.out.println("Patient page"); // you can call Patient page
                    break;
                case 0:
                    exit = false;
                    System.out.println("Program Exited");
                    break;
                default:
                    System.out.println("Invalid selection! Please select from choices.");

            }


        }while (exit);
        stopProject();

    }
    public static void stopProject() {
        System.out.println("You exited from Application");
        System.exit(0);
    }
    public static void blockProject() {
        System.out.println("You are blocked!");
        System.exit(0);
    }

}
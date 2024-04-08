package com.mentoringgroup.app;

import com.mentoringgroup.entities.Doctor;

import java.util.Scanner;

import static com.mentoringgroup.entities.Admin.adminLogin;

public class Starting {

    public static void start() throws InterruptedException {
        Scanner input = new Scanner(System.in);
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
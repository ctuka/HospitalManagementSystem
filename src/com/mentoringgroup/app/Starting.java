package com.mentoringgroup.app;

import java.util.Scanner;

public class Starting {

    public static void start(){
        Scanner input = new Scanner(System.in);
        int select;
        boolean exit = true;
        do {
            System.out.println("----------- Welcome to Hospital Management System -----------");
            System.out.println("\n\s1- Admin           2- Doctor \n\n\s3- Patient         0-Exit");
            System.out.print("\n\nEnter number of the selection: ");
            select = input.nextInt();
            switch (select){
                case 1:
                    System.out.println("Admin page"); // you can call Admin page
                    break;
                case 2:
                    System.out.println("Doctor page"); // you can call Doctor page
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
    }


}
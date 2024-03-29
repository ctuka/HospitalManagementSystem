package com.mentoringgroup.entities;

import java.util.Scanner;

public class Admin {

    static Scanner scan = new Scanner(System.in);

    public static void adminLogin(){
        String id;
        String password;
        String select;

        do {
            System.out.println("Please enter your Id number");
            id= scan.nextLine();
            System.out.println("Please enter your password");
            password=scan.nextLine();
            select=scan.nextLine();


        }while(select.equalsIgnoreCase("q"));


    }
}

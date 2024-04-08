package com.mentoringgroup.entities;

import com.mentoringgroup.app.Starting;
import com.mentoringgroup.utilities.AdminDataBank;

import java.util.*;

public class Admin {


    static Scanner scan = new Scanner(System.in);
    private static String adminId=AdminDataBank.getAdminId();
    private static String adminPassword=AdminDataBank.getAdminPassword();
    private static String adminName=AdminDataBank.getAdminName();
    private static String adminLastName=AdminDataBank.getAdminLastName();
    private static String adminBirthDate=AdminDataBank.getAdminBirthDate();
    private static String adminPhoneNumber=AdminDataBank.getPhoneNumber();
    private static String adminAddress=AdminDataBank.getAddress();
    private static String eachValue;
    private static String[] eachValueList;
    static String id;
    static String password;


    public static void adminLogin() throws InterruptedException {

        String select;
        int count=0;
        System.out.println("Please enter 'S' to return 'Starting Page', to continue press any key");
        Thread.sleep(1000);
        select = scan.nextLine();
        if (select.equalsIgnoreCase("s")){
            Starting.start();

        }

        do {


            System.out.println("Please enter your Id number");
            id= scan.nextLine();//to get id from user
            System.out.println("Please enter your password");
            password=scan.nextLine();//to get password from user

            //Ids and passwords are stored in a Set
            Set<Map.Entry<String,String>> setOfIdAndPassword = AdminDataBank.add();
            List<String> ids = new ArrayList<>();
            List<String> passes = new ArrayList<>();


            //put id and password into a List
            for (Map.Entry<String, String> each: setOfIdAndPassword) {

                adminId= each.getKey();
                ids.add(adminId);
                adminPassword = each.getValue();
                passes.add(adminPassword);
            }
            //Checks if the given id and password are in the system
            if (ids.contains(id)&&passes.contains(password)){
                mainMenu();

            }else  {
                if (count<2){
                    System.out.println("Invalid ID and Password");
                    count++;
                }else {
                    System.out.println("You entered wrong id or password 3 time!");
                    Thread.sleep(1000);
                    Starting.blockProject();//Blocks the project
                }
            }

        }while(!select.equalsIgnoreCase("Q"));
        Starting.stopProject();//stops the project
    }


    public static void mainMenu() throws InterruptedException {
        String name=null;
        String lastName=null;
        Set<Map.Entry<String,String>> in = AdminDataBank.adminInfo.entrySet();
        for (Map.Entry<String, String> each: in) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuarr = eachValue.split("- ");
            if (id.equals(eachKey)){
                name= eachValuarr[0];
                lastName=eachValuarr[1];
            }
        }

        String choice="";
        do {
            System.out.println("Welcome Admin Page " + name+ " " + lastName);
            System.out.println("""
                    1 - New Patient Registration
                    2 - Find Patient with ID\s
                    3 - Delete Patient with ID
                    4 - Patient List\s
                    5 - Update Patient's Information
                    6 - New Doctor Registration\s
                    7 - Find Doctor with ID\s
                    8 - Delete Doctor with ID\s
                    9 - Doctor List\s
                    10- Update Doctor's Information
                    M - Management
                    S - Starting Page\s
                    Q - Exit""");
            choice= scan.next();



            switch (choice){
                case "1": //1 - New Admin Registration
                    //Patient.addPatient();
                    break;
                case "2":
                    //Patient.findPatientById();
                    break;
                case "3":
                    //Patient.deletePatientById();
                    break;
                case "4":
                    //Patient.patientList();
                    break;
                case "5":
                    //updatePatientInfo();
                    break;
                case "6":
                    //Doctor.addDoctor();
                    break;
                case "7":
                    //Doctor.findDoctorById();
                    break;
                case "8":
                    //Doctor.deleteDoctorById();
                    break;
                case "9":
                    //Doctor.doctorList();
                    break;
                case "10":
                    //Doctor.updateDoctorInfo();
                    break;
                case "M":
                case "m":
                    AdminDataBank.management();
                    break;
                case "s":
                case "S":
                    Starting.start();
                    break;

                case "Q":
                case "q":
                    Starting.stopProject();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }while (!choice.equalsIgnoreCase("q"));
    }


}

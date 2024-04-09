package com.mentoringgroup.utilities;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.mentoringgroup.app.Starting;
import com.mentoringgroup.entities.Admin;

public class AdminDataBank extends Util{

    static String adminId;
    private static String adminPassword;
    private static String adminName;
    private static String adminLastName;
    private static String adminBirthDate;
    private static String gender;
    private static String phoneNumber;
    private static String streetName;
    private static String houseNumber;
    private static String postalCode;
    private static String city;
    private static String address;
    private static int age;
    private static String eachKey;
    private static String eachValue;
    private static String[] eachValueList;

    static Scanner scan = new Scanner(System.in);
    public static Map<String, String> idPassword= new HashMap<>();
    public static Map<String, String> adminInfo = new HashMap<>();
    public static Set<Map.Entry<String, String>> add(){
        return idPassword.entrySet();
    }
    public static Set<Map.Entry<String, String>> info(){
        return adminInfo.entrySet();
    }
    public static void idPasswordSampleList(){
        idPassword.put("12311", "Admin123");
        idPassword.put("12322", "112233");

    }
    public static void adminInfoSampleList(){
        adminInfo.put("12311", "Tom- Hanks- 02/02/1990- Male- +11117774589- New York");
        adminInfo.put("12322", "Angelina- Jolie- 01/01/1970- Female- +49123454141- Boston");
    }

    public static void management() throws InterruptedException {
        String choice=null;
        int entrance;
        int code = 123456;

        do {
            System.out.println("Please enter Authorization Code");
            entrance=scan.nextInt();
            scan.nextLine();
            if (entrance==code){
                System.out.println("""
                        1 - Add a new Admin
                        2 - Get Admin by Id
                        3 - Update Admin Info
                        4 - Delete Admin by Id
                        5 - Admin List
                        A - Admin Menu
                        Q - Exit
                        """);
                choice = scan.next();
                switch (choice){
                    case "1":
                        createAdmin();
                        break;
                    case "2":
                        getAdminInfoById();
                        break;
                    case "3":
                        updateAdminInfo();
                        break;
                    case "4":
                        deleteAdmin();
                        break;
                    case "5":
                        adminList();
                        break;
                    case "A":
                    case "a":
                        Admin.mainMenu();
                        break;
                    case "Q":
                    case "q":
                        Starting.stopProject();
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }

            }else {
                System.out.println("Incorrect Authorization");
            }
        }while (!choice.equalsIgnoreCase("q"));

    }
    public static void createAdmin() throws InterruptedException {

        String choice;
        boolean condition;

        do {
            condition=false;
            System.out.println("y - to continue\n" +
                    "N - Menu");
            choice = scan.next();
            scan.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                continue;
            }
            else if(choice.equalsIgnoreCase("y")){
                setAdminId(null);
                setAdminPassword(null);
                setAdminName(null);
                setAdminLastName(null);
                setAdminBirthDate(null);
                setGender(null);
                setPhoneNumber(null);
                setStreetName(null);
                setHouseNumber(null);
                setPostalCode(null);
                setCity(null);
                setAddress(null);

                String admin = getAdminName() + "- " + getAdminLastName() + "- " + getAdminBirthDate() + "- " + getGender() + "- " + getPhoneNumber() + "- " + getAddress();

                idPassword.put(getAdminId(), getAdminPassword());
                adminInfo.put(getAdminId(), admin);
                condition=true;


            }


        }while (condition);

    }
    public static void getAdminInfoById() throws InterruptedException {//gets admin's info and put them into a set
        String id;
        boolean condition;
        do {
            condition =false;
            System.out.println("Enter id of admin, or 0 to Main Menu");

            id = scan.next();
            Set<Map.Entry<String, String>> setOfInfo = AdminDataBank.info();
            if (id.equals("0")){
                management();
                break;
            }

            for (Map.Entry<String, String> each : setOfInfo) {
                eachKey = each.getKey();
                eachValue = each.getValue();
                eachValueList = eachValue.split("- ");
                if (id.equals(eachKey)){
                    System.out.println(
                            "\nId Number             :" + eachKey +
                                    "\nName                  :" + eachValueList[0] +
                                    "\nLast Name             :" + eachValueList[1] +
                                    "\nBirth Date            :" + eachValueList[2] +
                                    "\nGender                :" + eachValueList[3] +
                                    "\nPhone Number          :" + eachValueList[4] +
                                    "\nAddress               :" + eachValueList[5]);
                    break;
                }
            }
            if (!id.equals(eachKey)){
                System.out.println("Invalid Id!");}

        }while (!id.equals(eachKey));

    }

    public static void updateAdminInfo() throws InterruptedException {
        String id;
        do {
            System.out.println("Enter the ID number of the manager to update the Information or press 0 to return menu");
            id = scan.next();
            if (id.equalsIgnoreCase("0")){
                management();
                break;
            }
            for (Map.Entry<String, String> w : adminInfo.entrySet()) {
                eachKey = w.getKey();
                eachValue = w.getValue();
                eachValueList = eachValue.split("- ");
                if (id.equals(eachKey)) {
                    adminInfo.replace(id, updatedAdminInfo());
                    break;
                }
            }
            if (!id.equals(eachKey)){
                System.out.println("Invalid Id!");
            }
        }while (!id.equals(eachKey));
    }
    public static String updatedAdminInfo() throws InterruptedException {

        setAdminName(null);
        setAdminLastName(null);
        setAdminBirthDate(null);
        setGender(null);
        setPhoneNumber(null);
        setStreetName(null);
        setHouseNumber(null);
        setPostalCode(null);
        setCity(null);
        setAddress(null);
        return getAdminName()+ "- " +getAdminLastName()+ "- "+getAdminBirthDate()+ "- "+getGender() +"- " +getPhoneNumber()+"- " +getAddress();
    }

    public static void deleteAdmin() throws InterruptedException {
        String id;
        do {
            System.out.println("Enter Admin Id to remove or '0' to Main Menu");
            id= scan.next();
            scan.nextLine();

            if (id.equals("0")){
                management();
                break;
            }
            for (Map.Entry<String, String> w: info()) {
                eachKey = w.getKey();
                eachValue = w.getValue();
                eachValueList = eachValue.split("- ");
                if (id.equals(eachKey)){
                    System.out.println("The admin with " + id +" number" + eachValueList[0] + " " + eachValueList[1] + " has been successfully deleted");
                    adminInfo.remove(id);
                    break;
                }
            }
            if (!id.equals(eachKey)){
                System.out.println("Invalid Id!");}
        }while (!id.equals(eachKey));

    }
    public static void adminList(){
        System.out.println("Id        Name      Lastname       Birthdate   Gender    Phone Number    address");
        for (Map.Entry<String,String> each : info()) {
            eachKey = each.getKey();
            eachValue = each.getValue();
            eachValueList = eachValue.split("- ");
            System.out.printf("%5s     %8s       %-5s           %8s          %-4s      %11s            %5s\n",
                    eachKey, eachValueList[0],eachValueList[1],eachValueList[2],eachValueList[3],eachValueList[4],eachValueList[5]);

        }

    }

    public static String getAdminId() {
        return adminId;
    }

    public static void setAdminId(String adminId) {

        do {
            System.out.println("Enter your Id");
            adminId = scan.next();
            if (adminId.length()==5) {
                AdminDataBank.adminId = adminId;
                break;
            }else {
                System.out.println("Id must have 5 digits");
            }
        }while (true);

    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    public static void setAdminPassword(String adminPassword) {
        do {
            System.out.println("Please enter a new password.\n" +
                    "And it must have at least 6 characters");
            adminPassword = scan.next();
            scan.nextLine();
            if (adminPassword.length()>5) {
                AdminDataBank.adminPassword = adminPassword;
                break;
            }else {
                System.out.println("PassWord Cannot be empty or must have at least 6 characters");
            }
        }while (true);


    }

    public static String getAdminName() {
        return adminName;
    }


    public static void setAdminName(String adminName) {
        do {
            System.out.println("Please enter Admin name");
            adminName= scan.nextLine();
            if (!adminName.isEmpty()) {
                AdminDataBank.adminName = adminName;
                break;
            }else {
                System.out.println("Name cannot be empty");
            }
        }while(true);
    }

    public static String getAdminLastName() {
        return adminLastName;
    }

    public static void setAdminLastName(String adminLastName) throws InterruptedException {
        do {
            System.out.println("Please enter your last name");
            adminLastName= scan.nextLine();
            if (!adminLastName.isEmpty()) {
                AdminDataBank.adminLastName = adminLastName;
                break;
            }else {
                System.out.println("Last name cannot be empty");

            }
        }while(true);
        Thread.sleep(1000);

    }
    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        do {
            System.out.println("Enter admins gender");
            gender = scan.nextLine();
            if (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")){
                AdminDataBank.gender = gender;
                break;
            }else {
                System.out.println("Invalid gender!");
            }
        }while (true);

    }


    public static String getPhoneNumber() {
        return phoneNumber;
    }

    @SuppressWarnings("ReassignedVariable")
    public static void setPhoneNumber(String phoneNumber) throws InterruptedException {
        do {
            System.out.println("Please Enter your Phone number");
            phoneNumber = scan.nextLine();
            if (!phoneNumber.isBlank()){
                AdminDataBank.phoneNumber = phoneNumber;
                break;
            }else {
                System.out.println("Phone number cannot be empty!");
                Thread.sleep(1000);
            }

        }while (true);
    }

    public static String getStreetName() {
        return streetName;
    }

    public static void setStreetName(String streetName) throws InterruptedException {
        do {
            System.out.println("Enter your street");
            streetName = scan.nextLine();
            if (!streetName.isBlank()){
                AdminDataBank.streetName = streetName;
                break;
            }else {
                System.out.println("Street cannot be empty!");
                Thread.sleep(1000);
            }
        }while (true);
    }

    public static String getHouseNumber() {
        return houseNumber;
    }

    public static void setHouseNumber(String houseNumber) {
        do {
            System.out.println("Enter your house number");
            houseNumber = scan.nextLine();
            if (!houseNumber.isBlank()){
                AdminDataBank.houseNumber = houseNumber;
                break;
            }else {
                System.out.println("House number cannot be empty!");
            }
        }while (true);
    }

    public static String getPostalCode() {
        return postalCode;
    }

    public static void setPostalCode(String postalCode) throws InterruptedException {
        do {
            System.out.println("Enter postal code");
            postalCode = scan.next();
            scan.nextLine();
            if (!postalCode.isBlank()) {
                AdminDataBank.postalCode = postalCode;
                break;
            } else {
                System.out.println("Postal code cannot be empty");
                Thread.sleep(1000);
            }
        }while (true);
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        do {
            System.out.println("Enter your city");
            System.out.print("");
            city = scan.nextLine();
            if (!city.isBlank()){
                AdminDataBank.city = city;
                break;
            }else {
                System.out.println("City cannot be empty!");
            }
        }while (true);
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        address = getStreetName()+" "+ getHouseNumber()+" " +getPostalCode()+" "+getCity();
        AdminDataBank.address = address;
    }

    public static String getAdminBirthDate() {
        return adminBirthDate;
    }
    public static void setAdminBirthDate(String adminBirthDate) throws InterruptedException {
        do {
            LocalDate birthDate = inputBirthDate();
            int age = calculateAge(birthDate);
            if (isValidAge(age)) {
                adminBirthDate = formatDate(birthDate);
                AdminDataBank.adminBirthDate = adminBirthDate;
                break;
            } else {
                System.out.println("Please enter a valid birth date.");
            }
        } while (true);
    }

    // Method to input the birth date
    private static LocalDate inputBirthDate() {
        int day, month, year;
        do {
            System.out.println("Enter your birth day");
            day = scan.nextInt();
            System.out.println("Enter your birth month");
            month = scan.nextInt();
            System.out.println("Enter your birth year");
            year = scan.nextInt();
            scan.nextLine(); // Consume newline character
        } while (!isValidDate(day, month, year));
        return LocalDate.of(year, month, day);
    }

    // Method to calculate the age based on the birth date
    private static int calculateAge(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }

    // Method to check if the calculated age is valid
    private static boolean isValidAge(int age) {
        return age >= 18 && age <= 120; // Assuming the valid age range is between 18 and 120
    }

    // Method to format the birth date
    private static String formatDate(LocalDate birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return birthDate.format(formatter);
    }

    // Method to validate the input date
    private static boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            System.out.println("Invalid date. Please enter a valid date.");
            return false;
        }
    }

}

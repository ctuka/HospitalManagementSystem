package com.mentoringgroup.utilities;
import java.util.InputMismatchException;
import java.util.regex.*;
public class Util {


    // Username Format Exceptions

    public static String usernameException(String username){
        String regx = "^[a-zA-Z][a-zA-Z0-9_]*$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(username);

        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Username should start with a letter and contain only letters, numbers, or underscores!");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return username;
    }

    // Email address Format Exception
    public static String emailException(String email){

        String regx = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Invalid email address format! Format example should be abc@gmail.com");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return email;
    }


    //  password Exception

    public static String passwordException(String password){
        String regx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+${5,}";
        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(password);


        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Invalid password format!\npasswords to contain at least one uppercase letter,\none lowercase letter,\nand at least one digit:");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return password;
    }
    //  Id Exception Exception
    public static String IdException(String id){
        String regx = "^[0-9]${5,}";
        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(id);


        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Invalid ID format!\nID should contain only digits\nMinimum length of 5 digits");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return id;

    }

    // Date Exception

    public static String DateException(String date){
        String regx = "^(0?[1-9]|1[0-2])/(0?[1-9]|1\\d|2\\d|3[01])/(19|20)\\d{2}$";
        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(date);


        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Invalid date format!\nDate format should be mm/dd/yyyy or dd/mm/yyyy");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return date;

    }


    // Phone Exception
    public static String PhoneException(String phone){

        String regx = "^(?=.*\\d)\\+?[0-9]*$";
        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(phone);


        if (!matcher.matches()){
            try {
                throw new InputMismatchException("Invalid Phone number format!\nshould contain only digits and + sign optional.");
            } catch (InputMismatchException e){
                return e.getMessage();
            }
        }
        return phone;

    }

}

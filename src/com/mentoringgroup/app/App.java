package com.mentoringgroup.app;





import static com.mentoringgroup.utilities.AdminDataBank.adminInfoSampleList;
import static com.mentoringgroup.utilities.AdminDataBank.idPasswordSampleList;


public class App {
    public static void main(String[] args) throws InterruptedException {
        idPasswordSampleList();
        adminInfoSampleList();
        //doctorSampleList();
        //patientSampleList();
        //listOfDepartment();
        Starting.start();


    }
}
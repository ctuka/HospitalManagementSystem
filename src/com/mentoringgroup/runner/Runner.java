package com.mentoringgroup.runner;


import com.mentoringgroup.entities.Doctor;
import com.mentoringgroup.entities.Patient;
import com.mentoringgroup.service.Appointment;
import com.mentoringgroup.service.Prescription;

import java.util.ArrayList;

//This class will help run the program
public class Runner {

    public  ArrayList<Patient> patientList = new ArrayList<>();
    public ArrayList<Doctor> doctorList =  new ArrayList<>();

    public ArrayList<Appointment> appointmentList = new ArrayList();
    public  ArrayList<Prescription> prescriptionList = new ArrayList<>();
    public static void run() {
        System.out.printf("Hello and welcome!");
    }

    public void addPatient(Patient patient) {
        //will add data to patienst's fieldfrom patioen parameter

        patientList.add(patient);
    }

    //Searching on all list and cheking id number if it finds the number remove patient from list
    public Patient removePatient(String idNumber) {
        try {
            for (Patient patient : patientList) {
                if (patient.idNumber.eualsIgnoreCase(idNumber)) {
                    patientList.remove(patient);
                    System.out.println("Patient " + patient.name + " " + patient.surname + " removed");
                    return patient;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void viewPatientInfo(String idNumber) {

        for (Patient patient : patientList) {
            if (patient.idNumber.eualsIgnoreCase(idNumber)) {
                System.out.println("Patient Id Number :" + patient.idNumber );
                System.out.println("Patient name :" + patient.name);
                System.out.println("Patient surname :" + patient.surname );
                System.out.println("Patient address :" + patient.address );
                System.out.println("Patient phone number  :" + patient.phoneNumber );
                System.out.println("Patient gender :" + patient.gender );
                System.out.println("Patient priority level :" + patient.priorityLevel );
                System.out.println("Patient diagnosis :" + patient.diagnosis );
            }
        }

    }

    //Adds doctor to doctor list
    public  void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }
    public Doctor removeDoctor(String idNumber) {
        try {
            for (Doctor doctor : doctorList) {
                if (doctor.idNumber.eualsIgnoreCase(idNumber)) {
                    doctorList.remove(patient);
                    System.out.println("Patient " + doctor.name + " " + doctor.surname + " removed");
                    return doctor;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public void viewDoctorInfo(String idNumber) {
        for (Doctor doctor : patientList) {
            if (doctor.idNumber.eualsIgnoreCase(idNumber)) {
                System.out.println("Doctor Id Number :" + doctor.idNumber );
                System.out.println("Doctor name :" + doctor.name);
                System.out.println("Doctor surname :" + doctor.surname );
                System.out.println("Doctor address :" + doctor.address );
                System.out.println("Doctor phone number  :" + doctor.phoneNumber );
                System.out.println("Doctor specialication :" + doctor.specialization );
            }
        }
    }
    public void scheduleAppointment(Patient patient, Doctor doctor, String date, String time) {
        Appointment apt =  new Appointment(patient, doctor, date, time);
        appointmentList.add(apt);

    }
    public  Appointment  cancelAppointment(String date, String time) {
        for (Appointment apt : appointmentList)
            if (apt.date.equals(date) && apt.time.equals(time)) {
                appointmentList.remove(apt);
                return apt;
            }
        return new Appointment();
    }
    public Prescription writePrescription(Patient patient, Doctor doctor, String[] medicines, String[] dosages){
        Prescription prescription =  new Prescription(patient, doctor, medicines, dosages);
        prescriptionList.add(prescription);
        return prescription;
    }



}

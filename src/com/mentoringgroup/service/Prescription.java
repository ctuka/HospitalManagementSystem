package com.mentoringgroup.service;

import com.mentoringgroup.entities.Doctor;
import com.mentoringgroup.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prescription {

    // FIELDS:
    //----------
    // Doctor doctor
    // Patient patient
    //----------
    // LIST as medicines
    // LIST as dosages
    //----------

    private Doctor doctor;
    private Patient patient;
    private String diagnosis;
    private List<String> medicines;
    private List<String> dosages;
    private int confCancel, confEdit;
    private boolean canceled;

    public Prescription(Doctor doctor, Patient patient, String diagnosis) {

        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.medicines = new ArrayList<>();
        this.dosages = new ArrayList<>();
        this.canceled = false;

    }

    // A (security check)-type of method in ADMIN class, accessible to other classes, including this one.
    // ex: public static void SecurityCheck(Doctor_info) {
    // CODE BLOCK ---> check doctor's name/surname, ID and extra info. Or just a password.
    // }

    public void writePrescription(String medicine, String dosage) {
        // Information content. (medicines, dosages, timePeriod, etc)
        medicines.add(medicine);
        dosages.add(dosage);
    }

    public void cancelPrescription() {
        // Confirmation process to make sure this is not an accidental request.
        Scanner sc = new Scanner(System.in);
        boolean cancelBool;
        do {
            cancelBool = false;
            System.out.println("You are about to CANCEL a prescription! Are you sure you want to continue?" +
                    "\n1 - Yes, proceed\n0 - No, recall");
            confCancel = sc.nextInt();

            if (confCancel == 1) {
                canceled = true;
                System.out.println("Prescription cancelled successfully!");
            } else if (confCancel == 0) {
                System.out.println("System recalled!");
            } else {
                System.err.println("INVALID CHOICE ... Please try again!");
                cancelBool = true;
            }
        } while (cancelBool);
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void editPrescription(List<String> newMedicines, List<String> newDosages) {
        // Confirmation process ...
        Scanner sc = new Scanner(System.in);
        boolean editBool;
        do {
            editBool = false;
            System.out.println("You are about to CANCEL a prescription! Are you sure you want to continue?" +
                    "\n1 - yes, proceed\n0 - no, recall");
            confEdit = sc.nextInt();

            if (confEdit == 1) {
                medicines.clear();
                dosages.clear();
                medicines.addAll(newMedicines);
                dosages.addAll(newDosages);
//                for (int i = 0; i < newMedicines.size(); i++) {
//                    medicines.add(newMedicines.get(i));
//                    dosages.add(newDosages.get(i));
//                }
                System.out.println("Prescription edited successfully!");
            } else if (confEdit == 0) {
                System.out.println("System recalled!");
            } else {
                System.err.println("INVALID DATA ... Please try again!");
                editBool = true;
            }
        } while (editBool);
    }

    public void viewPrescription() {
        // Here there is need for getters and setters from DOCTOR/PATIENT classes!!!

//      System.out.println("Doctor: " + doctor.getName() + " " + doctor.getSurname());
//      System.out.println("Patient: " + patient.getName() + " " + patient.getSurname());
//      System.out.println("Diagnosis: " + diagnosis);
//      System.out.println("Medicines:");

        for (int i = 0; i < medicines.size(); i++) {
            System.out.println(" - " + medicines.get(i) + " (" + dosages.get(i) + ")");
        }

        if (isCanceled()) {
            System.out.println("Status: CANCELLED");
        } else {
            System.out.println("Status: ACTIVE");
        }
    }

    public void printPrescription() {
        System.out.println("Prescription for:");
        // In the 2 lines of code below I need someone to add getters and setters in Doctor and Patient classes!
        // System.out.println("Doctor: " + doctor.getName() + " " + doctor.getSurname());
        // System.out.println("Patient: " + patient.getName() + " " + patient.getSurname());
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medicines:");
        viewPrescription();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

}

package com.mentoringgroup.service;

import com.mentoringgroup.entities.Doctor;
import com.mentoringgroup.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prescription {

    private Doctor doctor;
    private Patient patient;
    private String diagnosis, medicine, dosage;
    private List<String> medicines, newMedicines;
    private List<String> dosages, newDosages;
    private int confCancel, confEdit, confWrite;
    private boolean canceled;

    public Prescription(Doctor doctor, Patient patient, String diagnosis) {
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.medicines = new ArrayList<>();
        this.dosages = new ArrayList<>();
        this.canceled = false;
    }

    public void prescEntrance() {
        // Let's assume that doctors have password always beginning with "DOC"
        // And patients always beginning with "PAT"
        Scanner sc = new Scanner(System.in);
        boolean pr;
        do {
            pr = false;
            System.out.print("Welcome to prescriptions section! \nPlease provide your identification [DOC or PAT]: ");
            String docpat = sc.next();

            switch (docpat) {
                case "DOC":
                    // System.out.print("You have entered as a doctor. \nPlease provide your ID: ");
                    System.out.println("You have entered as a doctor - MENU: ");
                    System.out.println("1 - Write Prescription ||| 2 - Update Prescription" +
                                    "\n3 - Cancel Prescription ||| 4 - View Prescription" +
                                    "\n0 - EXIT");
                    int doc = sc.nextInt();

                    if (doc == 1) {
                        writePrescription();
                    } else if (doc == 2) {
                        editPrescription();
                    } else if (doc == 3) {
                        cancelPrescription();
                    } else if (doc == 4) {
                        printPrescription();
                    } else if (doc == 0) {
                        System.out.println("EXIT MADE!");
                    } else {
                        System.err.println("ERROR - Invalid input ::: Please try again!");
                        pr = true;
                    }
                    break;

                case "PAT":
                    System.out.println("You have entered as a patient - MENU: ");
                    System.out.println("1 - View Prescription ||| 0 - EXIT");
                    int pat = sc.nextInt();

                    if (pat == 1) {
                        printPrescription();
                    } else if (pat == 0) {
                        System.out.println("EXIT MADE!");
                    } else {
                        System.err.println("ERROR - Invalid Input ::: Please try again!");
                        pr = true;
                    }
                    break;

                default:
                    System.err.println("ERROR - Invalid Input ::: Please try again!");
                    pr = true;
            }
        } while (pr);
    }

    public void writePrescription() {
        // Information content. (medicines, dosages, timePeriod, etc)
        Scanner sc = new Scanner(System.in);
        boolean writeBool;
        do {
            writeBool = false;
            System.out.println("You are about to write a new prescription! Do you want to proceed:\n1 - Yes\n0 - No, EXIT");
            confWrite = sc.nextInt();

            switch (confWrite) {
                case 1:
                    System.out.print("Write medicine: ");
                    medicine = sc.nextLine();
                    System.out.println("Write dosage: ");
                    dosage = sc.nextLine();
                    medicines.add(medicine);
                    dosages.add(dosage);
                    System.out.println("Prescription written successfully!");
                    prescEntrance();
                    break;

                case 0:
                    System.out.println("EXIT MADE!");
                    prescEntrance();
                    break;

                default:
                    System.err.println("ERROR - Invalid Input ::: Please try again!");
                    writeBool = true;
            }
        } while (writeBool);
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
                prescEntrance();
            } else if (confCancel == 0) {
                System.out.println("System recalled!");
                prescEntrance();
            } else {
                System.err.println("INVALID CHOICE ... Please try again!");
                cancelBool = true;
            }
        } while (cancelBool);
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void editPrescription() {
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
                prescEntrance();
            } else if (confEdit == 0) {
                System.out.println("System recalled!");
                prescEntrance();
            } else {
                System.err.println("INVALID DATA ... Please try again!");
                editBool = true;
            }
        } while (editBool);
    }

    public void viewPrescription() {
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
        System.out.println("------------------------");
        prescEntrance();
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
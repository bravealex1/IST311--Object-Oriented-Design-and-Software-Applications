package edu.psu.ist;

import java.util.Scanner;

public class Applicant {
    private String ApplicantName;
    private String ApplicantEmail;
    private String ApplicantSelfDescription;
    private int ApplicantScore;
    private String creditCardNumber;

    public Applicant(String name, String Email, String SelfDescription, int Score, String creditCardNumber) {
        ApplicantName = name;
        ApplicantEmail = Email;
        ApplicantSelfDescription = SelfDescription;
        ApplicantScore = Score;
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() {
        return ApplicantName;
    }

    public void setName(String name) {
        ApplicantName = name;
    }

    public boolean selfDescriptionWordCount(String i) {
        if (i.length() < 50) {
            return false;
        } else if (i.length() < 0){
            return false;
        } else if (i.length() >= 400) {
            return false;
        } else {
            return true;
        }
    }

    public boolean creditCardNumber(String i) {
        if (i.length() != 16) {
            return false;
        } else {
            return true;
        }
    }

}

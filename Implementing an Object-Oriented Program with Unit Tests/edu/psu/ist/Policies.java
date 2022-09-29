package edu.psu.ist;

import java.util.ArrayList;

public class Policies extends NewMemberOrientation {
    private String BackgroundCheck;
    private String PreventionTraining;
    private String ClubRules;
    private double MembershipFee;

    @Override
    public void NewMemberOrientation() {

    }

//    public void doBackgroundCheck(boolean criminalRecord) {
//        if (criminalRecord = true) {
//            System.out.println("Is not qualified to join the club");
//        } else {
//            System.out.println("Moving forward.");
//        }
//    }
//
//    public void PreventionTraining() {
//        boolean completionStatus;
//        if (completionStatus = true) {
//            System.out.println("Is not qualified to join the club");
//        } else {
//            System.out.println("Moving forward.");
//        }
//    }
//
//    public void ToClubRules() {
//        boolean readTermsAndAgreement;
//        if (readTermsAndAgreement = true) {
//            System.out.println("Is not qualified to join the club");
//        } else {
//            System.out.println("Moving forward.");
//        }
//    }
//
//    public void MembershipFee() {
//        boolean paymentStatus;
//        if (paymentStatus = true) {
//            System.out.println("Is not qualified to join the club");
//        } else {
//            System.out.println("Moving forward");
//        }
//    }

    public String statusCheck(boolean criminalRecord, boolean preventionTrainingCompletionStatus, boolean readTermsAndAgreement, boolean membershipPaymentStatus) {
//        if (criminalRecord = false) {
//            return false;
//
//        } else if (preventionTrainingCompletionStatus = false) {
//            return false;
//
//        } else if (readTermsAndAgreement = false) {
//            return false;
//
//        } else if (membershipPaymentStatus = false) {
//            return false;
//
//        }
//            return true;
//    }
        ArrayList<Boolean> statusCheck = new ArrayList<>();
        statusCheck.add(criminalRecord);
        statusCheck.add(preventionTrainingCompletionStatus);
        statusCheck.add(readTermsAndAgreement);
        statusCheck.add(membershipPaymentStatus);

        for (int i = 0; i < statusCheck.size(); i++) {
            if (!statusCheck.get(i))
                return "Not qualified";
        }
        return "Congratulations, you are finally able to join the club";
    }
}

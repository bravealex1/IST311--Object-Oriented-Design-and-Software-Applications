package edu.psu.ist;

import java.util.ArrayList;

public abstract class NewMemberOrientation {
    private String WelcomingEmail;
    private String OrientationDate;
    private String Training;

    public abstract void NewMemberOrientation();

    public boolean EmailingList() {
        ArrayList<String> newMember = new ArrayList<>();
        newMember.add("Alice");
        newMember.add("Bob");

        if (newMember.contains("Alice") && (newMember.contains("Bob"))) {
            return true;
        } else {
            return false;
        }
    }
}

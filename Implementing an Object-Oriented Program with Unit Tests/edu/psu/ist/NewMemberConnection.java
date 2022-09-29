package edu.psu.ist;

import java.util.ArrayList;

public class NewMemberConnection extends NewMemberOrientation {
    private String CommunicationPlatform;
    private Boolean MemberName;
    private String Subgroup;


    @Override
    public void NewMemberOrientation() {

    }

    public boolean BuildCommunicationPlatform(int n) {
        if (n > 50) {
            return false;
        } else if (n < 0) {
            return false;
        } else {
            return true;
        }
    }
}

package edu.psu.ist;

import java.util.ArrayList;
import java.util.Scanner;

public class RecruitingProcess {
    private String Interviewer;
    private String Interviewee;
    private String InterviewQuestion;

    public boolean Interview(int Score) {
            if (Score > 85) {
                return true;
            } else if (Score < 0) {
                System.out.println("Invalid score");
            }
                return false;
    }
}

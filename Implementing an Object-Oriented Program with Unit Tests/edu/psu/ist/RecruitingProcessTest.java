package edu.psu.ist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecruitingProcessTest {
    @Test
    public void testRecruiting() {
     RecruitingProcess p = new RecruitingProcess();
        ArrayList<String> interviewees = new ArrayList<>();
        interviewees.add("Alice");
        interviewees.add("Nick");
        interviewees.add("Bob");

        System.out.print("Please Enter Applicant's name: ");
        System.out.println("Alice");
        System.out.println("Please Enter Alice's score: " + 89);

        System.out.print("Please Enter Applicant's name: ");
        System.out.println("Nick");
        System.out.println("Please Enter Alice's score: " + 67);

        System.out.print("Please Enter Applicant's name: ");
        System.out.println("Bob");
        System.out.println("Please Enter Alice's score: " + 96);

     assertEquals(true, p.Interview(89));
     assertEquals(false, p.Interview(67));
     assertEquals(true, p.Interview(96));

    }
}
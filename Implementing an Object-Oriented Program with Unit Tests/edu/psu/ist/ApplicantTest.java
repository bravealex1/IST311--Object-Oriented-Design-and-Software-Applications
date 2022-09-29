package edu.psu.ist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {
    @Test
    public void selfDescriptionWordCountTest() {
        Applicant a = new Applicant("Peter", "Peter@gmail.com", "Hi, my name is peter, and I am a student at Penn State", 89, "8002792478398092");

    assertEquals(false, a.selfDescriptionWordCount("Hi, my name is peter"));
    assertEquals(false, a.selfDescriptionWordCount("I’m Avery Lucas, and I want to swimming"));
    assertEquals(true, a.selfDescriptionWordCount("My name is Rylan Curtis, and I’m chief engineer for Jacobs and Associates."));
    assertEquals(false, a.selfDescriptionWordCount("My name is Riley See. I’m a recent elementary education graduate from Ball State University. I’ve been working at a camp for elementary children this summer, and I’m excited to find my first teaching position for the coming school year. I have several original lesson plans I created during my teaching internship that I look forward to implementing in my own classroom. I attended Brookwood Elementary myself and believe I would be a great fit for your second grade opening. It would be a joy for me to teach students in the same place that sparked my love of learning."));
    assertEquals(false, a.creditCardNumber("8900183900"));
    assertEquals(true, a.creditCardNumber("8900183980001900"));
    assertEquals(false, a.creditCardNumber("8900183900181809893849"));
    }
}
package edu.psu.ist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewMemberOrientationTest {
    @Test
    public void memberTest() {
        NewMemberOrientation newMember = new NewMemberConnection();

        assertEquals(false, newMember.equals("Bob"));
        assertEquals(false, newMember.equals("Alice"));
        assertEquals(false, newMember.equals("Sam"));
        assertEquals(true, newMember.EmailingList());

    }
}
package edu.psu.ist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliciesTest {
    @Test
    public void statusCheck() {
        Policies p = new Policies();
        assertEquals("Not qualified", p.statusCheck(false, false, true, false));
        assertEquals("Not qualified", p.statusCheck(true, true, true, false));
        assertEquals("Congratulations, you are finally able to join the club", p.statusCheck(true, true, true, true));
    }
}
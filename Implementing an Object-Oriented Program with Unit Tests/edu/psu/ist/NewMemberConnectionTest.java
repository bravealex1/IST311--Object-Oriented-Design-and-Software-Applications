package edu.psu.ist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewMemberConnectionTest {
    @Test
    public void BuildCommunicationPlatform() {
        NewMemberConnection platform = new NewMemberConnection();
        assertEquals(false, platform.BuildCommunicationPlatform(67));
        assertEquals(false, platform.BuildCommunicationPlatform(-2));
        assertEquals(true, platform.BuildCommunicationPlatform(34));
    }
}
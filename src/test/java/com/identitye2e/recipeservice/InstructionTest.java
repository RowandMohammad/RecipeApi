package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    private Instruction instruction;

    @BeforeEach
    void setUp() {
        instruction = new Instruction();
    }

    @Test
    void testGetDisplayText() {
        instruction.setDisplayText("Test instruction");
        assertEquals("Test instruction", instruction.getDisplayText());
    }

    @Test
    void testSetDisplayText() {
        instruction.setDisplayText("New instruction");
        assertEquals("New instruction", instruction.getDisplayText());
    }

    @Test
    void testGetStartTime() {
        instruction.setStartTime(1000);
        assertEquals(1000, instruction.getStartTime());
    }

    @Test
    void testSetStartTime() {
        instruction.setStartTime(2000);
        assertEquals(2000, instruction.getStartTime());
    }

    @Test
    void testGetEndTime() {
        instruction.setEndTime(3000);
        assertEquals(3000, instruction.getEndTime());
    }

    @Test
    void testSetEndTime() {
        instruction.setEndTime(4000);
        assertEquals(4000, instruction.getEndTime());
    }

    @Test
    void testShouldDisplayDurationWhenStartTimeAndEndTimeAreNotZero() {
        instruction.setStartTime(1000);
        instruction.setEndTime(2000);
        assertTrue(instruction.shouldDisplayDuration());
    }

    @Test
    void testShouldNotDisplayDurationWhenStartTimeIsZero() {
        instruction.setStartTime(0);
        instruction.setEndTime(2000);
        assertFalse(instruction.shouldDisplayDuration());
    }

    @Test
    void testShouldNotDisplayDurationWhenEndTimeIsZero() {
        instruction.setStartTime(1000);
        instruction.setEndTime(0);
        assertFalse(instruction.shouldDisplayDuration());
    }

    @Test
    void testGetDurationInMinutes() {
        instruction.setStartTime(0);
        instruction.setEndTime(6000);
        assertEquals(1, instruction.getDurationInMinutes());
    }

    @Test
    void testToString() {
        instruction.setDisplayText("Test");
        instruction.setStartTime(1000);
        instruction.setEndTime(2000);
        assertEquals("Instruction{displayText='Test', startTime=1000, endTime=2000}", instruction.toString());
    }
}

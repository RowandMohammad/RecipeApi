package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    private Unit unit;

    @BeforeEach
    void setUp() {
        unit = new Unit();
    }

    @Test
    void testName() {
        unit.setName("Kilogram");
        assertEquals("Kilogram", unit.getName());
    }

    @Test
    void testAbbreviation() {
        unit.setAbbreviation("kg");
        assertEquals("kg", unit.getAbbreviation());
    }

    @Test
    void testDisplaySingular() {
        unit.setDisplaySingular("Kilogram");
        assertEquals("Kilogram", unit.getDisplaySingular());
    }

    @Test
    void testDisplayPlural() {
        unit.setDisplayPlural("Kilograms");
        assertEquals("Kilograms", unit.getDisplayPlural());
    }

}

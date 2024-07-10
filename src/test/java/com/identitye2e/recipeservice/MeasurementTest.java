package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    private Measurement measurement;

    @BeforeEach
    void setUp() {
        measurement = new Measurement();
    }

    @Test
    void testUnitSetterAndGetter() {
        Unit unit = new Unit();
        unit.setName("Kilogram");
        unit.setAbbreviation("kg");
        unit.setDisplaySingular("Kilogram");
        unit.setDisplayPlural("Kilograms");

        measurement.setUnit(unit);
        assertEquals("Kilogram", measurement.getUnit().getName());
        assertEquals("kg", measurement.getUnit().getAbbreviation());
        assertEquals("Kilogram", measurement.getUnit().getDisplaySingular());
        assertEquals("Kilograms", measurement.getUnit().getDisplayPlural());
    }

    @Test
    void testQuantitySetterAndGetter() {
        measurement.setQuantity("5");
        assertEquals("5", measurement.getQuantity());
    }
}

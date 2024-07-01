package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComponentTest {

    private Component component;

    @BeforeEach
    void setUp() {
        component = new Component();
    }

    @Test
    void testMeasurements() {
        Measurement measurement1 = new Measurement();
        Measurement measurement2 = new Measurement();
        ArrayList<Measurement> measurements = new ArrayList<>(Arrays.asList(measurement1, measurement2));

        component.setMeasurements(measurements);
        assertEquals(2, component.getMeasurements().size());
        assertTrue(component.getMeasurements().contains(measurement1));
        assertTrue(component.getMeasurements().contains(measurement2));
    }

    @Test
    void testIngredient() {
        Ingredient ingredient = new Ingredient();
        component.setIngredient(ingredient);
        assertEquals(ingredient, component.getIngredient());
    }

    @Test
    void testRawText() {
        String rawText = "2 cups of flour";
        component.setRawText(rawText);
        assertEquals(rawText, component.getRawText());
    }

    @Test
    void testToString() {
        Measurement measurement1 = new Measurement();
        Measurement measurement2 = new Measurement();
        ArrayList<Measurement> measurements = new ArrayList<>(Arrays.asList(measurement1, measurement2));
        Ingredient ingredient = new Ingredient();
        String rawText = "2 cups of flour";

        component.setMeasurements(measurements);
        component.setIngredient(ingredient);
        component.setRawText(rawText);

        String expectedString = "Component{" +
                "measurements=" + measurements +
                ", ingredient=" + ingredient +
                ", rawText='" + rawText + '\'' +
                '}';

        assertEquals(expectedString, component.toString());
    }
}

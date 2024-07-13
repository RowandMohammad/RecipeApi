package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    private Section section;

    @BeforeEach
    void setUp() {
        section = new Section();
    }

    @Test
    void testComponentsSetterAndGetter() {
        Component component1 = new Component();
        Component component2 = new Component();

        List<Component> componentList = Arrays.asList(component1, component2);

        section.setComponents(componentList);

        assertNotNull(section.getComponents());
        assertEquals(2, section.getComponents().size());
        assertTrue(section.getComponents().contains(component1));
        assertTrue(section.getComponents().contains(component2));
    }

    @Test
    void testToStringMethod() {
        Component component1 = new Component();
        Component component2 = new Component();
        List<Component> componentList = Arrays.asList(component1, component2);

        section.setComponents(componentList);

        String expectedOutput = "Section{components=" + componentList + "}";
        assertEquals(expectedOutput, section.toString());
    }
}
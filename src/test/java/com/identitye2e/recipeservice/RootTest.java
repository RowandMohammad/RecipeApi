package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RootTest {

    private Root root;

    @BeforeEach
    void setUp() {
        root = new Root();
    }

    @Test
    void testThumbnailUrl() {
        String thumbnail = "http://example.com/thumbnail.jpg";
        root.setThumbnailUrl(thumbnail);
        assertEquals(thumbnail, root.getThumbnailUrl());
    }

    @Test
    void testName() {
        String name = "Test Recipe";
        root.setName(name);
        assertEquals(name, root.getName());
    }

    @Test
    void testVideoUrl() {
        String video = "http://example.com/video.mp4";
        root.setVideoUrl(video);
        assertEquals(video, root.getVideoUrl());
    }

    @Test
    void testDescription() {
        String description = "This is a test description";
        root.setDescription(description);
        assertEquals(description, root.getDescription());
    }

    @Test
    void testSections() {
        List<Section> sections = new ArrayList<>();
        sections.add(new Section());
        root.setSections(sections);
        assertEquals(sections, root.getSections());
    }

    @Test
    void testInstructions() {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction());
        root.setInstructions(instructions);
        assertEquals(instructions, root.getInstructions());
    }

    @Test
    void testNumServings() {
        int servings = 4;
        root.setNumServings(servings);
        assertEquals(servings, root.getNumServings());
    }

    @Test
    void testNutrition() {
        Nutrition nutrition = new Nutrition();
        root.setNutrition(nutrition);
        assertEquals(nutrition, root.getNutrition());
    }

    @Test
    void testToString() {
        String name = "Test Recipe";
        root.setName(name);
        assertTrue(root.toString().contains(name));
    }
}

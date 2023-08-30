package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecipeWebControllerTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private RecipeWebController recipeWebController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIndex() throws IOException {
        String expectedContent = "Expected Content";
        when(fileService.readFileContent("src/main/resources/templates/index.html")).thenReturn(expectedContent);

        String result = recipeWebController.index();

        assertEquals(expectedContent, result);
    }

    @Test
    void testIndexIOException() throws IOException {
        when(fileService.readFileContent("src/main/resources/templates/index.html")).thenThrow(IOException.class);

        String result = recipeWebController.index();

        assertEquals(RecipeWebController.ERROR_MSG, result);
    }


}

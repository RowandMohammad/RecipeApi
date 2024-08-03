package com.identitye2e.recipeservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileServiceTest {

    private FileService fileService;

    private Path tempFilePath;

    @BeforeEach
    void setUp() throws IOException {
        fileService = new FileService();

        tempFilePath = Files.createTempFile("test", ".txt");
        String content = "Test Content";
        Files.write(tempFilePath, content.getBytes(StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFilePath);
    }

    @Test
    void testReadFileContent() throws IOException {

        String actualContent = fileService.readFileContent(tempFilePath.toString());

        assertEquals("Test Content", actualContent);
    }

    @Test
    void testReadFileContentNonExistentFile() {
        String nonExistentFilePath = "/path/that/doesnt/exist.txt";

        assertThrows(IOException.class, () -> fileService.readFileContent(nonExistentFilePath));
    }
}

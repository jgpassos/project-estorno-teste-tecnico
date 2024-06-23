package estornoProject.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileDataWriterTest {
    private static final String TEST_FILE_PATH = "data.json";

    @AfterEach
    public void tearDown() {
        // Clean up test file after each test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void writeFile() {
        String expectedJson = "\"{\\\\\\\"user_id\\\\\\\":1,\\\\\\\"name\\\\\\\":\\\\\\\"Julia Passos\\\\\\\",\\\\\\\"orders\\\\\\\":[{\\\\\\\"order_id\\\\\\\":101,\\\\\\\"total\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"date\\\\\\\":\\\\\\\"2023-06-22\\\\\\\"}]}";
        FileDataWriter jsonFileWriter = new FileDataWriter();

        jsonFileWriter.writeFile(expectedJson, TEST_FILE_PATH);

        File file = new File(TEST_FILE_PATH);
        assertTrue(file.exists());

        StringBuilder actualJson = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualJson.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedJson, actualJson.toString());
    }
}
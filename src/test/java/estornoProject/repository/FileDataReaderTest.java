package estornoProject.repository;

import estornoProject.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileDataReaderTest {
    @TempDir
    Path tempDir;

    @Test
    void readFile() throws IOException {
        FileDataReader fileReader = new FileDataReader();

        File tempFile = File.createTempFile("temp_file", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("0000000015                                   Bonny Koss00000001530000000004        80.820210701");
        writer.newLine();
        writer.close();

        List<User> users = fileReader.readFile(tempFile.getAbsolutePath());
        assertEquals(0, users.size());
    }

    @Test
    void testReadFileLengthInvalid() throws IOException {
        FileDataReader fileDataReader = new FileDataReader();
        File tempFile;
        try {
            tempFile = File.createTempFile("short_line", ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                writer.write("Short line.");

                assertThrows(IllegalArgumentException.class, () -> {
                    fileDataReader.readFile(tempFile.getAbsolutePath());
                });
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create temporary file.", e);
        }
    }

    @Test
    void testReadFileLineLengthValid() throws IOException {
        File validFile = tempDir.resolve("valid.txt").toFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(validFile))) {
            writer.write("0000000023                                  Logan Lynch00000002530000000002      322.1220210523");
            writer.newLine();
            writer.write("0000000015                                   Bonny Koss00000001530000000004        80.820210701");
            writer.newLine();
        }

        FileDataReader fileDataReader = new FileDataReader();
        List<User> users = fileDataReader.readFile(validFile.getAbsolutePath());

        assertNotNull(users);

        assertDoesNotThrow(() -> {
            fileDataReader.readFile(validFile.getAbsolutePath());
        });
    }

    @Test
    void testReadFileEmpty() throws IOException {
        File emptyFile = tempDir.resolve("empty.txt").toFile();
        emptyFile.createNewFile();

        FileDataReader fileDataReader = new FileDataReader();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fileDataReader.readFile(emptyFile.getAbsolutePath());
        });

        assertEquals("The file is empty.", exception.getMessage());
    }
}
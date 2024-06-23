package estornoProject.repository;

import estornoProject.interfaces.FileWriter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileDataWriter implements FileWriter {
    @Override
    public void writeFile(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file" + e);
        }
    }
}

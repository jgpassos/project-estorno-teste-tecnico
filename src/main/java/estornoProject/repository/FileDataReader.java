package estornoProject.repository;

import estornoProject.interfaces.FileReader;
import estornoProject.model.User;
import estornoProject.service.DataNormalizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements FileReader {
    @Override
    public List<User> readFile(String file) {
        List<User> users = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new java.io.FileReader(file))) {
            if(bfr.readLine() == null) {
                throw new IllegalArgumentException("The file is empty.");
            }
            String line;
            while((line = bfr.readLine()) != null) {
                if(line.length() != 95)
                    throw new IllegalArgumentException("Each line must contain 95 characters.");
                User user = DataNormalizer.normalizeData(line);
                users.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

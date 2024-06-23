package estornoProject;

import estornoProject.interfaces.FileWriter;
import estornoProject.interfaces.JsonConverter;
import estornoProject.imps.JsonConverterImp;
import estornoProject.model.User;
import estornoProject.interfaces.FileChooser;
import estornoProject.imps.FileChooserImp;
import estornoProject.repository.FileDataReader;
import estornoProject.interfaces.FileReader;
import estornoProject.repository.FileDataWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileChooser fileChooser = new FileChooserImp();
        String file = fileChooser.chooseFile();

        FileReader fileReader = new FileDataReader();
        List<User> users = fileReader.readFile(file);

        JsonConverter converter = new JsonConverterImp();
        String json = converter.jsonConverter(users);

        FileWriter fileWriter = new FileDataWriter();
        fileWriter.writeFile(json, "data.json");
    }
}

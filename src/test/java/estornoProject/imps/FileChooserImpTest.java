package estornoProject.imps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileChooserImpTest {
    @Test
    void chooseFile() {
        FileChooserImp fileChooser = new FileChooserImp();
        String selectedFile = fileChooser.chooseFile();
        assertNotNull(selectedFile);
        assertTrue(selectedFile.endsWith(".txt"));
    }
}
package estornoProject.imps;

import estornoProject.interfaces.FileChooser;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileChooserImpTest {

    @Test
    void chooseFile() {
        FileChooserImp fileChooser = new FileChooserImp();
        String selectedFile = fileChooser.chooseFile();
        assertNotNull(selectedFile);
        assertTrue(selectedFile.endsWith(".txt"));
    }
}
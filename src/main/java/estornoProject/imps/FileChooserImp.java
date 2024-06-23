package estornoProject.imps;

import estornoProject.interfaces.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserImp implements FileChooser {
    @Override
    public String chooseFile() {
        JFileChooser fileChooser = new JFileChooser();  // Allows the user to choose the file.
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if(result != JFileChooser.APPROVE_OPTION) {
            return null;
        } else {
            String file = fileChooser.getSelectedFile().getAbsolutePath();
            if(file.endsWith(".txt"))
                return file;
            else
                throw new IllegalArgumentException("Invalid file type selected.");
        }
    }
}

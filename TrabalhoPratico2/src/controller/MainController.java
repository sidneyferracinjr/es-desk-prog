package controller;

import java.io.File;
import java.io.IOException;

import config.Config;
import utils.FileUtils;
import view.MainView;

/**
 *
 * @author sidneyferracinjr
 */
public class MainController {
    
    private final MainView mainView;
    private final Config config = Config.getInstance();
    private String directoryPath = config.getProperty("directoryPath");

    public MainController(MainView mainView) {
        this.mainView = mainView;
        this.directoryPath = config.getProperty("directoryPath");
    }
    
    public String selectDirectory(String directoryPath) throws IOException {
        if (directoryPath == null || directoryPath.isBlank()) {
            return this.directoryPath = FileUtils.selectDirectory();
        } 

        return directoryPath;
    }
    
    public String describeDirectory(String selectedDirectory) throws IOException {
        if (new File(selectedDirectory).isDirectory()) {
            return FileUtils.describeDirectory(selectedDirectory);
        } else {
            mainView.showMessage(null, "O caminho da pasta não pode ser vazio.", "Aviso", 1);
        }
        return FileUtils.describeDirectory(selectedDirectory);
    }

}

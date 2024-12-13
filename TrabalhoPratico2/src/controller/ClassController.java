package controller;

import config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ClassModel;
import utils.FileUtils;
import view.ClassView;

/**
 *
 * @author
 */
public class ClassController {

    private List<ClassModel> classes = new ArrayList<>();
    private ClassView classView;
    private Config config = Config.getInstance();
    private String directoryPath = config.getProperty("directoryPath");
    private String namePath = config.getProperty("namePath");
    private final String classFile = config.getProperty("studentFile");

    public ClassController() {
    
    }

    public ClassController(String directoryPath, ClassView studentView) {
        this.classView = studentView;
        if (!directoryPath.isBlank()) {
            this.directoryPath = directoryPath;
        }
    }

    public boolean openFile() {
        try {
            Object data = FileUtils.readObjectFromFile(directoryPath, namePath, classFile);
            if (data instanceof List) {
                classes = (List<ClassModel>) data;
                return true;
            }
        } catch (IOException | ClassNotFoundException e) {
            classView.showMessage(null, "Erro ao abrir arquivo: " + e.getMessage(), "Erro", 0);
        }
        return false;
    }

    public boolean saveFile() throws IOException {
        try {
            FileUtils.writeObjectToFile(classes, directoryPath, namePath, classFile, true);
            classView.showMessage(null, "Arquivo salvo com sucesso em: " + directoryPath, "Sucesso", 1);
            return true;
        } catch (IOException e) {
            throw new IOException("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public boolean saveFileHow() {
        try {
            String newDirectoryPath = FileUtils.selectDirectory();
            if (newDirectoryPath != null) {
                FileUtils.writeObjectToFile(classes, newDirectoryPath, namePath, classFile, true);
                classView.showMessage(null, "Arquivo salvo como em: " + newDirectoryPath, "Sucesso", 1);
                return true;
            }
        } catch (IOException e) {
            classView.showMessage(null, "Erro ao salvar como: " + e.getMessage(), "Erro", 0);
        }
        return false;
    }

    public boolean createClass(String name, String studentClass, Object registration) {
        try {
            int registrationNumber = Integer.parseInt(registration.toString());
            ClassModel newStudent = new ClassModel(registrationNumber, name, studentClass);
            classes.add(newStudent);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean readClass(int registration) {
        for (ClassModel student : classes) {
            if (student.getCodigo()== registration) {
                classView.showMessage(null, "Aluno encontrado: " + student, "Sucesso", 1);
                return true;
            }
        }
        return false;
    }

    public boolean updateClass(int registration, String newName, String newTurma) {
        for (ClassModel student : classes) {
            if (student.getCodigo()== registration) {
                student.setNome(newName);
                student.setAlunos(newTurma);
                return true;
            }
        }
        return false;
    }

    public boolean deleteClass(int registration) {
        for (ClassModel student : classes) {
            if (student.getCodigo()== registration) {
                classes.remove(student);
                return true;
            }
        }
        return false;
    }

    public List<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassModel> students) {
        this.classes = students;
    }
}

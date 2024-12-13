package controller;

import config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.StudentModel;
import utils.FileUtils;
import view.StudentView;

/**
 *
 * @author
 */
public class StudentController {

    private List<StudentModel> students = new ArrayList<>();
    private StudentView studentView;
    private Config config = Config.getInstance();
    private String directoryPath = config.getProperty("directoryPath");
    private String namePath = config.getProperty("namePath");
    private final String studentFile = config.getProperty("studentFile");

    public StudentController() {
    
    }

    public StudentController(String directoryPath, StudentView studentView) {
        this.studentView = studentView;
        if (!directoryPath.isBlank()) {
            this.directoryPath = directoryPath;
        }
    }

    public boolean openFile() {
        try {
            Object data = FileUtils.readObjectFromFile(directoryPath, namePath, studentFile);
            if (data instanceof List) {
                students = (List<StudentModel>) data;
                return true;
            }
        } catch (IOException | ClassNotFoundException e) {
            studentView.showMessage(null, "Erro ao abrir arquivo: " + e.getMessage(), "Erro", 0);
        }
        return false;
    }

    public boolean saveFile() throws IOException {
        try {
            FileUtils.writeObjectToFile(students, directoryPath, namePath, studentFile, true);
            studentView.showMessage(null, "Arquivo salvo com sucesso em: " + directoryPath, "Sucesso", 1);
            return true;
        } catch (IOException e) {
            throw new IOException("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public boolean saveFileHow() {
        try {
            String newDirectoryPath = FileUtils.selectDirectory();
            if (newDirectoryPath != null) {
                FileUtils.writeObjectToFile(students, newDirectoryPath, namePath, studentFile, true);
                studentView.showMessage(null, "Arquivo salvo como em: " + newDirectoryPath, "Sucesso", 1);
                return true;
            }
        } catch (IOException e) {
            studentView.showMessage(null, "Erro ao salvar como: " + e.getMessage(), "Erro", 0);
        }
        return false;
    }

    public boolean createStudent(String name, String studentClass, Object registration) {
        try {
            int registrationNumber = Integer.parseInt(registration.toString());
            StudentModel newStudent = new StudentModel(name, studentClass, registrationNumber);
            students.add(newStudent);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean readStudent(int registration) {
        for (StudentModel student : students) {
            if (student.getMatricula() == registration) {
                studentView.showMessage(null, "Aluno encontrado: " + student, "Sucesso", 1);
                return true;
            }
        }
        return false;
    }

    public boolean updateStudent(int registration, String newName, String newTurma) {
        for (StudentModel student : students) {
            if (student.getMatricula() == registration) {
                student.setNome(newName);
                student.setTurma(newTurma);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int registration) {
        for (StudentModel student : students) {
            if (student.getMatricula() == registration) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }
}

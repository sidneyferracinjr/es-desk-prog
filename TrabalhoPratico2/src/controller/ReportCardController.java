package controller;

import config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ReportCardModel;
import utils.FileUtils;
import view.ReportCardView;

/**
 *
 * @author
 */
public class ReportCardController {

    private List<ReportCardModel> students = new ArrayList<>();
    private ReportCardView studentView;
    private Config config = Config.getInstance();
    private String directoryPath = config.getProperty("directoryPath");
    private String namePath = config.getProperty("namePath");
    private final String studentFile = config.getProperty("studentFile");

    public ReportCardController() {
    
    }

    public ReportCardController(String directoryPath, ReportCardView studentView) {
        this.studentView = studentView;
        if (!directoryPath.isBlank()) {
            this.directoryPath = directoryPath;
        }
    }

    public boolean openFile() {
        try {
            Object data = FileUtils.readObjectFromFile(directoryPath, namePath, studentFile);
            if (data instanceof List) {
                students = (List<ReportCardModel>) data;
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

    public boolean createReportCard(String name, String studentClass, Object registration) {
        try {
            int registrationNumber = Integer.parseInt(registration.toString());
            ReportCardModel newStudent = new ReportCardModel(registrationNumber, name, studentClass);
            students.add(newStudent);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean readReportCard(int registration) {
        for (ReportCardModel student : students) {
            if (student.getIdBoletim()== registration) {
                studentView.showMessage(null, "Aluno encontrado: " + student, "Sucesso", 1);
                return true;
            }
        }
        return false;
    }

    public boolean updateReportCard(int registration, String newName, String newTurma) {
        for (ReportCardModel student : students) {
            if (student.getIdBoletim()== registration) {
                student.setAluno(newName);
                student.setMedia(newTurma);
                return true;
            }
        }
        return false;
    }

    public boolean deleteReportCard(int registration) {
        for (ReportCardModel student : students) {
            if (student.getIdBoletim()== registration) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public List<ReportCardModel> getReportCards() {
        return students;
    }

    public void setReportCard(List<ReportCardModel> students) {
        this.students = students;
    }
}

package utils;

import config.Config;
import java.io.*;
import javax.swing.JFileChooser;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileUtils {
    
    private static final Config config = Config.getInstance();

    private FileUtils() {
        
    }

    public static String createDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath, config.getProperty("namePath"));
        
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Não foi possível criar o diretório: " + directoryPath);
        }
        
        return directory.getAbsolutePath();
    }

    public static String selectDirectory() {
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ? 
                                               chooser.getSelectedFile().getPath() : 
                                               null;
    }
   
    public static void createFile(String directoryPath, String namePath, String fileName) throws IOException {
        File directory = new File(directoryPath, namePath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Não foi possível criar o diretório: " + directory.getAbsolutePath());
            }
        }

        File file = new File(directory, fileName);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Não foi possível criar o arquivo: " + file.getAbsolutePath());
            }
        }
    }
    
    public static String selectFileBin() {
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileFilter(new FileNameExtensionFilter("Arquivos BIN", "bin"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ? 
                                               chooser.getSelectedFile().getPath() : 
                                               null;
    }

    public static void writeObjectToFile(Object obj, String directoryPath, String namePath, String fileName, boolean overwrite) throws IOException {
        File directory = new File(directoryPath, namePath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Não foi possível criar o diretório: " + directory.getAbsolutePath());
            }
        }

        File file = new File(directory, fileName);
        if (file.exists() && !overwrite) {
            throw new IOException("O arquivo já existe e 'overwrite' está definido como falso: " + file.getAbsolutePath());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
        }
    }
    
    public static Object readObjectFromFile(String directoryPath, String namePath, String fileName) throws IOException, ClassNotFoundException {
        File file = new File(directoryPath, namePath + File.separator + fileName);

        if (!file.exists()) {
            throw new IOException("Arquivo não encontrado: " + file.getAbsolutePath());
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        }
    }

    public static String describeDirectory(String directoryPath) throws IOException {
        File file = new File(directoryPath);
        return String.format("Nome: %s\nTipo: %s\nLocal: %s\nTamanho: %d bytes\nCriado em: %s",
                             file.getName(), 
                             getDirectoryExtension(directoryPath), 
                             file.getAbsolutePath(), 
                             getDirectorySize(directoryPath), 
                             getCreatedIn(directoryPath)
        );
    }

    public static long getDirectorySize(String directoryPath) throws IOException {
        File file = new File(directoryPath);
        if (!file.exists()) {
            throw new IOException("O diretório não existe: " + directoryPath);
        }
        return file.length();
    }

    public static String getDirectoryExtension(String directoryPath) {
        return (
            directoryPath == null || directoryPath.lastIndexOf('.') == -1) ?
            "Pasta de arquivos" : 
            directoryPath.substring(directoryPath.lastIndexOf('.') + 1
        );
    }

    public static String getCreatedIn(String directoryPath) {
        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get(directoryPath), 
                                                            BasicFileAttributes.class
            );
            return LocalDateTime.ofInstant(attr.creationTime().toInstant(), 
                                           ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        } catch (IOException e) {
            return "Erro ao obter a data de criação";
        }
    }
}

package utils;

import java.io.*;
import javax.swing.JFileChooser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.Config;

public class FileUtils {

    private static FileUtils fileUtils;

    public static synchronized FileUtils getInstance() {
        if (fileUtils == null) {
            fileUtils = new FileUtils();
        }
        return fileUtils;
    }

    // Leitura de Arquivo Binário ------------------------------------------- //

    // Lê dados de um arquivo binário e retorna um objeto
    public static Object readObjectFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        }
    }
    
    // Escrita de Arquivo Binário ------------------------------------------- //
    
    // Grava um objeto em um arquivo binário
    public static void writeObjectToFile(Object obj, String filePath) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
        }
    }
    
    // Manipulação de Arquivos e Diretórios --------------------------------- //
    
    // Cria um arquivo binário vazio
    public static void createFile(String filePath, String fileName) throws IOException {
        File file = new File(filePath, fileName);
        if (!file.exists()) {
            boolean isCreated = file.createNewFile();
            if (!isCreated) {
                throw new IOException("Não foi possível criar o arquivo: " + fileName);
            }
        } else {
            throw new IOException("O arquivo já existe: " + fileName);
        }
    }

    // Cria um diretório (se não existir)
    public static void createDirectory(String dirPath) throws IOException {
        File directory = new File(dirPath);
        if (!directory.exists()) {
            boolean isCreated = directory.mkdirs();
            if (!isCreated) {
                throw new IOException("Não foi possível criar o diretório: " + dirPath);
            }
        }
    }
    
    // Abre um JFileChooser para selecionar um arquivo e retorna o caminho do arquivo selecionado
    public static String selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de Texto", "txt", "text"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }
    }
    
    // Informações sobre Arquivos ------------------------------------------- //
    
    // Método para descrever um arquivo ou diretório
    public static String describeDiretory(String filePath) throws IOException {
        File file = new File(filePath);

        String descricaoDiretorio = "Nome: " + file.getName() +
                                    "Tipo: " + getFileExtension(filePath) +
                                    "Local: " + file.getAbsolutePath() +
                                    "Tamanho: " + getFileSize(filePath) + " bytes" +
                                    "Criado em: " + getCreatedIn(filePath);
        
        return descricaoDiretorio;
    }
    
    // Método Auxiliares ---------------------------------------------------- //

    // Retorna o tamanho de um arquivo em bytes
    public static long getFileSize(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("O arquivo não existe: " + filePath);
        }
        return file.length();
    }

    // Retorna a extensão de um arquivo
    public static String getFileExtension(String filePath) {
        if (filePath == null || filePath.lastIndexOf('.') == -1) {
            return "";
        }
        int lastIndex = filePath.lastIndexOf('.');
        return filePath.substring(lastIndex + 1);
    }

    // Retorna quando o arquivo foi criado
    public static String getCreatedIn(String filePath) {
        try {
            Path path = Paths.get(filePath);
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            LocalDateTime creationTime = LocalDateTime.ofInstant(attr.creationTime().toInstant(), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return creationTime.format(formatter);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao obter a data de criação";
        }
    }
    
}
package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    
    private static Config instance;
    private Properties properties;

    private Config() {
        properties = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IllegalArgumentException("Arquivo config.properties nao encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar config.properties", e);
        }
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Config to edit this template
 */
package config;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sidneyferracinjr
 */
public class Config {
    private static Properties properties;
    private static Config config;
    
    private Config() {
        try {
            if (properties == null) {
                properties = new Properties();
                InputStream inputStream = this.getClass().getResourceAsStream("config.properties");
                properties.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

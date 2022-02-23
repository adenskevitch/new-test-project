package com.solvd.newtestproject.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigService {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final HashMap<String, String> properties = new HashMap<>();

    private static ConfigService instance;

    private ConfigService() {
    }

    public static String getProperty(String key) {
        return properties.get(key);
    }

    public static void initInstance() {
        if (instance == null) {
            instance = new ConfigService();
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            Properties PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
            PROPERTIES.keySet()
                    .forEach(key -> properties.put((String) key, PROPERTIES.getProperty((String) key)));
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    LOGGER.debug(e.getMessage());
                }
            }
        }
    }
}

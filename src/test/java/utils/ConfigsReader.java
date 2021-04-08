package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    /**
     * This method reads any given properties file
     *
     * @param filePath
     * @return Properties
     */

    static Properties properties;

    public static Properties readProperties(String filePath) {

        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

    /**
     * This method retrieves a single value depending on the specified key
     * @param key
     * @return String
     */
    public static String retrieveValue(String key) {
        return properties.getProperty(key);
    }



}


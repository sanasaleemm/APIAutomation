package com.exe.api.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigManager {

    private static ConfigManager manager;
    private static final Properties prop = new Properties();

    // reading the config.properties file here
    private ConfigManager() throws IOException {

        //  FileInputStream f = new FileInputStream("resources/config.properties");
        InputStream inputStream= ConfigManager.class. getClassLoader().getResourceAsStream( "config.properties");
        prop.load(inputStream);
    }
    public static  ConfigManager getInstance() throws IOException {
        // checking manager is null only then (one) object should be created for this config manager (and not multiple objects)
        // only one thread should be able to access it
        if (manager== null) {

            synchronized (ConfigManager.class) {

                manager = new ConfigManager();
            }
        }


        return manager;

    }
    public String getString (String key)
    {

        return System.getProperty(key, prop.getProperty(key));
    }

}

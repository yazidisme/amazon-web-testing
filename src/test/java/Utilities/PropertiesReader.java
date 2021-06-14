package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String getValue(String key) throws Exception {

        File file = new File("./config.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public Long getTimeout() throws Exception {

        String timeout = PropertiesReader.getValue("timeout");
        return Long.parseLong(timeout);
    }
}

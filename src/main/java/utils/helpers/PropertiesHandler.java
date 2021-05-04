package utils.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    private static Properties properties;
    public static String baseUri;

    public Properties init(){

        String env = System.getProperty("env");
        if (this.properties == null){
        properties = new Properties();
        try {
            properties.load(PropertiesHandler.class.getClassLoader().getResourceAsStream(env + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }}
        return properties;
    }

    public static String getProperty(String name){
        return properties.getProperty(name);
    }

}

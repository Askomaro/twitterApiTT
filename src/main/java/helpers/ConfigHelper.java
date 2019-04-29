package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import java.io.InputStream;

public class ConfigHelper {
    private final Properties prop;
    InputStream inputStream;

    public ConfigHelper() throws IOException {
        prop = new Properties();
        String propFileName = "twitter4j.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
    }

    public String getProperty(String key){
        return prop.getProperty(key);
    }

    public String getTwitterLogin(){
        String loginBase64 = getProperty("login");
        byte[] decodedBytes = Base64.getDecoder().decode(loginBase64);

        return new String(decodedBytes);
    }

    public String getTwitterPassword(){
        String loginBase64 = getProperty("password");
        byte[] decodedBytes = Base64.getDecoder().decode(loginBase64);

        return new String(decodedBytes);
    }
}

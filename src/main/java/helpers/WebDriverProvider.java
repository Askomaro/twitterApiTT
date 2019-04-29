package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class WebDriverProvider {
    public WebDriver get() {
        // Depends on config or other conditions method should provide corresponded WebDriver
        // (e.g. ChromeDriver for this example)
        URL res = getClass().getClassLoader().getResource("chromedriver");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        return new ChromeDriver();
    }
}

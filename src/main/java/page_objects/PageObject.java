package page_objects;

import helpers.ConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public abstract class PageObject {
    ConfigHelper config;
    WebDriver driver;

    PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            config = new ConfigHelper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void refresh(){
        driver.navigate().refresh();
    }
}

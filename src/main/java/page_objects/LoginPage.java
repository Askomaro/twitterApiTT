package page_objects;

import helpers.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URISyntaxException;

public class LoginPage extends PageObject {
    private String twitterUrl = "https://twitter.com/login";

    @FindBy(className="js-username-field")
    private WebElement usernameEl;

    @FindBy(className="js-password-field")
    private WebElement passwordEl;

    @FindBy(xpath="//button[contains(@class, 'submit')]")
    private WebElement submitButtonEl;

    public LoginPage() {
        super(new WebDriverProvider().get());
        driver.get(twitterUrl);
    }

    public MainPage logIn(String username, String password){
        return LogIntoTwitter(username, password);
    }

    public MainPage logIn(){
        return LogIntoTwitter(config.getTwitterLogin(), config.getTwitterPassword());
    }

    private MainPage LogIntoTwitter(String username, String password){
        usernameEl.sendKeys(username);
        passwordEl.sendKeys(password);
        submitButtonEl.click();

        return new MainPage(driver);
    }
}

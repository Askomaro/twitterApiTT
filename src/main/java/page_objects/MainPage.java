package page_objects;

import models.TweetInfoModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(className="stream")
    private WebElement streamEl;

    MainPage(WebDriver driver) {
        super(driver);
    }

    public TweetInfoModel getTweetInformation(long tweetId){
        WebElement tweetEl = streamEl
                .findElement(By.xpath(String.format("//li[@data-item-id='%s']", tweetId)));

        String text = tweetEl.findElement(By.className("js-tweet-text-container")).getText();
        String dateInMs = tweetEl.findElement(By.xpath("//span[contains(@class, '_timestamp')]"))
                .getAttribute("data-time-ms");
        String retweetCount = tweetEl
                .findElement(By.xpath("//span[contains(@class, 'ProfileTweet-actionCountForPresentation')]"))
                .getText();

        return new TweetInfoModel(
                text,
                Long.parseLong(dateInMs),
                Integer.parseInt(retweetCount.equals("") ? "0": retweetCount));
    }
}

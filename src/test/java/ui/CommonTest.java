package ui;

import api.TwitterApi;
import models.TweetInfoModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import page_objects.LoginPage;
import page_objects.MainPage;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommonTest {
    private TwitterApi twitterApi;
    private LoginPage loginPage;

    @BeforeAll
    void SetUp() throws TwitterException {
        twitterApi = new TwitterApi();
    }

    @Test
    void functionalTestBasedOnApi() throws TwitterException {
        String statusText = "test";
        Status createdStatus = twitterApi.createStatus(statusText);

        loginPage = new LoginPage();
        MainPage mainPage = loginPage.logIn();

        TweetInfoModel tweetInfo = mainPage.getTweetInformation(createdStatus.getId());

        assertEquals(statusText, tweetInfo.getText());
        assertTrue(new Date().getTime() - tweetInfo.getDate() < 10000);
        assertEquals(0, tweetInfo.retweetCount());

        twitterApi.destroyStatus(createdStatus.getId());
        mainPage.refresh();

        assertThrows(NoSuchElementException.class,
                () -> mainPage.getTweetInformation(createdStatus.getId()));
    }

    @AfterAll
    void TearDown() {
        loginPage.closeBrowser();
    }
}

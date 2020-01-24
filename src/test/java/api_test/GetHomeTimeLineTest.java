package api_test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import api.TwitterApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetHomeTimeLineTest {
    private List<Status> statuses;

    @BeforeAll
    void setUp() throws TwitterException{
        TwitterApi twitterApi = new TwitterApi();
        statuses = twitterApi.getHomeTimeLine();
    }

    @Test
    void checkCreatedAtDateIsBeforeCurrentDate() {
        for (Status status : statuses) {

            assertTrue(status.getCreatedAt().compareTo(new Date()) < 0,
                    "Wrong created date found ${status.getCreatedAt()}");
        }
    }

    @Test
    void checkRetweetCountValueIsNotNegativeNumber(){
        for (Status status : statuses) {

            assertTrue(status.getRetweetCount() >= 0,
                    "RetweetCount is less than 0");
        }
    }

    @Test
    void checkTweetTextIsNotEmpty(){
        for (Status status : statuses) {

            assertTrue(!status.getText().equals(""),
                    "Tweet text is empty");
        }
    }
}

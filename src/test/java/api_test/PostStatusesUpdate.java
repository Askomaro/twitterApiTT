package api_test;

import api.TwitterApi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import twitter4j.Status;
import twitter4j.TwitterException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostStatusesUpdate {
    private TwitterApi twitterApi;
    private Status status;
    private String statusText = "test";

    @BeforeAll
    void SetUp() throws TwitterException {
        twitterApi = new TwitterApi();
        status = twitterApi.createStatus(statusText);
    }

    @Test
    void CheckStatusText() throws TwitterException{
        String result = twitterApi.getStatus(status.getId()).getText();
        assertEquals(statusText, result);
    }

    @Test
    void TweetDuplicationCauses403Error() {
        TwitterException thrown =
                assertThrows(TwitterException.class,
                        () -> twitterApi.createStatus(statusText),
                        "Expected createStatus() to throw 403, but it didn't");

        assertTrue(thrown.getMessage().contains("Status is a duplicate"));
        assertEquals(thrown.getStatusCode(), 403);
    }

    @AfterAll
    void TearDown() throws TwitterException{
        twitterApi.destroyStatus(status.getId());
    }
}

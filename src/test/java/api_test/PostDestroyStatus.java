package api_test;

import api.TwitterApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import twitter4j.Status;
import twitter4j.TwitterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostDestroyStatus {
    @Test
    void CheckStatusIsDeleted() throws TwitterException {
        // arrange
        TwitterApi twitterApi = new TwitterApi();
        long statusId = twitterApi.createStatus("test").getId();

        // act
        twitterApi.destroyStatus(statusId);

        // assert
        TwitterException thrown =
                assertThrows(TwitterException.class,
                        () -> twitterApi.getStatus(statusId));

        assertTrue(thrown.getMessage().contains("No status found with that ID"));
        assertEquals(thrown.getStatusCode(), 404);
    }
}

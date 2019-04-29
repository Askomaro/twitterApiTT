package api;

import twitter4j.*;

import java.util.List;

public class TwitterApi {
    private Twitter twitter;

    public TwitterApi() throws TwitterException{
        // gets Twitter instance with default credentials
        twitter = new TwitterFactory().getInstance();
        twitter.verifyCredentials();
    }

    public List<Status> getHomeTimeLine() throws TwitterException{
        return twitter.getHomeTimeline();
    }

    public Status destroyStatus(long id) throws TwitterException{
        return twitter.destroyStatus(id);
    }

    public Status createStatus(String statusValue) throws TwitterException {
        return twitter.updateStatus(statusValue);
    }

    public Status getStatus(long id) throws TwitterException{
        return twitter.showStatus(id);
    }
}

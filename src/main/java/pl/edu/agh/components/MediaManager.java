package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lmarek on 16.03.16.
 */
@Component
public class MediaManager {

    public MediaFeedData getMediaInfo(Token token, String mediaId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getMediaInfo(mediaId).getData();
    }

    public List<MediaFeedData> searchForMediaInArea(Token token, double latitude, double longitude) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.searchMedia(latitude,longitude).getData();
    }
}

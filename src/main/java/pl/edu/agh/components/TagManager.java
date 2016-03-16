package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lmarek on 16.03.16.
 */
@Component
public class TagManager {

    public TagInfoData getInfoAboutTag(Token token, String tagName) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getTagInfo(tagName).getTagInfo();
    }

    public List<MediaFeedData> getRecentlyTaggedMedia(Token token, String tagName) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getRecentMediaTags(tagName).getData();
    }

    public List<TagInfoData> searchForTagsByName(Token token, String tagName) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.searchTags(tagName).getTagList();
    }
}

package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.common.User;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lmarek on 16.03.16.
 */
@Component
public class LikeManager {

    public List<User> getMediaLikes(Token token, String mediaId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserLikes(mediaId).getUserList();
    }

    public void setLikeOnMedia(Token token, String mediaId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        instagram.setUserLike(mediaId);
    }

    public void removeLikeFromMedia(Token token, String mediaId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        instagram.deleteUserLike(mediaId);
    }
}

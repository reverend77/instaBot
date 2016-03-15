package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Stateless user-endpoints API manager.
 * Created by lmarek on 15.03.16.
 */
@Component
public class UserManager {

    public UserInfoData getUserInfo(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getCurrentUserInfo().getData();
    }

    public UserInfoData getUserinfo(Token token, String userId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserInfo(userId).getData();
    }

    public List<MediaFeedData> getRecentMediaFromUser(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserRecentMedia().getData();
    }

    public List<MediaFeedData> getRecentMediaFromUser(Token token, String userId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getRecentMediaFeed(userId).getData();
    }

    public List<MediaFeedData> getRecentlyLikedByUser(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserLikedMediaFeed().getData();
    }
    public List<UserFeedData> searchForUserByName(Token token,String name) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.searchUser(name).getUserList();
    }
}

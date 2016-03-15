package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.relationships.RelationshipData;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.model.Relationship;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Stateless.
 * Created by lmarek on 15.03.16.
 */
@Component
public class RelationshipManager {
    /**
     * @param token
     * @return Users current user follows.
     * @throws InstagramException
     */
    public List<UserFeedData> getUserFollowers(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserFollowList(instagram.getCurrentUserInfo().getData().getId()).getUserList();
    }

    public List<UserFeedData> getUserFollowers(Token token, String userId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserFollowList(userId).getUserList();
    }

    /**
     * @param token
     * @return Users this user is followed by.
     */
    public List<UserFeedData> getUserFollowedBy(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserFollowedByList(instagram.getCurrentUserInfo().getData().getId()).getUserList();
    }

    public List<UserFeedData> getUserFollowedBy(Token token, String userId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserFollowedByList(userId).getUserList();
    }

    public List<UserFeedData> getFollowerRequests(Token token) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserRequestedBy().getUserList();
    }

    public RelationshipData getRelationshipData(Token token, String userId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getUserRelationship(userId).getData();
    }

    /**
     * Has side effects- modifies the relationship with user specified by userId.
     * @param token
     * @param userId
     * @param newRelationship
     * @throws InstagramException
     */
    public void modifyRelationship(Token token, String userId, Relationship newRelationship) throws InstagramException {
        Instagram instagram = new Instagram(token);
        instagram.setUserRelationship(userId,newRelationship);
    }
}


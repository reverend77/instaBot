package pl.edu.agh.ai;

import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.model.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.edu.agh.components.MediaManager;
import pl.edu.agh.components.RelationshipManager;
import pl.edu.agh.components.TagManager;
import pl.edu.agh.components.TokenContainer;

/**
 * Created by lmarek on 17.03.16.
 */
@Component
public class FollowForFollowBot {

    @Autowired
    protected RelationshipManager rm;

    @Autowired
    protected TokenContainer tc;

    @Autowired
    protected MediaManager mm;

    @Autowired
    protected TagManager tm;
    @Scheduled(fixedDelay = 120000)
    public void approveFollowers(){
        try {
            rm.getFollowerRequests(tc.getToken())
                    .stream().map(user -> user.getId())
                    .forEach(id -> {
                        try {
                            rm.modifyRelationship(tc.getToken(), id, Relationship.APPROVE);
                            Thread.sleep(1000);
                        } catch (InstagramException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (InstagramException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 240000)
    public void lookForFriends(){
        try {
            tm.getRecentlyTaggedMedia(tc.getToken(), "computerscience")
                    .stream()
                    .map(x -> x.getUser().getId())
                    .forEach(x -> {
                        try {
                            rm.modifyRelationship(tc.getToken(), x, Relationship.FOLLOW);
                        } catch (InstagramException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (InstagramException e) {
            e.printStackTrace();
        };
    }
}

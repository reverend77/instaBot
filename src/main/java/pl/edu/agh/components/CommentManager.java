package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.comments.CommentData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lmarek on 16.03.16.
 */
@Component
public class CommentManager {

    public List<CommentData> getCommentsOnMedia(Token token, String mediaId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getMediaComments(mediaId).getCommentDataList();
    }

    public CommentData addComment(Token token, String mediaId, String text) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.setMediaComments(mediaId,text).getCommentData();
    }

    public void removeComment(Token token, String mediaId, String commentId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        instagram.deleteMediaCommentById(mediaId, commentId);
    }
}

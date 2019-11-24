package animation_recommend_backend.service;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;

import java.util.List;

public interface CommentService {
    ResponseBox comment(String comment, String animationName, String username);

    List<Comment> getMyComments(String username,String animationName);

    ResponseBox deleteOneComment(String username,String animationName);

    List<Comment> getAllComments(String animationName);
}

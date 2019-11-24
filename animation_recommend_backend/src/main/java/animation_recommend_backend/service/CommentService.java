package animation_recommend_backend.service;

import animation_recommend_backend.entity.Comment;

import java.util.List;

public interface CommentService {
    Boolean comment(String comment,String animationName,String username);

    List<Comment> getMyComments(String username,String animationName);

    Boolean deleteOneComment(String username,String animationName);

    List<Comment> getAllComments(String animationName);
}

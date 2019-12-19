package animation_recommend_backend.service;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    ResponseBox comment(String comment, String animationName, String username);

    ResponseBox modifyComment(String username, String oldComment, String newComment, String animationName);

    List<Comment> getMyComments(String username, String animationName);

    ResponseBox deleteOneComment(String comment, String username, String animationName);

    List<Comment> getAllComments(String animationName);

    Page<Comment> getAllCommentsByAnimationNameAndPageable(String animationName, Pageable pageable);


}

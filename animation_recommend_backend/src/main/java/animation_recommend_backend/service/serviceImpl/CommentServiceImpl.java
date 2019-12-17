package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.repository.CommentRepository;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AnimationRepository animationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseBox comment(String comment, String animationName, String username) {
        if (commentRepository.existsCommentByCommentAndAnimation_NameAndUser_Name(comment, animationName, username))
            return new ResponseBox(false, "不可以重复发布评论");
        Comment commentObject = new Comment();
        Animation animation = animationRepository.getAnimationByName(animationName);
        if (animation == null)
            return new ResponseBox(false, "没有动画");
        commentObject.setAnimation(animation);
        User user = userRepository.getUserByName(username);
        if (user == null)
            return new ResponseBox(false, "没有用户");
        commentObject.setUser(user);
        commentObject.setComment(comment);
        commentRepository.save(commentObject);
        return new ResponseBox(true, "");
    }

    @Override
    public List<Comment> getMyComments(String username, String animationName) {
        return commentRepository.getCommentsByUser_NameAndAnimation_Name(username, animationName);
    }

    @Override
    public ResponseBox deleteOneComment(String comment, String username, String animationName) {
        commentRepository.deleteCommentByCommentAndUser_NameAndAnimation_Name(comment, username, animationName);
        return new ResponseBox(true, "");
    }

    @Override
    public List<Comment> getAllComments(String animationName) {
        return commentRepository.getCommentsByAnimation_Name(animationName);
    }
}

package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.repository.CommentRepository;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Boolean comment(String comment, String animationName, String username) {
        return null;
    }

    @Override
    public List<Comment> getMyComments(String username, String animationName) {
        return null;
    }

    @Override
    public Boolean deleteOneComment(String username, String animationName) {
        return null;
    }

    @Override
    public List<Comment> getAllComments(String animationName) {
        return null;
    }
}

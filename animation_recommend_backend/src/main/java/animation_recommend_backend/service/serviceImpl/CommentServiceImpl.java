package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.repository.CommentRepository;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
}

package animation_recommend_backend.controller;

import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class CommentController {
    @Autowired
    private CommentService commentService;
}

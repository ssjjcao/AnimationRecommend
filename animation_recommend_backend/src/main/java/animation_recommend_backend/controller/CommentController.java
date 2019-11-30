package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "comment")
    public @ResponseBody
    ResponseBox comment(@RequestParam String username, @RequestParam String comment, @RequestParam String animationName) {
        return commentService.comment(comment, animationName, username);
    }

    @GetMapping(path = "getMyComments")
    public @ResponseBody
    List<Comment> getMyComments(@RequestParam String username, @RequestParam String animationName) {
        return commentService.getMyComments(username, animationName);
    }

    @PostMapping(path = "deleteOneComment")
    public @ResponseBody
    ResponseBox deleteOneComment(@RequestParam String username, @RequestParam String animationName) {
        return commentService.deleteOneComment(username, animationName);
    }

    @GetMapping(path = "getAllComments")
    public @ResponseBody
    List<Comment> getAllComments(@RequestParam String animationName) {
        return commentService.getAllComments(animationName);
    }
}

package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "comment")
    public @ResponseBody
    ResponseBox comment(@RequestParam String comment, @RequestParam String animationName, @RequestParam String username) {
        return null;
    }

    @GetMapping(path = "getMyComments")
    public @ResponseBody
    List<Comment> getMyComments(@RequestParam String username, @RequestParam String animationName) {
        return new ArrayList<>();
    }

    @PostMapping(path = "deleteOneComment")
    public @ResponseBody
    Boolean deleteOneComment( @RequestParam String username,@RequestParam String animationName){
        return false;
    }

    @GetMapping(path = "getAllComments")
    public @ResponseBody
    List<Comment> getAllComments(@RequestParam String animationName) {
        return new ArrayList<>();
    }
}

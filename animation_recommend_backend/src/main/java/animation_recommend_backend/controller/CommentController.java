package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.CommentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path ="commentAnimation")
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
    ResponseBox deleteOneComment(@RequestParam String comment, @RequestParam String username, @RequestParam String animationName) {
        return commentService.deleteOneComment(comment, username, animationName);
    }

    @GetMapping(path = "getAllComments")
    public @ResponseBody
    JSON getAllComments(@RequestParam String animationName) {
        List<Comment> comments = commentService.getAllComments(animationName);
        JSONArray result = new JSONArray();
        for (Comment comment : comments) {
            JSONObject comment_json = new JSONObject();
            comment_json.put("comment", comment);
            comment_json.put("username", comment.getUser().getName());
            result.add(comment_json);
        }
        return result;
    }
}

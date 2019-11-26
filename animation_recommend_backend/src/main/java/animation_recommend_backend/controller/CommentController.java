package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.CookieCache;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "comment")
    public @ResponseBody
    ResponseBox comment(@CookieValue(value = "user",defaultValue = "")Cookie cookie, @RequestParam String comment, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return commentService.comment(comment, animationName, responseBox.getMessage());
        else return responseBox;
    }

    @GetMapping(path = "getMyComments")
    public @ResponseBody
    List<Comment> getMyComments(@CookieValue(value = "user",defaultValue = "")Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return commentService.getMyComments(responseBox.getMessage(),animationName);
        else return null;
    }

    @PostMapping(path = "deleteOneComment")
    public @ResponseBody
    ResponseBox deleteOneComment( @CookieValue(value = "user",defaultValue = "")Cookie cookie,@RequestParam String animationName){
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return commentService.deleteOneComment(responseBox.getMessage(),animationName);
        else return responseBox;
    }

    @GetMapping(path = "getAllComments")
    public @ResponseBody
    List<Comment> getAllComments(@RequestParam String animationName) {
        return commentService.getAllComments(animationName);
    }
}

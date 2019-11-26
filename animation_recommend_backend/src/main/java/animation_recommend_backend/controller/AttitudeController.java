package animation_recommend_backend.controller;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.CookieCache;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping(path = "/")
public class AttitudeController {
    @Autowired
    private AttitudeService attitudeService;
//Message is username
    @PostMapping(path = "likeIt")
    public @ResponseBody
    ResponseBox likeIt(@CookieValue(value = "user",defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return attitudeService.likeIt(responseBox.getMessage(),animationName);
        else return responseBox;
    }

    @PostMapping(path = "dislikeIt")
    public @ResponseBody
    ResponseBox dislikeIt(@CookieValue(value = "user",defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return attitudeService.dislikeIt(responseBox.getMessage(),animationName);
        else return responseBox;
    }

    @PostMapping(path = "stopLiking")
    public @ResponseBody
    ResponseBox stopLiking(@CookieValue(value = "user",defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return attitudeService.stopLiking(responseBox.getMessage(),animationName);
        else return responseBox;
    }

    @PostMapping(path = "stopDisliking")
    public @ResponseBody
    ResponseBox stopDisliking(@CookieValue(value = "user",defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox= CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return attitudeService.likeIt(responseBox.getMessage(),animationName);
        else return responseBox;
    }
}

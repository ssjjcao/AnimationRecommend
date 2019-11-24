package animation_recommend_backend.controller;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class AttitudeController {
    @Autowired
    private AttitudeService attitudeService;

    @PostMapping(path = "likeIt")
    public @ResponseBody
    ResponseBox likeIt(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.likeIt(username,animationName);
    }

    @PostMapping(path = "dislikeIt")
    public @ResponseBody
    ResponseBox dislikeIt(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.dislikeIt(username, animationName);
    }

    @PostMapping(path = "stopLiking")
    public @ResponseBody
    ResponseBox stopLiking(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.stopLiking(username, animationName);
    }

    @PostMapping(path = "stopDisliking")
    public @ResponseBody
    ResponseBox stopDisliking(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.stopDisliking(username, animationName);
    }
}

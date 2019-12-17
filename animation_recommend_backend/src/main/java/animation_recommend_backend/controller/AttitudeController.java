package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.Comment;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.AttitudeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/attitude/")
public class AttitudeController {
    @Autowired
    private AttitudeService attitudeService;

    //Message is username
    @PostMapping(path = "likeIt")
    public @ResponseBody
    ResponseBox likeIt(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.likeIt(username, animationName);
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
        return attitudeService.likeIt(username, animationName);
    }

    @GetMapping(path = "getCollectionsByUsername")
    public @ResponseBody
    JSON getCollectionsByUsername(@RequestParam String username) {
        List<Attitude> attitudes = attitudeService.getCollectionsByUsername(username);
        JSONArray result = new JSONArray();
        for (Attitude attitude : attitudes) {
            result.add(attitude.getAnimation());
        }
        return result;
    }
}

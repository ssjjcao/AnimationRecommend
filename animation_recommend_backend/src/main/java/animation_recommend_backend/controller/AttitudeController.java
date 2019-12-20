package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.AttitudeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
        return attitudeService.stopDisliking(username, animationName);
    }

    @GetMapping(path = "getCollectionsByUsernameAndPageNum")
    public @ResponseBody
    JSON getCollectionsByUsernameAndPageNum(@RequestParam String username, @RequestParam Integer pageNum) {
        Sort jpaSort = JpaSort.unsafe(Sort.Direction.DESC, "\\Qid\\E");
        org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNum - 1, 5, jpaSort);
        Page<Attitude> attitudes = attitudeService.getCollectionsByUsernameAndPageable(username, pageable);
        JSONArray jsonArray = new JSONArray();
        for (Attitude attitude : attitudes.getContent()) {
            jsonArray.add(attitude.getAnimation());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("collections", jsonArray);
        jsonObject.put("totalPage", attitudes.getTotalPages());
        return jsonObject;
    }

    @GetMapping(path = "getAttitudeByUsernameAndAnimationName")
    public @ResponseBody
    Attitude getAttitudeByUsernameAndAnimationName(@RequestParam String username, @RequestParam String animationName) {
        return attitudeService.getAttitudeByUsernameAndAnimationName(username, animationName);
    }
}

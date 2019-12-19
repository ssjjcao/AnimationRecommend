package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.service.AnimationService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/animation/")
public class AnimationController {
    @Autowired
    private AnimationService animationService;

    @GetMapping(path = "searchByName")
    public @ResponseBody
    List<Animation> searchByName(@RequestParam String name) {
        return animationService.searchByName(name);
    }

    @GetMapping(path = "getAnimationByName")
    public @ResponseBody
    Animation getAnimationByName(@RequestParam String animationName) {
        return animationService.getAnimationByName(animationName);
    }

    @PostMapping(path = "updateAnimationPageViewByName")
    public @ResponseBody
    void updateAnimationPageViewByName(@RequestParam String animationName) {
        animationService.updateAnimationPageViewByName(animationName);
    }

    @GetMapping(path = "findAnimationsByPageNum")
    public @ResponseBody
    Page<Animation> findAnimationsByPageNum(@RequestParam Integer pageNum) {
        Sort jpaSort = JpaSort.unsafe(Sort.Direction.DESC, "\\Qlike_num\\E")
                .andUnsafe(Sort.Direction.DESC, "\\Qpage_view\\E")
                .andUnsafe(Sort.Direction.ASC, "\\Qunlike_num\\E");
        Pageable pageable = PageRequest.of(pageNum - 1, 10, jpaSort);
        return animationService.findAnimationsByPageable(pageable);
    }

    @GetMapping(path = "getRecommendationsByUsernameAndPageNum")
    public @ResponseBody
    JSON getRecommendationsByUsernameAndPageNum(@RequestParam String username, @RequestParam Integer pageNum) {
        Sort jpaSort = JpaSort.unsafe(Sort.Direction.DESC, "\\Qlike_num\\E")
                .andUnsafe(Sort.Direction.DESC, "\\Qpage_view\\E")
                .andUnsafe(Sort.Direction.ASC, "\\Qunlike_num\\E");
        Pageable pageable = PageRequest.of(pageNum - 1, 5, jpaSort);
        Page<Animation> animations = animationService.getRecommendationsByUsernameAndPageable(username, pageable);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(animations.getContent());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("recommendations", jsonArray);
        jsonObject.put("totalPage", animations.getTotalPages());
        return jsonObject;
    }

}

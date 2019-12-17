package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.service.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}

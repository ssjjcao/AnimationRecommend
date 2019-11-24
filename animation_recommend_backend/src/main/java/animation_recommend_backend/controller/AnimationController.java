package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.service.AnimationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class AnimationController {
    @Autowired
    private AnimationService animationService;

    @GetMapping(path = "searchByName")
    public @ResponseBody
    List<Animation> searchByName(@RequestParam String name) {
        List<Animation> animations=animationService.searchByName(name);
        System.out.println("hellosearch");
        return animations;
    }

    @GetMapping(path = "getAnimationByName")
    public @ResponseBody
    Animation getAnimationByName(@RequestParam String animationName) {
        Animation animation=animationService.getAnimationByName(animationName);
        System.out.println("helloget");
        return animation;
    }


}

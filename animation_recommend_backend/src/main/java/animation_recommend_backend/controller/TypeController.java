package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping(path = "/getAnimationByType")
    public @ResponseBody
    Animation getAnimationByType(@RequestParam String typeName){
        return new Animation();
    }

}

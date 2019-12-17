package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Type;
import animation_recommend_backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping(path = "/getAnimationByType")
    public @ResponseBody
    List<Animation> getAnimationByType(@RequestParam String typeName) {
        return typeService.getAnimationByType(typeName);
    }

    @GetMapping(path = "/getAllTypes")
    public @ResponseBody
    List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }
}

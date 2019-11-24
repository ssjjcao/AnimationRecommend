package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;

import java.util.List;

public interface AnimationService {
    List<Animation> searchByName(String name);
    Animation getAnimationByName(String animationName);
}

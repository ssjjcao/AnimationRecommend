package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;

import java.util.List;

public interface TypeService {

    List<Animation> getAnimationByType(String typeName);
}

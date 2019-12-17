package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Type;

import java.util.List;

public interface TypeService {

    List<Animation> getAnimationByType(String typeName);

    List<Type> getAllTypes();
}

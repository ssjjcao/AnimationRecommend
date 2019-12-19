package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimationService {
    List<Animation> searchByName(String name);

    Animation getAnimationByName(String animationName);

    void updateAnimationPageViewByName(String animationName);

    Page<Animation> findAnimationsByPageable(Pageable pageable);

    Page<Animation> getRecommendationsByUsernameAndPageable(String username, Pageable pageable);
}

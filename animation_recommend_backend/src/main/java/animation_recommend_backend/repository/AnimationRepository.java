package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Animation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimationRepository extends JpaRepository<Animation, Integer> {
    List<Animation> getAnimationsByNameContains(String name);

    Animation getAnimationByName(String name);
}

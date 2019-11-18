package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Animation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimationRepository extends JpaRepository<Animation, Integer> {
}

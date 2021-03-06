package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Animation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimationRepository extends JpaRepository<Animation, Integer> {
    List<Animation> getAnimationsByNameContaining(String name);

    Animation getAnimationByName(String name);

    boolean existsAnimationByName(String name);

    Page<Animation> findAll(Pageable pageable);

    Page<Animation> findAllByUser_Name(String userName, Pageable pageable);
}

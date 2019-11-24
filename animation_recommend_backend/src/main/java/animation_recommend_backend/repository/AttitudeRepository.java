package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttitudeRepository extends JpaRepository<Attitude, Integer> {
    Boolean existsAttitudeByAnimation_NameAfterAndUser_NameAfter(String username,String animationName);
}

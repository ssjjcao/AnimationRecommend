package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttitudeRepository extends JpaRepository<Attitude, Integer> {
    Attitude getAttitudeByUser_NameAndAnimation_Name(String username,String animationName);
}

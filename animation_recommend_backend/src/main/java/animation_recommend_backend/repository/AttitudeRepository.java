package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Attitude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttitudeRepository extends JpaRepository<Attitude, Integer> {
}

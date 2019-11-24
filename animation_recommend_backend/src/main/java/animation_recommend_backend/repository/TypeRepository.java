package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Type;
import javafx.animation.Animation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type getTypeByName(String name);
}

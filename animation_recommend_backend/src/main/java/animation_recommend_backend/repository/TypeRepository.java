package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type getTypeByName(String name);

    List<Type> findAll();
}

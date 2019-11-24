package animation_recommend_backend.repository;

import animation_recommend_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByName(String name);
}

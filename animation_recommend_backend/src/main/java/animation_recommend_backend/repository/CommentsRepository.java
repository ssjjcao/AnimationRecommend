package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Comments;
import animation_recommend_backend.entity.combineKey.CommentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, CommentKey> {
}

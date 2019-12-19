package animation_recommend_backend.repository;

import animation_recommend_backend.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Boolean existsCommentByCommentAndAnimation_NameAndUser_Name(String comment, String animationName, String username);

    List<Comment> getCommentsByUser_NameAndAnimation_Name(String username, String animationName);

    @Transactional
    void deleteCommentByCommentAndUser_NameAndAnimation_Name(String comment, String username, String animationName);

    List<Comment> getCommentsByAnimation_Name(String animation_Name);

    Page<Comment> getCommentsByAnimation_Name(String animation_Name, Pageable pageable);

    Comment findCommentByCommentAndAnimation_NameAndUser_Name(String comment, String animationName, String username);
}

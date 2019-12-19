package animation_recommend_backend.service;

import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.ResponseBox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttitudeService {
    ResponseBox likeIt(String username, String animationName);

    ResponseBox dislikeIt(String username, String animationName);

    ResponseBox stopLiking(String username, String animationName);

    ResponseBox stopDisliking(String username, String animationName);

    Attitude getAttitudeByUsernameAndAnimationName(String username, String animationName);

    Page<Attitude> getCollectionsByUsernameAndPageable(String username, Pageable pageable);
}

package animation_recommend_backend.service;

import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.ResponseBox;

import java.util.List;

public interface AttitudeService {
    ResponseBox likeIt(String username, String animationName);

    ResponseBox dislikeIt(String username, String animationName);

    ResponseBox stopLiking(String username, String animationName);

    ResponseBox stopDisliking(String username, String animationName);

    List<Attitude> getCollectionsByUsername(String username);
}

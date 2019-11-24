package animation_recommend_backend.service;

import animation_recommend_backend.entity.ResponseBox;

public interface AttitudeService {
    ResponseBox likeIt(String username, String animationName);

    ResponseBox dislikeIt(String username,String animationName);

    ResponseBox stopLiking(String username,String animationName);

    ResponseBox stopDisliking(String username,String animationName);
}

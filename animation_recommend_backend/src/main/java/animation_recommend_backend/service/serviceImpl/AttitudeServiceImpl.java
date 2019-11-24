package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.repository.AttitudeRepository;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttitudeServiceImpl implements AttitudeService {
    @Autowired
    private AttitudeRepository attitudeRepository;

    @Override
    public ResponseBox likeIt(String username, String animationName) {
        attitudeRepository.existsAttitudeByAnimation_NameAfterAndUser_NameAfter(username, animationName);
        return null;
    }

    @Override
    public ResponseBox dislikeIt(String username, String animationName) {
        return null;
    }

    @Override
    public ResponseBox stopLiking(String username, String animationName) {
        return null;
    }

    @Override
    public ResponseBox stopDisliking(String username, String animationName) {
        return null;
    }
}

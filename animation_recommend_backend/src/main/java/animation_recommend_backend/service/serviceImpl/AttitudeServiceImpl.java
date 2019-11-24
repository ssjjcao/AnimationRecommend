package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.repository.AttitudeRepository;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class AttitudeServiceImpl implements AttitudeService {
    @Autowired
    private AttitudeRepository attitudeRepository;
    @Autowired
    private AnimationRepository animationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseBox likeIt(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (attitude.isFavorite())
                return new ResponseBox(false, "已点赞");
            else return new ResponseBox(false, "请先取消点踩");
        }
        attitude = new Attitude();
        attitude.setUser(userRepository.getUserByName(username));
        attitude.setAnimation(animationRepository.getAnimationByName(animationName));
        attitude.setFavorite(true);
        attitudeRepository.save(attitude);
        return new ResponseBox(true, "点赞成功");
    }

    @Override
    public ResponseBox dislikeIt(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (attitude.isFavorite())
                return new ResponseBox(false, "请先取消点赞");
            else return new ResponseBox(false, "已点踩");
        }
        attitude = new Attitude();
        attitude.setUser(userRepository.getUserByName(username));
        attitude.setAnimation(animationRepository.getAnimationByName(animationName));
        attitude.setFavorite(false);
        attitudeRepository.save(attitude);
        return new ResponseBox(true, "点踩成功");
    }

    @Override
    public ResponseBox stopLiking(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (attitude.isFavorite()) {
                attitudeRepository.delete(attitude);
                return new ResponseBox(true, "取消点赞成功");
            } else return new ResponseBox(false, "您已经踩过这篇文章了");
        }
        return new ResponseBox(false, "请先点赞吖");
    }

    @Override
    public ResponseBox stopDisliking(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (!attitude.isFavorite()) {
                attitudeRepository.delete(attitude);
                return new ResponseBox(true, "取消点踩成功");
            } else return new ResponseBox(false, "您已经赞过这篇文章了");
        }
        return new ResponseBox(false, "您还没有踩过这篇文章吖");
    }
}

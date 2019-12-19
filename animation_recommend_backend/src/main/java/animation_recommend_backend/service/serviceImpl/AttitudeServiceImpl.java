package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.Attitude;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.repository.AttitudeRepository;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
            else {
                attitude.setFavorite(true);
                attitudeRepository.save(attitude);
                this.attitudeUpdate(animationName);
                return new ResponseBox(true, "已点赞");
            }
        }
        attitude = new Attitude();
        User user = userRepository.getUserByName(username);
        if (user == null)
            return new ResponseBox(false, "没有用户");
        attitude.setUser(user);
        Animation animation = animationRepository.getAnimationByName(animationName);
        if (animation == null)
            return new ResponseBox(false, "没有动画");
        attitude.setAnimation(animation);
        attitude.setFavorite(true);
        attitudeRepository.save(attitude);
        this.attitudeUpdate(animationName);
        return new ResponseBox(true, "点赞成功");
    }

    @Override
    public ResponseBox dislikeIt(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (attitude.isFavorite()) {
                attitude.setFavorite(false);
                attitudeRepository.save(attitude);
                this.attitudeUpdate(animationName);
                return new ResponseBox(true, "点踩");
            } else return new ResponseBox(false, "已点踩");
        }
        attitude = new Attitude();
        User user = userRepository.getUserByName(username);
        if (user == null)
            return new ResponseBox(false, "点赞失败");
        attitude.setUser(user);
        Animation animation = animationRepository.getAnimationByName(animationName);
        if (animation == null)
            return new ResponseBox(false, "点赞失败");
        attitude.setAnimation(animation);
        attitude.setFavorite(false);
        attitudeRepository.save(attitude);
        this.attitudeUpdate(animationName);
        return new ResponseBox(true, "点踩成功");
    }

    @Override
    public ResponseBox stopLiking(String username, String animationName) {
        Attitude attitude = attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
        if (attitude != null) {
            if (attitude.isFavorite()) {
                attitudeRepository.delete(attitude);
                this.attitudeUpdate(animationName);
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
                this.attitudeUpdate(animationName);
                return new ResponseBox(true, "取消点踩成功");
            } else return new ResponseBox(false, "您已经赞过这篇文章了");
        }
        return new ResponseBox(false, "您还没有踩过这篇文章吖");
    }

    @Override
    public Attitude getAttitudeByUsernameAndAnimationName(String username, String animationName) {
        return attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username, animationName);
    }

    @Override
    public Page<Attitude> getCollectionsByUsernameAndPageable(String username, Pageable pageable) {
        return attitudeRepository.getAttitudesByUser_NameAndFavorite(username, true, pageable);
    }

    private void attitudeUpdate(String animationName) {
        List<Attitude> attitudes = attitudeRepository.getAttitudesByAnimation_Name(animationName);
        int likeNum = 0;
        int unlikeNum = 0;
        for (int i = 0; i < attitudes.size(); i++) {
            if (attitudes.get(i).isFavorite()) {
                likeNum++;
            } else unlikeNum++;
        }
        Animation animation = animationRepository.getAnimationByName(animationName);
        animation.setLike_num(likeNum);
        animation.setUnlike_num(unlikeNum);
        animationRepository.save(animation);
    }
}

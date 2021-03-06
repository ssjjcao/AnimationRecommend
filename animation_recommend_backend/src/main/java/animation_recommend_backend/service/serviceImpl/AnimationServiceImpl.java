package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.service.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AnimationServiceImpl implements AnimationService {
    @Autowired
    private AnimationRepository animationRepository;

    @Override
    public List<Animation> searchByName(String name) {
        return animationRepository.getAnimationsByNameContaining(name);
    }

    @Override
    public Animation getAnimationByName(String animationName) {
        return animationRepository.getAnimationByName(animationName);
    }

    @Override
    public void updateAnimationPageViewByName(String animationName) {
        Animation animation = animationRepository.getAnimationByName(animationName);
        animation.setPage_view(animation.getPage_view() + 1);
        animationRepository.save(animation);
    }

    @Override
    public Page<Animation> findAnimationsByPageable(Pageable pageable) {
        return animationRepository.findAll(pageable);
    }

    @Override
    public Page<Animation> getRecommendationsByUsernameAndPageable(String username, Pageable pageable) {
        return animationRepository.findAllByUser_Name(username, pageable);
    }
}

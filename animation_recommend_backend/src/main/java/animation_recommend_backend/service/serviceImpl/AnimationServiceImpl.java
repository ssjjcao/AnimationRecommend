package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.service.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

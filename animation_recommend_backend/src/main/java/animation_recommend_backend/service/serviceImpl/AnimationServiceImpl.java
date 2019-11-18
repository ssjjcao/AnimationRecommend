package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.service.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AnimationServiceImpl implements AnimationService {
    @Autowired
    private AnimationRepository animationRepository;
}

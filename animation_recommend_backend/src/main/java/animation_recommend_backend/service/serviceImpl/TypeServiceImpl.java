package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.repository.TypeRepository;
import animation_recommend_backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Animation> getAnimationByType(String typeName) {

        return (List<Animation>) typeRepository.getTypeByName(typeName).getAnimations();
    }
}

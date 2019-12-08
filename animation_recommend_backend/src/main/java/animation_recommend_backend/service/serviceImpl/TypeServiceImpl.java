package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.repository.TypeRepository;
import animation_recommend_backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Animation> getAnimationByType(String typeName) {
        Set<Animation> animationSet = typeRepository.getTypeByName(typeName).getAnimations();
        ArrayList<Animation> animations = new ArrayList<>(animationSet);
        Comparator<Animation> comparator = (o1, o2) -> {
            int recommendIndex1 = o1.getLike_num() + o1.getPage_view() + o1.getComments().size() - o1.getUnlike_num();
            int recommendIndex2 = o2.getLike_num() + o2.getPage_view() + o2.getComments().size() - o2.getUnlike_num();
            if (recommendIndex1 == recommendIndex2) {
                return 0;
            } else {
                return recommendIndex1 > recommendIndex2 ? 1 : -1;
            }
        };
        animations.sort(comparator);
        return animations;
    }
}

package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.TypeRepository;
import animation_recommend_backend.service.TypeService;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class TypeServiceTest {
    @Autowired
    TypeService typeService;
    private TypeRepository typeRepository;



    @Test
    public void testGetAnimationByTypeSuccess(){
        List<Animation>expected = typeService.getAnimationByType("热血");
        Assertions.assertTrue(expected.size() != 0);
    }
}

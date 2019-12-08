package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.AnimationService;
import animation_recommend_backend.service.CommentService;
import animation_recommend_backend.service.TypeService;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class AnimationServiceTest {
    @Autowired
    AnimationService animationService;


    @Test
    public void testSearchByNameSuccess(){
        List<Animation>list = animationService.searchByName("网");
        if (list.size() == 0){
            Assertions.assertFalse(false);
        }else {
            boolean has = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals("网球王子")){
                    has = !has;
                }
            }
            Assertions.assertTrue(has);
        }
    }

    @Test
    public void testGetAnimationByNameFailure(){
        Animation animation = animationService.getAnimationByName("网球");
        if (animation == null){
            Assertions.assertFalse(false);
        }else Assertions.assertFalse(true);
    }

    @Test
    public void testGetAnimationByNameSuccess(){
        Animation animation = animationService.getAnimationByName("网球王子");
        Assertions.assertEquals(animation.getName(),"网球王子");
    }

}

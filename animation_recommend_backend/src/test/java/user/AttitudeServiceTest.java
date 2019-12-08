package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.AttitudeService;
import animation_recommend_backend.service.CommentService;
import animation_recommend_backend.service.TypeService;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class AttitudeServiceTest {
    @Autowired
    AttitudeService attitudeService;

    @Test
    public void testLikeItFailure() {
        ResponseBox responseBox = attitudeService.likeIt("be","书灵记");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = attitudeService.likeIt("bear","书");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testLikeItSuccess() {
        ResponseBox responseBox = attitudeService.likeIt("bear","书灵记");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = attitudeService.likeIt("bear","斗罗大陆");
        Assertions.assertTrue(responseBox.isResult());
    }

    @Test
    public void testDislikeItFailure() {
        ResponseBox responseBox = attitudeService.dislikeIt("be","书灵记");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = attitudeService.dislikeIt("bear","书");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testDislikeItSuccess() {
        ResponseBox responseBox = attitudeService.dislikeIt("bear","一人之下");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = attitudeService.dislikeIt("bear","黑猫警长");
        Assertions.assertTrue(responseBox.isResult());
    }

    @Test
    public void testStopLikingFailure() {
        ResponseBox responseBox = attitudeService.stopLiking("be","书灵记");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = attitudeService.stopLiking("bear","书");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testStopLikingSuccess() {
        ResponseBox responseBox = attitudeService.stopLiking("bear","书灵记");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = attitudeService.stopLiking("bear","斗罗大陆");
        Assertions.assertTrue(responseBox.isResult());
    }

    @Test
    public void testStopDislikingFailure() {
        ResponseBox responseBox = attitudeService.dislikeIt("be","书灵记");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = attitudeService.dislikeIt("bear","书");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testStopDislikingSuccess() {
        ResponseBox responseBox = attitudeService.stopDisliking("bear","一人之下");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = attitudeService.stopDisliking("bear","黑猫警长");
        Assertions.assertTrue(responseBox.isResult());
    }
}

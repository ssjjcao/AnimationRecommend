package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class UserAccountTest {
    @Autowired
    UserService userService;

    @Test
    public void testUserSignInFailure() {
//        User user = getUser("Dream", "123456");
        ResponseBox responseBox = userService.signIn("Dream","123456");
        Assertions.assertFalse(responseBox.isResult());

//        user = getUser("dream", "niubility");
        responseBox = userService.signIn("dream","niubility");
        Assertions.assertFalse(responseBox.isResult());

        //todo :更多的测试用例
    }

    @Test
    public void testUserSignInSuccess() {
        User user = getUser("dream", "123456");
        ResponseBox responseBox = userService.signIn("dream", "123456");
        Assertions.assertTrue(responseBox.isResult());

        user = getUser("bear", "niubility");
        responseBox = userService.signIn("bear", "niubility");
        Assertions.assertTrue(responseBox.isResult());
    }

    private User getUser(String userName, String password) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        return user;
    }
}

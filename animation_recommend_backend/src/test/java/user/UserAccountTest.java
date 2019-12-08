package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class UserAccountTest {
    @Autowired
    UserService userService;

    @Test
    public void testUserServiceGetUserNameSuccess(){
        User user = userService.getUserByName("bear");
        Assertions.assertEquals(user.getPassword(),"123456");
        Assertions.assertEquals(user.getId(),4);
    }

    @Test
    public void testUserServiceGetUserNameNull(){
        Assertions.assertNull(userService.getUserByName(""));
    }

    @Test
    public void testUserSignInFailure() {
        //User("Dream", "123456");
        ResponseBox responseBox = userService.signIn("Dream","123456");
        Assertions.assertFalse(responseBox.isResult());

        //User("dream", "niubility");
        responseBox = userService.signIn("dream","niubility");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserSignInSuccess() {
        ResponseBox responseBox = userService.signIn("dream", "123456");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = userService.signIn("bear", "123456");
        Assertions.assertTrue(responseBox.isResult());
    }

    @Test
    public void testUserSignInNull() {
        ResponseBox responseBox = userService.signIn("","");
        Assertions.assertFalse(responseBox.isResult());

    }

    @Test
    public void testUserSignUpFailure() {
        String[] type = {"青春","搞笑"};
        ResponseBox responseBox = userService.signUp("dream","123456","",type);
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserSignUpSuccess() {
        String[] type = {"青春","搞笑"};
        ResponseBox responseBox = userService.signUp("ream", "123456","daw",type);
        User user = userService.getUserByName("ream");
        Assertions.assertTrue(responseBox.isResult());
        userService.deleteUserById(user.getId());

        responseBox = userService.signUp("Dream", "niubility","dwad",type);
        user = userService.getUserByName("Dream");
        Assertions.assertTrue(responseBox.isResult());
        userService.deleteUserById(user.getId());
    }

    @Test
    public void testUserSignUpNull() {
        String[] type = {};
        ResponseBox responseBox = userService.signUp("","","",type);
        if (responseBox.isResult()){
            userService.deleteUserById(userService.getUserByName("").getId());
        }
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserUpdateNull() {
        ResponseBox responseBox = userService.update(null,null,null,null,null,null,null);
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserGetUserInfoSuccess() {
        ResponseDataBox responseDataBox = userService.getUserInfo("dream");
        Assertions.assertTrue(responseDataBox.isResult());

        responseDataBox = userService.getUserInfo("bear");
        Assertions.assertTrue(responseDataBox.isResult());
    }

    @Test
    public void testUserModifyUserInfoSuccess() {
        userService.signIn("bear","123456");
        String[] type = {"青春","搞笑"};
        ResponseBox responseBox = userService.modifyUserInfo("bear","reab","bear",type);
        Assertions.assertTrue(responseBox.isResult());
        Assertions.assertEquals(userService.getUserByName("reab").getSignature(),"bear");
        userService.modifyUserInfo("reab","bear","bear",type);
    }

    @Test
    public void testUserModifyUserInfoFailure() {
        String[] type = {"青春","搞笑"};
        ResponseBox responseBox = userService.modifyUserInfo("modefityname","newName","",type);
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserModifyUserInfoNull() {
        ResponseBox responseBox = userService.modifyUserInfo("","",null,null);
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserModifyPasswordFailure() {
        ResponseBox responseBox = userService.modifyPassword("bear","bear","bear");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = userService.modifyPassword("123456","bear","Bear");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserModifyPasswordSuccess() {
        userService.signIn("bear","123456");
        ResponseBox responseBox = userService.modifyPassword("123456","654321","bear");
        Assertions.assertTrue(responseBox.isResult());
        Assertions.assertEquals(userService.getUserByName("bear").getPassword(),"654321");

        responseBox = userService.modifyPassword("654321","123456","bear");
        Assertions.assertTrue(responseBox.isResult());
        Assertions.assertEquals(userService.getUserByName("bear").getPassword(),"123456");
    }

    @Test
    public void testUserModifyPasswordNull() {
        ResponseBox responseBox = userService.modifyPassword(null,null,"");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void testUserSerice(){

    }
}

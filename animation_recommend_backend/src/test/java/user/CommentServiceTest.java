package user;

import animation_recommend_backend.AnimationRecommendBackendApplication;
import animation_recommend_backend.entity.*;
import animation_recommend_backend.service.CommentService;
import animation_recommend_backend.service.TypeService;
import animation_recommend_backend.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest(classes = AnimationRecommendBackendApplication.class)
public class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    public void  testCommentFailure(){
        ResponseBox responseBox = commentService.comment("好喜欢","网球王子","be");
        Assertions.assertFalse(responseBox.isResult());

        responseBox = commentService.comment("好喜欢","网球王","bear");
        Assertions.assertFalse(responseBox.isResult());
    }

    @Test
    public void  testCommentSuccess(){
        ResponseBox responseBox = commentService.comment("好喜欢","网球王子","bear");
        Assertions.assertTrue(responseBox.isResult());

        responseBox = commentService.comment("好喜欢","网球王子","dream");
        Assertions.assertTrue(responseBox.isResult());
    }



    @Test
    public void  testDeleteOneCommentSuccess(){
        ResponseBox responseBox = commentService.deleteOneComment("好喜欢","bear","网球王子");
        Assertions.assertTrue(responseBox.isResult());
    }

    @Test
    public void testGetAllCommentsFailure(){
        List<Comment>list = commentService.getAllComments("网球王");
        Assertions.assertTrue(list.size() == 0);
    }

    @Test
    public void testGetAllCommentsSuccess(){
        List<Comment>list = commentService.getAllComments("网球王子");
        Assertions.assertTrue(list.size()!=0);
    }
}

package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    void deleteUserById(Integer id);

    ResponseBox signIn(String username, String password);

    ResponseBox signUp(String username, String password, String signature, String[] myTypes);

    ResponseBox update(MultipartFile image, String animationName, String recommend, String[] animationTypes, String link, String animationInfo, String username);

    ResponseDataBox getUserInfo(String targetName);

    ResponseBox modifyUserInfo(String username, String newUsername, String signature, String[] myTypes);

    ResponseBox modifyPassword(String oldPassword, String newPassword, String username);

    ResponseBox removeLike(String animationName, String username);

    ResponseBox deleteRecommend(String animationName, String username);

    List<Animation> getRecommendationsByUsername(String username);
}

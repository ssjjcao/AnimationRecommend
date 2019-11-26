package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User getUserByName(String name);

    void deleteUserById(Integer id);

    ResponseBox signIn(User user);

    ResponseBox signUp(User user);

    ResponseBox update(MultipartFile image,String animationName,String recommend, String[] animationTypes,String link,String animationInfo,String username);

    ResponseDataBox getUserInfo(String username);

    ResponseBox modifyUserInfo(String username,String signature,String[] myTypes);

    ResponseBox modifyPassword(String oldPassword, String newPassword,String username);

    ResponseBox removeLike(String animationName,String username);

    ResponseBox deleteRecommend(String animationName,String username);
    }

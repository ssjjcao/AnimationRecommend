package animation_recommend_backend.service;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User getUserByName(String name);

    void deleteUserById(Integer id);

    User signIn(User user);

    User signUp(User user);

    Animation update(MultipartFile image,String animationName,String recommend, String[] animationTypes,String link,String animationInfo);

    User getUserInfo(String username);

    Boolean modifyUserInfo(String username,String signature,String[] myTypes);

    Boolean modifyPassword(String oldPassword,String newPassword);

    Boolean removeLike(String animationName,String username);

    Boolean deleteRecommend(String animationName,String username);
    }

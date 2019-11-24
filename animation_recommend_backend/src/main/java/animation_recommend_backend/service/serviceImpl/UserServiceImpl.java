package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User signIn(User user) {
        return null;
    }

    @Override
    public User signUp(User user) {
        return null;
    }

    @Override
    public Animation update(MultipartFile image, String animationName, String recommend, String[] animationTypes, String link, String animationInfo) {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }

    @Override
    public ResponseBox modifyUserInfo(String username, String signature, String[] myTypes) {
        return null;
    }

    @Override
    public ResponseBox modifyPassword(String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public ResponseBox removeLike(String animationName, String username) {
        return null;
    }

    @Override
    public ResponseBox deleteRecommend(String animationName, String username) {
        return null;
    }


}

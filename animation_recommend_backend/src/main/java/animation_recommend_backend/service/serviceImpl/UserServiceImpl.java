package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.*;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.repository.TypeRepository;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private AnimationRepository animationRepository;

    @Override
    public User getUserByName(String name) {
        return this.userRepository.getUserByName(name);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }

    //ToDO 密码强度校验先搁置一下，之后确定了再加上去
    @Override
    public ResponseBox signIn(User user) {
        User user0 = userRepository.getUserByName(user.getName());
        if (user0 != null)
            if (user0.getPassword().equals(user.getPassword()))
                return new ResponseBox(true, "登陆成功");
            else return new ResponseBox(false, "用户名或密码错误");
        else return new ResponseBox(false, "用户不存在");
    }

    @Override
    public ResponseBox signUp(User user) {
        if (!userRepository.existsUserByName(user.getName())) {
            userRepository.save(user);
            return new ResponseBox(true, "注册成功");
        }
        return new ResponseBox(false, "用户名重复");
    }

    //ToDO multipartFile这里需要好好写一下，暂时先随便写一个生成路径的代替
    //ToDo 如果用户所选种类系统没有提供的解决方案，或者根本不需要管
    //ToDO 上传页面传递用户信息的解决方案，好像这里要解决的问题还有点多，等脑子清楚的时候再写吧
    @Override
    public ResponseBox update(MultipartFile image, String animationName, String recommend, String[] animationTypes, String link, String animationInfo) {
//        if (animationRepository.existsAnimationByName(animationName))
        if (image != null && !image.isEmpty()) {
            String filename = image.getOriginalFilename();
            assert filename != null;
            String prefix = filename.substring(filename.lastIndexOf(".") + 1);
            String cover = "封面图/" + animationName + prefix;
            Animation animation = new Animation();
            animation.setCover(cover);
            animation.setName(animationName);
            animation.setRecommendation(recommend);
            ArrayList<Type> types = new ArrayList<>();
            for (String animationType : animationTypes) {
                Type type = typeRepository.getTypeByName(animationType);
                if (type != null)
                    types.add(type);
            }
            animation.setTypes(new HashSet<>(types));
            animation.setLink(link);
            animation.setDetail(animationInfo);
            User user = userRepository.getUserByName("joker");
            animation.setUser(user);
            animationRepository.save(animation);
        }
        return new ResponseBox(false, "反正就是上传失败了");
    }

    @Override
    public ResponseDataBox getUserInfo(String username) {
        User user = userRepository.getUserByName(username);
        return new ResponseDataBox(true, "", user);
    }
//ToDO用户信息传递问题
    @Override
    public ResponseBox modifyUserInfo(String username, String signature, String[] myTypes) {
        User user = new User();
        if (user != null) {
            ArrayList<Type> types = new ArrayList<>();
            for (String myType : myTypes) {
                Type type = typeRepository.getTypeByName(myType);
                if (type != null)
                    types.add(type);
            }
            user.setName(username);
            user.setTypes(new HashSet<>(types));
            user.setSignature(signature);
            userRepository.save(user);
            return new ResponseBox(true,"修改成功");
        }
        return new ResponseBox(false,"修改失败");
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

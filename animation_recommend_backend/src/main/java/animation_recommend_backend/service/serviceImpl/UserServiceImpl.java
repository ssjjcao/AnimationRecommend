package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.*;
import animation_recommend_backend.repository.AnimationRepository;
import animation_recommend_backend.repository.AttitudeRepository;
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
    @Autowired
    private AttitudeRepository attitudeRepository;

    private static HashSet<Type> Strings2TypeSet(TypeRepository typeRepository,String [] myTypes){
        ArrayList<Type> types = new ArrayList<>();
        for (String myType : myTypes) {
            Type type = typeRepository.getTypeByName(myType);
            if (type != null)
                types.add(type);
        }
        return new HashSet<>(types);
    }
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
    public ResponseBox signIn(String username, String password) {
        User user = userRepository.getUserByName(username);
        if (user != null)
            if (user.getPassword().equals(password))
                return new ResponseBox(true, "登陆成功");
            else return new ResponseBox(false, "用户名或密码错误");
        else return new ResponseBox(false, "用户不存在");
    }

    @Override
    public ResponseBox signUp(String username, String password, String signature, String[] myTypes) {
        if (!userRepository.existsUserByName(username)) {
            User user=new User();
            user.setName(username);
            user.setPassword(password);
            user.setSignature(signature);
            user.setTypes(Strings2TypeSet(typeRepository,myTypes));
            userRepository.save(user);
            return new ResponseBox(true, "注册成功");
        }
        return new ResponseBox(false, "用户名重复");
    }

    //ToDO multipartFile这里需要好好写一下，暂时先随便写一个生成路径的代替
    //ToDo 如果用户所选种类系统没有提供的解决方案，或者根本不需要管
    //ToDO 上传页面传递用户信息的解决方案，好像这里要解决的问题还有点多，等脑子清楚的时候再写吧
    @Override
    public ResponseBox update(MultipartFile image, String animationName, String recommend, String[] animationTypes, String link, String animationInfo,String username) {
        Animation animationOriginal=animationRepository.getAnimationByName(animationName);
        if (animationOriginal!=null&&!animationOriginal.getUser().getName().equals(username))
            return new ResponseBox(false,"番剧推荐已存在");
        if (image != null && !image.isEmpty()) {
            String filename = image.getOriginalFilename();
            assert filename != null;
            String prefix = filename.substring(filename.lastIndexOf(".") + 1);
            String cover = "封面图/" + animationName + prefix;
            //ToDO 文件保存，相同文件过滤
            Animation animation = animationOriginal==null?new Animation():animationOriginal;
            animation.setCover(cover);
            animation.setName(animationName);
            animation.setRecommendation(recommend);
            animation.setTypes(Strings2TypeSet(typeRepository,animationTypes));
            animation.setLink(link);
            animation.setDetail(animationInfo);
            User user = userRepository.getUserByName(username);
            animation.setUser(user);
            animationRepository.save(animation);
            return new ResponseBox(true,"你的推荐已成功上传");
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
        User user = userRepository.getUserByName(username);
        if (user != null) {
            String message="修改成功";
            if (!user.getName().equals(username)) {
                if (userRepository.existsUserByName(username))
                    return new ResponseBox(false,"该用户名已被使用");
                user.setName(username);
            }
            user.setTypes(Strings2TypeSet(typeRepository,myTypes));
            user.setSignature(signature);
            userRepository.save(user);
            return new ResponseBox(true,message);
        }
        return new ResponseBox(false,"修改失败");
    }

    @Override
    public ResponseBox modifyPassword(String oldPassword, String newPassword,String username) {
        User user=userRepository.getUserByName(username);
        if (user!=null){
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                return new ResponseBox(true, "密码修改成功");
            }else return new ResponseBox(false,"原密码错误");
        }
        return new ResponseBox(false,"请联系后台，用户不存在");
    }

    @Override
    public ResponseBox removeLike(String animationName, String username) {
        Attitude attitude=attitudeRepository.getAttitudeByUser_NameAndAnimation_Name(username,animationName);
        if (attitude.isFavorite()) {
            attitudeRepository.delete(attitude);
            return new ResponseBox(true,"成功取消喜欢并移出收藏列表");
        }
        return new ResponseBox(false,"请联系后台，unknown");
    }
    //ToDO 清除存储文件
    @Override
    public ResponseBox deleteRecommend(String animationName, String username) {
        Animation animation=animationRepository.getAnimationByName(animationName);
        if (animation.getUser().getName().equals(username)){
            animationRepository.delete(animation);
            return new ResponseBox(true,"删除成功");
        }
        return new ResponseBox(false,"请联系后台，unknown");
    }


}

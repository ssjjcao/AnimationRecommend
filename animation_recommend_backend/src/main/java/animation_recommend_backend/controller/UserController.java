package animation_recommend_backend.controller;

import animation_recommend_backend.entity.Animation;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserByName", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        User user = this.userService.getUserByName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteUserById")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        this.userService.deleteUserById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "signIn")
    public @ResponseBody
    User signIn(@Valid User user) {
        return new User();
    }

    @PostMapping(path = "signUp")
    public @ResponseBody
    User signOn(@Valid User user) {
        return new User();
    }

    @PostMapping(path = "update")
    public @ResponseBody
    Animation update(@RequestParam MultipartFile image, @RequestParam String animationName, @RequestParam String recommend, @RequestParam String[] animationTypes, @RequestParam String link, @RequestParam String animationInfo) {
        return new Animation();
    }

    @GetMapping(path = "getUserInfo")
    public @ResponseBody
    User getUserInfo(@RequestParam String username) {
        return new User();
    }

    @PostMapping(path = "modifyUserInfo")
    public @ResponseBody
    Boolean modifyUserInfo(@RequestParam String username, @RequestParam String signature, @RequestParam String[] myTypes) {
        return false;
    }

    @PostMapping(path = "modifyPassword")
    public @ResponseBody
    ResponseBox modifyPassword(@RequestParam String oldPassword,@RequestParam String newPassword){
        return new ResponseBox();
    }

    @PostMapping(path = "removeLike")
    public @ResponseBody
    Boolean removeLike(@RequestParam String animationName,@RequestParam String username){
        return false;
    }

    @PostMapping(path = "deleteRecommend")
    public @ResponseBody
    Boolean deleteRecommend(@RequestParam String animationName,@RequestParam String username){
        return false;
    }
}

package animation_recommend_backend.controller;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.CookieCache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.Duration;
import java.util.UUID;

@Controller
@RequestMapping(path = "/")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value = "getUserByName", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Object> getUser(HttpServletRequest request) {
//        String userName = request.getParameter("userName");
//        User user = this.userService.getUserByName(userName);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

    //    @RequestMapping(value = "deleteUserById")
//    @ResponseBody
//    public ResponseEntity<Object> deleteUser(HttpServletRequest request) {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        this.userService.deleteUserById(id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
//@CookieValue(value = "user",defaultValue = "") Cookie cookie,
    @PostMapping(path = "signIn")
    public @ResponseBody
    ResponseBox signIn(@Valid User user, HttpServletResponse response) {
        ResponseBox responseBox = userService.signIn(user);
        return CookieCache.generateCookie(user.getName(), response, responseBox);
    }

    @PostMapping(path = "signUp")
    public @ResponseBody
    ResponseBox signUp(@Valid User user, HttpServletResponse response) {
        ResponseBox responseBox = userService.signUp(user);
        return CookieCache.generateCookie(user.getName(), response, responseBox);
    }


    @PostMapping(path = "update")
    public @ResponseBody
    ResponseBox update(@CookieValue(value = "user", defaultValue = "") Cookie cookie, @RequestParam MultipartFile image, @RequestParam String animationName, @RequestParam String recommend, @RequestParam String[] animationTypes, @RequestParam String link, @RequestParam String animationInfo) {
        ResponseBox responseBox = CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return userService.update(image, animationName, recommend, animationTypes, link, animationInfo, responseBox.getMessage());
        else return responseBox;
    }

    @GetMapping(path = "getUserInfo")
    public @ResponseBody
    ResponseDataBox getUserInfo(@RequestParam String username) {
        return userService.getUserInfo(username);
    }
//IMPORTANT 这个接口在修改了用户名的情况下会返回新的cookie
    @PostMapping(path = "modifyUserInfo")
    public @ResponseBody
    ResponseBox modifyUserInfo(@CookieValue(value = "user", defaultValue = "") Cookie cookie, @RequestParam String signature, @RequestParam String[] myTypes,HttpServletResponse response) {
        ResponseBox responseBox = CookieCache.getUserName(cookie);
        if (responseBox.isResult()) {
            ResponseBox responseBox1 = userService.modifyUserInfo(responseBox.getMessage(), signature, myTypes);
            if (responseBox1.getMessage().equals("生成新cookie")) {
                CookieCache.generateCookie(responseBox.getMessage(), response, responseBox1);
                return new ResponseBox(true,"修改成功");
            }
        }
        return responseBox;
    }

    @PostMapping(path = "modifyPassword")
    public @ResponseBody
    ResponseBox modifyPassword(@CookieValue(value = "user", defaultValue = "") Cookie cookie, @RequestParam String oldPassword, @RequestParam String newPassword) {
        ResponseBox responseBox = CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return userService.modifyPassword(oldPassword, newPassword, responseBox.getMessage());
        return responseBox;
    }

    @PostMapping(path = "removeLike")
    public @ResponseBody
    ResponseBox removeLike(@CookieValue(value = "user", defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox = CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return userService.removeLike(animationName, responseBox.getMessage());
        return responseBox;
    }

    @PostMapping(path = "deleteRecommend")
    public @ResponseBody
    ResponseBox deleteRecommend(@CookieValue(value = "user", defaultValue = "") Cookie cookie, @RequestParam String animationName) {
        ResponseBox responseBox = CookieCache.getUserName(cookie);
        if (responseBox.isResult())
            return userService.deleteRecommend(animationName, responseBox.getMessage());
        return responseBox;
    }
}

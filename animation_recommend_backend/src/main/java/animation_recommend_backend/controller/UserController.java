package animation_recommend_backend.controller;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.ResponseDataBox;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/user/")
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
    ResponseBox signIn() {
        return null;
    }

    @PostMapping(path = "signUp")
    public @ResponseBody
    ResponseBox signUp() {
        return null;
    }


    @PostMapping(path = "update")
    public @ResponseBody
    ResponseBox update(@RequestParam String username, @RequestParam MultipartFile image, @RequestParam String animationName, @RequestParam String recommend, @RequestParam String[] animationTypes, @RequestParam String link, @RequestParam String animationInfo) {

        return userService.update(image, animationName, recommend, animationTypes, link, animationInfo, username);
    }

    @GetMapping(path = "getUserInfo")
    public @ResponseBody
    ResponseDataBox getUserInfo(@RequestParam String username) {
        return userService.getUserInfo(username);
    }

    //IMPORTANT 这个接口在修改了用户名的情况下会返回新的cookie
    @PostMapping(path = "modifyUserInfo")
    public @ResponseBody
    ResponseBox modifyUserInfo(@RequestParam String username, @RequestParam String signature, @RequestParam String[] myTypes, HttpServletResponse response) {
        return userService.modifyUserInfo(username, signature, myTypes);
    }

    @PostMapping(path = "modifyPassword")
    public @ResponseBody
    ResponseBox modifyPassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {
        return userService.modifyPassword(oldPassword, newPassword, username);
    }

    @PostMapping(path = "removeLike")
    public @ResponseBody
    ResponseBox removeLike(@RequestParam String username, @RequestParam String animationName) {
        return userService.removeLike(animationName, username);
    }

    @PostMapping(path = "deleteRecommend")
    public @ResponseBody
    ResponseBox deleteRecommend(@RequestParam String username, @RequestParam String animationName) {
        return userService.deleteRecommend(animationName, username);
    }
}

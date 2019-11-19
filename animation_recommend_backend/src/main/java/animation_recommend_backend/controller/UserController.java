package animation_recommend_backend.controller;

import animation_recommend_backend.entity.User;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserByName", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        User user = this.userService.getUserByName(userName);
        //应该要自己组json，如果利用ResponseEntity自动转化的话会出现josn无限循环的问题。
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteUserById")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        this.userService.deleteUserById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}

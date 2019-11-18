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
        User user = userService.getUserByName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

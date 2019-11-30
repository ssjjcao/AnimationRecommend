package utils;

import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CookieCache {
    private static Map<String, Cookie> cookieMap = new HashMap<>();//username,cookie
    private static Map<Cookie, String> userMap =new HashMap<>();
    @PostConstruct

    public void init() {
//        cookieMap.put("joker",new Session.Cookie());
    }

    @PreDestroy
    public void destroy() {
        //系统运行结束
    }

    @Scheduled(cron = "0 0 0/2 * * ?")
    public void testOne() {
        //每2小时执行一次缓存
        init();
    }

    public static ResponseBox generateCookie(String username, HttpServletResponse response, ResponseBox responseBox) {
        if (responseBox.isResult()) {
            Cookie cookie = new Cookie("user", UUID.randomUUID().toString());
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setSecure(false);//测试环境所用无https
            cookie.setPath("/");
            response.addCookie(cookie);
            userMap.put(cookie,username);
            cookieMap.put(username, cookie);
            responseBox=new ResponseBox(true,cookie.getValue());
        }
        return responseBox;
    }

    public static ResponseBox getUserName(Cookie cookie) {
        if (cookie != null && userMap.containsKey(cookie)) {
            String username = userMap.get(cookie);
            if (cookie.equals(cookieMap.get(username)))
                return new ResponseBox(true,username);
            else return new ResponseBox(false,"cookie过期");
        }else return new ResponseBox(false,"请先登陆");
    }
}

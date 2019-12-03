package animation_recommend_backend.securityUtils.filter;

import animation_recommend_backend.entity.JSONResult;
import animation_recommend_backend.entity.ResponseBox;
import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.securityUtils.TokenAuthentication;
import animation_recommend_backend.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class JWTUserFilter extends AbstractAuthenticationProcessingFilter {
    UserService userService;
    UserRepository userRepository;

    public JWTUserFilter(String url, AuthenticationManager authManager, ApplicationContext applicationContext) {
        super(new AntPathRequestMatcher(url));
        this.userService =applicationContext.getBean(UserService.class);
        this.userRepository=applicationContext.getBean(UserRepository.class);
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        // 返回一个验证令牌
        if (req.getMethod().equals("OPTIONS")){
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
            res.setHeader("Access-Control-Allow-Headers","*");
            return null;
        }
        res.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
        res.setHeader("Access-Control-Expose-Headers","username");
        String username=req.getParameter("name");
        String password=req.getParameter("password");
        if (username==null||password==null) return null;
        if (req.getRequestURI().contains("signUp")){
            String signature=req.getParameter("signature");
            //直接的Filter未作数组分割，是我着相了...
            String types=req.getParameter("myTypes");
            String[] myTypes=types.split(",");
            String name=req.getParameter("name");
            if (name==null) return null;
            ResponseBox responseBox=userService.signUp(username,password,signature,myTypes);
            if (!responseBox.isResult()) return null;
//            userService.modifyUserInfo(username,username,signature,myTypes);
        }
        if (req.getRequestURI().contains("signIn")){
            ResponseBox responseBox=userService.signIn(username,password);
            if (!responseBox.isResult()) return null;
        }
        res.setHeader("username", username);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(userRepository.getUserByName(username).getId(),password)
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) {
        TokenAuthentication.addAuthentication(res, auth.getName(),"ROLE_USER");
    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().println(JSONResult.fillResultString(500, "Internal Server Error!!!",null));
    }
}

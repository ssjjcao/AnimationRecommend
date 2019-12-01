package animation_recommend_backend.securityUtils.filter;

import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.securityUtils.TokenAuthentication;
import animation_recommend_backend.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {
    UserRepository userRepository;

    public JWTAuthenticationFilter(ApplicationContext applicationContext) {
        this.userRepository=applicationContext.getBean(UserRepository.class);
    }
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setHeader("Access-Control-Allow-Origin", servletRequest.getHeader("Origin"));
        servletResponse.setHeader("Access-Control-Allow-Headers", "*");
        if (servletRequest.getMethod().equals("OPTIONS")) {
            servletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            Authentication authentication = TokenAuthentication
                    .getAuthentication(servletRequest);
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
            if (authentication!=null) {
                String username=userRepository.getOne(Integer.valueOf(authentication.getName())).getName();
                System.out.println("************************\n");
                System.out.println(username);
                System.out.println("************************\n");
                servletRequest.setAttribute("username", username);
            }
//            else return;
            //ToDO 其他异常情况
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

package animation_recommend_backend.securityUtils.filter;

import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.securityUtils.TokenAuthentication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class JWTAuthenticationFilter extends GenericFilterBean {
    UserRepository userRepository;

    public JWTAuthenticationFilter(ApplicationContext applicationContext) {
        this.userRepository = applicationContext.getBean(UserRepository.class);
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
            if (authentication != null) {
                String username = userRepository.getOne(Integer.valueOf(authentication.getName())).getName();
//                System.out.println("************************\n");
//                System.out.println(username);
//                System.out.println("************************\n");
                ModifyParametersWrapper prettyFaceRequest=new ModifyParametersWrapper(servletRequest);
                prettyFaceRequest.setUsername(username);
//                System.out.println(prettyFaceRequest.getParameter("username"));
                filterChain.doFilter(prettyFaceRequest, servletResponse);
                return;
            }
//            else return;
            //ToDO 其他异常情况
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}

/**
 * 继承HttpServletRequestWrapper，创建装饰类，以达到修改HttpServletRequest参数的目的
 */
class ModifyParametersWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap; // 所有参数的Map集合
    private String username;

    public ModifyParametersWrapper(HttpServletRequest request) {
        super(request);
        parameterMap = request.getParameterMap();
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
     *
     * @param name 指定参数名
     * @return 指定参数名的值
     */
    @Override
    public String getParameter(String name) {
        if (name.equals("username"))
            return username;
        else return super.getParameter(name);

    }
    /**
     * 获取指定参数名的所有值的数组，如：checkbox的所有数据
     * 接收数组变量 ，如checkobx类型
     */
    @Override
    public String[] getParameterValues(String name) {
        if (name.equals("username"))
            return new String[]{username};
        else return super.getParameterValues(name);
    }
}

package animation_recommend_backend.Configuration;

import animation_recommend_backend.securityUtils.filter.JWTAuthenticationFilter;
import animation_recommend_backend.securityUtils.filter.JWTUserFilter;
import animation_recommend_backend.securityUtils.provider.CustomAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                // 所有 / 的所有请求 都放行
                .antMatchers("/").permitAll()
                // 角色检查 所有请求需要身份认证
                .antMatchers("/user","/attitude","/comment").hasRole("USER")
                .antMatchers("/img/**","/animation/**","/comment/getAllComments","/type/**").permitAll()
               // .antMatchers("/swagger-ui.html").permitAll()
                .anyRequest().authenticated()
                .and()
                // 添加一个过滤器 所有访问 登陆注册 的请求交给 JWTUserFilter 来处理 这个类处理所有的JWT相关内容
                .addFilterBefore(new JWTUserFilter("/user/signIn", authenticationManager(),getApplicationContext()),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTUserFilter("/user/signUp",authenticationManager(),getApplicationContext()),UsernamePasswordAuthenticationFilter.class)
            // 添加一个过滤器验证其他请求的Token是否合法
            .addFilterBefore(new JWTAuthenticationFilter(getApplicationContext()),
    UsernamePasswordAuthenticationFilter.class);
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider());
    }
}

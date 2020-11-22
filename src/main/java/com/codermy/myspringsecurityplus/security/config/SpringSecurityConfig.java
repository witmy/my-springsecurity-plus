package com.codermy.myspringsecurityplus.security.config;


import com.codermy.myspringsecurityplus.security.UserDetailsServiceImpl;
import com.codermy.myspringsecurityplus.security.filter.JwtAuthenticationTokenFilter;
import com.codermy.myspringsecurityplus.security.filter.VerifyCodeFilter;
import com.codermy.myspringsecurityplus.security.handler.MyAuthenticationFailureHandler;
import com.codermy.myspringsecurityplus.security.handler.MyAuthenticationSuccessHandler;
import com.codermy.myspringsecurityplus.security.handler.RestAuthenticationEntryPoint;
import com.codermy.myspringsecurityplus.security.handler.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author codermy
 * @createTime 2020/7/15
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 验证码拦截器
     */
    @Autowired
    private VerifyCodeFilter verifyCodeFilter;

    /**
     * 登录成功逻辑
     */
    @Autowired
    MyAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 登录失败逻辑
     */
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 无权限拦截器
     */
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 无权访问 JSON 格式的数据
     */
    @Autowired
    private RestfulAccessDeniedHandler accessDeniedHandler;



    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行静态资源
        web.ignoring()
                .antMatchers(HttpMethod.GET,
                        "/swagger-resources/**",
                        "/PearAdmin/**",
                        "/component/**",
                        "/admin/**",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v2/**",
                        "/druid/**");
    }

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        //关闭csrf
        http.csrf().disable()
                // .sessionManagement()// 基于token，所以不需要session
                // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // .and()
                //未登陆时返回 JSON 格式的数据给前端
                .httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                //任何人都能访问这个请求
                .antMatchers("/captcha").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //登录页面 不设限访问
                .loginPage("/login.html")
                //拦截的请求
                .loginProcessingUrl("/login")
                // 登录成功
                .successHandler(authenticationSuccessHandler)
                // 登录失败
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .rememberMe().rememberMeParameter("rememberme")
                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and();

        // 禁用缓存
        http.headers().cacheControl();



        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /**
     * 身份认证接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


}

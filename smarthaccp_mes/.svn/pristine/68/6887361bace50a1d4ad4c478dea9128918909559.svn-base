package com.ppm.mes;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.chequer.axboot.core.utils.CookieUtils;
import com.ppm.mes.code.GlobalConstants;
import com.ppm.mes.domain.user.user000.UserService;
import com.ppm.mes.logging.AXBootLogbackMdcFilter;
import com.ppm.mes.security.AXBootAuthenticationEntryPoint;
import com.ppm.mes.security.AXBootAuthenticationFilter;
import com.ppm.mes.security.AXBootLoginFilter;
import com.ppm.mes.security.AXBootTokenAuthenticationService;
import com.ppm.mes.security.AXBootUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
@Configuration
public class AXBootSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_API = "/api/login";
	public static final String LOGOUT_API = "/api/logout";
    
    public static final String LOGIN_PAGE = "/jsp/login.jsp";
    public static final String LOGIN_POP_PAGE = "/jsp/pop/login.jsp";
    
    public static final String ACCESS_DENIED_PAGE = "/jsp/common/not-authorized.jsp?errorCode=401";
    public static final String ROLE = "ASP_ACCESS";

    public static final String[] ignorePages = new String[]{
            "/resources/**",
            "/ppmboot.config.js",
            "/assets/**",
            "/jsp/common/**",
            "/jsp/setup/**",
            "/swagger/**",
            "/api-docs/**",
            "/setup/**",
            "/h2-console/**",
            "/health",
            "/api/v1/aes/**",
            "/jsp/install/**",
            "/api/v1/open/**",
            "/api/v1/sr/**",
            "/api/v1/pop/**",
            "/api/v1/barcode/**",
            "/api/v1/pda/**",
            "/jsp/help-desk.jsp",
            "/jsp/sso_login.jsp",
            "/jsp/sso_login_success.jsp"
            
    };

    @Inject private AXBootUserDetailsService userDetailsService;
    @Inject private UserService userService;
    @Inject private SHAPasswordEncoder bCryptPasswordEncoder;
    @Inject private AXBootTokenAuthenticationService tokenAuthenticationService;


    public AXBootSecurityConfig() {
        super(true);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(ignorePages);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
		         .anonymous()
		         .and()
		         .authorizeRequests()
		         //.anyRequest()
		         //.hasRole(ROLE)
		         .antMatchers(HttpMethod.POST, LOGIN_API).permitAll()
		         .antMatchers(LOGIN_PAGE).permitAll()
		         .and()
		         .formLogin().loginPage(LOGIN_PAGE).permitAll()
		         .and()
		         .logout().logoutUrl(LOGOUT_API)
		         .deleteCookies(GlobalConstants.ADMIN_AUTH_TOKEN_KEY, GlobalConstants.LAST_NAVIGATED_PAGE)
		         .logoutSuccessHandler(new LogoutSuccessHandler(LOGIN_PAGE)).permitAll()
		         .and()
		         .exceptionHandling().authenticationEntryPoint(new AXBootAuthenticationEntryPoint())
		         .and()
		         .addFilterBefore(new AXBootLoginFilter(LOGIN_API, tokenAuthenticationService, userService, authenticationManager(), new AXBootAuthenticationEntryPoint()), UsernamePasswordAuthenticationFilter.class)
		         .addFilterBefore(new AXBootAuthenticationFilter(tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class)
		         .addFilterAfter(new AXBootLogbackMdcFilter(), UsernamePasswordAuthenticationFilter.class);
		 
		 /*
		 http.sessionManagement()
		 .maximumSessions(1) // session 허용 갯수 
		 .expiredUrl(LOGOUT_API) // session 만료시 이동 페이지
		 .maxSessionsPreventsLogin(false)// 동일한 사용자 로그인시 x, false 일 경우 기존 사용자
		 .sessionRegistry(sessionRegistry());
		 */
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected AXBootUserDetailsService userDetailsService() {
        return userDetailsService;
    }

    class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        public LogoutSuccessHandler(String defaultTargetURL) {
            this.setDefaultTargetUrl(defaultTargetURL);
        }

        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            CookieUtils.deleteCookie(GlobalConstants.ADMIN_AUTH_TOKEN_KEY);
            CookieUtils.deleteCookie(GlobalConstants.LAST_NAVIGATED_PAGE);
            request.getSession().invalidate();
            super.onLogoutSuccess(request, response, authentication);
        }
    }
}

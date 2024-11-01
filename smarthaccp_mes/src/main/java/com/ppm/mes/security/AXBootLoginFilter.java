package com.ppm.mes.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.code.ApiStatus;
import com.chequer.axboot.core.utils.HttpUtils;
import com.chequer.axboot.core.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppm.mes.domain.user.user000.SessionUser;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.domain.user.user000.UserService;
import com.ppm.mes.utils.AES256Util;

public class AXBootLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final AXBootTokenAuthenticationService adminTokenAuthenticationService;
    private final AXBootAuthenticationEntryPoint adminAuthenticationEntryPoint;
    private final UserService userService; 

    public AXBootLoginFilter(String urlMapping, AXBootTokenAuthenticationService adminTokenAuthenticationService, UserService userService, AuthenticationManager authenticationManager, AXBootAuthenticationEntryPoint adminAuthenticationEntryPoint) {
        super(new AntPathRequestMatcher(urlMapping));

        this.adminTokenAuthenticationService = adminTokenAuthenticationService;
        this.userService = userService;
        this.adminAuthenticationEntryPoint = adminAuthenticationEntryPoint;
        this.setAuthenticationFailureHandler(new LoginFailureHandler());
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        
    	final SessionUser user = new ObjectMapper().readValue(request.getReader(), SessionUser.class);   

    	String company = user.getCompany();
    	String language = user.getLanguage();
    	String userPs = user.getPassword();
    	
        if(null!=user.getSsoPassword() && !user.getSsoPassword().equals("")){

    		String key = "aes256-mes-key!!";       // key는 16자 이상
    		AES256Util aes256Util = new AES256Util(key);

        	try{
                User u = userService.findOne(user.getUsername());
            	String decUserPs = aes256Util.aesDecode(u.getUserSsoPs());
                userPs = decUserPs;
        	}catch(Exception e){
        		userPs = "";
        	}
        }        

        request.getSession().setAttribute("company", company);      
        request.getSession().setAttribute("language", language);       
        
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(user.getUsername(), userPs);
        return getAuthenticationManager().authenticate(loginToken);
    }

    @Override
    @Transactional
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        
    	final AXBootUserAuthentication userAuthentication = new AXBootUserAuthentication((SessionUser) authentication.getPrincipal());
        adminTokenAuthenticationService.addAuthentication(response, userAuthentication);

        response.setContentType(HttpUtils.getJsonContentType(request));
        response.getWriter().write(JsonUtils.toJson(ApiResponse.of(ApiStatus.SUCCESS, "Login Success")));
        response.getWriter().flush();
    }

    private class LoginFailureHandler implements AuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            adminAuthenticationEntryPoint.commence(request, response, exception);
        }
    }
}

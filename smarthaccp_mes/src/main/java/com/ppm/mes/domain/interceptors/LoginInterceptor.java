package com.ppm.mes.domain.interceptors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class LoginInterceptor extends HandlerInterceptorAdapter {

	   @Inject private JdbcTemplate jdbcTemplate;
	   private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);    
	   @Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		   return true;
	   }
	   @Override   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,    
			   ModelAndView modelAndView) throws Exception {
		      // TODO Auto-generated method stub   
		   }
	   @Override   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		         throws Exception {
		      // TODO Auto-generated method stub   }

		   }
	   
	   

	    public String getHostName() {

	        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
	        String ip = req.getHeader("X-FORWARDED-FOR");
	        if (ip == null)
	            ip = req.getRemoteAddr();
	        
	        try {
	            //ip = ContextUtil.getLocalHostName();
	            return ip;
	        } catch (Exception e) {
	            // ignored
	        }
	        return null;
	    }
}
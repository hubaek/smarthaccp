package com.ppm.mes.domain.user.user000;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.SHAPasswordEncoder;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.user.user050.UserAuthService;
import com.ppm.mes.domain.user.user100.UserCompany;
import com.ppm.mes.domain.user.user100.UserCompanyService;
import com.ppm.mes.utils.AES256Util;
import com.querydsl.core.BooleanBuilder;


@Service
public class UserService extends BaseService<User, String> {

    private UserRepository repository;

    @Inject private SHAPasswordEncoder bCryptPasswordEncoder;
    @Inject private UserAuthService userAuthService;
    @Inject private UserCompanyService userCompanyService;
    @Inject private UserMapper userMapper;
    
    @Inject
    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //조회
    public List<UserVO> getUserList(RequestParams<UserVO> requestParams) {
    	return userMapper.getUserList(requestParams);
    }
    
    //POP 권한 대상유저 조회
    public List<PopAuthUserVO> getPopAuthUserList(RequestParams<PopAuthUserVO> requestParams) {
    	return userMapper.getPopAuthUserList(requestParams);
    }

    
    @Transactional
    public void saveUser(User user) throws Exception {
    	if(null!=user){    		
    		
            delete(qUserCompany).where(qUserCompany.userCd.eq(user.getUserCd())).execute();

    		String key = "aes256-mes-key!!";       // key는 16자 이상
    		AES256Util aes256Util = new AES256Util(key);
    		
    	    String encSsoPs = aes256Util.aesEncode(user.getUserPs());
    	    
    	    String password = bCryptPasswordEncoder.encode(user.getUserPs());
    	    User originalUser = repository.findOne(user.getUserCd());
    	
    	    if (originalUser != null) {
    	        if (isNotEmpty(user.getUserPs())) {
    	            user.setPwUpdateDt(Instant.now(Clock.systemUTC()));
    	            user.setUserPs(password);
    	            user.setUserSsoPs(encSsoPs);
    	        } else {
    	            user.setUserPs(originalUser.getUserPs());
    	            user.setUserSsoPs(originalUser.getUserSsoPs());
    	        }
    	    } else {
    	        user.setPwUpdateDt(Instant.now(Clock.systemUTC()));
    	        user.setUserPs(password);
    	    }
    	        	    
    	    save(user);    	       
            
            List<UserCompany> userCompany = user.getUserCompany();
            userCompanyService.save(userCompany);
    	}
	}

    public User getUser(RequestParams requestParams) {
        User user = getOne(requestParams);
        if (user != null) {
            user.setUserCompany(userCompanyService.get(requestParams));
        }
        return user;
    }
    
    public User getOne(RequestParams requestParams) {
        String userCd = requestParams.getString("userCd");
        String userNm = requestParams.getString("userNm");

        BooleanBuilder builder = new BooleanBuilder();
        
        if (isNotEmpty(userCd)) {
            builder.and(qUser.userCd.eq(userCd));
        }
        
        if (isNotEmpty(userNm)) {
            builder.and(qUser.userNm.eq(userNm));
        }
        User user = select().from(qUser).where(builder).orderBy(qUser.userNm.asc()).fetchOne();
        return user;
    }

    public List<User> get(RequestParams requestParams) {

    	String userCd = requestParams.getString("userCd");
        String userNm = requestParams.getString("userNm");

        BooleanBuilder builder = new BooleanBuilder();
        
        if (isNotEmpty(userCd)) {
            builder.and(qUser.userCd.eq(userCd));
        }
        
        if (isNotEmpty(userNm)) {
            builder.and(qUser.userNm.eq(userNm));
        }

        List<User> list = select().from(qUser).where(builder).orderBy(qUser.userNm.asc()).fetch();

        return list;
    }

    @Transactional
    public void changePw(User user) throws Exception {
    	if(null!=user){    		

    		String key = "aes256-mes-key!!";       // key는 16자 이상
    		AES256Util aes256Util = new AES256Util(key);
    	    String encSsoPs = aes256Util.aesEncode(user.getUserPs());
    	    
    	    String password = bCryptPasswordEncoder.encode(user.getUserPs());
    	    User originalUser = repository.findOne(user.getUserCd());
    	    
    	    
    	    if (originalUser != null) {
    	        if (isNotEmpty(user.getUserPs())) {
    	            user.setPwUpdateDt(Instant.now(Clock.systemUTC()));
    	            user.setUserPs(password);
    	            user.setUserSsoPs(encSsoPs);
    	        } else {
    	            user.setUserSsoPs(originalUser.getUserSsoPs());
    	        }
    	    }    	        	    
    	    save(user);    	     
    	}
	}

    @Transactional
    public void setLoginDate(String userCd) {    
    	update(qUser)
			.set(qUser.lastLoginDt, Instant.now(Clock.systemUTC()))
			.set(qUser.ip, getHostName())
    		.where(qUser.userCd.eq(userCd)).execute();
    }

    public String getHostName() {
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = req.getRemoteAddr();
        
        try {
            return ip;
        } catch (Exception e) {
        }
        return null;
    }
}

package com.ppm.mes.security;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.DateTimeUtils;
import com.ppm.mes.domain.auth.auth000.AuthGroup;
import com.ppm.mes.domain.auth.auth000.AuthGroupService;
import com.ppm.mes.domain.user.user000.SessionUser;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.domain.user.user000.UserService;
import com.ppm.mes.domain.user.user050.UserAuth;
import com.ppm.mes.domain.user.user050.UserAuthService;
import com.ppm.mes.utils.UserLogUtil;

@Service
public class AXBootUserDetailsService implements UserDetailsService {

    @Inject private UserService userService;
    @Inject private UserAuthService userAuthService;
    @Inject private AuthGroupService authGroupService;
    
    @Override
    public final SessionUser loadUserByUsername(String userCd) throws UsernameNotFoundException {
    	
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        String company = (String) request.getSession().getAttribute("company");
        String language = (String) request.getSession().getAttribute("language" );

    	User user = userService.findOne(userCd);

    	if (user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요.");
        }
        
    	if (user.getUseYn().equals("N")) {
            throw new UsernameNotFoundException("존재하지 않는 사용자 입니다.");
        }

        if (!user.getUserSt().equals("NORMAL")) {
            throw new UsernameNotFoundException("해당 계정은 현재 잠김상태입니다.관리자에게 문의하세요.");
        }

        System.out.println("##company:"+company);
        System.out.println("##userCd:"+userCd);
        System.out.println("##language:"+language);
       
        List<UserAuth> userAuthList = userAuthService.getUserAuthList(company,userCd);

        SessionUser sessionUser = new SessionUser();
        sessionUser.setCompany(company);
        sessionUser.setUserCd(user.getUserCd());
        sessionUser.setUserNm(user.getUserNm());
        sessionUser.setUserPs(user.getUserPs());
        sessionUser.setUserSsoPs(user.getUserSsoPs());
        sessionUser.setHpNo(user.getHpNo());  
        sessionUser.setEmail(user.getEmail());
        sessionUser.setDeptCd(user.getDeptCd());
        sessionUser.setSystemType(user.getSystemType());



        //권한이 없는 유져인경우, 권한마스터에 기본권한이 y인 권한으로  default 셋팅.
        if(userAuthList.isEmpty()){       
    		RequestParams<AuthGroup> requestParams = new RequestParams<>(AuthGroup.class);
    		requestParams.put("company",company);
    		requestParams.put("defaultYn","Y");
    		List<AuthGroup> authList = authGroupService.getGroupList(requestParams);
    		authList.forEach(a -> sessionUser.addAuthGroup(a.getGrpAuthCd()));   		
        }else{
            userAuthList.forEach(a -> sessionUser.addAuthGroup(a.getGrpAuthCd()));
        }

        String[] localeString = language.split("_");
        
        Locale locale = new Locale(localeString[0], localeString[1]);

        final Calendar cal = Calendar.getInstance();
        final TimeZone timeZone = cal.getTimeZone();

        sessionUser.setTimeZone(timeZone.getID());
        sessionUser.setDateFormat(DateTimeUtils.dateFormatFromLocale(locale));
        sessionUser.setTimeFormat(DateTimeUtils.timeFormatFromLocale(locale));
        sessionUser.setLocale(locale);
        sessionUser.setLanguage(localeString[0]);

        //로그인 ip,시간,LOCALE 저장
    	userService.setLoginDate(userCd); 
		UserLogUtil.saveUserLog(userCd,"LOGIN","로그인","GET");
        return sessionUser;
    }
}

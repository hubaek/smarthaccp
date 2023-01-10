package com.ppm.mes.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.config.AXBootContextConfig;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.cp.cp000.CompanyManagement;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.ppm.mes.domain.init.DatabaseInitService;
import com.ppm.mes.domain.user.user000.SessionUser;
import com.ppm.mes.security.AXBootTokenAuthenticationService;
import com.ppm.mes.security.AXBootUserAuthentication;
import com.ppm.mes.security.AXBootUserDetailsService;
import com.ppm.mes.utils.KISA_SEED_CBC;
import com.ppm.mes.utils.SessionUtils;

@RequestMapping("/haccpLogin")
@Controller
public class HaccpLoginController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HaccpLoginController.class);

    @Inject
    private AXBootContextConfig axBootContextConfig;

    @Inject
    private DatabaseInitService databaseInitService;
    
    @Inject
    private CompanyManagementService companyManagementService;
    
    @Inject
    private AXBootUserDetailsService userDetailsService;
    
    @Inject
    private AXBootTokenAuthenticationService adminTokenAuthenticationService;

    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginFromHACCP", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginFromHACCP(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String pattern = "(#SECRET_MES_)(.*)(_USER_SECRET#)";
        String userId = request.getParameter("userId");
        String authToken = request.getParameter("authToken");
        //String rtn = "/help/basic";
        String rtn = "redirect:/";
        
        /* 아이디 규칙 : #SECRET_MES_{사용자아이디}_USER_SECRET# (#은 %23으로 변환해서 보내줘야함) */
        /* 토큰 규칙 : 암호화된 현재 시간 (yyyyMMddHHmmss) */
        
        if (!StringUtils.hasText(userId)) {
        	logger.warn("토큰 로그인 처리 실패 : {}", "사용자 아이디 미입력");
            return rtn;
        } else if (!StringUtils.hasText(authToken)) {
        	logger.warn("토큰 로그인 처리 실패 : {}", "보안 토큰 미입력");
            return rtn;
        } else {
            String decUserId = KISA_SEED_CBC.decrypt(userId);

            if (!Pattern.matches(pattern, decUserId)) {
            	logger.warn("토큰 로그인 처리 실패 : {}", "잘못된 사용자 아이디 (입력된 사용자 아이디 : " + userId + ")");
                return rtn;
            } else {
                decUserId = decUserId.replaceAll(pattern, "$2");

                long loginLimitMinutes = 5; // 토큰 로그인 허용 시간 (5분)
                //long loginLimitMinutes = 30;
                try {
                    String decAuthToken = KISA_SEED_CBC.decrypt(authToken);
                    LocalDateTime now = LocalDateTime.now();
                    LocalDateTime tokenTime = LocalDateTime.parse(decAuthToken, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                    tokenTime = tokenTime.plusMinutes(loginLimitMinutes);

                    if (now.isAfter(tokenTime)) {
                    	logger.warn("토큰 로그인 처리 실패 : {}", "보안 토큰 시간이 만료됨 (토큰시간[+" + loginLimitMinutes + "분] : " + tokenTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", 현재시간 : " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ")");
                        return rtn;
                    }
                } catch (Exception e) {
                	logger.warn("토큰 로그인 처리 실패 : {}", "잘못된 보안 토큰 (입력된 보안 토큰 : " + authToken + "), " + e.getMessage());
                    return rtn;
                }

                if (StringUtils.hasText(decUserId)) {
                    try {
                    	String company = "";
                        String language = "ko_KR";
                        
                        RequestParams<CompanyManagement> requestParams = new RequestParams<CompanyManagement>();
                        requestParams.setParameterMap(new HashMap<String, String[]>(){{
                            put("useYn", new String[]{"Y"});
                        }});
                        List<CompanyManagement> companyList = companyManagementService.gets(requestParams);
                        company = companyList.get(0).getCompany(); 
                        
                        request.getSession().setAttribute("company", company);
                        request.getSession().setAttribute("language", language);
                    	
                        SessionUser user = userDetailsService.loadUserByUsername(decUserId);
                        
                        //AXBootUserAuthentication authentication = new AXBootUserAuthentication(user);
                        
                        //Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                        //SecurityContext securityContext = SecurityContextHolder.getContext();
                        //securityContext.setAuthentication(authentication);

                        logger.info("토큰 로그인 처리 성공 {}", "사용자 아이디 : " + decUserId);

                        final AXBootUserAuthentication userAuthentication = new AXBootUserAuthentication(user);
                        adminTokenAuthenticationService.addAuthentication(response, userAuthentication);
                    } catch (Exception e) {
                    	logger.warn("토큰 로그인 처리 실패 {}", "로그인 처리 오류 (" + e.getMessage() + ")");
                        return rtn;
                    }
                }
            }

            rtn = "redirect:/";
        }
        
        return rtn;
    }
    
    @Value("${service.haccp.url}")
    String serviceHaccpUrl;
    
    /**
     * HACCP으로 이동 (EGM SmartHaccp 대응)
     *
     * @param model 기본모델
     * @return 로그인 된 페이지
     * @throws Exception 예외처리
     */
    @RequestMapping(value = "/loginToHACCP", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginToHACCP(Model model) throws Exception {
    	model.addAttribute("serviceHaccpUrl", serviceHaccpUrl);
    	
        String userId = "#SECRET_MES_" + SessionUtils.getCurrentLoginUserCd() + "_USER_SECRET#";
        String encryptedUserId = KISA_SEED_CBC.encrypt(userId);
        model.addAttribute("encryptedUserId", encryptedUserId);

        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String encryptedAuthToken = KISA_SEED_CBC.encrypt(today);
        model.addAttribute("encryptedAuthToken", encryptedAuthToken);
        
        return "/haccp/loginToHACCP";
    }
}

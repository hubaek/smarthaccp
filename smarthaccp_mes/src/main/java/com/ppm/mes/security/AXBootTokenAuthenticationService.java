package com.ppm.mes.security;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chequer.axboot.core.code.AXBootTypes;
import com.chequer.axboot.core.utils.ContextUtil;
import com.chequer.axboot.core.utils.CookieUtils;
import com.chequer.axboot.core.utils.JsonUtils;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.utils.PhaseUtils;
import com.chequer.axboot.core.utils.RequestUtils;
import com.ppm.mes.code.GlobalConstants;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenu;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenuService;
import com.ppm.mes.domain.menu.menu000.Menu;
import com.ppm.mes.domain.menu.menu000.MenuService;
import com.ppm.mes.domain.pgm.pgm000.Program;
import com.ppm.mes.domain.user.user000.SessionUser;
import com.ppm.mes.utils.JWTSessionHandler;
import com.ppm.mes.utils.session.ScriptSessionVO;

@Service
public class AXBootTokenAuthenticationService {

    private final JWTSessionHandler jwtSessionHandler; 

    @Inject private AuthGroupMenuService authGroupMenuService;
    @Inject private MenuService menuService;    

    public AXBootTokenAuthenticationService() {
        jwtSessionHandler = new JWTSessionHandler(DatatypeConverter.parseBase64Binary("YXhib290"));
    }

    public int tokenExpiry() {
        if (PhaseUtils.isProduction()) {
            return 60 * 10 * 10 * 10 * 10;
            //return 60 * 60;
        } else {
            return 60 * 10 * 10 * 10 * 10;
        }
    }

    public void addAuthentication(HttpServletResponse response, AXBootUserAuthentication authentication) throws IOException {
        final SessionUser user = authentication.getDetails();

        CookieUtils.addCookie(response, GlobalConstants.LANGUAGE_PARAMETER_KEY, user.getUserLanguage());
        
        setUserEnvironments(user, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void setUserEnvironments(SessionUser user, HttpServletResponse response) throws IOException {
        String token = jwtSessionHandler.createTokenForUser(user);
        CookieUtils.addCookie(response, GlobalConstants.ADMIN_AUTH_TOKEN_KEY, token, tokenExpiry());
    }

    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	RequestUtils requestUtils = RequestUtils.of(request);
        final String token = CookieUtils.getCookieValue(request, GlobalConstants.ADMIN_AUTH_TOKEN_KEY);
        final String progCd = FilenameUtils.getBaseName(request.getServletPath());
        final String menuCd = requestUtils.getString("menuCd");
        final String requestUri = request.getRequestURI();
        
        
        //파라미터로 들어올때만 값이 있음
        final String language = requestUtils.getString(GlobalConstants.LANGUAGE_PARAMETER_KEY, "");
                
        if (StringUtils.isNotEmpty(language)) {
            CookieUtils.addCookie(response, GlobalConstants.LANGUAGE_PARAMETER_KEY, language);
        }

        if (token == null) {
            return deleteCookieAndReturnNullAuthentication(request, response);
        }

        SessionUser user = jwtSessionHandler.parseUserFromToken(token);

        if (user == null) {
            return deleteCookieAndReturnNullAuthentication(request, response);
        }

        if (!requestUri.startsWith(ContextUtil.getBaseApiPath())) {
            if (!StringUtils.isEmpty(menuCd)) {
                Menu menu = menuService.findOne(menuCd);

                if (menu != null) {
                    Program program = menu.getProgram();

                    if (program != null) {
                        requestUtils.setAttribute("program", program);
                        requestUtils.setAttribute("pageName", menu.getLocalizedMenuName(request));
                        requestUtils.setAttribute("pageRemark", program.getRemark());

                        if (program.getAuthCheck().equals(AXBootTypes.Used.YES.getLabel())) {
                        	AuthGroupMenu userAuth = authGroupMenuService.getCurrentAuthGroupMenu(menuCd, user);                       	 
                        	 
                            if (userAuth == null) {
                                throw new AccessDeniedException("Access is denied");
                            }
                            
                            requestUtils.setAttribute("authGroupMenu", userAuth);
                        }
                    }
                }
            }
            
            //vo변환
            ScriptSessionVO scriptSessionVO = ModelMapperUtils.map(user, ScriptSessionVO.class);
            scriptSessionVO.setDateFormat(scriptSessionVO.getDateFormat().toUpperCase());
            
            scriptSessionVO.getDetails().put("language", RequestUtils.getLocale(request).getLanguage());
            scriptSessionVO.getDetails().put("menuGrpCd", user.getMenuGrpCd());            
            
            requestUtils.setAttribute("loginUser", user);
            requestUtils.setAttribute("scriptSession", JsonUtils.toJson(scriptSessionVO));

            if (progCd.equals("main")) {
                List<Menu> menuList = menuService.getAuthorizedMenuList(user.getCompany(), "DEFAULT_GROUP", user.getAuthGroupList());
                requestUtils.setAttribute("menuJson", JsonUtils.toJson(menuList));
            }
        }
        setUserEnvironments(user, response);
        return new AXBootUserAuthentication(user);
    }

    private Authentication deleteCookieAndReturnNullAuthentication(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, GlobalConstants.ADMIN_AUTH_TOKEN_KEY);
        ScriptSessionVO scriptSessionVO = ScriptSessionVO.noLoginSession();
        request.setAttribute("scriptSession", JsonUtils.toJson(scriptSessionVO));
        return null;
    }
}

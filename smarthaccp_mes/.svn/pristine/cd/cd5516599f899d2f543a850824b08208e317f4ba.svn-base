package com.ppm.mes.domain.auth.auth100;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.code.AXBootTypes;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.menu.menu000.Menu;
import com.ppm.mes.domain.menu.menu000.MenuService;
import com.ppm.mes.domain.user.user000.SessionUser;
import com.querydsl.core.BooleanBuilder;

@Service
public class AuthGroupMenuService extends BaseService<AuthGroupMenu, AuthGroupMenu.AuthGroupMenuId> {
    private AuthGroupMenuRepository repository;

    @Inject private MenuService menuService;
     
    @Inject
    public AuthGroupMenuService(AuthGroupMenuRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public AuthGroupMenuVO get(RequestParams requestParams) {
    	
        String menuCd = requestParams.getString("menuCd");
        Menu menu = menuService.findOne(menuCd);
        AuthGroupMenuVO authGroupMenuVO = new AuthGroupMenuVO();

        List<AuthGroupMenu> list = 
        		select()
        		.from(qAuthGroupMenu)
        		.where(qAuthGroupMenu.menuCd.eq(menuCd))
        		.orderBy(qAuthGroupMenu.createdAt.asc()).fetch();
        
        authGroupMenuVO.setList(list);
        authGroupMenuVO.setProgram(menu.getProgram());

        return authGroupMenuVO;
        
    } 
    
    public List<AuthGroupMenu> gets(String menuCd) {

        List<AuthGroupMenu> list = 
        		select()
        		.from(qAuthGroupMenu)
        		.where(qAuthGroupMenu.menuCd.eq(menuCd)).fetch();

        return list;
    }

    public AuthGroupMenu getCurrentAuthGroupMenu(String menuCd, SessionUser sUser) {
    	
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(qAuthGroupMenu.company.eq(sUser.getCompany()));
        builder.and(qAuthGroupMenu.grpAuthCd.in(sUser.getAuthGroupList()));
        builder.and(qAuthGroupMenu.menuCd.eq(menuCd));

        List<AuthGroupMenu> authorizationList = select().from(qAuthGroupMenu).where(builder).fetch();

        AuthGroupMenu authorization = null;

        for (AuthGroupMenu authGroupMenu : authorizationList) {
            if (authorization == null) {
                authorization = authGroupMenu;
            } else {
                authorization.updateAuthorization(authGroupMenu);
            }
        }
        return authorization;
    }
    


    public AuthGroupMenu getCurrentAuthGroupModal(String modalCd, SessionUser sUser) {
    	
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(qAuthGroupMenu.company.eq(sUser.getCompany()));
        builder.and(qAuthGroupMenu.grpAuthCd.in(sUser.getAuthGroupList()));

        List<AuthGroupMenu> authorizationList = select().from(qAuthGroupMenu).where(builder).fetch();

        AuthGroupMenu authorization = null;

        for (AuthGroupMenu authGroupMenu : authorizationList) {
            if (authorization == null) {
                authorization = authGroupMenu;
            } else {
                authorization.updateAuthorization(authGroupMenu);
            }
        }
        return authorization;
    }
    
    /*
     * 메뉴 삭제시 권한동시 삭제
     */
    @Transactional
    public void deleteAuth(String menuCd){
    	delete(qAuthGroupMenu).where(qAuthGroupMenu.menuCd.eq(menuCd)).execute();
    }
    
    /*
     * 메뉴저장시 권한 동시 저장
     */
    @Transactional
    public void saveAuth(List<AuthGroupMenu> authGroupMenuList) {
        for (AuthGroupMenu authGroupMenu : authGroupMenuList) {
            if (authGroupMenu.getUseYn() == AXBootTypes.Used.NO) {
                delete(authGroupMenu);                
            } else {
                save(authGroupMenu);
            }
        }      
    }
}

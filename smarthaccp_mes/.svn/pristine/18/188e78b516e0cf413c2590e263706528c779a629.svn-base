package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenu;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenuService;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenuVO;
import com.ppm.mes.domain.menu.menu000.Menu;
import com.ppm.mes.domain.menu.menu000.MenuRequestVO;
import com.ppm.mes.domain.menu.menu000.MenuService;

/*
 * 메뉴관리
 */
@Controller
@RequestMapping(value = "/api/v2/menu")
public class MenuController extends BaseController {

    @Inject private MenuService menuService;
    @Inject private AuthGroupMenuService authGroupMenuService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse menuList(RequestParams requestParams) {
        List<Menu> list = menuService.get(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody MenuRequestVO menuVO) {
        menuService.processMenu(menuVO);
        return ok();
    }

    @RequestMapping(value = "/{code}", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse update(@PathVariable String code, @RequestBody Menu menu) {
        menuService.updateMenu(code, menu);
        return ok();
    }

    @RequestMapping(value = "/{code}", method = {RequestMethod.GET}, produces = APPLICATION_JSON)
    public Menu update(@PathVariable String code) {
        return menuService.findOne(code);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public AuthGroupMenuVO authMapList(RequestParams requestParams) {
        return authGroupMenuService.get(requestParams);
    }

    @RequestMapping(value = "/auth", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody List<AuthGroupMenu> authGroupMenuList) {
        authGroupMenuService.saveAuth(authGroupMenuList);
        return ok();
    }
}

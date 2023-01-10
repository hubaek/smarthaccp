package com.ppm.mes.domain.menu.menu000;

import java.util.List;

import lombok.Data;

@Data
public class MenuRequestVO {

    private List<Menu> menuList;
    private List<Menu> deletedList;
}

package com.ppm.mes.utils.session;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ScriptSessionVO {

    protected String company;
    private String currency;    
    protected String userCd;
    protected String userNm;
    protected String email;    
    protected String hpNo;
    protected String menuGrpCd;    
    protected Locale locale;    
    protected String timeZone;
    protected String dateFormat;
    protected boolean login = true;
    
    private Map<String, Object> details = new HashMap<>();

    @Getter(AccessLevel.NONE)
    protected String dateTimeFormat;

    protected String timeFormat;

    public String getDateTimeFormat() {
        return dateFormat + " " + timeFormat;
    }

    public static ScriptSessionVO noLoginSession() {
        ScriptSessionVO scriptSessionVO = new ScriptSessionVO();
        scriptSessionVO.setLogin(false);
        return scriptSessionVO;
    }
}

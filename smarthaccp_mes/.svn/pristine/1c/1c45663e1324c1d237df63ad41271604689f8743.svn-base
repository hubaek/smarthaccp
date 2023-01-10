package com.ppm.mes.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/*
//  클래스  명 : JsonUtil
//  클래스설명 : JsonUtil 클래스
//  최초작성일 : 2012-11-12
//  최종수정일 : 2012-12-26
//  Programmer : 박상민
*/
public class JsonUtil
{
    public JsonUtil()
    {
        // 생성자 Code
    }


    /**
     * 함수명   : JsonToMap()
     * FuncDesc : Json String Map 형태 변환
     * Param    : param : Json String
     * Return   : Map<String, Object>
     * Author   :
     * History  : 2012-11-12
    */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> JsonToMap(String param)
    {
        Gson gson = new Gson();

        // 테스트 코드
        /*
        Map<String, Object> map = gson.fromJson(param, new HashMap<String,Object>().getClass());

        Set<Entry<String, Object>> ms = map.entrySet();


        for (Entry<String, Object> e:ms)
        {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        */

        return gson.fromJson(param, new HashMap<String,Object>().getClass());
    }


    /**
     * 함수명   : ListToJson()
     * FuncDesc : Json List Map 형태 변환
     * Param    : res : Json String
     * Return   : Json String
     * Author   :
     * History  : 2012-11-12
    */
    @SuppressWarnings("unchecked")
    public static String ListToJson(List<Map<String, Object>> res)
    {
        Gson gson = new Gson();

        // 테스트 코드
        /*
        Map<String, Object> param = gson.fromJson(param, new HashMap<String,Object>().getClass());

        Set<Entry<String, Object>> ms = param.entrySet();

        for (Entry<String, Object> e:ms)
        {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        */

        return gson.toJson(res);
    }


    /**
     * 함수명   : OneStringToJson()
     * FuncDesc : Json 형태 변환
     * Param    : sData : String
     * Return   : String
     * Author   :
     * History  : 2012-12-26
    */
    @SuppressWarnings("unchecked")
    public static String OneStringToJson(String sData)
    {
        Gson gson = new Gson();

        return gson.toJson(sData);
    }
}

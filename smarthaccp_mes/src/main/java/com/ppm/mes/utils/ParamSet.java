package com.ppm.mes.utils;

import java.util.HashMap;
import java.util.Map;

public class ParamSet{

	private String p;
	private Map pm =null;

	public String getP() {
		return p;
	}
	
	// p 파라미터 저장
	public void setP(String p) {
		this.p = p;
	}
	
	public Map getParamMap(){
		if (pm ==null) {
			if (this.p !=null) pm =JsonUtil.JsonToMap(this.p);
			else pm =new HashMap();
		}
		return pm;
	}
	public String getParamStr(String skey){
		Map m =this.getParamMap();
		if (m==null) return null;
		
		return (String)m.get(skey);
	}
	public void addParam(String skey, Object val){
		if (val==null || this.getParamMap()==null) return;
		this.getParamMap().put(skey, val);
	}

}

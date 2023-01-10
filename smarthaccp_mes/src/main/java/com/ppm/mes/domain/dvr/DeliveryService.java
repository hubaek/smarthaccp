package com.ppm.mes.domain.dvr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.ppm.mes.utils.StringUtil;


@Service
public class DeliveryService {
	
//	택배송장 서비스
public List<Map<String, String>> getDeliveryDetailList(String num, String company) throws Exception {
		String deliveryNo = num;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        //https://apis.tracker.delivery/carriers/kr.cjlogistics/tracks/632675005115
        String url = "https://apis.tracker.delivery/carriers/"+company+"/tracks/";
        url += deliveryNo;
        byte utf8Bytes[] = url.getBytes("utf-8");
        String url2 = new String(utf8Bytes, "utf-8");

        System.out.println("url : "+url);
        try {
     
        	InputStream doc =null;
        	try{
        		doc = new URL(url2).openStream();
        	}catch(Exception ex){
        		URL surl;
				try {
					surl = new URL(url2);
					HttpURLConnection conn;
					conn = (HttpURLConnection)surl.openConnection();
					//conn.setSSLSocketFactory(getSSLSocketFactory());
					if(doc != null){
						doc =conn.getInputStream();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        	if(doc != null){
	        	BufferedReader rd = new BufferedReader(new InputStreamReader(doc));
	        	String line;
	        	StringBuffer r = new StringBuffer(); 
	        	try {
					while((line = rd.readLine()) != null) {
					 r.append(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					rd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	JSONParser jsonParser = new JSONParser();
	        	JSONObject jo1 = (JSONObject)jsonParser.parse(r.toString());
	        	
	        	Object objCarrier =  jsonParser.parse(jo1.get("carrier").toString());
	        	JSONObject jsonCarrier = (JSONObject) objCarrier;
    	System.out.println("##############################################################");
    	System.out.println("배달업체 : "+StringUtil.null2Str(jsonCarrier.get("name")));
    	System.out.println("연락처 : "+StringUtil.null2Str(jsonCarrier.get("tel")));
		    	//System.out.println(jsonCarrier.get("id").toString());
		    		    	
		    	Object objFrom =  jsonParser.parse(StringUtil.null2Str(jo1.get("from")));
	        	JSONObject jsonFrom = (JSONObject) objFrom;	    	
    	System.out.println("보내는사람 : "+StringUtil.null2Str(jsonFrom.get("name")));
		    	String shipDate = StringUtil.null2Str(jsonFrom.get("time"));
		    	shipDate = shipDate.replace("T"," ").replace("+09:00","");
    	System.out.println("발신일자 : "+shipDate);
		    	
		    	
		    	Object objTo =  jsonParser.parse(StringUtil.null2Str(jo1.get("to")));
	        	JSONObject jsonTo = (JSONObject) objTo;	    	
    	System.out.println("받는사람 : "+StringUtil.null2Str(jsonTo.get("name")));
		    	String receDate = StringUtil.null2Str(jsonTo.get("time"));
		    	receDate = receDate.replace("T"," ").replace("+09:00","");
    	System.out.println("수신일자 : "+receDate);
		        
		        JSONArray ja1 =  (JSONArray) jo1.get("progresses");
		        
        System.out.println("##############################################################");
		        for(int i =0;i<ja1.size();i++) {
		        	JSONObject o1 = (JSONObject) ja1.get(i);
		        	Map<String, String> map = new HashMap<String, String>();
		        	Object objLoc =  jsonParser.parse(StringUtil.null2Str(o1.get("location")));
		        	JSONObject jsonLoc = (JSONObject) objLoc;	
        	System.out.println("--------------------------------------------------------------");
	    	System.out.println("위치 : "+StringUtil.null2Str(jsonLoc.get("name")));
			    	
			    	Object objStatus =  jsonParser.parse(StringUtil.null2Str(o1.get("status")));
		        	JSONObject jsonStatus = (JSONObject) objStatus;	    	
	    	System.out.println("상태 : "+StringUtil.null2Str(jsonStatus.get("text")));
        	System.out.println("시간 : "+StringUtil.null2Str(o1.get("time")));
        	System.out.println("상세내역 : "+StringUtil.null2Str(o1.get("description")));
        	System.out.println("--------------------------------------------------------------");
		        	
		        	String strTime = StringUtil.null2Str(o1.get("time"));
		        	strTime = strTime.replace("T"," ").replace("+09:00","");
		        	
		        	String strTimeSort = StringUtil.null2Str(o1.get("time"));
		        	strTimeSort = strTimeSort.replace("T"," ").replace("+09:00","");
		        	strTimeSort = strTimeSort.substring(0, 14);
		        	
		        	String loc = StringUtil.null2Str(jsonLoc.get("name"));
		            byte enLoc[] = loc.getBytes("utf-8");
		            String loc2 = new String(enLoc, "utf-8");
		            
		           	String status = StringUtil.null2Str(jsonStatus.get("text"));
		           	byte enStatus[] = status.getBytes("utf-8");
		            String status2 = new String(enStatus, "utf-8");
		            
		           	String desc = StringUtil.null2Str(o1.get("description"));
		           	byte enDesc[] = desc.getBytes("utf-8");
		            String desc2 = new String(enDesc, "utf-8");
			    	
		            map.put("LOC"		, loc2);
		    		map.put("STATUS"	, status2);
		    		map.put("TIME"		,  strTime);
		    		map.put("TIMESORT"	, strTimeSort);
		    		map.put("DESC"		, desc2);
		    		map.put("SORT"		, Integer.toString(i));
		        	
		    		list.add(map);
		        }
		        
		        
		        
		        // 오름차순 정렬
		        list.sort(new Comparator<Map<String, String>>() {
		             
		               @Override
					public int compare(Map<String, String> arg0, Map<String, String> arg1) {
		                      // TODO Auto-generated method stub
		                      String age0 = arg0.get("SORT");
		                      String age1 = arg1.get("SORT");
		                      if (age0.compareTo(age1) == 0)
		                            return 0;
		                      else if (age0.compareTo(age1) == 1)
		                            return 1;
		                      else
		                            return -1;
		               }
	
		         });
		         
        	}
        } catch (Exception e) {
	        e.printStackTrace();
        }return list;

        
	}

//택배송장 서비스
public List<Map<String, String>> getDeliveryMasterList(String num, String company) throws Exception {
	String deliveryNo = num;
	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    //https://apis.tracker.delivery/carriers/kr.cjlogistics/tracks/632675005115
    String url = "https://apis.tracker.delivery/carriers/"+company+"/tracks/";
    url += deliveryNo;
    byte utf8Bytes[] = url.getBytes("utf-8");
    String url2 = new String(utf8Bytes, "utf-8");
    
    try {
 
    	InputStream doc =null;
    	try{
    		doc = new URL(url2).openStream();
    	}catch(Exception ex){
    		URL surl;
			try {
				surl = new URL(url2);
				HttpURLConnection conn;
				conn = (HttpURLConnection)surl.openConnection();
				//conn.setSSLSocketFactory(getSSLSocketFactory());
				if(doc != null){
					doc =conn.getInputStream();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(doc != null){
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(doc));
	    	String line;
	    	StringBuffer r = new StringBuffer(); 
	    	try {
				while((line = rd.readLine()) != null) {
				 r.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Map<String, String> map = new HashMap<String, String>();
	    	JSONParser jsonParser = new JSONParser();
	    	JSONObject jo1 = (JSONObject)jsonParser.parse(r.toString());
	    	
	    	Object objCarrier =  jsonParser.parse(jo1.get("carrier").toString());
	    	JSONObject jsonCarrier = (JSONObject) objCarrier;
	    	System.out.println("##############################################################");
	    	System.out.println("배달업체 : "+jsonCarrier.get("name").toString());
	    	System.out.println("연락처 : "+jsonCarrier.get("tel").toString());
	    	//System.out.println(jsonCarrier.get("id").toString());
	    		    	
	    	Object objFrom =  jsonParser.parse(jo1.get("from").toString());
	    	JSONObject jsonFrom = (JSONObject) objFrom;	    	
	    	System.out.println("보내는사람 : "+jsonFrom.get("name").toString());
	    	String shipDate = jsonFrom.get("time").toString();
	    	shipDate = shipDate.replace("T"," ").replace("+09:00","");
	    	System.out.println("발신일자 : "+shipDate);
	    	
	    	
	    	Object objTo =  jsonParser.parse(jo1.get("to").toString());
	    	JSONObject jsonTo = (JSONObject) objTo;	    	
	    	System.out.println("받는사람 : "+jsonTo.get("name").toString());
	    	String receDate =  StringUtil.null2Str(jsonTo.get("time"));
	    	receDate = receDate.replace("T"," ").replace("+09:00","");
	    	System.out.println("수신일자 : "+receDate);
	    	System.out.println("##############################################################");
	        
	        JSONArray ja1 =  (JSONArray) jo1.get("progresses"); 
	        
	    	String from = jo1.get("from").toString();
	        byte enFrom[] = from.getBytes("utf-8");
	        String from2 = new String(enFrom, "utf-8");
	        
	       	String sender = jsonFrom.get("name").toString();
	       	byte enSender[] = sender.getBytes("utf-8");
	        String sender2 = new String(enSender, "utf-8");
	        
	       	String receiver = jsonTo.get("name").toString();
	       	byte enReceiver[] = receiver.getBytes("utf-8");
	        String receiver2 = new String(enReceiver, "utf-8");
	        
	       	String cust = jsonCarrier.get("name").toString();
	       	byte enCust[] = cust.getBytes("utf-8");
	        String cust2 = new String(enCust, "utf-8");
	        
	        map.put("from", from2);
			map.put("SENDER", sender2);
			map.put("shipDate",  shipDate);
			map.put("RECEIVER", receiver2);
			map.put("receDate", receDate);
	       	map.put("cust", cust2);       
	        
	       	list.add(map);
    	}
    } catch (Exception e) {
        e.printStackTrace();
    }return list;

    
}
	
}

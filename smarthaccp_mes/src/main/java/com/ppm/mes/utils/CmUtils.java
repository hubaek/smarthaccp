package com.ppm.mes.utils;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chequer.axboot.core.context.AppContextManager;
import com.chequer.axboot.core.utils.PhaseUtils;


@Service
public class CmUtils {
	
    @Inject private JdbcTemplate jdbcTemplate;
    
    private static String API_DOMAIN = "komico.8pm.kr";
    
	public void runProgram(String executableMethod,String executableNm){
		//API
		if(executableMethod.equals("API")){
			try { 			
				RestTemplate rest = new RestTemplate();
				Map<String, String> vars = new HashMap<String, String>();
				vars.put("userCd", "system");
				String result = "";

		        if (PhaseUtils.isProduction()) {
					result = rest.getForObject("http://" + API_DOMAIN + executableNm, String.class, vars);		
					System.out.println("###### END CM (API) ##http://" + API_DOMAIN + executableNm  + result.toString());
		        }else{
					InetAddress local; 
					local = InetAddress.getLocalHost(); 
					String ip = local.getHostAddress(); 	
					
					result = rest.getForObject("http://" + ip + ":8080" + executableNm, String.class, vars);		
					System.out.println("###### END CM (API) ##http://" + ip + ":8080"+ executableNm  + result.toString());
		        }
					
			} catch (UnknownHostException e1) 
			{ 
				e1.printStackTrace(); 
			}
		}
	} 

    public static JdbcTemplate getService() {
        return AppContextManager.getBean(JdbcTemplate.class);
    }
	
	public void runCm(){
		this.jdbcTemplate = getService();
		
		String cmSql = " SELECT A.CM_RUN_EVERY, " +
                "          A.CM_CD, " +
                "          A.CYCLE, " +
                "          A.EXECUTABLE_NM, " +
                "          A.EXECUTABLE_METHOD, " +
                "          B.JOB_STATUS, " + 
				"          DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i') AS START_DT, " + 
				"          B.START_DATE, " +
                "          B.END_DATE " +
                "   FROM   TB_MES_CMJOB000 A, " +
                "          TB_MES_CMJOB100 B " +
                "   WHERE  A.CM_CD = B.CM_CD " +
                "   AND B.JOB_STATUS = 'SCHEDUAL' " +
                "   AND B.START_DATE <= NOW() " +
                "   AND A.USE_YN = 'Y' " ;		
		
		jdbcTemplate.query(cmSql,
  	    		new RowMapper<Object>() {
    		    	@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    		    		String addTimeSql = "";
    		    		
    		    		if(rs.getString("CM_RUN_EVERY").equals("10")){
    		    			addTimeSql = "DATE_ADD('" + rs.getString("START_DT") + "', INTERVAL " + rs.getInt("CYCLE") + " MONTH)";
    		    		}else if(rs.getString("CM_RUN_EVERY").equals("20")){
    		    			addTimeSql = "DATE_ADD('" + rs.getString("START_DT") + "', INTERVAL 7 DAY)";
        		    	}else if(rs.getString("CM_RUN_EVERY").equals("30")){
    		    			addTimeSql = "DATE_ADD('" + rs.getString("START_DT") + "', INTERVAL " + rs.getInt("CYCLE") + " DAY)";
        		    	}else if(rs.getString("CM_RUN_EVERY").equals("40")){
    		    			addTimeSql = "DATE_ADD('" + rs.getString("START_DT") + "', INTERVAL " + rs.getInt("CYCLE") + " HOUR)";
        		    	}else if(rs.getString("CM_RUN_EVERY").equals("50")){
    		    			addTimeSql = "DATE_ADD('" + rs.getString("START_DT") + "', INTERVAL " + rs.getInt("CYCLE") + " MINUTE)";
        		    	}
    		    		
    		    		String updateSql = " UPDATE TB_MES_CMJOB100 SET JOB_STATUS = 'END',TRACE = '" + "TRACE" + "', END_DATE = DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i') WHERE JOB_STATUS='SCHEDUAL' AND CM_CD = '" + rs.getString("CM_CD") + "'";
    		    		jdbcTemplate.update(updateSql);   
    		    		
    		    		runProgram(rs.getString("EXECUTABLE_METHOD"),rs.getString("EXECUTABLE_NM"));
    		    		
    		    		String insertSql = 
    		    				" INSERT INTO TB_MES_CMJOB100 "
    		                    + " (  REQUEST_ID, CM_CD, START_DATE, JOB_STATUS, CREATED_BY, CREATED_AT, UPDATED_BY, UPDATED_AT) "

    		                    + " VALUES "
    		                    + " ( (SELECT IFNULL(MAX(Z.REQUEST_ID),1) + 1 FROM TB_MES_CMJOB100 Z), "
    		                    + "'" + rs.getString("CM_CD") + "' "
    		                    + "  , (" + addTimeSql + ")"
    		                    + "  , 'SCHEDUAL' "
    		                    + "  , 'CM' "
    		                    + "  , DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i') "
    		                    + "  , 'CM' "
    		                    + "  , DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i'))";

    		    		jdbcTemplate.update(insertSql);   
    		    		
    		    		return null;
    		    	}
    		});
	}
} 
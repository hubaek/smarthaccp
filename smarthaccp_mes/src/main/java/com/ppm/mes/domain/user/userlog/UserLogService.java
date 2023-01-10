package com.ppm.mes.domain.user.userlog;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chequer.axboot.core.config.AXBootContextConfig;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.MDCUtil;
import com.chequer.axboot.core.utils.PhaseUtils;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.prd.list.PrdListMapper;
import com.ppm.mes.domain.prd.list.PrdOrderListVO;
import com.ppm.mes.utils.SessionUtils;
import com.querydsl.core.BooleanBuilder;


@Service
public class UserLogService extends BaseService<UserLog, Long> {

    private UserLogRepository repository;

    @Inject
    private AXBootContextConfig axBootContextConfig;
    
    @Autowired
    private UserLogMapper userlogmapper;
    
    @Autowired
    private PrdListMapper prdlistmapper;
    
    @Inject
    public UserLogService(UserLogRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    @Transactional
    public void deleteAllLogs() {
        Query query = em.createNativeQuery("DELETE FROM TB_MES_USERLOG");
        query.executeUpdate();
    }

    public void deleteLog(Long id) {
        delete(id);
    }


    @Transactional
    public void saveUserLog(String programCode,String programNm, String programAction) {
        String userCd = SessionUtils.getCurrentLoginUserCd();
        //if(!userCd.equals("system")){
            UserLog userLog = new UserLog();
            userLog.setPhase(PhaseUtils.phase());
            userLog.setSystem("HACCP");
            userLog.setUserCd(userCd);
            
            userLog.setProgramCode(programCode);
            userLog.setProgramNm(programNm);
            userLog.setProgramAction(programAction); 
            
            userLog.setLoggerName("");
            userLog.setServerName(axBootContextConfig.getServerName());
            userLog.setHostName(getHostName());
            //userLog.setPath(MDCUtil.get(MDCUtil.REQUEST_URI_MDC));
            //userLog.setHeaderMap(MDCUtil.get(MDCUtil.HEADER_MAP_MDC));
            //userLog.setParameterMap(MDCUtil.get(MDCUtil.PARAMETER_BODY_MDC));
            //userLog.setUserInfo(MDCUtil.get(MDCUtil.USER_INFO_MDC));
            save(userLog);
        //}
    }
    
    @Transactional
    public void saveUserLog(String userCd,String programCode,String programNm, String programAction) {

    	//if(!userCd.equals("system")){
            UserLog userLog = new UserLog();
            
            userLog.setPhase(PhaseUtils.phase());
            userLog.setSystem("MES");
            userLog.setUserCd(userCd);
            
            userLog.setProgramCode(programCode);
            userLog.setProgramNm(programNm);
            userLog.setProgramAction(programAction);
            
            userLog.setLoggerName("");
            userLog.setServerName(axBootContextConfig.getServerName());
            userLog.setHostName(getHostName());
            userLog.setHeaderMap(MDCUtil.get(MDCUtil.HEADER_MAP_MDC));
            userLog.setUserInfo(MDCUtil.get(MDCUtil.USER_INFO_MDC));
            save(userLog);
            
        //}
    	
    }

    public String getHostName() {

        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = req.getRemoteAddr();
        
        try {
            return ip;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<UserLog> get(RequestParams<UserLog> requestParams) {
        

        String userCd = requestParams.getString("userCd" , "");

        BooleanBuilder builder = new BooleanBuilder();
        

        if (isNotEmpty(userCd)) {
            builder.and(qUserLog.userCd.eq(userCd));           	
        }
        
        List<UserLog> list = select().from(qUserLog).where(builder).orderBy(qUserLog.userCd.asc()).fetch();

        return list;
    }
    
    public Page<UserLog> get(RequestParams<UserLog> requestParams, Pageable pageable) {
        String userCd = requestParams.getString("userCd" , "");
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(userCd)) {
            builder.and(qUserLog.userCd.eq(userCd));           	
        }

        return findAll(builder, pageable);
    }

	public List<UserLog> getUserLogList(RequestParams searchParams) {
		
		BooleanBuilder builder = new BooleanBuilder();
	    String userCd =  searchParams.getString("userCd", "");    
        if (isNotEmpty(userCd)) {
            builder.and(qUserLog.updatedBy.eq(userCd));           	
        }
        
        List<UserLog> list = select().from(qUserLog).where(builder).orderBy(qUserLog.id.desc()).fetch();

        return list;
	}
	
	public void SendLogData() throws Exception{
		Date now = new Date();

        /*
         * 1. 스마트공장 1번가 log전송 처리(전사이트 공통)
         * Parameter
         * - crtfcKey : api인증키
         * - logDt : 로그일시
         * - useSe : 접속구분
         * - sysUser : 사용자
         * - conectIp : IP정보
         * - dataUsgqty : 데이터사용량(숫자)
         * */		
		/********************************************************************************************************************************************/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = format.format(now);

		String crtfcKey = "$5$API$v8xgb.yuZRr5isTDEjy1NR44Xuv77uSfzo3p4OyaqM."; //사이트별로 발급 받아야함(https://1st.smart-factory.kr/index.do)
		List<Map<String,Object>> logList = userlogmapper.getSendLogData();
		
		for(int i=0; i<logList.size(); i++){
			Map<String,Object> Log = logList.get(i);
			
			String conectIp = String.valueOf(Log.get("conectIp"));
			String dataUsgqty = String.valueOf(Log.get("dataUsgqty"));
			String sysUser = String.valueOf(Log.get("sysUser"));
			String useSe = String.valueOf(Log.get("useSe"));

			URL url = new URL("https://log.smart-factory.kr/apisvc/sendLogData.json");
	        String postData =  "crtfcKey="+ crtfcKey + "&conectIp=" + conectIp + "&dataUsgqty=" + dataUsgqty + "&sysUser=" + sysUser + "&useSe=" + useSe + "&logDt=" + time;
	        
	        URLConnection conn = url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
	 
	        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
	            dos.writeBytes(postData);
	        }
	 
	        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
	                                                        conn.getInputStream())))
	        {
	            String line;
	            Map<String,Object> param = new HashMap<String,Object>();
	            while ((line = bf.readLine()) != null) {
	                //System.out.println(line);
	                param.put("type","LOG");
	                param.put("result",line);
	                userlogmapper.saveResult(param);
	            }
	        }
		}
		/********************************************************************************************************************************************/
		
		/*
         * 2. 전남 스마트제조혁신센터 KPI수집(일부 기업만 적용, 나머지는 주석)
         * 적용기업 : 농부누리, 황금밭, 브루웍스, 무화담, 푸른터, 온드림푸드, 그리올푸드, 다미설, 삼도웰빙, 달콤한자연식품, 올곧은, 티아이지푸드 
         * Parameter
         * - crtfcKey : api인증키
         * - logDt : 로그일시
         * - useSe : 접속구분
         * - sysUser : 사용자
         * - conectIp : IP정보
         * - dataUsgqty : 데이터사용량(숫자)
         * 적용기업 이외에는 주석처리
         * */
		/********************************************************************************************************************************************/
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
	    String time2 = format2.format(now);
		
		String apiKey = "0xE2DCBA156E3F35E941D70D79E94E3728752BBFB19C69A37A42BD7B6AFDEF339D"; //사이트별로 발급 받아야함(http://smart.jntp.or.kr/)
		String bizNumber = "2021_00381"; //구축사업 일렬번호(사업년도_일련번호)
		String kpiDate = time2; //KPI 측정일자
		String kpiCode = "P007"; //KPI 구분코드(시간당 생산량)
		
		RequestParams<PrdOrderListVO> vo = new RequestParams<PrdOrderListVO>();
		Map<String, String[]> tempMap = new HashMap<String, String[]>();
		String[] strArr = new String[]{"END"};
		tempMap.put("orderSt", strArr);
		vo.setParameterMap(tempMap);
		
		List<PrdOrderListVO> kpiList = prdlistmapper.orderList1(vo);
		
		for(int i=0; i<kpiList.size(); i++){
			PrdOrderListVO Kpi = kpiList.get(i);
			Long temp = Kpi.getUph();
			int kpiValue = Math.round(temp);
			
			URL url = new URL("http://smartapi.jntp.or.kr/api/KPI_API_SUPY");
	        String postData =  "apiKey="+ apiKey + "&bizNumber=" + bizNumber + "&kpiDate=" + kpiDate + "&kpiCode=" + kpiCode + "&kpiValue=" + kpiValue; 
	        
	        URLConnection conn = url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
	 
	        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
	            dos.writeBytes(postData);
	        }
	 
	        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
	                                                        conn.getInputStream())))
	        {
	            String line;
	            String result = "";
	            Map<String,Object> param = new HashMap<String,Object>();
	            while ((line = bf.readLine()) != null) {
	                //System.out.println(line);
	                result += line;
	            }
	            param.put("type","KPI");
                param.put("result",result);
                userlogmapper.saveResult(param);
	        }
		}
		/********************************************************************************************************************************************/
	}

	
	public List<Map<String, Object>> getSendLogHis() {
		
		List<Map<String, Object>> list = userlogmapper.getSendLogHis();

        return list;
	}
	
	/*************************************** ERP *****************************************************/
	public void transMesTable(List<Map<String, Object>> erpList, String tableNm){
		if(erpList.size() > 0){
			Map<String, Object> tempMap = new HashMap<String,Object>();
			StringBuffer execQuery = new StringBuffer();
			StringBuffer colbuf = new StringBuffer();
			StringBuffer valuebuf = new StringBuffer();
			
			/*
			 * 연동될 MES 테이블 초기화
			 */
			if(tableNm.equals("tb_mes_cd000")){
				execQuery.append("delete from " + tableNm + " where pg_module_cd = '40'");
			}else if(tableNm.equals("tb_mes_cd100")){
				execQuery.append("delete from " + tableNm + " where REMARK = 'ERP'");
			}else{
				execQuery.append("delete from " + tableNm);
			}
			
			tempMap.put("execQuery", execQuery);
			userlogmapper.execQuery(tempMap);
			execQuery.setLength(0);
			
			Map<String, Object> temp = erpList.get(0);
			
			int totalSize = erpList.size();
			/*
			 * ERP데이터가 1000건이상 넘어가는 경우 List를분할하여 저장처리
			 */
			
			//default
			int quarter = 1;
			int Cycle = totalSize;
			
			/*
			 * 조회된 데이터가 1000건이상인 경우, 분기 및 주기 Setting
			 */
			if(totalSize > 1000){
				quarter = 1 + (totalSize/1000);
				Cycle = 1000;
			}
			System.out.println("quarter : " + quarter);
			System.out.println("Cycle : " + Cycle);
			
			//1. List분할
			for(int j=0; j<quarter; j++){
				int startPoint = j*Cycle;
				int endPoint = (j+1)*Cycle;
				
				//2. 마지막 분할 끝의 endPoint는 전체 list의 사이즈로
				if(j == (quarter-1)){ endPoint = totalSize; }
				
				List<Map<String, Object>> erpSubList = erpList.subList(startPoint, endPoint);
				System.out.println("SubListSize : " + erpSubList.size());
				
				//3. 분할된 시점마다 insert문 새로 생성
				/* ex) SQL 
				 *       insert into (col1, col2, col3, ....) - (1) column
				 *       values (data1, data2, data3, ....), (data1, data2, data3, ....), (data1, data2, data3, ....) - (2) values(row)
				 * */
				
				//(1) column
				int colidx = 0;
				for (String key : temp.keySet()) {
					colidx = colidx + 1;
					if(temp.keySet().size() != colidx){colbuf.append(key + ",");}
					else{colbuf.append(key);}
				}
				execQuery.append("insert into " + tableNm + "\n");
				execQuery.append("(" + colbuf + ")");
				execQuery.append(" values" + "\n");
				
				//(2) values(row)
				for(int i=0; i<erpSubList.size(); i++){
					Map<String, Object> erpinfo = erpSubList.get(i);
					
					valuebuf.append("(");	
					int valueidx = 0;
					for (String key : erpinfo.keySet()) {
						valueidx = valueidx + 1;
						String value = String.valueOf(erpinfo.get(key));
						
						if(erpinfo.keySet().size() != valueidx){
							if(value.equals("") || value == null || value.equals("null")){
								valuebuf.append("null,");
							}else{
								valuebuf.append("'" + value + "',");
							}
						}else{
							if(value.equals("") || value == null || value.equals("null")){
								valuebuf.append("null");
							}else{
								valuebuf.append("'" + value + "'");
							}
						}
					}
					
					if(i != erpSubList.size()-1){
						valuebuf.append(")," + "\n");
					}else{
						valuebuf.append(");" + "\n");
					}
				}
				execQuery.append(valuebuf);
				
				//4. 생성된 SQL 실행
				System.out.println("===================================ERP -> MES==============================");
				tempMap.put("execQuery", execQuery);
				userlogmapper.execQuery(tempMap);
				
				//5. SQL실행후 insert문 초기화
				execQuery.setLength(0);
				valuebuf.setLength(0);
				colbuf.setLength(0);
			}	
		}
	}
}


package com.ppm.mes.domain.erp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.user.userlog.UserLogService;

@Service
public class ErpService extends BaseService {
	@Autowired
	private ErpMapper erpMapper; 
	
	@Autowired
	private UserLogService userlogservice;
	
	//품목 - Master
	public void syncTbMesItem000 (Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		                                       
		sb.append(" select  '1000'         as COMPANY                                     " + "\n");
		sb.append(" 	      ,a.item         as ITEM_CD                                  " + "\n");
		sb.append(" 	      ,a.item_nm      as ITEM_NM                                  " + "\n");
		sb.append(" 	      ,case                                                       " + "\n");
	    sb.append(" 	         when a.acc_gbn = '14600' then '50'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '15000' then '10'                       " + "\n");
		sb.append(" 	         when a.acc_gbn = '15300' then '30'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '15600' then '30'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '15900' then '30'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '16200' then '40'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '16900' then '20'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '53000' then '40'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '63000' then '40'	                      " + "\n");
		sb.append(" 	         when a.acc_gbn = '73000' then '40'	                      " + "\n");
	    sb.append(" 	       end as ITEM_TYPE                                           " + "\n");
		sb.append(" 	      ,a.big          as ITEM_MAIN_CD                             " + "\n");
		sb.append(" 	      ,case when a.use_gbn = '1' then 'Y' else 'N' end as USE_YN  " + "\n");
		sb.append(" 	      ,ifnull(a.set_gbn,'N')      as SET_YN                       " + "\n");
		sb.append(" 	      ,a.sml          as ITEM_SUB_CD                              " + "\n");
		sb.append(" 	      ,a.spl_gbn      as SUPPORT_TYPE                             " + "\n");
		sb.append(" 	      ,a.spec         as SPEC                                     " + "\n");
	    sb.append("           ,case 													  " + "\n");
	    sb.append("            when a.unit = '01' then 'EA'	                              " + "\n");
		sb.append("            when a.unit = '02' then 'GR' 	                          " + "\n");
		sb.append("            when a.unit = '03' then 'KG'	                              " + "\n");
		sb.append("            when a.unit = '04' then 'BOX'	                          " + "\n");
	    sb.append("            end as UNIT                                                " + "\n");
	    sb.append("           ,case                                                       " + "\n");
	    sb.append("            when a.unit_pack = '01' then 'EA'	                      " + "\n");
		sb.append("            when a.unit_pack = '02' then 'GR' 	                      " + "\n");
		sb.append("            when a.unit_pack = '03' then 'KG'	                      " + "\n");
		sb.append("            when a.unit_pack = '04' then 'BOX'	                      " + "\n");
	    sb.append("            end as BOM_UNIT                                            " + "\n");
		sb.append(" 	      ,a.bigo         as REMARK                                   " + "\n");
		sb.append(" 	      ,ifnull(a.last_buy_pri,0) as SA_AMT                         " + "\n");
		sb.append(" 	      ,ifnull(a.last_in_pri,0)  as PC_AMT                         " + "\n");
		sb.append(" 	      ,ifnull(a.cost,0)         as STD_COST                       " + "\n");
		sb.append(" 	      ,ifnull(a.conv_num,0)     as SL_TRANS                       " + "\n");
		sb.append(" 	      ,ifnull(a.thick,0)        as VERTICAL                       " + "\n");
		sb.append(" 	      ,ifnull(a.width,0)        as HORIZONTAL                     " + "\n");
		sb.append(" 	      ,ifnull(a.exp_date,0)     as EXPIRATION_DATE                " + "\n");
		sb.append(" 	      ,a.stk_gbn      as STOCK_YN                                 " + "\n");
		sb.append(" 	      ,ifnull(a.qty_pack,0)     as LOT_QTY                        " + "\n");
		sb.append(" 	      ,a.cus_in       as CUST_CD                                  " + "\n");
		sb.append(" 	      ,ifnull(a.safe_stk,0)     as SAFETY_QTY                     " + "\n");
		sb.append(" 	      ,sysdate()      as CREATED_AT                               " + "\n");
		sb.append("          ,'system'       as CREATED_BY                                " + "\n");
		sb.append("  from sys020 a                                                        " + "\n");
		sb.append("  left outer join sys021 b on a.corp = b.corp                          " + "\n");
		sb.append("  						  and a.big = b.big	                          " + "\n");
		sb.append("  left outer join sys022 c on a.corp = c.corp                          " + "\n"); 
		sb.append("  						  and a.big = c.big                           " + "\n");
		sb.append("  						  and a.sml = c.sml                           " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_item000 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_item000");
		sb.setLength(0);
		sb = null;
	}
	
	//품목 - 대분류
	public void syncTbMesItem100(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append(" select  '1000'    as COMPANY      " + "\n");
		sb.append("        ,a.big     as ITEM_MAIN_CD " + "\n");
		sb.append("        ,a.cd_nm   as ITEM_MAIN_NM " + "\n");
		sb.append("	      ,case when a.use_gbn = '1' then 'Y' else 'N' end as USE_YN " + "\n");
		sb.append("	       ,sysdate() as CREATED_AT   " + "\n");
		sb.append("        ,'system'  as CREATED_BY   " + "\n");
	    sb.append("   from sys021 a                   " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_item100 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_item100");
		sb.setLength(0);
	}
	
	//품목 - 소분류
	public void syncTbMesItem150(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append(" select  '1000'    as COMPANY      " + "\n");
		sb.append("		   ,a.big     as ITEM_MAIN_CD " + "\n");
		sb.append("		   ,a.sml     as ITEM_SUB_CD  " + "\n");
		sb.append("		   ,a.cd_nm   as ITEM_SUB_NM  " + "\n");
		sb.append("	      ,case when a.use_gbn = '1' then 'Y' else 'N' end as USE_YN " + "\n");
		sb.append("	       ,sysdate() as CREATED_AT   " + "\n");
		sb.append("        ,'system'  as CREATED_BY   " + "\n");
		sb.append("   from sys022 a                   " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_item150 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_item150");
		sb.setLength(0);
		sb = null;
	}
	
	//공통코드 Master(ERP)
	public void syncTbMesCd000(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select distinct                   " + "\n");
		sb.append("        a.big     as MAIN_CD      " + "\n");
		sb.append("       ,sysdate() as CREATED_AT   " + "\n");
		sb.append("       ,'system'  as CREATED_BY   " + "\n");
		sb.append("       ,'1'       as CD_TYPE      " + "\n");
		sb.append("       ,'40'      as PG_MODULE_CD " + "\n");
		sb.append("       ,'Y'       as USE_YN       " + "\n");
		sb.append("       ,'system'  as USER_CD      " + "\n");
		sb.append("       ,'ERP'     as REMARK       " + "\n");
	    sb.append("  from sys910 a                   " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		sb.append("   and a.sml_nm != '사용자설정'" + "\n");
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_cd000 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		
		//공통 MAIN_CD에 따른 NAME부여(ERP에 대분류 CODE에 따른 NAME 테이블 정보가 없음)
		for(int i=0; i<result.size(); i++){
			Map<String, Object> type1Info = result.get(i);
			
			String mainCd = String.valueOf(type1Info.get("MAIN_CD"));
			String mainNm = "";
			
			switch(mainCd) {
				case "01" :	mainNm = "직위"; break;  
				case "02" :	mainNm = "단위"; break;
				case "03" :	mainNm = "단가유형"; break;
				case "04" :	mainNm = "메이커"; break;
				case "05" :	mainNm = "판매처등급"; break;
				case "06" :	mainNm = "배송코스"; break;
				case "07" :	mainNm = "가맹점요청사항"; break;
				case "08" :	mainNm = "주문연계업체"; break;
				case "09" :	mainNm = "상담구분"; break;
				case "10" :	mainNm = "영업사원"; break;
				case "12" :	mainNm = "신용카드사"; break;
				case "13" :	mainNm = "매입 과세유형"; break;
				case "14" :	mainNm = "매출 과세유형"; break;
				case "15" :	mainNm = "고객상담(CS) 문의유형"; break;
				case "16" :	mainNm = "수금 결제종류"; break;
				case "17" :	mainNm = "지급 결제종류"; break;
				case "31" :	mainNm = "택배사"; break;
				case "70" :	mainNm = "생산공정"; break;
				case "71" :	mainNm = "작업팀"; break;
				case "72" :	mainNm = "판매처지역"; break;
				case "73" :	mainNm = "판매처유형"; break;
				case "74" :	mainNm = "작업자"; break;
				case "75" :	mainNm = "설비"; break;
				case "76" :	mainNm = "불량구분"; break;
				case "77" :	mainNm = "작업종류"; break;
				case "78" :	mainNm = "중지사유"; break;
				case "81" :	mainNm = "창고"; break;
				case "82" :	mainNm = "부서"; break;
				case "91" :	mainNm = "재고조정유형-재고증가"; break;
				case "92" :	mainNm = "재고조정유형-재고감소"; break;
				case "AC" :	mainNm = "품목분류"; break;
				case "BU" :	mainNm = "이력추적 부위코드"; break;
				case "BC" :	mainNm = "이력추적 거래업체구분"; break;
				case "U1" :	mainNm = "프로젝트유형"; break;
				case "UD" :	mainNm = "문자메시지 상용구"; break;
				case "UE" :	mainNm = "문자메시지전화번호"; break;
				default : mainNm = "기타"; break;
			}
			type1Info.put("MAIN_NM", mainNm);
		}

		userlogservice.transMesTable(result, "tb_mes_cd000");
		sb.setLength(0);
		sb = null;
	}
	
	//공통코드 Detail(ERP)
	public void syncTbMesCd100(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select  a.big as MAIN_CD                " + "\n");
		sb.append("       ,a.sml as SUB_CD                 " + "\n");
		sb.append("       ,sysdate() as CREATED_AT         " + "\n");
		sb.append("       ,'system' as CREATED_BY          " + "\n");
		sb.append("       ,a.sml_nm as SUB_NM              " + "\n");
		sb.append("       ,a.sml_nm as SUB_NM_EN           " + "\n");
		sb.append("       ,a.sml_nm as SUB_NM_ZH           " + "\n");
		sb.append("       ,cast(a.sml as unsigned) as SORT " + "\n");
		sb.append("       ,case                            " + "\n");
		sb.append("        when a.use_gbn = 1 then 'Y'     " + "\n");
		sb.append("        else 'N' end as USE_YN          " + "\n");
		sb.append("       ,'ERP' as REMARK                 " + "\n");
	    sb.append("  from sys910 a                         " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		sb.append("   and a.sml_nm != '사용자설정'" + "\n");
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_cd100 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_cd100");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesPc200(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select  '1000'    as COMPANY    " + "\n");
		sb.append("	      ,a.code    as SLIP_CD    " + "\n");
		sb.append("	      ,a.ymd     as REQUEST_DT " + "\n");
		sb.append("	      ,a.cus_emp as USER_CD    " + "\n");
		sb.append("	      ,date_format(a.mk_time, '%Y-%m-%d') as SLIP_DT " + "\n");
		sb.append("       ,sysdate() as CREATED_AT " + "\n");
		sb.append("       ,'system'  as CREATED_BY " + "\n");
		sb.append("  from buy010 a                 " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_pc200 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_pc200");
		sb.setLength(0);
		sb = null;
		
	}

	public void syncTbMesPc210(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));

		sb.append("select  '1000'    as COMPANY    " + "\n");
		sb.append("       ,a.code    as SLIP_CD    " + "\n");
		sb.append("       ,a.seq     as SLIP_SEQ   " + "\n");
		sb.append("       ,a.item    as ITEM_CD    " + "\n");
		sb.append("       ,a.qty     as ITEM_QTY   " + "\n");
		sb.append("       ,a.pri     as UNIT_AMT   " + "\n");
		sb.append("       ,a.amt     as SUPPLY_AMT " + "\n");
		sb.append("       ,a.vat     as SURTAX_AMT " + "\n");
		sb.append("       ,a.bigo    as ITEM_REMARK" + "\n");
		sb.append("       ,sysdate() as CREATED_AT " + "\n");
		sb.append("       ,'system'  as CREATED_BY " + "\n");
		sb.append("  from buy011 a                 " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_pc210 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_pc210");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesPc300(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select '1000'  as COMPANY      " + "\n");
		sb.append("      ,a.code  as SLIP_CD      " + "\n");
		sb.append("      ,a.cus   as CUST_CD      " + "\n");
	    sb.append("      ,a.jugyo as REMARK       " + "\n");
	    sb.append("      ,a.mk    as SLIP_DT      " + "\n");
		sb.append("      ,sysdate() as CREATED_AT " + "\n");
		sb.append("      ,'system'  as CREATED_BY " + "\n");
	    sb.append("  from buy030 a          " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_pc300 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_pc300");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesPc310(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select  '1000'    as COMPANY    " + "\n");
		sb.append("	      ,a.code    as SLIP_CD    " + "\n");
		sb.append("	      ,a.seq     as SLIP_SEQ   " + "\n");
		sb.append("	      ,a.item    as ITEM_CD    " + "\n");
		sb.append("	      ,a.lot     as LOT_NO     " + "\n");
		sb.append("	      ,a.pri     as UNIT_AMT   " + "\n");
		sb.append("	      ,a.ex_rate as PD_TRANS   " + "\n");
		sb.append("	      ,a.qty     as ITEM_QTY   " + "\n");
		sb.append("	      ,a.amt     as SUPPLY_AMT " + "\n");
		sb.append("	      ,a.vat     as SURTAX_AMT " + "\n");
		sb.append("	      ,a.bigo    as REMARK     " + "\n");
		sb.append("       ,sysdate() as CREATED_AT " + "\n");
		sb.append("       ,'system'  as CREATED_BY " + "\n");
		sb.append("     from buy031 a              " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_pc310 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_pc310");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesBom000(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select distinct '1000'      as COMPANY     " + "\n");
		sb.append("               ,a.his_seq   as REVISION_NO " + "\n");
		sb.append("               ,a.item_p    as ITEM_CD     " + "\n");
		sb.append("               ,a.bigo      as REMARK      " + "\n");
        sb.append("               ,'1'         as ITEM_QTY	  " + "\n");
        sb.append("               ,'Y'	       as LAST_YN     " + "\n");
        sb.append("               ,'Y'         as USE_YN      " + "\n");
		sb.append("               ,sysdate()   as CREATED_AT  " + "\n");
		sb.append("               ,'system'    as CREATED_BY  " + "\n");
		sb.append("  from prd010 a                            " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_bom000 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_bom000");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesBom100(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select '1000'      as COMPANY       " + "\n");
		sb.append("      ,a.his_seq   as REVISION_NO   " + "\n");
		sb.append("      ,a.item_p    as PARENT_ITEM_CD" + "\n");
		sb.append("      ,a.item      as ITEM_CD       " + "\n");
		sb.append("      ,a.seq       as BOM_SEQ       " + "\n");
		sb.append("      ,a.qty       as BOM_QTY       " + "\n");
		sb.append("      ,a.loss_rate as LOSS_PER      " + "\n");
		sb.append("      ,a.bigo      as REMARK        " + "\n");
		sb.append("      ,sysdate()   as CREATED_AT    " + "\n");
		sb.append("      ,'system'    as CREATED_BY    " + "\n");
		sb.append("  from prd010 a                     " + "\n"); 
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_bom100 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_bom100");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesEq000(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select '1000' as COMPANY      " + "\n");
		sb.append("	  ,a.code     as EQUIP_CD    " + "\n");
		sb.append("	  ,a.nm       as EQUIP_NM    " + "\n");
		sb.append("	  ,a.model    as MODEL_NM    " + "\n");
		sb.append("	  ,a.maker    as EQUIP_MAKER " + "\n");
		sb.append("	  ,a.buyer    as CUST_CD     " + "\n");
		sb.append("	  ,a.ymd      as PURCHASE_DT " + "\n");
		sb.append("	  ,a.price    as PC_AMT      " + "\n");
		sb.append("	  ,a.bigo     as REMARK      " + "\n");
		sb.append("	  ,a.use_gbn  as USE_YN      " + "\n");
		sb.append("	  ,a.mk       as CREATED_BY  " + "\n");
		sb.append("	  ,a.mk_time  as CREATED_AT  " + "\n");
		sb.append("	  ,a.upd      as UPDATED_BY  " + "\n");
		sb.append("	  ,a.upd_time as UPDATED_AT  " + "\n");
		sb.append("  from prd910 a               " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_eq000 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_eq000");
		sb.setLength(0);
		sb = null;
	}
	
	public void syncTbMesSa300(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("	select                       " + "\n"); 
		sb.append("	    '1000'     as COMPANY    " + "\n"); 
		sb.append("	   ,a.code     as SLIP_CD    " + "\n"); 
		sb.append("	   ,a.mk       as CREATED_BY " + "\n");  
		sb.append("	   ,a.mk_time  as CREATED_AT " + "\n"); 
		sb.append("	   ,a.upd      as UPDATED_BY " + "\n");
		sb.append("	   ,a.upd_time as UPDATED_AT " + "\n"); 
		sb.append("	   ,a.cus      as CUST_CD    " + "\n"); 
		sb.append("	   ,a.ymd      as SLIP_DT    " + "\n"); 
		sb.append("	   ,a.vat_yn   as SURTAX_YN  " + "\n");          
		sb.append("  from sal020 a               " + "\n"); 
	    if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_sa300 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_sa300");
		sb.setLength(0);
		sb = null;
	}
	
	public void syncTbMesSa310(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select                          " + "\n");
		sb.append("	     '1000'     as COMPANY     " + "\n");
		sb.append("	    ,a.code     as SLIP_CD     " + "\n");
		sb.append("	    ,a.seq      as SLIP_SEQ    " + "\n");
		sb.append("	    ,case when a.mk = '' then 'system' else a.mk end as CREATED_BY  " + "\n");
		sb.append("	    ,case when a.mk_time = '' then DATE_FORMAT(now(), '%Y%m%d%H%i%s') else a.mk_time end as CREATED_AT  " + "\n");
		sb.append("	    ,case when a.upd  = '' then 'system' else a.upd end as UPDATED_BY  " + "\n");
		sb.append("	    ,case when a.upd_time = '' then DATE_FORMAT(now(), '%Y%m%d%H%i%s') else a.upd_time end as UPDATED_AT   " + "\n");
		sb.append("	    ,a.item     as ITEM_CD     " + "\n");
		sb.append("	    ,a.qty      as ITEM_QTY    " + "\n");
		sb.append("	    ,a.amt      as SUPPLY_AMT  " + "\n");
		sb.append("	    ,a.vat      as SURTAX_AMT  " + "\n");
		sb.append("	    ,a.pri      as UNIT_AMT    " + "\n");
		sb.append("	    ,a.ymd_dlv  as DELIVERY_DT " + "\n");
		sb.append("	    ,a.ymd      as SA_ORDER_DT " + "\n");
		sb.append("	    ,a.spec     as SPEC        " + "\n");
		sb.append("	    ,a.vat_yn   as SURTAX_YN   " + "\n");  
		sb.append("  from sal021 a                 " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_sa310 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_sa310");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesSa400(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select                          " + "\n"); 
		sb.append("	     '1000'     as COMPANY    " + "\n");
		sb.append("	    ,a.code      as SLIP_CD    " + "\n");
		sb.append("	    ,a.mk        as CREATED_BY " + "\n");
		sb.append("	    ,a.mk_time   as CREATED_AT " + "\n");
		sb.append("	    ,a.cus       as CUST_CD    " + "\n");
		sb.append("	    ,a.ymd       as SA_DT      " + "\n");
		sb.append("	    ,a.vat_yn    as SURTAX_YN  " + "\n");
		sb.append("	    ,a.emp       as USER_CD    " + "\n");
		sb.append("  from sal030 a                 " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_sa400 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_sa400");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesSa410(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select                         " + "\n");
		sb.append("	     '1000'     as COMPANY    " + "\n");
		sb.append("	    ,a.code     as SLIP_CD    " + "\n");
		sb.append("	    ,a.seq      as SLIP_SEQ   " + "\n");
		sb.append("	    ,case when a.mk = '' then 'system' else a.mk end as CREATED_BY "              + "\n");
		sb.append("	    ,case when a.mk_time = '' then sysdate() else a.mk_time end as CREATED_AT "   + "\n");
		sb.append("	    ,case when a.upd  = '' then 'system' else a.upd end as UPDATED_BY "           + "\n");
		sb.append("	    ,case when a.upd_time = '' then sysdate() else a.upd_time end as UPDATED_AT " + "\n");
		sb.append("	    ,a.item     as ITEM_CD    " + "\n");
		sb.append("	    ,a.qty      as ITEM_QTY   " + "\n");
		sb.append("	    ,a.amt      as SUPPLY_AMT " + "\n");
		sb.append("	    ,a.vat      as SURTAX_AMT " + "\n");
		sb.append("	    ,a.pri      as UNIT_AMT   " + "\n");
		sb.append("	    ,a.ymd      as SA_DT      " + "\n");
		sb.append("	    ,a.spec     as SPEC       " + "\n");
		sb.append("	    ,a.vat_yn   as SURTAX_YN  " + "\n");
		sb.append("  from sal031 a                " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_sa410 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_sa410");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesCust000(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select                                 " + "\n");
		sb.append("	      '1000'       as COMPANY        " + "\n"); 
		sb.append("	     ,a.cus         as CUST_CD        " + "\n");
		sb.append("	     ,case when a.mk = '' then 'system' else a.mk end as CREATED_BY" + "\n");
		sb.append("	     ,case when a.mk_time = '' then DATE_FORMAT(now(), '%Y%m%d%H%i%s') else ifnull(a.mk_time, DATE_FORMAT(now(), '%Y%m%d%H%i%s')) end as CREATED_AT" + "\n");
		sb.append("	     ,case when a.upd  = '' then 'system' else a.upd end as UPDATED_BY" + "\n");
		sb.append("	     ,case when a.upd_time = '' then DATE_FORMAT(now(), '%Y%m%d%H%i%s') else ifnull(a.upd_time, DATE_FORMAT(now(), '%Y%m%d%H%i%s')) end as UPDATED_AT" + "\n");
		sb.append("	     ,a.cus_nm      as CUST_NM        " + "\n");
		sb.append("      ,case                            " + "\n");
	    sb.append("       when a.cus_gbn = '1' then '99'  " + "\n");
	    sb.append("       when a.cus_gbn = '4' then '10'  " + "\n");
	    sb.append("       when a.cus_gbn = '5' then '20'  " + "\n");
	    sb.append("       when a.cus_gbn = '9' then '99'  " + "\n");
	    sb.append("       end as CUST_TYPE                " + "\n");	
		sb.append("	     ,a.saup_no     as BUSINESS_NO    " + "\n");
		sb.append("	     ,a.owner       as CEO_NM         " + "\n");
		sb.append("	     ,a.up          as BUSINESS_TYPE1 " + "\n");
		sb.append("	     ,a.jong        as BUSINESS_TYPE2 " + "\n");
		sb.append("	     ,a.tel         as TEL            " + "\n");
		sb.append("	     ,a.fax         as FAX            " + "\n");
		sb.append("	     ,a.zip         as EMAIL          " + "\n");
		sb.append("	     ,a.addr        as ADDRESS        " + "\n");
		sb.append("	     ,a.emp         as MAN_NM         " + "\n");
		sb.append("	     ,a.deal_bank   as BANK           " + "\n");
		sb.append("	     ,a.bank_owner  as DEPOSITOR      " + "\n");
		sb.append("	     ,a.bank_no     as ACCOUNT_NO     " + "\n");
		sb.append("	     ,a.bigo        as REMARK         " + "\n");
		sb.append("	     ,case when a.use_gbn = '1' then 'Y' else 'N' end as USE_YN" + "\n");
		sb.append("  from sys010 a                        " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_cust000 =================================\n" + sb);
		List<Map<String, Object>> result = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result, "tb_mes_cust000");
		sb.setLength(0);
		sb = null;
	}

	public void syncTbMesPr200(Map<String, Object> param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String corp = String.valueOf(param.get("corp"));
		
		sb.append("select                          " + "\n");
		sb.append("	      '1000' as COMPANY        " + "\n");
		sb.append("	     ,a.cus  as CUST_CD        " + "\n");
		sb.append("	     ,a.item as ITEM_CD        " + "\n");
	    sb.append("      ,'system'  as CREATED_BY  " + "\n");
        sb.append("      ,now()     as CREATED_AT  " + "\n");
        sb.append("      ,'system'  as UPDATED_BY  " + "\n");
        sb.append("      ,now()     as UPDATED_AT  " + "\n");
		sb.append("	     ,date_format(a.chg_dt_out, '%Y-%m-%d') as REG_DT" + "\n");
		sb.append("	     ,a.out_pri as UNIT_PRICE  " + "\n");
		sb.append("      ,'Y'       as USE_YN      " + "\n");
		sb.append("  from sys040 a                 " + "\n");
		if(!corp.equals("") && corp != null){
			sb.append(" where a.corp = '" + corp + "'\n");
		}                  
		
		param.put("erpQuery", sb);
		System.out.println("=================================== ERP DATA -> MES : tb_mes_pr200 =================================\n" + sb);
		List<Map<String, Object>> result2 = erpMapper.erpQuery(param);
		userlogservice.transMesTable(result2, "tb_mes_pr200");
		sb.setLength(0);
		sb = null;
	}
}

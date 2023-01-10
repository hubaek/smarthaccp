package com.ppm.mes.domain.init;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.db.schema.SchemaGenerator;
import com.chequer.axboot.core.model.extract.service.jdbc.JdbcMetadataService;
import com.chequer.axboot.core.utils.ArrayUtils;
import com.chequer.axboot.core.utils.JsonUtils;
import com.ppm.mes.SHAPasswordEncoder;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenu;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenuService;
import com.ppm.mes.domain.cd.cd000.BasicCodeMaster;
import com.ppm.mes.domain.cd.cd000.BasicCodeMasterService;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetail;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailService;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.ppm.mes.domain.menu.menu000.Menu;
import com.ppm.mes.domain.menu.menu000.MenuService;
import com.ppm.mes.domain.pgm.pgm000.Program;
import com.ppm.mes.domain.pgm.pgm000.ProgramService;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.domain.user.user000.UserService;
import com.ppm.mes.domain.user.user050.UserAuth;
import com.ppm.mes.domain.user.user050.UserAuthService;

@Service
public class DatabaseInitService {

    @Inject private SchemaGenerator schemaGenerator;
    @Inject private UserService userService;
    @Inject private MenuService menuService;
    @Inject private AuthGroupMenuService authGroupMenuService;
    @Inject private ProgramService programService;
    @Inject private JdbcMetadataService jdbcMetadataService;
    @Inject private JdbcTemplate jdbcTemplate;
	@Inject private BasicCodeMasterService masterCodeService;
	@Inject private BasicCodeDetailService detailCodeService;   
	@Inject	private CompanyManagementService companyManagementService;
	@Inject private SHAPasswordEncoder bCryptPasswordEncoder;
	@Inject private UserAuthService userAuthService;
	
    public boolean initialized() {
        return ArrayUtils.isNotEmpty(jdbcMetadataService.getTables());
    }

    @Transactional
    public void createBaseCode() throws Exception {
        List<String> lines = new ArrayList<>();
        List<Program> programs = programService.findAll();
        for (Program program : programs) {
            String line = String.format("programService.save(Program.of(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"));",
                    program.getProgCd(),
                    program.getProgNm(),
                    program.getProgPh(),
                    program.getTarget(),
                    program.getAuthCheck(),
                    program.getSchAh(),
                    program.getSavAh(),
                    program.getExlAh(),
                    program.getDelAh(),
                    program.getFn1Ah(),
                    program.getFn2Ah(),
                    program.getFn3Ah(),
                    program.getFn4Ah(),
                    program.getFn5Ah());

            lines.add(line);
        }
        lines.add("\n");
        for (Menu menu : menuService.findAll()) {
            if (menu.getParentCd() == null) {
                String line = String.format("menuService.save(Menu.of(%dL,\"%s\",\"%s\",JsonUtils.fromJson(%s), null, %d, %d, null));",
                        menu.getId(),
                        menu.getMenuGrpCd(),
                        menu.getMenuNm(),
                        JsonUtils.toJson(JsonUtils.toJson(menu.getMultiLanguageJson())),
                        menu.getLv(),
                        menu.getSort());

                lines.add(line);
            } else {
                String line = String.format("menuService.save(Menu.of(%dL,\"%s\",\"%s\",JsonUtils.fromJson(%s),%dL, %d, %d, \"%s\"));",
                        menu.getId(),
                        menu.getMenuGrpCd(),
                        menu.getMenuNm(),
                        JsonUtils.toJson(JsonUtils.toJson(menu.getMultiLanguageJson())),
                        menu.getParentCd(),
                        menu.getLv(),
                        menu.getSort(),
                        menu.getProgCd());

                lines.add(line);
            }
        }
        
        lines.add("\n");

        for (AuthGroupMenu authGroupMenu : authGroupMenuService.findAll()) {
            String line = String.format("authGroupMenuService.save(AuthGroupMenu.of(\"%s\",%dL,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"));",
                    authGroupMenu.getGrpAuthCd(),
                    authGroupMenu.getSchAh(),
                    authGroupMenu.getSavAh(),
                    authGroupMenu.getExlAh(),
                    authGroupMenu.getDelAh(),
                    authGroupMenu.getFn1Ah(),
                    authGroupMenu.getFn2Ah(),
                    authGroupMenu.getFn3Ah(),
                    authGroupMenu.getFn4Ah(),
                    authGroupMenu.getFn5Ah());
            lines.add(line);
        }

        String code = System.getProperty("user.home") + "/Desktop/code.txt";

        IOUtils.writeLines(lines, null, new FileOutputStream(new File(code)), "UTF-8");
    }


    public void init() throws Exception {
        createSchema();
    }


    public void initMenu() throws Exception {
        createMenuData();
    }

    public void initData() throws Exception {
    	createBasicData();
    }
    
    public void createSchema() throws Exception {
        dropSchema();
        schemaGenerator.createSchema();
        createDefaultData();
        createMenuData();
        createBasicData();
    }

    public void createMenuData(){
    	authGroupMenuService.deleteAll();
    	menuService.deleteAll();
    	programService.deleteAll();
    	
    	programService.save(Program.of("api", "API", "/swagger/", "_self", "N", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("login", "로그인", "/jsp/login.jsp", "_self", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("main", "메인", "/jsp/main.jsp", "_self", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("not-authorized", "not-authorized", "/jsp/common/not-authorized.jsp", "_self", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"));

        //시스템관리  
        programService.save(Program.of("basic-data", "공통코드 관리", "/jsp/mes/common/basic-data.jsp", "_self", "Y", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-auth-user", "사용자관리", "/jsp/system/system-auth-user.jsp", "_self", "Y", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-config-menu", "메뉴 관리", "/jsp/system/system-config-menu.jsp", "_self", "Y", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-config-program", "프로그램 관리", "/jsp/system/system-config-program.jsp", "_self", "Y", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-operation-log", "에러로그 관리", "/jsp/system/system-operation-log.jsp", "_self", "Y", "Y", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-config-program-help", "프로그램 도움말", "/jsp/system/system-config-program-help.jsp", "_self", "Y", "Y", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("system-user-log", "사용자 로그관리", "/jsp/system/system-user-log.jsp", "_self", "Y", "Y", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("company-manage", "COMPANY 관리", "/jsp/company/company-manage.jsp", "_self", "Y", "Y", "N", "N", "N", "N", "N", "N", "N", "N"));
        programService.save(Program.of("cm-management", "CM JOB Management", "/jsp/system/cm-management.jsp", "_self", "Y", "Y", "Y", "N", "N", "N", "N", "N", "N", "N"));

        menuService.save(Menu.of("SYSTEM_MANAGE", "SYSTEM_ADMIN_GROUP", "시스템 관리", JsonUtils.fromJson("{\"ko\":\"시스템 관리\",\"en\":\"System Management\"}"), null, 0, 95, null));
        menuService.save(Menu.of("SYSTEM_MANAGE_01", "SYSTEM_ADMIN_GROUP", "메뉴관리", JsonUtils.fromJson("{\"ko\":\"메뉴 관리\",\"en\":\"Menu Mgmt\"}"), "SYSTEM_MANAGE", 1, 1, "system-config-menu"));
        menuService.save(Menu.of("SYSTEM_MANAGE_02", "SYSTEM_ADMIN_GROUP", "프로그램 관리", JsonUtils.fromJson("{\"ko\":\"프로그램 관리\",\"en\":\"Program Mgmt\"}"), "SYSTEM_MANAGE", 1, 2, "system-config-program"));
        menuService.save(Menu.of("SYSTEM_MANAGE_03", "SYSTEM_ADMIN_GROUP", "에러로그 관리", JsonUtils.fromJson("{\"ko\":\"에러로그관리\",\"en\":\"에러로그관리\"}"), "SYSTEM_MANAGE", 1, 3, "system-operation-log"));
        menuService.save(Menu.of("SYSTEM_MANAGE_04", "SYSTEM_ADMIN_GROUP", "사용자관리", JsonUtils.fromJson("{\"ko\":\"사용자관리\",\"en\":\"사용자관리\"}"), "SYSTEM_MANAGE", 1, 4, "system-auth-user"));
        menuService.save(Menu.of("SYSTEM_MANAGE_05", "SYSTEM_ADMIN_GROUP", "프로그램 도움말", JsonUtils.fromJson("{\"ko\":\"프로그램도움말\",\"en\":\"프로그램도움말\"}"), "SYSTEM_MANAGE", 1, 5, "system-config-program-help"));
        menuService.save(Menu.of("SYSTEM_MANAGE_06", "SYSTEM_ADMIN_GROUP", "사용자 로그관리", JsonUtils.fromJson("{\"ko\":\"사용자 로그관리\",\"en\":\"사용자 로그관리\"}"), "SYSTEM_MANAGE", 1, 6, "system-user-log"));
        menuService.save(Menu.of("SYSTEM_MANAGE_07", "SYSTEM_ADMIN_GROUP", "공통코드관리", JsonUtils.fromJson("{\"ko\":\"공통코드관리\",\"en\":\"공통코드관리\"}"), "SYSTEM_MANAGE", 1, 7, "basic-data"));
        menuService.save(Menu.of("SYSTEM_MANAGE_08", "SYSTEM_ADMIN_GROUP", "COMPANY 관리", JsonUtils.fromJson("{\"ko\":\"COMPANY 관리\",\"en\":\"COMPANY 관리\"}"), "SYSTEM_MANAGE", 1, 8, "company-manage"));
        menuService.save(Menu.of("SYSTEM_MANAGE_09", "SYSTEM_ADMIN_GROUP", "CM JOB Management", JsonUtils.fromJson("{\"ko\":\"CM JOB Management\",\"en\":\"CM JOB Management\"}"), "SYSTEM_MANAGE", 1, 9, "cm-management"));
    }
    
    
    public void createBasicData(){
    	masterCodeService.deleteAll();
    	detailCodeService.deleteAll();    	

		//////PCMS/////////
		masterCodeService.save(BasicCodeMaster.of("AUTH_GROUP","권한그룹"));
		detailCodeService.save(BasicCodeDetail.of("AUTH_GROUP","S0000","시스템관리자",0));
		detailCodeService.save(BasicCodeDetail.of("AUTH_GROUP","S0001","관리 사용자 그룹(수정/삭제)",1));
		detailCodeService.save(BasicCodeDetail.of("AUTH_GROUP","S0002","조회용 사용자그룹(조회)",2));	
		
		masterCodeService.save(BasicCodeMaster.of("USER_ST","계정상태"));
		detailCodeService.save(BasicCodeDetail.of("USER_ST","ACCOUNT_LOCK","잠김",1));
		detailCodeService.save(BasicCodeDetail.of("USER_ST","NORMAL","활성",2));
		
		masterCodeService.save(BasicCodeMaster.of("LOCALE","로케일"));		
		detailCodeService.save(BasicCodeDetail.of("LOCALE","ko_KR","대한민국",1));
		detailCodeService.save(BasicCodeDetail.of("LOCALE","en_US","미국",2));
		
		masterCodeService.save(BasicCodeMaster.of("MENU_GROUP","메뉴그룹"));		
		detailCodeService.save(BasicCodeDetail.of("MENU_GROUP","SYSTEM_ADMIN_GROUP","기본그룹",1));
		
		masterCodeService.save(BasicCodeMaster.of("USE_YN","사용여부"));
		detailCodeService.save(BasicCodeDetail.of("USE_YN","N","미사용",2));
		detailCodeService.save(BasicCodeDetail.of("USE_YN","Y","사용",1));		
		
		masterCodeService.save(BasicCodeMaster.of("USER_ROLE","사용자 롤"));
		detailCodeService.save(BasicCodeDetail.of("USER_ROLE","API","API 접근 롤",1));
		detailCodeService.save(BasicCodeDetail.of("USER_ROLE","ASP_ACCESS","시스템 접근 롤",	2));
		detailCodeService.save(BasicCodeDetail.of("USER_ROLE","SYSTEM_ADMIN_GROUP","시스템 관리자 롤",3));
		
		masterCodeService.save(BasicCodeMaster.of("DEL_YN","삭제여부"));
		detailCodeService.save(BasicCodeDetail.of("DEL_YN","N","미삭제",2));
		detailCodeService.save(BasicCodeDetail.of("DEL_YN","Y","삭제",1));		
		
		masterCodeService.save(BasicCodeMaster.of("DEAL_TYPE","거래유형"));
		detailCodeService.save(BasicCodeDetail.of("DEAL_TYPE","NO_SURTAX","부가세별도",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("DEAL_TYPE","SURTAX_AMT","부가세포함",2,"","Y"));

		//////////
		masterCodeService.save(BasicCodeMaster.of("RUN_EVERY","JOB 주기"));
		detailCodeService.save(BasicCodeDetail.of("RUN_EVERY","10","월",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("RUN_EVERY","20","주",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("RUN_EVERY","30","일",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("RUN_EVERY","40","시간",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("RUN_EVERY","50","분",5,"","Y"));
		
		masterCodeService.save(BasicCodeMaster.of("EXECUTABLE_METHOD","JOB 실행방법"));
		detailCodeService.save(BasicCodeDetail.of("EXECUTABLE_METHOD","10","EXE",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("EXECUTABLE_METHOD","20","DB 프로시져",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("EXECUTABLE_METHOD","30","API",3,"","Y"));
		
		
		
		
		
		//MES
		
		//품목
		masterCodeService.save(BasicCodeMaster.of("ITEM_TYPE","품목유형"));
		detailCodeService.save(BasicCodeDetail.of("ITEM_TYPE","10","제품",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ITEM_TYPE","20","반제품",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ITEM_TYPE","30","원재료",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ITEM_TYPE","40","부재료",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ITEM_TYPE","50","상품",5,"","Y"));


		masterCodeService.save(BasicCodeMaster.of("UNIT","수불단위"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","EA","개(EA)",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","KG","킬로그램(KG)",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","GR","그램(GR)",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","MT","미터(MT)",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","MM","밀리미터(MM)",5,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","CM","센티미터(Cm)",6,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","MT","미터(MT)",7,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","NA","NA",8,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","RL","롤(RL)",9,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("UNIT","ST","세트(ST)",10,"","Y"));		
		
		//거래처
		masterCodeService.save(BasicCodeMaster.of("CUST_TYPE","거래처유형"));
		detailCodeService.save(BasicCodeDetail.of("CUST_TYPE","10","매입",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("CUST_TYPE","20","매출",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("CUST_TYPE","99","기타",3,"","Y"));
		
		//창고
		masterCodeService.save(BasicCodeMaster.of("WH_TYPE","창고유형"));
		detailCodeService.save(BasicCodeDetail.of("WH_TYPE","10","자재창고",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("WH_TYPE","20","출하창고",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("WH_TYPE","30","공정창고",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("WH_TYPE","40","검사창고",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("WH_TYPE","50","외주창고",5,"","Y"));

		//설비
		masterCodeService.save(BasicCodeMaster.of("EQUIP_TYPE","설비유형"));
		detailCodeService.save(BasicCodeDetail.of("EQUIP_TYPE","10","유형1",1,"","Y"));

		masterCodeService.save(BasicCodeMaster.of("EQUIP_CLASS","설비분류"));
		detailCodeService.save(BasicCodeDetail.of("EQUIP_CLASS","10","분류1",1,"","Y"));

		//공정
		masterCodeService.save(BasicCodeMaster.of("ROUT_TYPE","공정분류"));
		detailCodeService.save(BasicCodeDetail.of("ROUT_TYPE","10","분류1",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ROUT_TYPE","20","분류2",2,"","Y"));

		masterCodeService.save(BasicCodeMaster.of("OUTSC_FLAG","외주여부"));
		detailCodeService.save(BasicCodeDetail.of("OUTSC_FLAG","10","사내",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("OUTSC_FLAG","20","외주",2,"","Y"));

		masterCodeService.save(BasicCodeMaster.of("INOUT_TYPE","입출고구분"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE","IN","입고",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE","OUT","출고",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE","USE","소모",3,"","Y"));

		masterCodeService.save(BasicCodeMaster.of("INOUT_TYPE_DETAIL","입출고상세구분"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","10","일반입고",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","15","일반입고(반품)",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","20","일반출고",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","30","창고입고",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","40","창고출고",5,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","50","재고실사",6,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","60","재공실사",7,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","70","구매입고",8,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","80","구매반품",9,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","85","구매취소",10,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","90","판매출고",11,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","100","판매반품",12,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","110","생산자재출고",13,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","115","생산자재출고(취소)",14,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","117","생산자재환입",15,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","120","생산자재투입",16,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","130","생산자재사용",17,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","135","생산자재사용(취소)",18,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","140","생산품입고",19,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","143","생산품불량",20,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","145","생산품공정입고",21,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","150","생산품공정이동",22,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","210","바코드분할",23,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","215","바코드생성",24,"","Y"));
		

		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","310","검사입고",25,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","320","검사불량",26,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("INOUT_TYPE_DETAIL","330","부적합-재처리",27,"","Y"));
		
		//생산
		masterCodeService.save(BasicCodeMaster.of("ORDER_ST","지시상태"));
		detailCodeService.save(BasicCodeDetail.of("ORDER_ST","ORDER","지시대기",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ORDER_ST","RUN","가동중",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ORDER_ST","END","종료",3,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ORDER_ST","NWRK","비가동",4,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("ORDER_ST","PAUSE","작업대기",5,"","Y"));
		

		masterCodeService.save(BasicCodeMaster.of("BAD_CD","불량유형"));
		masterCodeService.save(BasicCodeMaster.of("NWRK_CD","비가동유형"));
		
		//품질

		masterCodeService.save(BasicCodeMaster.of("QC_WAY","검사방법"));
		detailCodeService.save(BasicCodeDetail.of("QC_WAY","10","무검사",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("QC_WAY","20","샘플링검사",2,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("QC_WAY","30","전수검사",3,"","Y"));

		masterCodeService.save(BasicCodeMaster.of("QC_CD","검사항목"));
		
		masterCodeService.save(BasicCodeMaster.of("QC_FLAG","검사상태"));
		detailCodeService.save(BasicCodeDetail.of("QC_FLAG","Y","합격",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("QC_FLAG","N","불합격",2,"","Y"));
		
		masterCodeService.save(BasicCodeMaster.of("QC_UNIT","검사단위"));
		detailCodeService.save(BasicCodeDetail.of("QC_UNIT","NA","NA",1,"","Y"));
		detailCodeService.save(BasicCodeDetail.of("QC_UNIT","MM","밀리미터(MM)",2,"","Y"));
    }
    
    public void createDefaultData() throws IOException {
    	/*
    	TbCmmsCp000 company = new TbCmmsCp000();
    	company.setCompany("1000");
    	company.setCompanyNm("HACCP");
    	company.setUseYn("Y");
    	tbCmmsCp000Service.save(company);
		*/
        User user = new User();
        user.setUserCd("system");
        user.setEmail("jeon.jy@8pmbiz.com");
        user.setUserNm("시스템 관리자");
        user.setUserPs(bCryptPasswordEncoder.encode("1"));
        user.setUserSt("NORMAL");
        user.setUseYn("Y");
        userService.save(user);

	    UserAuth auth = new UserAuth();
	    auth.setUserCd(user.getUserCd());
	    auth.setGrpAuthCd("S0000");
        userAuthService.save(auth);
    }
    
    public void setupDeptIf() throws IOException {

    //	String deleteSql = " DELETE FROM TB_MES_INF100 WHERE IF_YN = 'Y' ";
    //	jdbcTemplate.update(deleteSql);   
    	
    	this.jdbcTemplate.query("SELECT COMPANY, COMPANY_TYPE FROM TB_MES_CP000 WHERE USE_YN = 'Y'",
  	    		new RowMapper<Object>() {
    		    	@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    		    		String sql = 
    		    			    " INSERT INTO TB_MES_INF100 (COMPANY, DEPT_CD, DEPT_NM, DEPT_EN_NM, UP_DEPT_CD,USE_YN,IF_YN,CREATED_AT, CREATED_BY) " + 
    		    			    " SELECT '"+rs.getString("COMPANY")+"', Z.DEPT_CD, Z.DEPT_NM, Z.DEPT_EN_NM, Z.UP_DEPT_CD ,'Y','Y',SYSDATE,'S' " +
    							"	  FROM IF_ESAOGDP Z " +
    							"	 WHERE 1=1  " +
    							"    AND Z.DEPT_CD NOT IN ( SELECT DEPT_CD FROM TB_MES_INF100 ) " +
    							"	 AND SUBSTR(Z.DEPT_CD,0,1) IN ( SELECT COMPANY_TYPE FROM TB_MES_CP000 WHERE USE_YN = 'Y' AND COMPANY = '"+rs.getString("COMPANY")+"') "; 
    		    	
    		    		jdbcTemplate.update(sql);   
    		    		return null;
    		    	}
    		});
    }

    public void dropSchema() {
        try {
            List<String> tableList = schemaGenerator.getTableList();

            tableList.forEach(table -> {
                jdbcTemplate.update("DROP TABLE " + table);
            });
        } catch (Exception e) {
            // ignore
        }

    }
}

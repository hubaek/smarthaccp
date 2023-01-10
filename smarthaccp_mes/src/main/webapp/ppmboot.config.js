
(function () {
    if (ppmboot && ppmboot.def) {

        ppmboot.def["DEFAULT_TAB_LIST"] = [
            {menuCd: "00-dashboard", id: "dashboard1", progNm: '홈', menuNm: '홈', progPh: '/jsp/dashboard.jsp', url: '/jsp/dashboard.jsp?progCd=dashboard', status: "on", fixed: true}
        ];

        ppmboot.def["API"] = {
	    	//권한마스터
	        "authGroup": "/api/v1/authGroup" ,
            "company": "/api/v1/company",
        	//공통코드
            "basic": "/api/v1/basicCode" ,
            //사용자
            "users": "/api/v1/users",
            //프로그램
            "programs": "/api/v1/programs",
            //메뉴
            "menu": "/api/v2/menu",   
            //에러로그
            "errorLogs": "/api/v1/errorLogs",
            //사용자로그
            "userLogs": "/api/v1/userLogs",
            //SYSTEM 관리
            "system": "/api/v1/system",
            //공통파일
            "files": "/api/v1/files",
            "dept": "/api/v1/dept",            
            "key": "/api/v1/key",

	        //품목마스터
	        "item": "/api/v1/item",
            //창고관리
            "whCd": "/api/v1/whCd" ,
            //공정관리
            "rout": "/api/v1/rout" ,
            "bom": "/api/v1/bom",
            //거래처정보
            "custInfo": "/api/v1/custInfo",        
            //설비마스터
	        "equip": "/api/v1/equip",
	        //설비이력카드
            "manuEquip" : "/api/v1/manuEquip",
            
            //구매
            "porder" : "/api/v1/porder",
            "purchase" : "/api/v1/purchase",
            "purchaseEtc" : "/api/v1/purchaseEtc",
            "purchaseReturn" : "/api/v1/purchaseReturn",
            "purchaseCancel" : "/api/v1/purchaseCancel",
            "purchaseEnd" : "/api/v1/purchaseEnd",        
            
            ////영업
            "order" : "/api/v1/order",
            "sales" : "/api/v1/sales",
            
            //생산
            "workPlan" : "/api/v1/workPlan",
            "worder" : "/api/v1/worder",
            "worderMaster" : "/api/v1/worderMaster",
            "worderDetail" : "/api/v1/worderDetail",
            "workOrderMove" : "/api/v1/workOrderMove",
            "workOrderIncoming" : "/api/v1/workOrderIncoming",
            "worderList" : "/api/v1/worderList",   
            
            //재고           
            "stock" : "/api/v1/stock",                   
            "modify" : "/api/v1/modify",            
            "moveInout" : "/api/v1/moveInout",    
            
            //부자재/부재료 입고
            "material" :"/api/v1/material",
            
            //품질
            "qualityInspectionBad" : "/api/v1/qualityInspectionBad",
            "outgoingInspection" : "/api/v1/outgoingInspection",   
            
            //QC
            "qcManage" : "/api/v1/qcManage",
            //계시판.
            "board" : "/api/v1/board",
            
            //HACCP
            "haccp": "/api/v1/haccp" ,
            //HACCP 공정관리
            "haccpProcess":"/api/v1/haccpProcess",
            //HACCP 자체위생위생점검
            "selfHygine": "/api/v1/selfHygine",
            //HACCP 차량운행및위생점검
            "car":"/api/v1/car",
            //HACCP 제조시설/설비점검
            "manufacturing":"/api/v1/manufacturing",
            
            "haccpInMaster": "/api/v1/HaccpInMaster",
            //HACCP 제품검사대장
            "itemCheck" : "/api/v1/itemCheck",
            //센서정보
            "snsr" : "/api/v1/snsr",
            //한계기준정보
            "limit" : "/api/v1/limit",
            //품질검사 연간계획
            "plan" : "/api/v1/plan",
            //HACCP 포충등 및 방서 점검
            "haccpLamp": "/api/v1/haccpLamp",
            //HACCP 폐기물 2020-11-24 cju
            "haccpWaste": "/api/v1/haccpWaste" ,
            //HACCP 통합점검일지
            "haccpAll": "/api/v1/haccpAll",
            //HACCP 일반위생관리 및 공정점검표 2020-11-24 CJU
            "haccpHgPrc": "/api/v1/haccpHgPrc",
            // 2020-11-24 CJU
            "price": "/api/v1/price",
            
            //주기관리 2020-12-07 cju
            "cycle" : "/api/v1/cycle",
            //HACCP 금속검출 2020-12-07 cju
            "haccpMetal": "/api/v1/haccpMetal" ,
            //HACCP 온도 습도 점검 2020-12-09 cju
            "haccpTemp": "/api/v1/haccpTemp" ,
            //여과점검
            "filter" :"/api/v1/haccpFilter",
            
            //가열살균
            "haccpHeat" : "/api/v1/haccpHeat",
         	//내포장설비
            "haccpProd" : "/api/v1/haccpProd",
            
            //살균
            "haccpSter" : "/api/v1/haccpSter",
          //살균
            "haccpTank" : "/api/v1/haccpTank",
            //파우치
            "haccpPack" : "/api/v1/haccpPack",
            //향온향습기
            "haccpTher" : "/api/v1/haccpTher",

            //세척
            "haccpClean" : "/api/v1/haccpClean",
            
            // 택배 송장 서비스
            "Delivery": "/api/v1/Delivery",
            
            // 리포트	2021-05-24 leg
            "dailyreport": "/api/v1/dailyreport",
            
            // 결재	2022-02-21 khj
            "approval": "/api/v1/appr",
        };

        ppmboot.def["MODAL"] = {          
        	/** 공통 **/
    		"ITEM-MODAL": { 
                width:1100,
                height: 700,
                iframe: {
                    url: "/jsp/mes/modal/ITEM-ONE-M.jsp"
                },
                header: false,
    		    fullScreen: function () {
                    return ($(window).width() < 600);
                }
            },
    		"EQUIP-MODAL": { 
                width:1100,
                height: 700,
                iframe: {
                    url: "/jsp/mes/modal/EQUIP-ONE-M.jsp"
                },
                header: false,
    		    fullScreen: function () {
                    return ($(window).width() < 600);
                }
            },
            "ITEM-SELECT-MODAL": { 
                width:1100,
                height: 780,
                iframe: {
                    url: "/jsp/mes/modal/ITEM-SEL-M.jsp"
                },
                header: false,
    		    fullScreen: function () {
                    return ($(window).width() < 600);
                }
            },
    		"CUST-MODAL": {
                width:1100,
                height: 700,
                iframe: {
                    url: "/jsp/mes/modal/CUST-ONE-M.jsp"
                },
                header: false
            },   
            "USER-MODAL": {
                width:900,
                height: 650,
                iframe: {
                    url: "/jsp/mes/modal/USER-ONE-M.jsp"
                },
                header: false
            },
            
            "RTSEL-MODAL": {
                width:900,
                height: 650,
                iframe: {
                    url: "/jsp/mes/modal/RT-SEL-M.jsp"
                },
                header: false
            },
            
            /**기준정보관리**/
            "ITEM100M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ITEM/modal/ITEM100M.jsp"
                },
                header: false
            },
            "LMT000M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/LMT/modal/LMT000M.jsp"
                },
                header: false
            },
            "STD020M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/STD/modal/STD020M.jsp"
                },
                header: false
            },
            "EQ000M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/EQ/modal/EQ000M.jsp"
                },
                header: false
            },
            "RT100M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/RT/modal/RT100M.jsp"
                },
                header: false
            },
            "SNSR000M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/SNSR/modal/SNSR000M.jsp"
                },
                header: false
            },
            
    		/**구매 관리**/
            //발주
            "PC020M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PC/modal/PC020M.jsp"
                },
                header: false
            },
            //구매입고
            "PC030M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PC/modal/PC030M.jsp"
                },
                header: false
            },
            
            //POP 원재료입고
            "POP-PC030M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PC/modal/POP-PC30M.jsp"
                },
                header: false
            },
            
            //POP 원재료입고
            "POP-PC090M": { 
                width:1600,
                height: 800,
                iframe: {
                    url: "/jsp/mes/PC/modal/POP-PC90M.jsp"
                },
                header: false
            },
            //구매반품
            "PC040M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PC/modal/PC040M.jsp"
                },
                header: false
            },
            //매입마감
            "PC050M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PC/modal/PC050M.jsp"
                },
                header: false
            },
            //영업
            //수주
            "SA030M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/SA/modal/SA030M.jsp"
                },
                header: false
            },          
            //출고판매
            "SA040M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/SA/modal/SA040M.jsp"
                },
                header: false
            },    
            /**생산**/
            //생산관리
            "PRD100M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PRD/modal/PRD100M.jsp"
                },
                header: false
            },
            //생산실적
            "PRD150M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/PRD/modal/PRD150M.jsp"
                },
                header: false
            },  
            //BOM등록
            "BOM010M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/BOM/modal/BOM010M.jsp"
                },
                header: false
            },
            //재고관리
            //재고수정-자재
            "ST110M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ST/modal/ST110M.jsp"
                },
                header: false
            },  
            //재고수정-생산
            "ST120M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ST/modal/ST120M.jsp"
                },
                header: false
            },  
            //재고수정-제품
            "ST130M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ST/modal/ST130M.jsp"
                },
                header: false
            },  
            //재공수정
            "ST140M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ST/modal/ST140M.jsp"
                },
                header: false
            },  
            //창고이동
            "ST210M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/ST/modal/ST210M.jsp"
                },
                header: false
            },  
            "ZIPCODE": {
                width:700,
                height: 650,
                iframe: {
                    url: "/jsp/common/zipcode.jsp"
                },
                header: false
            },
            "USER-INFO-M": {
                width: 800,
                height:270,
                iframe: {
                    url: "/jsp/SYS/USER-INFO-M.jsp"
                },
                header: false
            },
            "OUT-STOCK-M": {
                width: 1300,
                height:780,
                iframe: {
                    url: "/jsp/mes/PRD/modal/OUT-STOCK-M.jsp"
                },
                header: false
            },
            "BAD-ITEM-M": {
                width: 1100,
                height:730,
                iframe: {
                    url: "/jsp/mes/PRD/modal/BAD-ITEM-M.jsp"
                },
                header: false
            },            
            //POP
            "POP-SEARCH-ORDER": {
                width: 1400,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/order-modal.jsp"
                },
                header: false
            },
            "POP-SEARCH-MAN": {
                width: 1100,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/man-modal.jsp"
                },
                header: false
            },
            "POP-SEARCH-NWRK": {
                width: 900,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/nwrk-modal.jsp"
                },
                header: false
            },
            "POP-OUT-STOCK": {
                width: 1400,
                height:950,
                iframe: {
                    url: "/jsp/pop/modal/out-stock-modal.jsp"
                },
                header: false
            },
            "POP-BAD": {
                width: 1200,
                height:850,
                iframe: {
                    url: "/jsp/pop/modal/bad-modal.jsp"
                },
                header: false
            },
            "POP-DISCARD": {
                width: 1200,
                height:850,
                iframe: {
                    url: "/jsp/pop/modal/discard-modal.jsp"
                },
                header: false
            },
            "POP-BARCODE": {
                width: 1300,
                height:1000,
                iframe: {
                    url: "/jsp/pop/modal/barcode-modal.jsp"
                },
                header: false
            },
            "POP-NUM-PAD": {
                width: 800,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad.jsp"
                },
                header: false
            },
            //양품등록패드
            "POP-NUM-PAD-PROD": {
                width: 1300,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-prod.jsp"
                },
                header: false
            },
            
            //입고출고패드 2020-11-04 cju
            "POP-NUM-PAD-PROD2": {
                width: 1300,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-prod2.jsp"
                },
                header: false
            },
            
            //바코드발행패드
            "POP-NUM-PAD-BARCODE": {
                width: 1000,
                height:700,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-barcode.jsp"
                },
                header: false
            },
            //BOX바코드발행
            "POP-NUM-PAD-BOX": {
                width: 1200,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-box.jsp"
                },
                header: false
            },
            //발행장수입력패드
            "POP-NUM-PAD-PRINT": {
                width: 800,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-print.jsp"
                },
                header: false
            },
            //자재출고패드
            "POP-NUM-PAD-OUT": {
                width: 800,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-out.jsp"
                },
                header: false
            },
            //lot반제품 출고패드
            "POP-NUM-PAD-LOT-OUT": {
                width: 800,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-lot-out.jsp"
                },
                header: false
            },
            //자재부분환입패드
            "POP-NUM-PAD-OUT-RETURN": {
                width: 800,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/num-pad-out-return.jsp"
                },
                header: false
            },
            "POP-SETUP": {
                width: 700,
                height:300,
                iframe: {
                    url: "/jsp/pop/modal/setup-modal.jsp" 
                },
                header: false
            },
            "POP-MENU": {
                width: 560,
                height:300,
                iframe: {
                    url: "/jsp/pop/modal/menu-modal.jsp" 
                },
                header: false
            },
            "POP-END": {
                width: 1400,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/end-order.jsp"
                },
                header: false
            },
            //설비
            "POP-EQUIP": {
                width: 1400,
                height:800,
                iframe: {
                    url: "/jsp/pop/modal/equip-modal.jsp"
                },
                header: false
            },
            "POP-WO-DOC": {
                width: 1400,
                height:900,
                iframe: {
                    url: "/jsp/pop/modal/wo-doc-modal.jsp"
                },
                header: false
            },
            "POP-INOUT": {
                width: 1400,
                height:950,
                iframe: {
                    url: "/jsp/pop/modal/inout-modal.jsp" 
                },
                header: false
            },
            
            // 2021-01-06 kjm 재고현황(제품)
            "POP-SA-SEARCH": {
                width: 1600,
                height:900,
                iframe: {
                    url: "/jsp/pop/modal/POP-SA-SEARCH.jsp"
                },
                header: false
            },
            
            // 2020-09-22 cju 재고현황
            "POP-ST-SEARCH": {
                width: 1600,
                height:900,
                iframe: {
                    url: "/jsp/pop/modal/pop-st-search.jsp"
                },
                header: false
            },
        	// 2020-09-22 cju 입/출고 관리
            "POP_IN_OUT_MODAL": {
                width: 1600,
                height:900,
                iframe: {
                    url: "/jsp/pop/modal/pop-in-out-modal.jsp"
                },
                header: false
            },
            //공지등록
    		"BOD010M": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD010M.jsp"
                },
                header: false
            },   
            //공지 조회
    		"BOD010MV": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD010MV.jsp"
                },
                header: false
            },
            //업데이트등록
    		"BOD020M": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD020M.jsp"
                },
                header: false
            },   
            //업데이트조회
    		"BOD020MV": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD020MV.jsp"
                },
                header: false
            },
            //자료실등록
    		"BOD030M": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD030M.jsp"
                },
                header: false
            },   
            //자료실조회
    		"BOD030MV": {
                width:1000,
                height: 700,
                iframe: {
                    url: "/jsp/mes/BOD/modal/BOD030MV.jsp"
                },
                header: false
            },
            //견적적용팝업
    		"SA020R": {
                width:1200,
                height: 750,
                iframe: {
                    url: "/jsp/mes/SA/ref-modal/SA020R.jsp"
                },
                header: false
            },
            //수주적용팝업
    		"SA030R": {
                width:1200,
                height: 750,
                iframe: {
                    url: "/jsp/mes/SA/ref-modal/SA030R.jsp"
                },
                header: false
            },
            "QC100M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/mes/QC/modal/QC100M.jsp"
                },
                header: false
            },
            /*HACCP팝업*/
            
            "HACCP050M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP050M.jsp"
                },
                header: true
            },
            "HACCP060M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP060M.jsp"
                },
                header: true
            },
            "HACCP070M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP070M.jsp"
                },
                header: true
            },
            "HACCP080M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP080M.jsp"
                },
                header: true
            },
            
            "HACCP090M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP090M.jsp"
                },
                header: true
            },
            
            "HACCP100M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP100M.jsp"
                },
                header: true
            },
            "HACCP110M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP110M.jsp"
                },
                header: true
            },
            //2020-11-24 cju 일반위생관리 및 공정점검표
            "HACCP130M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP130M.jsp"
                },
                header: true
            },
            
            //포충등 및 방서 점검
            "HACCP330M": {
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP330M.jsp"
                },
                header: true
            },
            
            //통합점검일지
            "HACCP340M": {
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP340M.jsp"
                },
                header: true
            },
            
            //제조시설/설비 점검
            "HACCP150M": {
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP150M.jsp"
                },
                header: true
            },
            
            "HACCP200M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP200M.jsp"
                },
                header: true
            },
            
            "HACCP210M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP210M.jsp"
                },
                header: true
            },
            
            "HACCP220M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP220M.jsp"
                },
                header: true
            },
            
            "HACCP230M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP230M.jsp"
                },
                header: true
            },
            
            "HACCP240M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP240M.jsp"
                },
                header: true
            },
            
            "HACCP250M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP250M.jsp"
                },
                header: true
            },
            
            "HACCP260M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP260M.jsp"
                },
                header: true
            },
            
            "HACCP270M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP270M.jsp"
                },
                header: true
            },
            
            "HACCP280M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP280M.jsp"
                },
                header: true
            },
            
            "HACCP290M": { 
                width:950,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP290M.jsp"
                },
                header: true
            },
            
            "HACCP400M": { 
                width:1100,
                height: 780,
                iframe: {
                    url: "/jsp/haccp/modal/HACCP400M.jsp"
                },
                header: true
            },
            //점검일지주기관리
            "CCP000M": { 
                width:1300,
                height: 470,
                iframe: {
                    url: "/jsp/mes/CCP/modal/CCP000M.jsp"
                },
                header: false
            },
            //POP 작업등록
            "POP-REG-ORDER": {
                width: 1500,
                height:900,
                iframe: {
                    url: "/jsp/pop/modal/reg-order-modal.jsp"
                },
                header: false
            },
            //POP 제품출고
            "POP-SA120M": { 
                width:1800,
                height: 1000,
                iframe: {
                    url: "/jsp/mes/SA/modal/POP-SA120M.jsp"
                },
                header: false
            },
            //보건증 등록
            "HEALTH000M": { 
                width:600,
                height: 550,
                iframe: {
                    url: "/jsp/haccp/modal/HEALTH000M.jsp"
                },
                header: true
            },
            //HACCP기준서 등록
            "DOC000M": { 
                width:700,
                height: 470,
                iframe: {
                    url: "/jsp/haccp/modal/DOC000M.jsp"
                },
                header: true
            },
            "REPORT001M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/report/modal/REPORT001M.jsp"
                },
                header: true
            },
            "REPORT002M": { 
               width:1300,
               height: 780,
               iframe: {
                  url: "/jsp/report/modal/REPORT002M.jsp"
               },
               header: true
            },
            "REPORT003M": { 
               width:1300,
               height: 780,
               iframe: {
                  url: "/jsp/report/modal/REPORT003M.jsp"
               },
               header: true
            },
            "REPORT004M": { 
               width:1300,
               height: 780,
               iframe: {
                  url: "/jsp/report/modal/REPORT004M.jsp"
               },
               header: true
            },
            "REPORT005M": { 
               width:1300,
               height: 780,
               iframe: {
                  url: "/jsp/report/modal/REPORT005M.jsp"
               },
               header: true
            },
            "REPORT006M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/report/modal/REPORT006M.jsp"
                },
                header: true
            },
            "REPORT007M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/report/modal/REPORT007M.jsp"
                },
                header: true
            },
            "REPORT008M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/report/modal/REPORT008M.jsp"
                },
                header: true
            },
            "REPORT009M": { 
                width:1300,
                height: 780,
                iframe: {
                    url: "/jsp/report/modal/REPORT009M.jsp"
                },
                header: true
            },
            "REPORT010M": { 
                width:1300,
                height: 780,
                iframe: {
                   url: "/jsp/report/modal/REPORT010M.jsp"
                },
                header: true
             },
             "REPORT011M": { 
                width:1300,
                height: 780,
                iframe: {
                   url: "/jsp/report/modal/REPORT011M.jsp"
                },
                header: true
             },
             "REPORT012M": { 
                width:1300,
                height: 780,
                iframe: {
                   url: "/jsp/report/modal/REPORT012M.jsp"
                },
                header: true
             },
             "REPORT013M": { 
                width:1300,
                height: 780,
                iframe: {
                   url: "/jsp/report/modal/REPORT013M.jsp"
                },
                header: true
             },
             "REPORT014M": { 
                width:1300,
                height: 780,
                iframe: {
                   url: "/jsp/report/modal/REPORT014M.jsp"
                },
                header: true
             },
             "REPORT015M": { 
                 width:1300,
                 height: 780,
                 iframe: {
                    url: "/jsp/report/modal/REPORT015M.jsp"
                 },
                 header: true
              },
              "REPORT016M": { 
                  width:1300,
                  height: 780,
                  iframe: {
                     url: "/jsp/report/modal/REPORT016M.jsp"
                  },
                  header: true
               },
               "REPORT017M": { 
                   width:1300,
                   height: 780,
                   iframe: {
                      url: "/jsp/report/modal/REPORT017M.jsp"
                   },
                   header: true
                },
                "REPORT018M": { 
                    width:1300,
                    height: 780,
                    iframe: {
                       url: "/jsp/report/modal/REPORT018M.jsp"
                    },
                    header: true
                 },
	            "REPORT019M": { 
	                width:1300,
	                height: 780,
	                iframe: {
	                   url: "/jsp/report/modal/REPORT019M.jsp"
	                },
	                header: true
	             },
	            "REPORT020M": { 
	                width:1300,
	                height: 780,
	                iframe: {
	                   url: "/jsp/report/modal/REPORT020M.jsp"
	                },
	                header: true
	             },
	            "REPORT021M": { 
	                width:1300,
	                height: 780,
	                iframe: {
	                   url: "/jsp/report/modal/REPORT021M.jsp"
	                },
	                header: true
	             },
	            "REPORT022M": { 
	                width:1300,
	                height: 780,
	                iframe: {
	                   url: "/jsp/report/modal/REPORT022M.jsp"
	                },
	                header: true
	             },
	            "REPORT023M": { 
	                width:1300,
	                height: 780,
	                iframe: {
	                   url: "/jsp/report/modal/REPORT023M.jsp"
	                },
	                header: true
	             },
	             
	             "REPORT024M": { 
		                width:1300,
		                height: 780,
		                iframe: {
		                   url: "/jsp/report/modal/REPORT024M.jsp"
		                },
		                header: true
		             },
            
        };
    }

    var preDefineUrls = {
        "manual_downloadForm": "/api/v1/manual/excel/downloadForm",
        "manual_viewer": "/jsp/system/system-help-manual-view.jsp"
    };
    ppmboot.getURL = function (url) {
        if (ax5.util.isArray(url)) {
            if (url[0] in preDefineUrls) {
                url[0] = preDefineUrls[url[0]];
            }
            return url.join('/');

        } else {
            return url;
        }
    }
})();
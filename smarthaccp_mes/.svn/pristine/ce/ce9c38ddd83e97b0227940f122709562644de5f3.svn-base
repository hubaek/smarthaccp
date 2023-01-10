/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 윤광준
 * 2. 작성일		: 2020.09.25
 * 3. Comment 	: 사무실 TV 모니터링 화면
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 */

var fnObj = {};
var wlotNo;
var wlotNoIdx;
var setupInfo;
var equipCd;

var ACTIONS = ppmboot.actionExtend(fnObj, {
	
	//페이지 세로고침	로그인 사용자별 POP 권한 가져오기
    PAGE_REFRESH: function (caller, act, data) {
    	ppmboot
			.call({
		     	type: "GET",
				 url: ["/api/v1/pop2/getSetup"],
				 data: {},
		         callback: function (data) {
		        	//가져온 권한 전역 변수 셋팅.
		        	setupInfo = data;		      
		        	//공정분류,공정 셋팅.
	               	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,setupInfo);       
		         }
		    })  
	        .done(function () {
	        });   
    },        
	//RUNNING 중인 오더 목록 가져오기.
    PAGE_SEARCH: function (caller, act, data) {
    	let today = new Date();
    	let year=today.getFullYear();
    	let month=today.getMonth()+1;
    	let date=today.getDate();
    	
    	if(month < 10){
    		month = "0" + month;
    	}
    	if(date < 10){
    		date = "0" + date;
    	}
    	let srDt = year +"-"+month +"-"+date;
        ppmboot.ajax({
        	type: "GET",
			url: ["/api/v1/pop2/getWorkOrderList02"],
			data: {fromDate:srDt,toDate:srDt},
	        callback: function (res) {
	           caller.gridView01.setData(res);
	           if(res.length > 0){
	        	   wlotNoIdx = 0;
	        	   if(nvl(wlotNo,'') != ''){
	        		   res.forEach(function (n) {   
			           		if(n.wlotNo == wlotNo){
			 	        	   caller.gridView01.target.select(wlotNoIdx);
				               ACTIONS.dispatch(ACTIONS.ORDER_CLICK,res[wlotNoIdx]);
			 	        	   return false;
			           		}		           		
			           		wlotNoIdx++;
			       		});     
	        	   }else{
	 	        	   caller.gridView01.target.select(wlotNoIdx);
		               ACTIONS.dispatch(ACTIONS.ORDER_CLICK,res[wlotNoIdx]);	// pop화면에 설비 등록 and 작업시작 버튼이 없기때문에 지시 선택과 함께 start(작업지시등록시에 설비등록을 해줘야함)
	        	   }
	           }else{
	               
	            }
	         }
        });	 
    },        
    
   
    //공정분류 변경
    CHANGE_ROUT_TYPE: function (caller, act, data) {           	

    	var routType = data.routType;
    	var routCd = data.routCd;
    	
    	$("#routType").val(routType);    	
    	
    	$("#routCd option").remove();
   		if(nvl(routType,'') == ''){
           	$("#routCd").append("<option value=''>공정 선택</option>")
   		}else{
   			
   			ppmboot.ajax({
   		    	type: "GET",
   	            url:  ["rout"],
   	            data: "routType=" + routType ,
   		        callback: function (res) {        
   	            	$("#routCd").append("<option value=''>전체</option>");
   		        	res.list.forEach(function (n) {
   	                	$("#routCd").append("<option value='"+n.routCd+"'>"+n.routNm+"</option>")
   		        	});	

   		        	if(nvl(routCd,'') != ''){
   		        		//$('#routCd option[value='+routCd+']').attr('selected','selected');	
   			        	$("#routCd").val(routCd).attr("selected", "selected");
   		        	}else{
   		    			$("#routCd option:eq(0)").attr("selected","selected");	
   		        	}
   		        }
   		    });
   		}

   		if(setupInfo.routType != ''){
   			$("#routType").attr("disabled","disabled");   			
   		}else{
   			$("#routType").removeAttr("disabled");
   		}

   		if(setupInfo.routCd != ''){
   			$("#routCd").attr("disabled","disabled");   			
   		}else{
   			$("#routCd").removeAttr("disabled");
   		}

   		if(nvl(setupInfo.authYn,'N') == 'Y'){
   			$("#setup-modal").removeAttr("disabled");		
   		}else{
   			$("#setup-modal").attr("disabled","disabled");   	
   		}
   		
   		ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   		
    },
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            // 직접코딩
            return false;
        }
    }
});

/**
* searchView
*/
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
  initView: function () {
      this.target = $(document["searchView0"]);
      this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
  }
});


fnObj.pageStart = function () {
    var _this = this;
    getDate();
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "ORDER_ST"},
        callback: function (res) {        		
            this.ORDER_ST = res.list;
        }
    })
    .call({
        type: "GET",
        url: ["rout"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.routCd;   
    			n.subNm = n.routNm;
    		});            	
        	res.list.push({subCd:"",subNm:"전체"});
            this.ROUT_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();

        /*$("#routType").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,{routType:$(this).val(),routCd:""});
        }); 
        
        $("#routCd").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });*/ 

    	ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);       
    	
    	setInterval("refreshPage()", 10000); // 600000 ms(10분)가 경과하면 refreshPage() 함수를 실행합니다.
    });
    
    document.title = "PROD-MONIT" ;
};

fnObj.pageResize = function () {
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });
    }
});
/**
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            scroller: {size: 35},
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            columns: [
                {key: "orderDt",width:165, hidden:true},
                {key: "orderNo",width:170},
                {key: "itemCd",width:170},
                {key: "itemNm",width:470, formatter:function(){
                	if(nvl(this.item.barcodePrintQty,0) <= 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                		return "<font color='blue'>"+this.value+"</font>";
                	}
                }},
				{key: "routCd", label: "공정",width:170, align: "center",formatter: function formatter() {
						return CONVERT_CODE["ROUT_CD"].map[this.value];
					}
				},	
                {key: "orderSt",
                    width: 120, label: "상태", align: "center", formatter: function formatter() { 
                    	if(this.item.orderSt == 'RUN'){
                    		return "<div class='worder-circle2'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'NWRK'){
                    		return "<div class='worder-circle1'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'END'){
                    		return "<div class='worder-circle4'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'PAUSE'){
                    		return "<div class='worder-circle5'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'LOCK'){
                    		return "<div class='worder-circle3'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else{
                    		return "<div class='worder-circle6'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}
                    }},
                //{key: "unit"},
                //{key: "exInitem", label: "예외입고수량",width: 100, formatter:"number", align: "right", editor: {type: "number"} },
                //    "<font color='red'>"+this.value+"</font>"
                //{key: "eaQty", label:"EA 수량", width: 100,align: "right"},
                {key: "orderQty", label: "주문수량", width: 155, },
                {key: "prodQty", label: "생산수량", width: 150},
                {key: "badQty", label: "불량수량", width: 150},
                {key: "prodPer", label: "생산률", width: 140,align: "center",formatter: function(){
                	let result;
                		result = this.item.prodQty/this.item.orderQty*100;
                	return "<font color='skyblue'>"+((isNaN(result))?'0'  : result.toFixed(2)) + "%"+"</font>";
                }},
                {key: "badprodPer", label: "불량률", width: 140,align: "center",formatter: function(){
                	let result;
                		result = this.item.badQty/this.item.orderQty*100;
                	return "<font color='red'>"+((isNaN(result))?'0'  : result.toFixed(2)) + "%"+"</font>";
                }},
                       
            ],
            body: {
                columnHeight: 55,
            },
            
            page: {
                display: false
            }
        });
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.wlotNo;
            });
        } else {
            list = _list;
        }
        return list;
    },
});

function refreshPage(){
	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
}

function getDate(){
	var dt = new Date();
	var year = dt.getFullYear();
	var month = dt.getMonth()+1;
	var date = dt.getDate();
	
	$('.todayDate').text(year + '년 ' +month+'월 '+date+'일 ');
}



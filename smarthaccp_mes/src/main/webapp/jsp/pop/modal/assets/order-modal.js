/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 작업지시조회
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_CLOSE: function (caller, act, data) { 
    	if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {  
        ppmboot.ajax({
            type: "GET",
            url: ["/api/v1/pop2/getWorkOrderList"],
            data: $.extend({orderSt:"ORDER",routType:$("#routType").val(),routCd:$("#routCd").val(),equipAuthYn:param.setupInfo.equipAuthYn,userCd:param.setupInfo.userCd}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list[0],param);
        	}else{            		
        		parent[param.callBack](list[0],param);      
        	}
        } else {
            alert(LANG("ax.script.requireselect"));
        }
    },
    ITEM_CLICK: function (caller, act, data) {
        ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
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
   			        	$("#routCd").val(routCd).attr("selected", "selected");
   		        	}else{
   		    			$("#routCd option:eq(0)").attr("selected","selected");	
   		        	}
   		        }
   		    });
   		}

   		if(param.setupInfo.routType != ''){
   			$("#routType").attr("disabled","disabled");   			
   		}else{
   			$("#routType").removeAttr("disabled");
   		}

   		if(param.setupInfo.routCd != ''){
   			$("#routCd").attr("disabled","disabled");   			
   		}else{
   			$("#routCd").removeAttr("disabled");
   		}
   		
   		ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   		
    },
    BARCODE_SEARCH: function (caller, act, data) {    	
    	var barcode = data;    	
    	ppmboot
        .call({
            type: "GET",
            url: ["/api/v1/pop2/getWorkOrderList"],
            data: {orderSt:"ORDER",barcode:barcode},
            callback: function (res) {
            	if(res.length > 0){
                    caller.gridView01.setData(res);
            	}else{

                    axDialog.alert({
                        theme: "danger",
                        width:500,
                        msg: "사용할 수 없는 바코드입니다.관리자에게 문의하세요."
                    }, function () {
                    	if(this.key == "ok")
                    	{
    	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });        
                	return false;
            	}
            }    
        })
       .done(function () {
    	    $("#barcode").val("");
       });  
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

fnObj.pageStart = function () {
    var _this = this;
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
        param = parent.ppmboot.modal.getData();
        
        

        $("#routType").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,{routType:$(this).val(),routCd:""});
        }); 
        
        $("#routCd").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        }); 
        
        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
       	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,param.setupInfo);       
       	

       	/*
    	$('#barcode').focus();
    	$('#barcode').click();
    	

        $('#barcode').blur(function(){ 
        	$('#barcode').focus();
        	$('#barcode').click();
        });
        */
    });
};





fnObj.pageResize = function () {

};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});

//== view 시작
/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
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
            sortable: true, 
            multiSort: false,
            showRowSelector: false, 
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "orderDt",width:100},
                {key: "orderNo",width:120},
				{key:"routCd", label: "공정",width:120, align: "center",formatter: function formatter() {
		    					return CONVERT_CODE["ROUT_CD"].map[this.value];
					}
				},	
                {key: "itemCd",width:150},
                {key: "itemNm",width:220},
                {key: "spec",width:150,label:"규격", align: "center"},
                {key: "orderQty"},       
                {key: "equipNm", label:"설비", width:180},     
                /*
                {key: "orderSt", width: 90, label: "상태", align: "center", formatter: function formatter() { 
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
                }},*/
                {key: "sort",label:"우선순위",width:80},       
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
        
    }
});

function onKeyDown() { 

    if(event.keyCode == 13)
    {
    	return send(); 
    }
} 


function send() { 
	var barcode = $("#barcode").val();
	barcode = barcode.replace("ㅠ","B").toUpperCase();
	$("#barcode").val(barcode);
	
	if(nvl(barcode,'')!=''){
	    ACTIONS.dispatch(ACTIONS.BARCODE_SEARCH,barcode);	
	}else{
		$("#barcode").val("");
	}
}
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
var whType = "20";

//모달 재정의 Start
var customModal = new ax5.ui.modal({
	absolute: true,
	onStateChanged: function onStateChanged() {
	    if (this.state === "open") {
	        window.axMask.open();
	    } else if (this.state === "close") {
	        window.axMask.close();
	    }  
	}
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_CLOSE: function (caller, act, data) {
        window.open('about:blank','_self').self.close();  // IE에서 묻지 않고 창 닫기
	},  
	/*
    PAGE_SEARCH: function (caller, act, data) {  
        ppmboot.ajax({
            type: "GET",
            url: ["/api/v1/stock/stockBarcodeSearch"],
            data: {barcode:""},
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    */
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
   		
   		//ACTIONS.dispatch(ACTIONS.BARCODE_SEARCH);   		
    },
    
    CUST_ONE_MODAL_OPEN: function (caller, act, data) {
    	
    	//var list = caller.gridView01.getData("selected");
    	var list2 = caller.gridView01.getData();
    	
    	if (list2.length > 0 ){

		//var idx = list[0].__index;
	    	var cnt = list2.length;
	    	
	    	customModal.open({
	            width: 1200,
	            height: 700,
	            iframe: {
	                method: "get",
	                url: "/jsp/pop/modal/POP-CUST-ONE-M.jsp", 
	                param: "callBack=customCustModalCallback&idx="+cnt
	            }
	        });
    	}
    	else{
    		axDialog.alert({
                theme: "primary",
                width:500,
                msg: "바코드 입력해주세요."
    		},function () {
                	if(this.key == "ok")
                	{
                		$('#barcode').focus();
                    }
          
            });        
        	return false;
    		
    	}
    	
    },   
    
    OUT_ITEM: function (caller, act, data) {  
        var list = caller.gridView01.getData();
        
        var barcodeChk = 0;           
        var custChk = 0;
        var dupbarcodeChk = 0;
        var dupbarcodeNm ='';
        var outYN;    
        
        
        if (list.length == 0){
           barcodeChk++;
        }
        
        list.forEach(function (n) {
           if (n.custCd === ""){
              custChk++;
           }
         });
        
        for (i=0; i<list.length-1; i++){
           var a = list[i].barcode;
            for(j=i+1; j<list.length; j++ ){
               var b = list[j].barcode
               if (a===b){    
                  dupbarcodeNm=list[j].barcode;
                  dupbarcodeChk++; 
               }
            }
  
        }
               if(barcodeChk > 0){
                   axDialog.alert({
                        theme: "primary",
                        msg: "출고대상이 없습니다."
                    });
                   return false;
                }else if(custChk > 0){
                   axDialog.alert({
                        theme: "primary",
                        msg: "거래처를 입력해주세요."
                    });
                   return false;
                }else if(dupbarcodeChk > 0){
                   axDialog.alert({
                        theme: "primary",
                        msg: "중복된 바코드  "+"{ "+dupbarcodeNm+"   }"+" 가 있습니다."
                    });
                   return false;
                }
        
        axDialog.confirm({
             theme: "danger",
             width:500,
             msg: "출고 하시겠습니까?"
         }, function () {
            if(this.key == "ok")
            {
                 //ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            var mData = caller.gridView01.getData();
            var testData = [].concat(caller.gridView01.getData());  	
            var sData = [].concat(caller.gridView01.getData()); 
            
            /*
            for(i=0; i<mData.length; i++){
         	   
		               ppmboot.ajax({
		               	type: "PUT", 
		               	url: ["/api/v1/pop2/updateWorkEnd"], 
		               	data: JSON.stringify(mData[i]),
		                   callback: function (res) {   
		   	            	wlotNo = "";
		                       
		                   }
		               });
         	              	   
            }
            
            
            
            		
	               ppmboot.call({
	                   type: "PUT",
	                   url: ["stock","salesInItem"],
	                   data: JSON.stringify(testData),
	                    callback: function (res) {       
	                          $('#barcode').focus(); 
	                    }
	               })
	               .done(function () {
	                    //window.location.reload();
	                  $('#barcode').focus(); 
	               });   
	               
	               
*/
		               ppmboot.ajax({
			               	type: "PUT", 
			               	url: ["stock","stockOutItem"], 
			               	data: JSON.stringify(sData),
			                   callback: function (res) {   
			   	            	wlotNo = "";
			   	            	axDialog.confirm({
		                             msg:"출고 되었습니다.",
		                             btns:{
		                                ok:{
		                                   label:"확인", theme:'primary', onClick:function(key){
		                                      if(this.value.label == "확인"){
		                                            location.reload(true);
		                                         }
		                                   }
		                                }
		                             }
		                          });
			                       
			                   }
			               });
	               
	               
	             
	               /*
	               ppmboot.call({
	                   type: "PUT",
	                   url: ["stock","stockOutItem"],
	                   data: JSON.stringify(mData),
	                    callback: function (res) {       
	                          $('#barcode').focus(); 
	                          axDialog.confirm({
	                             msg:"출고 되었습니다.",
	                             btns:{
	                                ok:{
	                                   label:"확인", theme:'primary', onClick:function(key){
	                                      if(this.value.label == "확인"){
	                                            location.reload(true);
	                                         }
	                                   }
	                                }
	                             }
	                          });   
	                    }
	               })
	               .done(function () {
	                    //window.location.reload();
	                  $('#barcode').focus(); 
	               });
	               
	               
	               */
             }
         });      
     },   
    
    CUSTOM_DIALOG: function (caller, act, data) {

    },
    
    BARCODE_SEARCH: function (caller, act, data) {  
    	console.log(data);
    	var barcode = data;    	
    	
    	ppmboot
        .call({
            type: "GET",
            url: ["/api/v1/stock/stockBarcodeSearch"],
            data: {barcode:barcode},
            callback: function (res) {
            	if(res.list.length > 0){
                    //caller.gridView01.setData(res);
            		/*
            		if (res.list[0].wlotNoB == undefined){
            			res.list[0].wlotNo = res.list[0].wlotNoF;
            			
            		}
            		if (res.list[0].wlotNoF == undefined){
            			res.list[0].wlotNo = res.list[0].wlotNoB;
            			
            		}        
            		*/
            		if (res.list[0].stockCd === undefined){
                        axDialog.alert({
                            theme: "danger",
                            width:500,
                            msg: "사용할 수 없는 바코드입니다.관리자에게 문의하세요."
                        }, function () {
                        	if(this.key == "ok")
                        	{
        	                    //ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                            }
                        });        
                    	return false;
                	}
            		fnObj.gridView01.addRow(res);
            		dData = caller.gridView01.getData();

            	}else if (res.list[0].itemNm === ''){
                    axDialog.alert({
                        theme: "danger",
                        width:500,
                        msg: "사용할 수 없는 바코드입니다.관리자에게 문의하세요."
                    }, function () {
                    	if(this.key == "ok")
                    	{
    	                    //ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
    
    ROW_REMOVE: function (caller, act, data) {
        caller.gridView01.delRow("selected");
        $('#barcode').focus();
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

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();

        $('#barcode').focus();
       	/*
    	
    	$('#barcode').click();
    	

        $('#barcode').blur(function(){ 
        	$('#barcode').focus();
        	$('#barcode').click();
        });
        */
    //});
};





fnObj.pageResize = function () {

};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "search": function () {
               // ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "out-item": function () {
                //alert("출고");
            	ACTIONS.dispatch(ACTIONS.OUT_ITEM);
            },
            "close": function () {
            	//alert("닫기");
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "cust-modal": function () {
            	//alert("거래처");
                ACTIONS.dispatch(ACTIONS.CUST_ONE_MODAL_OPEN);
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
        //this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
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
            	
            	{key: "company",width:300, label:"회사",hidden:true},
            	{key: "outDt",width:300, label:"날짜",hidden:true},
            	{key: "itemCd",width:300, label:"품목코드",hidden:true},
            	{key: "etcYn",width:300, label:"예외입고",hidden:true},
            	{key: "whType",width:300, label:"창고타입",hidden:true},
            	{key: "stockCd",width:300, label:"재고코드",hidden:true},
            	{key: "orderSeq",width:300, label:"주문순서",hidden:true},
            	{key: "orderNo",width:300, label:"주문번호",hidden:true},
            	{key: "toWarehouse",width:300, label:"주문번호",hidden:true},
            	
                {key: "itemNm",width:300, label:"품목명"},
                {key: "whCd",width:120, label:"창고"},
                {key: "spec",width:120, label:"규격"},
                {key: "wlotNo",width:120, label:"LOT" ,hidden:true},
                {key: "barcode",width:120, label:"바코드"},
                {key: "itemQty",width:120,formatter:"number", label:"수량"},
                
                //{key: "itemQty",width:120,formatter:"number", label:"수량"},
                {key: "unit",width:120, label:"단위"},
                {key: "del", width:120, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>삭제</button>";
                }},
                {key: "custCd",width:120, label:"거래처코드",hidden:true},
                {key: "equipCd",width:120, label:"설비",hidden:true},
                {key: "custNm",width:120, label:"거래처"},
    
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "del") {
                    	//alert("삭제");
                    	ACTIONS.dispatch(ACTIONS.ROW_REMOVE);
                	}
                }
            },
            page: {
                display: false
            }
        });
        
    },
    addRow: function (data) {    	
    this.target.addRow({__created__: true,
    	itemCd:data.list[0].itemCd,
    	company:'1000',
    	outDt:getNowDt(),
    	etcYn:'N',
    	whType:'20', /***/
    	stockCd:data.list[0].stockCd,
    	itemQty:data.list[0].stockQty,
    	itemNm:data.list[0].itemNm,
    	whCd:data.list[0].whCd,
    	spec:data.list[0].spec,
    	/*
    	wlotNo:data.list[0].wlotNo,
    	orderNo:data.list[0].orderNo,
    	orderSeq:data.list[0].orderSeq,
    	*/
    	barcode:data.list[0].barcode,
    	toWarehouse:'S001',
    	custNm:'',
    	custCd:'',
    	unit:data.list[0].unit,}, "last");
    
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
	if(barcode!=''){
	    ACTIONS.dispatch(ACTIONS.BARCODE_SEARCH,barcode);	
	}else{
		$("#barcode").val("");
	}
}

function customCustModalCallback(data,param){
	
	var idx = param.idx;
	//alert("모달 콜백 : "+idx)
	//fnObj.gridView01.target.setValue(idx,"custCd", data.custCd);
	$("#custNm").val(data.custNm);
	for (i=0; i<idx; i++ ){
		fnObj.gridView01.target.setValue(i,"custCd", data.custCd);
		fnObj.gridView01.target.setValue(i,"custNm", data.custNm);
	}
	customModal.close();
    $('#barcode').focus();
}
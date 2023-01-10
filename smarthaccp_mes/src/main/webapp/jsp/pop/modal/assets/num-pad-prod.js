/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 크리에이티브
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 양품등록
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
    	
    	$("#calc_result").val("0");
    	
    	ppmboot
   	   	.call({
   	     	type: "GET",
   	        url: ["/api/v1/pop2/getWorkOrderList"],
            data: {wlotNo: param.wlotNo},
   	        callback: function (res) {
   	        	if(res.length > 0){
   	        		caller.gridView01.setData(res);
   	        		caller.gridView01.target.select(0);
   	        	}
   	        }
	   	 })  
   	   	.call({
   	     	type: "GET",
   	        url: ["worderList" ,"incomingList"],
            data: {wlotNo: param.wlotNo},
   	        callback: function (res) {
   	           caller.gridView02.setData(res);
   	        }
	   	 })  
        .done(function () {
        });   
    },
    IN_ITEM1: function (caller, act, data) {
    	
    	var mData = caller.gridView01.getData("selected");
        var num = mData[0].itemQty;
        var chk = false;	//바코드 분할 이력 존재시 true로  변경

        ppmboot
   	   	.call({
   	     	type: "GET",
   	        url: ["/api/v1/pop2/getDividedBarcodeCnt"],
            data: {barcode: mData[0].barcode},
   	        callback: function (res) {
   	        	if(res[0].cnt > 0 ){
   	        		chk = true;
   	        	}
   	        	debugger;
   	        }
   	   	})
   	   	.done(function(){
	   	   	if(chk){
		   	   	axDialog.alert({
		            theme: "primary",
		            width:500,
		            msg: "이미 분할된 바코드입니다."
		        });
		    	return false;
	   	   	}
	   	   	
	        if(nvl(num,0) == 0){
	        	axDialog.alert({
	                theme: "primary",
	                width:500,
	                msg: "실적 수량을 입력하세요."
	            });
	        	return false;
	        }else{
	        	//마이너스 실적인데 양품수량보다 많을경우
	        	if(num < 0 && nvl(mData[0].goodQty,0) < (Number(num) * -1)){
	            	axDialog.alert({
	                    theme: "primary",
	                    width:500,
	                    msg: "양품수량을 확인하세요."
	                });
	            	return false;
	        	}else{
	            	axDialog.confirm({
	                    theme: "danger",
	                    width:500,
	                    msg: "<font color=red>생산실적 ["+num+"] 등록 하시겠습니까?</font>"
	                }, function () {
	                	if(this.key == "ok")
	                	{            		
	                		var item = new Object();
	                		item.company = "1000";//mData[0].company;
	                		item.wlotNo = mData[0].wlotNo;
	                		item.stockCd = mData[0].stockCd;
	                		item.itemCd = mData[0].itemCd;
	                		item.itemQty = num;
	                		
	        	        	ppmboot.ajax({
	            	        	type: "PUT", 
	            	        	url: ["/api/v1/pop2/updateWorkProdQty"], 
	            		     	data: JSON.stringify(item),
	            		        callback: function (res) {       
	           		        	 	parent.ppmboot.modal.callback();
	            		        	
	            		        	 /** 메일발송 처리(안전재고 체크)
	            		        	  * frMail : 보내는 email(필수)
 	             		        		frName : 보내는 이름(필수),
 	             		        		toMail : 전송할 상대 email(필수),
 	             		        		subJect : 메일제목(필수),
 	             		        		(+ 추가적으로 전송에 필요한 데이터는 parameter로 setting)
 	 	             		        	ex) itemCd, stockCd .... 	
	            		        	  */
	            		        	 var url = "/api/v1/stock/chksafetyQtyandsendMail"; 
	            		        	 var itemchkparam = {
 	             		        		   frMail : "k003o85894o4@gmail.com",
 	             		        		   frName : "스마트해썹앤팩토리KHJ",
 	             		        		   toMail : "kdw92322@naver.com",
 	             		        		   subJect : "안전재고 메일발송 알림",
 	 	             		        	   itemCd : item.itemCd,
 	 	             		        	   stockCd : item.stockCd	   
 	             		        	 };
	            		        	 
 	             		        	 ppmboot.sendMail(url, itemchkparam, "");
 	             		        	 ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);	
	            		        }
	        	        	});
	                    }
	                });   
	        	}   
	        }
   	   	});
    },
    IN_ITEM2: function (caller, act, data) {
    	
    	var mData = caller.gridView01.getData("selected");
    	
        var prodQty = mData[0].prodQty;
        var orderQty = mData[0].orderQty;
        
        if(nvl(prodQty,0) > 0){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "이미 입력된 실적이 존재합니다."
            });
        	return false;
        }else{
            axDialog.confirm({
                theme: "danger",
                width:500,
                msg: "<font color=red>지시수량 ["+orderQty+"] 만큼 생산실적 등록 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{            		
            		var item = new Object();
            		item.company = "1000";
            		item.wlotNo = mData[0].wlotNo;
            		item.stockCd = mData[0].stockCd;
            		item.itemCd = mData[0].itemCd;
            		item.itemQty = orderQty;
            		
    	        	ppmboot.ajax({
        	        	type: "PUT", 
        	        	url: ["/api/v1/pop2/updateWorkProdQty"], 
        		     	data: JSON.stringify(item),
        		        callback: function (res) {       
       		        	 	parent.ppmboot.modal.callback();
        		        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        		        }
    	        	});
                }
            });
        }
    },
    
    DIVIDE_CHECK: function(caller, act, data){
    	debugger;
    },
  //실적등록취소
    CANCEL_ITEM: function (caller, act, data) {
        var mData = caller.gridView01.getData("selected");
        var chk = false; //바코드 분할 이력 조재시 true로 변경
        debugger;
        ppmboot
        .call({
            type: "GET",
               url: ["/api/v1/pop2/getDividedBarcodeCnt"],
            data: {barcode: mData[0].barcode},
               callback: function (res) {
                   if(res[0].cnt > 0 ){
                       chk = true;
                   }
               }
        })
        .done(function(){
            if(chk){
                      axDialog.alert({
                    theme: "primary",
                    width:500,
                    msg: "이미 분할된 바코드입니다."
                });
                return false;
            }
                if(nvl(data.itemQty,0) > nvl(mData[0].barcodeQty,0)){
                    axDialog.alert({
                        theme: "primary",
                        width:500,
                        msg: "바코드 발행수량이 실적취소 수량보다 많습니다."
                    });
                    return false;
                }else{
                    axDialog.confirm({
                        theme: "danger",
                        width:500,
                        msg: "<font color=red>생산실적 취소 하시겠습니까?</font>"
                    }, function () {
                        if(this.key == "ok")
                        {
                            ppmboot.ajax({
                                type: "PUT",
                                url: ["/api/v1/pop2/cancelWorkProdQty"],
                                 data: JSON.stringify(data),
                                callback: function (res) {      
                                        parent.ppmboot.modal.callback();
                                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                            }
                        });
                    }
                });
            }
        })
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
    param = parent.ppmboot.modal.getData();      

    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
    document.body.onkeydown = function(e){
    	key_detect_calc('calc',e);
    };
};

fnObj.pageResize = function () {

}; 

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "choice1": function () {
                ACTIONS.dispatch(ACTIONS.IN_ITEM1);
            },
            "choice2": function () {
                ACTIONS.dispatch(ACTIONS.IN_ITEM2);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
            showLineNumber: false,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            columns: [
              {key: "itemNm",width:300},
              //{key: "partNo",width:120,label:"P/N", align: "center"},
              {key: "spec",width:140,label:"규격", align: "center"},
                  {key: "unit",width:140},
                  {key: "orderQty",width:110},
                  {key: "prodQty",width:110},
                  {key: "badQty",width:110},
                  {key: "goodQty",width:110},
                {key: "itemQty", label: "추가실적", width: 260, formatter:"number", align: "right",formatter:function(){
                	return "<font size = 6>"+nvl(this.value,0)+"</font>";
                }},
            ],
            body: {
                columnHeight: 60,
            },
            page: {
                display: false
            }
        });        
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    setCalcResult:function(data){
    	fnObj.gridView01.target.setValue(0,"itemQty", data.itemQty);
    	fnObj.gridView01.target.select(0);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    }
});


/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            header: {
                columnHeight: 27
            },
            scroller: {size: 35},
            columns: [
                {
                	key: "lotNo",width:140, columns: [ 
                		{key: "barcode",width:140},
                    ]
                },
                {key: "itemQty",width: 160},
                {key: "unit"},
                {key: "cancelItem", label:"실적취소",width: 185, align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>실적취소</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    //실적취소
                    if(this.column.key == "cancelItem") {  
                		ACTIONS.dispatch(ACTIONS.CANCEL_ITEM, this.item);
                    }
                }
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    }
});

function add_calc(v)
{
	var r = nvl($("#calc_result").val(),"0");
	
	if(v == "C"){
		$("#calc_result").val(0);
	}else if (v == "nbs"){
		r = r.substr(0, r.length -1);     
		$("#calc_result").val(r);
	}else{
		//이미 소수점이 들어갔으면.
		if(r!=0 && v == "." && r.indexOf(v) != -1){
			return false;
		}
		
		if(r == '0'){
			if(v == "."){
				$("#calc_result").val(r+v);
			}else{
				$("#calc_result").val(v);
			}
			
		}else{
			$("#calc_result").val(r+v);
		}
	}
	
	setCalcResult($("#calc_result").val());
	return true;
}


function key_detect_calc(id,evt)
{
	if((evt.keyCode>95) && (evt.keyCode<106))
	{
	    var nbr = evt.keyCode-96;
	    add_calc(nbr);
	}
	else if((evt.keyCode>47) && (evt.keyCode<58))
	{
	    var nbr = evt.keyCode-48;
	    add_calc(nbr);
	}else if(evt.keyCode==110)
	{
		add_calc('.');
	}
	else if(evt.keyCode==190)
	{
		add_calc('.');
	}
	else if(evt.keyCode==188)
	{
		add_calc('.');
	}
	else if(evt.keyCode==46)
	{
		add_calc('C');
	}
	else if(evt.keyCode==8)
	{
		add_calc('nbs');
	}
	else if(evt.keyCode==27)
	{
		add_calc('C');
	}
	return true;
}


function setCalcResult(v){
	fnObj.gridView01.setCalcResult({itemQty:v});
}

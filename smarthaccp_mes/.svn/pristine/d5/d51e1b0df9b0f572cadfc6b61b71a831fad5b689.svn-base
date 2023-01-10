/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 자재투입팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

var bomType = "Y"; //양품대비
var discardYn = "N"; // 투입/폐기
var whType = "";		//생산창고

//모달 재정의 Start
var customModal = new ax5.ui.modal({
absolute: true,
onStateChanged: function onStateChanged() {
    // mask
    if (this.state === "open") {
        window.axMask.open();
    } else if (this.state === "close") {
        window.axMask.close();
    }  
	}
});


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
    	ppmboot
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getStockBomList"],
	            data: {wlotNo: param.order.wlotNo,routCd: param.order.routCd,routSeq: param.order.routSeq},
	            callback: function (res) {
	            	if(res.length > 0){
		     		   	res.forEach(function (n) {   
		     		   		n = changeBomQty(n);
			       		});     
		                caller.gridView01.setData(res);
	 		            caller.gridView01.target.select(0);
	            	}else{
	            		//if(param.order.routCd != passRoutCode){
		                	axDialog.alert({
		                        theme: "danger",
		                        width:500,
		                        msg: "<font color=red>등록된 BOM이 없습니다.</font>"
		                    }, function () {
		                    	if(this.key == "ok")
		                    	{
		    	                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
		                        }
		                    });  
	                    //}
	                }
	            }    
	        })
		    .done(function () {
	    	    $("#barcode").val("");
	             ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
	    	    
		    });   
	        return false;
    },    
    BARCODE_SEARCH: function (caller, act, data) {    	
    	var barcode = data;    	
    	ppmboot
	        .call({
	            type: "GET",
		  	    url: ["stock","stockGroupByAll"],
	   	        data: {groupByType:"barcode",whType:whType,barcode:barcode,zeroStock:"N"},
	            callback: function (res) {
	            	var res2 = res;
	                if(res2.list.length > 0){
	                	ppmboot
	        	        .call({
	        	            type: "GET",
	        	            url:  ["/api/v1/pop2/getStockBomList"],
	        	            data: {wlotNo: param.order.wlotNo,routCd: param.order.routCd,routSeq: param.order.routSeq,itemCd:res2.list[0].itemCd},
	        	            callback: function (res) {
	        	            	if(res.length > 0){

	        		     		   	res.forEach(function (n) {   
	        		     		   		n = changeBomQty(n);
	        			       		});     
	        		     		   	
		        	            	caller.gridView01.setData(res);
		        	                caller.gridView02.setData(res2);
				 	        	    caller.gridView01.target.select(0);
				 	        	    caller.gridView02.target.select(0);
				 	        	    
	        	            	}else{

		        	                caller.gridView02.setData(res2);
				 	        	    caller.gridView02.target.select(0);
				 	        	    
	        	            		if(param.order.routType == "C"){
			        	                caller.gridView02.setData(res2);
					 	        	    caller.gridView02.target.select(0);
	        	            		}else{
	        	            			axDialog.alert({
		        	                        theme: "danger",
		        	                        width:500,
		        	                        msg: "등록되지 않은 자재바코드입니다.관리자에게 문의하세요."
		        	                    }, function () {
		        	                    	if(this.key == "ok")
		        	                    	{
		        	    	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
		        	                        }
		        	                    });        
		        	                    
		        	                	return false;
	        	            		}
	        	            	}
	        	            }    
	        	        })
	        	       .done(function () {
	        	       });
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
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	
    	var routCd = "";
    	var data = caller.gridView01.getData("selected");
    	
    	//로뜨투입인 자재일 경우에는 공정코드 조건 추가
    	if(data[0].wipYn== "Y"){
    		routCd = data[0].routCd;
    	}
    	
    	if(data.length > 0){
        	ppmboot
    	        .call({
    	            type: "GET",
    		  	    url: ["stock","stockGroupByAll"],
    	   	        data: {groupByType:"barcode",whType:whType,itemCd:data[0].itemCd,zeroStock:"N",prdUseYn:"N",routCd:routCd},
    	            callback: function (res) {
    	                caller.gridView02.setData(res);    	                
    	                if(res.length > 0){
    	 		            caller.gridView02.target.select(0);
    	                }
    	                
    	            }    
    	        })
    	       .done(function () {
    	            ACTIONS.dispatch(ACTIONS.OUTGOING_LIST);
    	       });  
    	}else{
            ACTIONS.dispatch(ACTIONS.OUTGOING_LIST);
    	}
    },    
    OUTGOING_LIST: function (caller, act, data) {  
    	ppmboot
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getOutgoingList"],
	            data: {wlotNo: param.order.wlotNo,discardYn : discardYn},
	            callback: function (res) {
	                caller.gridView03.setData(res);
	                if(res.length > 0){
	 		            caller.gridView03.target.select(0);
	                }
	            }    
	        })
	       .done(function () {
	       		
	       });  
    },
    NUMBER_PAD_MODAL: function (caller, act, data) {  

    	var mData = caller.gridView01.getData("selected");
    	var pData = caller.gridView02.getData("selected");

    	if(nvl(mData[0].autoFifoYn,'N') == "Y"){
            axDialog.alert({
                theme: "danger",
                width:500,
                msg: "자동선출 자재는 투입 할 수 없습니다."
            }, function () {
            });        
        	return false;
    	}
    	
    	if(mData.length > 0){
    		pData[0].totalQty = mData[0].totalQty;
    	}
    	    	
    	ppmboot.modal2.open({  
            modalType: "POP-NUM-PAD-OUT",
            param: "",
            sendData: function(){
            	return { 
                    "obj" : data,
                    "pData" : pData[0]
                };
            },
            callback: function (data) {
            	this.close();
                ACTIONS.dispatch(ACTIONS.OUTGOING_ITEM,data);
            }
        });
    	
    },
    //자재투입
    OUTGOING_ITEM: function (caller, act, data) {  
		var item = data.item;
		
		item.bomItemQty = data.num;
		item.bomUnit = data.unit;
		item.wlotNo = param.order.wlotNo;
		
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 자재를 ("+item.bomItemQty +" "+item.bomUnit+") 투입 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var obj = {
	            	workMaster: param.order,
	            	workOutgoingItem: item,
	            };
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/saveOutgoing"], 
    		     	data: JSON.stringify(obj),
    		         callback: function (res) {       
    		        	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
    		         }
	        	});
            }
        });        
    },  
    DISCARD_MODAL: function (caller, act, data) {  

    	var mData = caller.gridView01.getData("selected");
    	var pData = caller.gridView02.getData("selected");

    	if(mData.length > 0){
    		pData[0].totalQty = mData[0].totalQty;
    	}
    	    	
    	ppmboot.modal2.open({  
            modalType: "POP-DISCARD",
            param: "",
            sendData: function(){
            	return { 
                    "order" : param.order,
                    "item" : pData[0]
                };
            },
            callback: function (data) {
            	this.close();
            }
        });
    	
    },
    //자재투입-오더소요량
    ORDER_OUTGOING_ITEM: function (caller, act, data) {  
    	
    	var mData = caller.gridView01.getData("selected");
    	var pData = caller.gridView02.getData("selected");
    	
    	if(nvl(mData[0].autoFifoYn,'N') == "Y"){
            axDialog.alert({
                theme: "danger",
                width:500,
                msg: "자동선출 자재는 투입 할 수 없습니다."
            }, function () {
            });        
        	return false;
    	}

    	var outYn = "Y";
    	var item = pData[0];
		item.itemQty = mData[0].totalQty;
		
		if(data.outType == "ORDER"){			
			if(item.transStockQty < mData[0].totalQty){
				item.bomItemQty = item.transStockQty;
			}else{
				item.bomItemQty = mData[0].totalQty;			//오더대비
			}
		}else{
			if(item.transStockQty < mData[0].goodTotalQty){
				item.bomItemQty = item.transStockQty;
			}else{
				item.bomItemQty = mData[0].goodTotalQty;		//양품대비
			}
		}
		
		item.wlotNo = param.order.wlotNo;
		
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 자재를 ("+item.bomItemQty +" "+item.bomUnit+") 투입 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var obj = {
	            	workMaster: param.order,
	            	workOutgoingItem: item,
	            };
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/saveOutgoing"], 
    		     	data: JSON.stringify(obj),
    		         callback: function (res) {       
    		        	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
    		         }
	        	});
            }
        });        
    },  
    //전체환입
    CANCEL_ITEM: function (caller, act, data) {  

        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 자재를 '전체' 환입처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data;
        		item.__deleted__ = true;
        		
        		var obj = {
	            	workMaster: param.order,
	            	workOutgoingItem: item,
	            };
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/cancelOutgoing"], 
    		     	data: JSON.stringify(obj),
    		         callback: function (res) {       
    		        	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
    		         }
	        	});	     
            }
        });        
    },  
    //부분환입 PAD
    RETURN_ITEM_PAD: function (caller, act, data) {  
    	
    	var pData = caller.gridView03.getData("selected");
    	
        ppmboot.modal2.open({  
            modalType: "POP-NUM-PAD-OUT-RETURN",
            param: "",
            sendData: function(){
            	return { 
                    "obj" : data,
                    "pData" : pData[0]
                };
            },
            callback: function (data) {
            	this.close();
                ACTIONS.dispatch(ACTIONS.RETURN_ITEM,data);
            }
        });
    },  
    //부분환입
    RETURN_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 자재를 '부분' 환입처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data.item;
        		
        		item.bomItemQty = data.num;
        		
        		var obj = {
	            	workMaster: param.order,
	            	workOutgoingItem: item,
	            };
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/updateOutgoing"], 
    		     	data: JSON.stringify(obj),
    		         callback: function (res) {       
    		        	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
    		         }
	        	});  
            }
        });        
    },  
    SEARCH_ITEM: function (caller, act, data) {
    	customModal.open({
            width: 1300,
            height: 850,
            iframe: {
                method: "get",
                url: "/jsp/pop/modal/stock-modal.jsp", 
                param: "callBack=customItemSelelctModalCallback"
            }
        });    
    },    
    //자재검색
    CHANGE_BOM_TYPE: function (caller, act, data) {
    	var list = caller.gridView01.getData();
    	list.forEach(function (n) {   
			n = changeBomQty(n);
   		});     
    	caller.gridView01.setData(list);
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
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();

    param = parent.ppmboot.modal.getData();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
	$('#barcode').focus();
	$('#barcode').click();	

    $('#barcode').blur(function(){ 
    	$('#barcode').focus();
    	$('#barcode').click();
    });

	$("input[name=bomType]").change(function() {
		bomType = $(this).val();
		ACTIONS.dispatch(ACTIONS.CHANGE_BOM_TYPE);
	});

	$("input[name=discardYn]").change(function() {
		discardYn = $(this).val();
		ACTIONS.dispatch(ACTIONS.OUTGOING_LIST);
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
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "search-item": function () {
                ACTIONS.dispatch(ACTIONS.SEARCH_ITEM);
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 25
            },
            scroller: {size: 25},
            columns: [
                {key: "itemCd",width:150},
                {key: "itemNm",width:230},
                {key: "routCd",width:110},
                {key: "autoFifoYn", label: "자동선출",align:"center", width:70},  
            	{
                    label: "BOM", columns: [
                        {key: "calcBomQty",label:"소요량",width:120 ,formatter:function(){
                        	return "<font size=5>"+ax5.util.number(this.value)+"</font>";
                        }, align: "right"},  

                        {key: "calcLossQty",label:"LOSS",width:110 ,formatter:function(){
                        	return "<font size=5>"+ax5.util.number(this.value)+"</font>";
                        }, align: "right"},  
                        {key: "totalQty",label:"오더대비소요량",width:110 ,formatter:function(){
                        	return "<font color=#007ff8 size=5>"+ax5.util.number(this.value)+"</font>";
                        }, align: "right"},  
                        {key: "goodTotalQty",label:"양품대비소요량",width:110 ,formatter:function(){
                        	return "<font color=#007ff8 size=5>"+ax5.util.number(this.value)+"</font>";
                        }, align: "right"},  
                        {key: "bomUnit",label:"소요단위",width:110, align: "center"},
                    ]
                },			
                {key: "unit",width:130},
            ],
            body: {
                columnHeight: 45,
                onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
                }
            },
            page: {
                display: false
            },
            trStyleClass: function(){
            	if(nvl(this.item.wipYn,'N')=='Y'){
            		return "grid-cell-important1";
            	}
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
                columnHeight: 25
            },
            scroller: {size: 20},
            columns: [
                //{key: "itemCd",width:120},
                {key: "itemNm",width:220},
                //{key: "routCd",width:120},
                //{key: "bomTrans", label: "소요단위수량", width: 90, formatter:"number", align: "right"},
            	{
                    label: "재고", columns: [
                        {key: "whCd", width: 100},
                        {key: "lotNo", width: 120},
                        {key: "barcode", width: 120},
                        //{key: "lotNo", width: 120},
                        //{key: "barcode", width: 120},
                        /*
                        {
                        	key: "transStockQty",width:120, label: "현재고", width: 120, formatter:"number", align: "right", columns: [ 
                        		{key: "bomUnit",label:"소요단위",width:120, align: "center"},
                            ]
                        },
                        */
                        {key: "transStockQty", label: "현재고", width: 120, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:120, align: "center"},
                       // {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                       // {key: "unit", width: 100},
                    ]
                },			
                {key: "outStock", label:"자재투입", width:100, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>투입</button>";
                }},  	
                {key: "orderOutStock", label:"오더소요량", width:100, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-info2 W70'>투입</button>";
                }},  
                {key: "goodOutStock", label:"양품소요량", width:100, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-info2 W70'>투입</button>";
                }},  
                {key: "discardOutStock", label:"자재폐기", width:100, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-danger W70'>폐기</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    
                    if(this.column.key == "outStock") {                      	
                        ACTIONS.dispatch(ACTIONS.NUMBER_PAD_MODAL,this.item);
                    }
                    
                    if(this.column.key == "orderOutStock") {  
                    	this.item.outType = "ORDER";
                        ACTIONS.dispatch(ACTIONS.ORDER_OUTGOING_ITEM,this.item);
                    }
                    
                    if(this.column.key == "goodOutStock") {  
                    	this.item.outType = "GOOD";
                        ACTIONS.dispatch(ACTIONS.ORDER_OUTGOING_ITEM,this.item);
                    }
                    
                    if(this.column.key == "discardOutStock") {  
                        ACTIONS.dispatch(ACTIONS.DISCARD_MODAL,this.item);
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

/**
 * gridView03
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-03"]'),
            header: {
                columnHeight: 27
            },
            scroller: {size: 35},
            columns: [
                {key: "itemNm",width:200},
            	{
                    label: "불출(소요단위)", columns: [
                        {key: "lotNo", width: 120},
                        {key: "barcode", width: 120},
                        {key: "bomItemQty", label: "투입수량", width: 120, formatter:"number", align: "right"},
                        //{key: "transConsumQty", label: "예상소모수량", width: 120, formatter:"number", align: "right"},
                        //{key: "transRemainQty", label: "예상남은수량", width: 120, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                    ]
                },	
                {key: "cancelStock", label:"전체환입", align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>전체환입</button>";
                }},  
                {key: "returnStock", label:"부분환입", align:"center", formatter:function(){
                	return "<button type='button' style='background-color:orangedark' class='btn btn-success W70'>부분환입</button>";
                }},  
                /*
            	{
                    label: "불출(수불단위)", columns: [
                        //{key: "whCd"},
                        {key: "itemQty", label: "투입수량", width: 90, formatter:"number", align: "right"},
                        {key: "remainQty", label: "예상남은수량", width: 90, formatter:"number", align: "right"},
                        {key: "unit", width: 80},
                        {key: "cancelStock", label:"전체환입", align:"center", formatter:function(){
                        	return "<button type='button' style='background-color:red' class='btn btn-success W70'>전체환입</button>";
                        }},  
                        {key: "returnStock", label:"부분환입", align:"center", formatter:function(){
                        	return "<button type='button' style='background-color:orangedark' class='btn btn-success W70'>부분환입</button>";
                        }},  
                    ]
                },		*/	
                
                
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "cancelStock") {  
                        ACTIONS.dispatch(ACTIONS.CANCEL_ITEM, this.item);
                    }
                    if(this.column.key == "returnStock") {  
                        ACTIONS.dispatch(ACTIONS.RETURN_ITEM_PAD, this.item);
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

function changeBomQty(n) { 

    n.goodTotalQty = calcResultCheck((Number(n.bomQty) + Number(n.lossQty)) * Number(param.order.goodQty));
	n.totalQty = calcResultCheck((Number(n.bomQty) + Number(n.lossQty)) * Number(param.order.orderQty));

	if(bomType == "Y"){
   		n.calcBomQty = calcResultCheck(Number(n.bomQty) * Number(param.order.goodQty));
   		n.calcLossQty = calcResultCheck(Number(n.lossQty) * Number(param.order.goodQty));
	}else{
   		n.calcBomQty = calcResultCheck(Number(n.bomQty) * Number(param.order.orderQty));
   		n.calcLossQty = calcResultCheck(Number(n.lossQty) * Number(param.order.orderQty));
	}
	return n;
}

function customItemSelelctModalCallback(data){
	$("#barcode").val(data.barcode);
	send();
	customModal.close();
}
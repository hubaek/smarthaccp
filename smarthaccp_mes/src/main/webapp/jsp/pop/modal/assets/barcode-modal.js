/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 바코드발행
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

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
				 url: ["/api/v1/pop2/getWorkOrderList"],
				 data: {wlotNo : param.order.wlotNo},
		         callback: function (res) {
		            caller.gridView01.setData(res);
   	        		caller.gridView01.target.select(0);
		         }
		    })  
			.call({
		     	type: "GET",
				 url: ["stock","stockBox"],
				 data: {company : param.order.company , wlotNo : param.order.wlotNo, boxYn:"N"},
		         callback: function (res) {
		            caller.gridView02.setData(res);
		         }
		    })  
			.call({
		     	type: "GET",
				 url: ["stock","stockBox"],
				 data: {company : param.order.company , wlotNo : param.order.wlotNo, boxYn:"Y"},
		         callback: function (res) {
		            //caller.gridView03.setData(res);
		         }
		    })  
	        .done(function () {
	        	var refBarcode = caller.gridView01.getData("selected")[0].barcode;
	        	/*ppmboot.call({
			     	type: "GET",
					 url: ["stock","stockBox"],
					 data: {company : param.order.company , wlotNo : param.order.wlotNo, boxYn:"N", refBarcode: "B20110800"},
			         callback: function (res) {
			            caller.gridView02.setData(res);
			         }
			    })*/
	        	ppmboot.ajax({
    	        	type: "GET", 
   				 	url: ["stock","stockBox"],
    		     	data: {company : param.order.company , wlotNo : param.order.wlotNo, boxYn:"N", refBarcode: refBarcode},
    		         callback: function (res) {
    		        	 caller.gridView02.setData(res);
    		         }
	        	});
	        });   
	
    	return false;
    }, 
    DIVISION_BARCODE_PAD: function (caller, act, data) {  

	    var layout$ = $('[data-ax5layout="tab1"]');
        layout$.ax5layout("tabOpen", 0);
        
    	var mData = caller.gridView01.getData("selected")

    	if(nvl(mData[0].barcodeQty,0) == 0){
            axDialog.alert({
                theme: "danger",
                width:500,
                msg: "발행가능한 수량이 없습니다."
            });        
        	return false;
    	}else{
        	ppmboot.modal2.open({  
                modalType: "POP-NUM-PAD-BARCODE",
                param: "",
                sendData: function(){
                	return {
                        "company" : mData[0].company,
                        "wlotNo" : mData[0].wlotNo,
                        "stockQty" : mData[0].barcodeQty,
                        "stockCd" : mData[0].stockCd,
                        
                    };
                },
                callback: function (data) {
                	this.close();
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });
    	}
    },
    DIVISION_BOX_PAD: function (caller, act, data) {  

	    var layout$ = $('[data-ax5layout="tab1"]');
        layout$.ax5layout("tabOpen", 1);
        
    	var mData = caller.gridView01.getData("selected")
    	
    	ppmboot.modal2.open({  
            modalType: "POP-NUM-PAD-BOX",
            param: "",
            sendData: function(){
            	return {
                    "company" : mData[0].company,
                    "wlotNo" : mData[0].wlotNo
                };
            },
            callback: function (data) {
            	this.close();
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },

    PRINT_BARCODE: function (caller, act, data) {    
    	
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>인쇄 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		data.printCnt = 1;
        		sendBarcodeList(data);
            }
        });   
    },
    PRINT_BARCODE_ALL: function (caller, act, data) {       
    	var list;
    	
    	if(data=="BARCODE"){
        	list = caller.gridView02.getData();    	
    	}else{
        	//list = caller.gridView03.getData();    	
    	}
    	
    	if(list.length > 0){
        	axDialog.confirm({
                theme: "danger",
                width:500,
                msg: "<font color=red>전체인쇄 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{
            		list.forEach(function (n) {
            			n.printCnt = 1;
                    });   
            		
            		sendBarcodeList(list);
                }
            });   
    	}else{
    		axDialog.alert({
                theme: "danger",
                width:500,
                msg: "인쇄가능한 바코드가 없습니다."
            });        
        	return false;
    	}
    },
    CANCEL_BARCODE: function (caller, act, data) {  
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>발행취소 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data;
        		item.itemQty = item.stockQty;
        		item.__deleted__ = true;
        		
        		var barcodeList = new Array();
        		barcodeList.push(item);
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
   				 	url: ["stock","stockBox"],
    		     	data: JSON.stringify(barcodeList),
    		         callback: function (res) {       
    	            	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    		         }
	        	});
            }
        });    
    },    
    CANCEL_BARCODE_ALL: function (caller, act, data) {   
    	  
    	var list;
    	
    	if(data=="BARCODE"){
        	list = caller.gridView02.getData();    	
    	}else{
        	//list = caller.gridView03.getData();    	
    	}
    	
    	if(list.length > 0){
        	axDialog.confirm({
                theme: "danger",
                width:500,
                msg: "<font color=red>전체 발행취소 하시겠습니까?</font>"
            }, function () {
            	
    			// 2020-10-12 cju
            	for (i=0; i<list.length; i++){
            		if(list[i].stockQty == 0){
                		axDialog.alert({
                            theme: "danger",
                            width:500,
                            msg: "이미 출고된 품목이 있습니다."
                        });
                		return false;
            		}
            		
            	}		
            	if(this.key == "ok")
            	{

            		list.forEach(function (n) {   
            			n.__deleted__ = true;
            			n.itemQty = n.stockQty;
    	       		});
            		          		
            		ppmboot.ajax({
        	        	type: "PUT", 
       				 	url: ["stock","stockBox"],
        		     	data: JSON.stringify(list),
        		         callback: function (res) {       
        	            	 parent.ppmboot.modal.callback();
        		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        		         }
    	        	});
    	        	
                }
            });   
    	}else{
    		axDialog.alert({
                theme: "danger",
                width:500,
                msg: "취소가능한 바코드가 없습니다."
            });        
        	return false;
    	}
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
    //_this.gridView03.initView();

    param = parent.ppmboot.modal.getData();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "itemNm",width:220},
                //{key: "partNo",width:120,label:"P/N", align: "center"},
                {key: "orderQty",width:100},
                {key: "prodQty",width:100},
                {key: "badQty",width:100},
                {key: "goodQty",width:100},
                {key: "barcodeQty",label:"발행가능",width:100},
                {key: "barcode",width:120},
                {key: "printBarcode", label:"바코드인쇄",width:120, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>인쇄</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "printBarcode") {  
                    	this.item.stockQty = this.item.barcodeQty;
                        ACTIONS.dispatch(ACTIONS.PRINT_BARCODE,this.item);
                    }
                }
            },
            page: {
                display: false
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
       	 	"out-item": function () {
                ACTIONS.dispatch(ACTIONS.BAD_ITEM);
            },
       	 	"divide-barcode": function () {
                ACTIONS.dispatch(ACTIONS.DIVISION_BARCODE_PAD);
            },
       	 	"divide-box": function () {
                ACTIONS.dispatch(ACTIONS.DIVISION_BOX_PAD);
            },
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
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
            	{key: "itemCd",width:120},
                {key: "itemNm",width:220},
                {key: "barcode",width:120},
                {key: "itemQty",label:"수량",width:100},
                {key: "stockQty",label:"재고",width:100},
                {key: "printBarcode", label:"바코드인쇄",width:150, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>인쇄</button>";
                }},  
                {key: "cancelBarcode", label:"발행취소",width:150, align:"center", hidden:true,formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>취소</button>";
                }},
                {key: "inoutType", label: "출고여부",width:120, formatter:function(){
                	if(this.item.inoutType == 'USE'){
                		return "O";
                	}else
                		return "X";
                }},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                	var _item = this.item;
                    this.self.select(this.dindex);
                    if(this.column.key == "printBarcode") {  
                        ACTIONS.dispatch(ACTIONS.PRINT_BARCODE,this.item);
                    }
                    if(this.column.key == "cancelBarcode") {
                    	var outYN = false;
                    	ppmboot
            			.call({
            		     	type: "GET",
            				 url: ["/api/v1/stock/outYNSearch"],
            				 data: {barcode : this.item.barcode},
            		         callback: function (res) {
            		            if(res.list.length>0){
            		            	outYN = true;
            		            }
            		         }
            		    })   
            	        .done(function () {
            	        	if(outYN){
            	        		axDialog.alert({
                                    theme: "danger",
                                    width:500,
                                    msg: "이미 출고 완료된 품목입니다. "
            	        		}); 
                        	}else{
                        		ACTIONS.dispatch(ACTIONS.CANCEL_BARCODE,_item);
                            	return false;
                        	}
            	        });   
                    }
                }
            },
            page: {
                display: false
            }
        });       
        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
       	 	"all-print": function () {
                ACTIONS.dispatch(ACTIONS.PRINT_BARCODE_ALL,"BARCODE");
            },
            "all-print-cancel": function () {
                ACTIONS.dispatch(ACTIONS.CANCEL_BARCODE_ALL ,"BARCODE");
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
                return this.barcode;
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
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
              //  {key: "itemCd",width:120},
                {key: "itemNm",width:220},
                {key: "barcode",width:120},
                {key: "itemQty",label:"수량",width:100},
                {key: "printBarcode", label:"바코드인쇄",width:150, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>인쇄</button>";
                }},  
                {key: "cancelBarcode", label:"발행취소",width:150, align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>취소</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "printBarcode") {  
                        ACTIONS.dispatch(ACTIONS.PRINT_BARCODE,this.item);
                    }
                    if(this.column.key == "cancelBarcode") {  
                    	var outYN = false;
                    	ppmboot
            			.call({
            		     	type: "GET",
            				 url: ["/api/v1/stock/outYNSearch"],
            				 data: {barcode : this.item.barcode},
            		         callback: function (res) {
            		            if(res.list.length>0){
            		            	outYN = true;
            		            }
            		         }
            		    })   
            	        .done(function () {
            	        	if(outYN){
            	        		axDialog.alert({
                                    theme: "danger",
                                    width:500,
                                    msg: "이미 출고 완료된 품목입니다. "
            	        		});      
                        	}else{
                        		ACTIONS.dispatch(ACTIONS.CANCEL_BARCODE,this.item);
                            	return false;
                        	}
            	        });  
                    }
                }
            },
            page: {
                display: false
            }
        });       
        

        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
       	 	"all-print": function () {
                ACTIONS.dispatch(ACTIONS.PRINT_BARCODE_ALL,"BOX");
            },
            "all-print-cancel": function () {
                ACTIONS.dispatch(ACTIONS.CANCEL_BARCODE_ALL ,"BOX");
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
                return this.barcode;
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
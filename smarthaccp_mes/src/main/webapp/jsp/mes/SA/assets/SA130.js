/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 제품출하등록_수주
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
  	        url: ["order","itemList"],
   	        data: $.extend({remainYn2:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {    
  	            caller.gridView01.setData(res);
  	            caller.gridView02.clear();
  	            caller.gridView03.clear();
  	            caller.formView01.clear();  
            }
        });
        return false;
   },  
   ITEM_CLICK: function (caller, act, data) {    		   
	    var hData = caller.gridView01.getData("selected");
	    data = hData[0];
        caller.formView01.setData(data);
 	    caller.gridView02.clear(); 	     	    
    	ppmboot
	   	   .call({
	   	     	type: "GET",
		   	     url: ["stock","stockGroupByAll"],
		   	     data: {groupByType:"barcode",whType:"20", itemCd:data.itemCd,zeroStock:"N"},
	   	         callback: function (res) {
	   	            caller.gridView02.setData(res);
	   	         }
	   	 	})        
		   	.call({
		   	     	type: "GET",
		   	     	url: ["stock","getStockOutList"],
		   	     	data: {refSlipCd:data.slipCd, refSlipSeq:data.slipSeq,itemCd: data.itemCd,whType:"20"},
		   	        callback: function (res) {			        	 
		   	            caller.gridView03.setData(res);
		   	        }
		   	 })     
	       .done(function () {
	       });  
    },
    SALES_OUT: function (caller, act, data) {
 	   var mData = fnObj.formView01.getData();
       if(nvl(mData.itemCd,'') == ''){
        	axDialog.alert({
                theme: "primary",
                msg: "제품을 선택하세요."
            });
        	return false;
        }else{
              if (caller.formView01.validate()) {    
            	  
 	            var dData = [].concat(caller.gridView02.getData());  
 	
 	 	        var itemQtyCnt1 = 0;	        
 	 	        var itemQtyCnt2 = 0;	        
 	 	        var detailSize = dData.length;

 		        var dArray = new Array();
 		        
 	 	        dData.forEach(function (n) {
 	 	        	
	 	        	n.whType = "20";
	 	        	
 	 	        	if (nvl(n.outYn,'N') == 'Y' && nvl(n.itemQty,0) == 0){
 	 	        		itemQtyCnt1++;
 	 	        	}
 	 	        	
 	 	        	if (nvl(n.outYn,'N') == 'Y'){
 	 	        		itemQtyCnt2++;
 	 	        		n.outDt = mData.outDt;
 	 	        		n.custCd = mData.custCd;
 	 	        		n.refSlipCd = mData.slipCd;
 	 	        		n.refSlipSeq = mData.slipSeq;
 	 	        		n.etcYn = "N";
 	                	dArray.push(n);
 	 	        	}
 	 	        });
 	      	  	
 	 	        if(itemQtyCnt1 > 0){
 	            	axDialog.alert({
 	                    theme: "primary",
 	                    msg: "출하수량을 입력하세요."
 	                });
 	            	return false;
 	 	        }else if(itemQtyCnt2 == 0){
 	            	axDialog.alert({
 	                    theme: "primary",
 	                    msg: "출하대상이 없습니다."
 	                });
 	            	return false;
 	 	        }else{
 	 	        	if(dData.length > 0){
 	 	      	  		axDialog.confirm({
 	 	                      msg: "선택하신 품목을 출하 처리 하시겠습니까?"
 	 	                  }, function () {
 	 	                      if (this.key == "ok") {
 	 	             		     ppmboot.ajax({
 	 	             		     	type: "PUT",
 	 	             		     	url: ["stock","stockOutItem"],
 	 	             		     	data: JSON.stringify(dArray),
 	 	             		         callback: function (res) {       
 	 	             		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
 	 	             		         }
 	 	             		     });	
 	 	                      }
 	 	                  });
 	 	      	  	 }else{
 	 	                	axDialog.alert({
 	 	                      theme: "primary",
 	 	                      msg: "출하 대상이 없습니다."
 	 	                  });
 	 	              	return false;
 	 	      	  	 }
 	 	       	}
         	 }
        }
     },
     SALES_CANCEL: function (caller, act, data) {
 	    var mData = fnObj.formView01.getData();
        if(nvl(mData.itemCd,'') == ''){
        	axDialog.alert({
                theme: "primary",
                msg: "제품을 선택하세요."
            });
        	return false;
        }else{   
            var dData = [].concat(caller.gridView03.getData());  
 	        var itemQtyCnt1 = 0;	        
 	        var detailSize = dData.length;
	        var dArray = new Array();
 	        dData.forEach(function (n) {
 	        	if (nvl(n.outYn,'N') == 'Y'){
 	        		itemQtyCnt1++;
                	dArray.push(n);
 	        	}
 	        });
      	  	
 	        if(itemQtyCnt1 == 0){
            	axDialog.alert({
                    theme: "primary",
                    msg: "출하취소대상이 없습니다."
                });
            	return false;
 	        }else{
 	        	if(dData.length > 0){
 	      	  		axDialog.confirm({
 	                      msg: "선택하신 품목을 출하취소 처리 하시겠습니까?"
 	                  }, function () {
 	                      if (this.key == "ok") {
 	             		     ppmboot.ajax({
 	             		     	type: "PUT",
 	             		     	url: ["stock","stockOutCancelItem"],
 	             		     	data: JSON.stringify(dArray),
 	             		         callback: function (res) {       
 	             		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
 	             		         }
 	             		     });	
 	                      }
 	                  });
 	      	  	 }else{
 	                	axDialog.alert({
 	                      theme: "primary",
 	                      msg: "출하취소 대상이 없습니다."
 	                  });
 	              	return false;
 	      	  	 }
 	       	}
        }
    },
    CUST_MODAL_OPEN: function (caller, act, data) {
        ppmboot.modal.open({
            modalType: "CUST-MODAL",
            param: "",
            sendData: function(){
            	//모달창에 전달할 객체                
            	return {
                };
            },
            callback: function (data) {
            	caller.formView01.setCustInfo(data);
                this.close(); 
            }
        });
    },
    OUT_YN_CHANGE: function (caller, act, data) {
    	var idx = data.__index;
   	 	
   	 	var mData = caller.formView01.getData();
 		var stdItemQty = Number(mData.itemQty);// Total 수주수량
   	 	
   	 	if(nvl(data.outYn,'N') == 'Y'){
   	 		//출하대상 체크시 수주수량 만큼 setting
   	 		var maxStockQty = data.maxStockQty; //row별 최대 재고수량
   	 		if(maxStockQty < stdItemQty){
   	 			caller.gridView02.target.setValue(idx,"itemQty", maxStockQty);
   	 			stdItemQty = stdItemQty - maxStockQty;
   	 			mData.itemQty = stdItemQty;
   	 			caller.formView01.setData(mData);
   	 		}else{
   	 			caller.gridView02.target.setValue(idx,"itemQty", stdItemQty);
   	 			stdItemQty = '0';
   	 			mData.itemQty = stdItemQty;
	 			caller.formView01.setData(mData);
   	 		}
   	 	}else{
   	 		//출하대상 체크해제시 수주수량 으로 return	
	 		stdItemQty = Number(stdItemQty) + Number(data.itemQty);
	 		mData.itemQty = stdItemQty;
	 		caller.formView01.setData(mData);
   	 		caller.gridView02.target.setValue(idx,"itemQty", 0);
   	 	}
    },
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            return false;
        }
    }
});

var CODE = {};
fnObj.pageStart = function () {
	
    var _this = this;
    
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.formView01.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();
    
    
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
        });        
    }
});

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
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
            sortable: true, 
            multiSort: false,
            showRowSelector: false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "saDeliveryDt", label: "납기일자", width: 80, align: "center"},
                {key: "custNm"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"}, 
            	{
                    label: "수량", columns: [
                        {key: "itemQty",label:"수주수량"},
                        {key: "useQty2" , label:"출하수량"},
                        {key: "remainQty2" , label:"출하잔량"},
                    ]
                },
                {key: "unit"}, 
                {key: "slipCd",label:"수주번호"},
                {key: "remainYn2",label:"수주상태"},
                {key: "saOrderDt", label: "수주일자", width: 80, align: "center"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
                },
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
            sortable: true, 
            multiSort: false,
            showRowSelector: false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [     
                {key: "stockDt", label: "재고일", width: 120, align: "center"},   
                {key: "lotNo", width: 110},
                {key: "barcode", width: 110},
                {key: "whCd", width: 120},
                {key: "stockQty",label:"재고", width: 140},
                {key: "itemQty", label: "출하수량", width: 140, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
                {key: "outYn", width: 100, label: "출하대상", editor: "checkYn"},        
            ],      
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                },
		        onDataChanged: function () {  	
		        	if(this.key == "outYn") {
                    	ACTIONS.dispatch(ACTIONS.OUT_YN_CHANGE, this.item);
                    }
		        }
            },
            footSum: [
                [  
                    {label: "합계", colspan: 4, align: "center"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"}
                ]],
        });        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "add-out-list": function () {
                ACTIONS.dispatch(ACTIONS.SALES_OUT);
            }            
        });
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
            sortable: true, 
            multiSort: false,
            showRowSelector: false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [     
                {key: "refSlipCd", width: 100 ,label:"수주번호"},
                {key: "outDt", label: "출하일", width: 110, align: "center"},   
                {key: "lotNo"},
                {key: "barcode"},
                {key: "whCd", width: 100},
                {key: "custNm", width: 150},
                {key: "itemQty", label: "출하수량", width: 100, formatter:"number", align: "right"},
                {key: "outYn", width: 100, label: "출하취소대상", editor: "checkYn"},        
            ],      
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"}
                ]],
        });     

        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
            "cancel-out-list": function () {
                ACTIONS.dispatch(ACTIONS.SALES_CANCEL);
            }            
        });
        
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
    addRow: function (data) {    	
        this.target.addRow({__created__: true,company:data.company, itemCd:data.itemCd,itemNm:data.itemNm,inoutDt:getNowDt(),lotNo:data.lotNo,barcode:data.barcode,itemQty:data.stockQty,whCd:data.whCd}, "last");
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
            
        this.initEvent();
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });        

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
        	"cust_modal": function () {
        		ACTIONS.dispatch(ACTIONS.CUST_MODAL_OPEN)
            }
        });
        
    },
    initEvent: function () {
        var _this = this;             
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();   
        data = $.extend({}, data);
        data.outDt = getNowDt();
        
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();  
        if (rs.error) {
        	 axDialog.alert({
                 theme: "warning",
                 msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
             });
            rs.error[0].jquery.focus();
            return false;
        }  
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
    },
    setCustInfo:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
    }
});
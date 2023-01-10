/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 예외출고등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var whType = "10";
var obj;
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
   	     	type: "GET",
  	         url: ["stock","stockGroupByAll"],
  	         data: $.extend({whType:whType}, getSerializeArrayToJson("#searchView0")),
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
	   var sData = getSerializeArrayToJson("#searchView0");
	   data.userCd = SCRIPT_SESSION.userCd;
	   data.userNm = SCRIPT_SESSION.userNm;

	   caller.formView01.setData(data);
	   caller.gridView02.clear(); 	     	    
	   
	   ppmboot
	   	.call({
	     	type: "GET",
	         url: ["stock","stockGroupByAll"],
	   	     data: {groupByType:"barcode",whCd:data.whCd, whType:"10", itemCd: data.itemCd,zeroStock:sData.zeroStock},
	         callback: function (res) {
	            caller.gridView02.setData(res);
	         }
	   	})        
	   	.call({
	   	     	type: "GET",
	   	     	url: ["stock","getStockOutList"],
	   	     	data: {itemCd: data.itemCd, whType:"10"},
	   	        callback: function (res) {			        	 
	   	            caller.gridView03.setData(res);
	   	        }
	   	 })     
	   	 .done(function () {
	   	 });  
    },
    SALES_OUT: function (caller, act, data) {
    	
 	   var mData = fnObj.formView01.getData();
 	   	if(nvl(mData.custCd, '') == ''){
 	   		axDialog.alert({
 	   			theme: "primary",
 	   			msg: "거래처를 입력하세요"
 	   		});
 	   		return false;
 	   	}
 	   
        if(nvl(mData.itemCd,'') == ''){
        	axDialog.alert({
                theme: "primary",
                msg: "자재을 선택하세요."
            });
        	return false;
        }else{
              if (mData.etcYn == "Y" || caller.formView01.validate()) {            
 	            var dData = [].concat(caller.gridView02.getData());  
 	
 	 	        var itemQtyCnt1 = 0;	        
 	 	        var itemQtyCnt2 = 0;	        
 	 	        var detailSize = dData.length;

 		        var dArray = new Array();
 		        
 	 	        dData.forEach(function (n) {

	 	        	n.whType = "10";
	 	        		
 	 	        	if (nvl(n.outYn,'N') == 'Y' && nvl(n.itemQty,0) == 0){
 	 	        		itemQtyCnt1++;
 	 	        	}
 	 	        	
 	 	        	if (nvl(n.outYn,'N') == 'Y'){
 	 	        		itemQtyCnt2++;
 	 	        		n.outDt = mData.outDt;
 	 	        		n.custCd = mData.custCd;
 	 	        		n.etcYn = mData.etcYn;
 	                	dArray.push(n);
 	 	        	}
 	 	        	
 	 	        });
 	      	  	
 	 	        if(itemQtyCnt1 > 0){
 	            	axDialog.alert({
 	                    theme: "primary",
 	                    msg: "출고수량을 입력하세요."
 	                });
 	            	return false;
 	 	        }else if(itemQtyCnt2 == 0){
 	            	axDialog.alert({
 	                    theme: "primary",
 	                    msg: "출고대상이 없습니다."
 	                });
 	            	return false;
 	 	        }else{
 	 	        	if(dData.length > 0){
 	 	      	  		axDialog.confirm({
 	 	                      msg: "선택하신 품목을 출고 처리 하시겠습니까?"
 	 	                  }, function () {
 	 	                      if (this.key == "ok") {
 	 	                    	 obj = new Object();	// 출고 후 정보 남기기 위해 객체 생성 20.11.11 kjm
 	 	                    	 obj = dArray[0];
 	 	             		     ppmboot.ajax({
 	 	             		     	type: "PUT",
 	 	             		     	url: ["stock","stockOutItem"],
 	 	             		     	data: JSON.stringify(dArray),
 	 	             		         callback: function (res) {
 	 	             		             //gridView01 Init
 	 	             		        	 var listParam = $.extend({whType:whType}, getSerializeArrayToJson("#searchView0"));
 	 	             		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH, listParam);
 	 	             		        	 obj.custCd = "";
 	 	             		        	 obj.custNm = "";
 	 	             		        	 
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
 	 	 	             		        	   itemCd : obj.itemCd,
 	 	 	             		        	   stockCd : obj.stockCd
 	 	             		        	 };
 		            		        	 
 	 	             		        	 ppmboot.sendMail(url, itemchkparam, "");
 	 	             		             //gridView02 Init
 	 	             		        	 ACTIONS.dispatch(ACTIONS.ITEM_CLICK, obj);
 	 	             		         }
 	 	             		     });	
 	 	                      }
 	 	                  });
 	 	      	  	 }else{
 	 	                	axDialog.alert({
 	 	                      theme: "primary",
 	 	                      msg: "출고 대상이 없습니다."
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
                    msg: "출고취소대상이 없습니다."
                });
            	return false;
 	        }else{
 	        	if(dData.length > 0){
 	      	  		axDialog.confirm({
 	                      msg: "선택하신 품목을 출고취소 처리 하시겠습니까?"
 	                  }, function () {
 	                      if (this.key == "ok") {
 	                    	 obj = new Object();
 	                    	 obj = dArray[0];
 	             		     ppmboot.ajax({
 	             		     	type: "PUT",
 	             		     	url: ["stock","stockOutCancelItem"],
 	             		     	data: JSON.stringify(dArray),
 	             		         callback: function (res) {  
 	             		        	 //gridView01 Init
 	             		        	 var listParam = $.extend({whType:whType}, getSerializeArrayToJson("#searchView0"));
 	             		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH, listParam);
 	             		        	 
 	             		             //gridView02 Init
 	             		             obj.custCd = "";
	             		        	 obj.custNm = "";
 	             		             ACTIONS.dispatch(ACTIONS.ITEM_CLICK, obj);
 	             		         }
 	             		     });	
 	                      }
 	                  });
 	      	  	 }else{
 	                	axDialog.alert({
 	                      theme: "primary",
 	                      msg: "출고취소 대상이 없습니다."
 	                  });
 	              	return false;
 	      	  	 }
 	       	}
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
            rowSelectorColumnWidth: 0,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"}, 
                //{key: "partNo"},
//                {key: "safetyQty"},   
                {label: "이력", columns: [
	                    {key: "inQty", label: " 입고(+)", width: 80, formatter:"number", align: "right"},
	                    {key: "outQty", label: "출고(-)", width: 80, formatter:"number", align: "right"},
	                    {key: "modQty", label: "조정", width: 80, formatter:"number", align: "right"},
	                ]
	            },
	            {key: "stockQty", label: "<font color='orange'>현재고</font>", width: 80, formatter:"number", align: "right"},
                {key: "unit"},  
                {key: "qcWay"},   
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 3, align: "center"},     
                    {key: "inQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "outQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: { 
                onClick: function () {
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
            }
        });        
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.slipCd;
            });
        } else {
            list = _list;
        }
        return list;
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
                {key: "lotNo", width: 120},
                {key: "barcode", width: 120},
                {key: "whCd", width: 100},
                {key: "stockQty", width: 100,label:"재고"},
                {key: "itemQty", label: "출고수량", width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
                {key: "outYn", width: 129, label: "출고대상", editor: "checkYn"},        
            ],      
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            footSum: [
                [   
                    {label: "합계", colspan: 4, align: "center"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"}
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
                {key: "outDt", label: "출고일", width: 120, align: "center"},   
                {key: "lotNo", width: 100},
                {key: "barcode", width: 100},
                {key: "whCd", width: 100},
                {key: "custNm", width: 169},
                {key: "itemQty", label: "출고수량", width: 100, formatter:"number", align: "right"},
                {key: "outYn", width: 100, label: "출고취소대상", editor: "checkYn"},        
            ],      
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            footSum: [
                [  
                    {label: "합계", colspan: 5, align: "center"},
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
        return $.extend({}, ppmboot.formView.defaultData, {etcYn:"Y"});
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
        data.etcYn = nvl(data.etcYn,"Y");
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
    setDefaultUser:function(data){
        this.model.set("userCd", data.userCd);
        this.model.set("userNm", data.userNm);
    },
    setDefaultCust:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
    },
});


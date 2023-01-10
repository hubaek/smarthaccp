/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 재고실사등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var wipYn = "N";

var customModal = new ax5.ui.modal({
	absolute: true ,
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
        if (parent) {
    		parent.ppmboot.modal.close();
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
        	type: "GET",
            url: ["modify"],
        	data: {slipCd: param.slipCd},
            callback: function (res) {         
                ppmboot.ajax({
	                type: "GET",
	   		        url: ["modify","itemList"],
	   		     	data: {slipCd: param.slipCd},
                    callback: function (res) {      
	 		            caller.gridView01.setData(res);
                    }
                });                
                caller.formView01.setData(res.list[0]);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {        	 
   	 	if (caller.formView01.validate()) {
	    	var mData = caller.formView01.getData();
	    	var dData = [].concat(caller.gridView01.getData());	  
   		
	        var itemQtyCnt1 = 0;
	        var itemQtyCnt2 = 0;
	        var detailSize = dData.length;
	        
	        dData.forEach(function (n) {
	          	if (nvl(n.whCd,"") == ""){
	          		itemQtyCnt2++;
	        		return false;
	          	}
	          	
	        });
	        
	        if(itemQtyCnt2 > 0){
        	 	axDialog.alert({
  	                  theme: "warning",
  	                  msg: "창고를 입력하세요."
  	            });
  	         	 return false;
  	        }else if(detailSize == 0){
	          	 axDialog.alert({
	                   theme: "warning",
	                   msg: "등록된 품목정보가 없습니다."
	             });
	          	 return false;
	        }else{

	            var saveList = [].concat(caller.gridView01.getData());
	            saveList = saveList.concat(caller.gridView01.getData("deleted"));
	            
		        mData.itemDetail = saveList;
		        mData.wipYn = wipYn;
	        	
		        var alertMsg = "'저장'하시겠습니까?";
	            axDialog.confirm({
	                theme: "danger",
	                msg: alertMsg
	            }, function () {
	            	if(this.key == "ok"){
	    		        ppmboot.ajax({
	    		        	type: "PUT", 
	    		        	url: ["modify"], 
	    		        	data: JSON.stringify(mData),
	    		            callback: function (res) {         
	    		            	param.slipCd = res.slipCd;
	    		            	param.mode = "mod";	            	
	    		                parent.ppmboot.modal.callback("");
	    	                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
	    		                
	    		            }
	    		        });
	            	}
	            });
	        }
	    }    	 
    },
    ITEM_DETAIL_CHANGE: function (caller, act, data) {    	
    	calcItem();
    },          
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    },
    //재고적용
    STOCK_MODAL_OPEN: function (caller, act, data) {
    	var mData = caller.formView01.getData();
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/STOCK-SEL-M.jsp", 
                param: "callBack=customStockModalCallback1&whCd="+mData.whCd
            }
        });    	
    },  
    //품목정보적용
    ITEM_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var itemTypeGroup = "";	  	        	
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/ITEM-SEL-M.jsp", 
                param: "callBack=customStockModalCallback2&itemTypeGroup=" + itemTypeGroup
            }
        });   
    },
    INIT_WH: function (caller, act, data) {    	
    	var mData = caller.formView01.getData();	 
    	var dData = [].concat(caller.gridView01.getData());	  
    	if(dData.length > 0){
            axDialog.alert({
                theme: "danger",
                msg: "창고 변경시 재고내역은 '초기화' 됩니다."
            }, function () {
            	if(this.key == "ok"){
            		caller.gridView01.setData([]);
            	}
            });
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
	
	param = parent.ppmboot.modal.getData();
    
    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.formView01.initView();
    
    if(param.mode == "add"){
        customUserModalCallback(SCRIPT_SESSION);
        setAuthBtn();
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }    
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
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
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
            	{
                    label: "품목정보", columns: [
                    	{key: "itemCd"},
                        {key: "itemNm"},
                        //{key: "partNo"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
            	{
                    label: "재고정보", columns: [			
                        {key: "lotNo",editor: {type: "text",
                            disabled: function () {
                                return (this.item.modifyDetailType == "10" );
                            }},
                            styleClass: function () {
                              	 if(this.item.modifyDetailType == "20"){
                              		 return "grid-cell-blue";
                              	 }else{
                              		 return "";
                              	 }
                              	
                       }},
                       {key: "barcode"},
                    ]
                },
            	{
                    label: "수량정보", columns: [
                        {key: "preItemQty",label: "이전재고"},   
                        {key: "modQty", label: "실사수량", editor: {type: "number"},styleClass: "grid-cell-blue"}, 
                        {key: "itemQty",label: "조정수량"}, 
                    ]
                },      
                {key: "itemRemark", label: "비고", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},  
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "preItemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {  
            	onClick: function () {  
                    this.self.select(this.dindex);
		        },
		        onDataChanged: function () {  	
		        	if(this.key == "modQty" ) {
                    	ACTIONS.dispatch(ACTIONS.ITEM_DETAIL_CHANGE, this);
                    }
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-remove": function () {  
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);    
            },
            "stock-all": function () {
            	ACTIONS.dispatch(ACTIONS.STOCK_MODAL_OPEN);
            },
            "item-all": function () {
            	ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN);
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
                return nvl(this.slipSeq,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addParentRow1: function (data) {
    	addParentRow1(this.target,data);
    },
    addParentRow2: function (data) {
    	addParentRow2(this.target,data);
    }
});  

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
	
    getDefaultData: function () {		
    	var today = getNowDt();
        return $.extend({}, ppmboot.formView.defaultData, {slipDt:today});
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
        this.model.onChange("whCd", function () {
            ACTIONS.dispatch(ACTIONS.INIT_WH);
        }); 
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {        
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);

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

        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);        
    	
        this.model.setModel(this.getDefaultData());
    },
    setDefaultUser:function(data){
        this.model.set("userCd", data.userCd);
        this.model.set("userNm", data.userNm);
    }
});

//재고적용
function customStockModalCallback1(data){
	fnObj.gridView01.addParentRow1(data);
}

//재고적용
function addParentRow1(obj,data){
	obj.addRow({__created__: true,
		itemCd:data.itemCd,  
		itemNm:data.itemNm,
		spec:data.spec,
		unit:data.unit,
		preItemQty:nvl(data.stockQty,0),  
		itemQty:nvl(data.itemQty,0),  
		modQty:nvl(data.stockQty,0),
		stockCd:data.stockCd,
		lotNo:data.lotNo,
		wlotNo:data.wlotNo,
		barcode:data.barcode,
		modifyDetailType:"10",
		whCd:data.whCd,
		}, "last");	
}

//품목적용
function customStockModalCallback2(data){
	fnObj.gridView01.addParentRow2(data);
}

//품목적용
function addParentRow2(obj,data){
	var mData = fnObj.formView01.getData();
	var whCd = mData.whCd;
	
	obj.addRow({__created__: true,
		itemCd:data.itemCd,  
		itemNm:data.itemNm,
		spec:data.spec,
		unit:data.unit,
		preItemQty:0,  
		itemQty:0,
		modQty:0,
		modifyDetailType:"20",
		whCd:nvl(whCd,""),
		}, "last");	
}

//사용자 목록
function customUserModalCallback(data){
	fnObj.formView01.setDefaultUser(data);
	customModal.close();
}

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.slipCd,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	}else{
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}

/*
 * 전체계산
 */
function calcItem(){  
	var obj = fnObj.gridView01;	
	var list = obj.getData();  
	if(list.length > 0){
		list.forEach(function (n) {
			n.itemQty= n.modQty - n.preItemQty;
	    }); 
	}
	obj.setData(list);  	
}

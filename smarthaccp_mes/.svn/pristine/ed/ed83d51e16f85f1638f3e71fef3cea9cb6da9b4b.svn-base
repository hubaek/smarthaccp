/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산실적수정
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var master;

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
    PAGE_SEARCH: function (caller, act, data) {
    	master = "";
    	ppmboot
		.call({
	     	type: "GET",
			 url: ["worderList" ,"workOrderList"],
			 data: $.extend({orderSt:"ORDER"}, getSerializeArrayToJson("#searchView0")),
	         callback: function (res) {
	            caller.gridView01.setData(res);
	            caller.gridView02.setData([]);
	         }
	    })  
        .done(function () {
        });   
   	 
        return false;
    },    
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	master = data;
    	ppmboot
	        //자재출고목록	
	        .call({
	                type: "GET",
	                url:  ["worderList","outgoingList"],
		            data: {wlotNo:data.wlotNo, discardYn:"N"},
	                callback: function (res) {
	                    caller.gridView02.setData(res);
	                }
	        })
	        .done(function () {
	        });
    	return false;
    },    
    OUT_STOCK_MODAL: function (caller, act, data) {
    	if (nvl(master,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "자재 적용할 실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	ppmboot.modal2.open({  
            modalType: "OUT-STOCK-M",
            param: "",
            sendData: function(){
            	return {
                    "order" : master,
                    "outType" : "OUT",
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
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

    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);    
    
    //$("#grid02").css("height", window.outerHeight-635);
}; 


fnObj.pageResize = function () {
	   //$("#grid02").css("height", window.outerHeight-635);
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "fn1": function () {
            	ACTIONS.dispatch(ACTIONS.PAGE_DEL);
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

        ppmboot.buttonClick(this, "data-page-btn", {      
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
        });
    }
});

/**
 * gridView01	작업지시
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,   
            sortable: false, 
            multiSort: false,
            showRowSelector: true, 
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "orderDt"},
                {key: "orderNo"},
                {key: "orderSeq"},
                {key: "routingNm"}, 
                {key: "routType"}, 
                {key: "routCd"}, 
                {key: "equipCd"},
                {key: "itemCd", label: "품목코드", width: 110, align: "center"},
                {key: "itemNm", label: "품목명", width: 150, align: "center"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "orderQty", label: "지시수량", width:80, formatter:"number", align: "right"},
                {key: "outYn"},
                {key: "wlotNo"},
            ],       
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
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
                return this.wlotNo;
            });
        } else {
            list = _list;
        }
        return list;
    },
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
            columns: [
                {key: "itemCd",width:120, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
                {key: "itemNm",width:200, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
            	{
                    label: "불출(소요단위)", columns: [
                        {key: "lotNo", width: 120},
                        {key: "barcode", width: 120},
                        {key: "bomItemQty", label: "투입수량", width: 120, formatter:"number", align: "right"},
                        {key: "transConsumQty", label: "소모수량", width: 120, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                    ]
                },	
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
       	 	"out-stock": function () {
                ACTIONS.dispatch(ACTIONS.OUT_STOCK_MODAL);
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
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
    	ppmboot
	   	 .call({
            type: "GET",
            url: ["purchase","header"],
            data: $.extend({remainYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {               	
                caller.gridView01.setData(res); 
                caller.gridView02.setData([]);
            }
	   	 })
	   	 .call({
	   	     	type: "GET",
	   	         url: ["purchase","itemList"],
	   	         data: $.extend({remainYn:"Y"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
	   	            caller.gridView03.setData(res);
	   	         }
	   	 })
	     .done(function () {
	       	
	     });   
        return false;
    },    
    PAGE_CHOICE: function (caller, act, data) {    	
    	
        var tabLayout = $('[data-ax5layout="tab1"]');
        var ta1 = tabLayout.ax5layout("getActiveTab");
        
        if(ta1.panelIndex == 0){
            var list = caller.gridView03.getData("selected");
            if (list.length > 0) {
            	if (typeof param.callBack === "undefined"){
            		parent.ppmboot.modal.callback(list);
            	}else{
            		parent[param.callBack](list);
            	}
            } else {
                alert(LANG("ax.script.requireselect"));
            }
        }else if (ta1.panelIndex == 1){
            var list = caller.gridView02.getData();
            if (list.length > 0) {
            	if (typeof param.callBack === "undefined"){
            		parent.ppmboot.modal.callback(list);
            	}else{
            		parent[param.callBack](list);
            	}
            } else {
                alert(LANG("ax.script.requireselect"));
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
                    "sendData": "AX5UI"
                };
            },
            callback: function (data) {
            	searchView0.custCd.value = data.custCd;
            	searchView0.custNm.value = data.custNm;
                this.close(); 
            }
        });
    },    
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {    	
    	 ppmboot
		 .call({
		     	type: "GET",
		         url: ["purchase","itemList"],
		     	data: {slipCd: data.slipCd,remainYn:"Y"},
		         callback: function (res) {
  
		            caller.gridView02.setData(res);
		         }
		 })        
         .done(function () {
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
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();

    param = ax5.util.param(ax5.info.urlUtil().param);
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
        
        ppmboot.buttonClick(this, "data-searchview-btn", {
            "cust_modal": function () {
                ACTIONS.dispatch(ACTIONS.CUST_MODAL_OPEN)
            }
        });  
    }
});

/**
 * gridView01	양식목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            showRowSelector: true,
            multipleSelect: true, 
            multiSort: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "slipCd", label: "구매번호"},
                {key: "slipDt"},
                {key: "userNm"},
                {key: "remark"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
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
 * gridView02 상세목록
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
                {key: "slipCd", label: "구매번호"},
                {key: "remainYn",label:"상태"},
                {key: "slipDt"},
                {key: "custNm"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "lotNo"},
                {key: "whCd", label: "입고창고"},
                {key: "pdUnit"},
                {key: "itemQty" , label:"입고수량"},
                {key: "useQty" , label:"미결마감"},
                {key: "remainQty" , label:"입고잔량"},
                {key: "itemRemark"}
            ],
            body: {
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
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "slipCd", label: "구매번호"},
                {key: "remainYn",label:"상태"},
                {key: "slipDt"},
                {key: "custNm"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "lotNo"},
                {key: "whCd", label: "입고창고"},
                {key: "pdUnit"},
                {key: "itemQty" , label:"입고수량"},
                {key: "useQty" , label:"미결마감"},
                {key: "remainQty" , label:"입고잔량"},
                {key: "itemRemark"}
            ],
            body: {
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
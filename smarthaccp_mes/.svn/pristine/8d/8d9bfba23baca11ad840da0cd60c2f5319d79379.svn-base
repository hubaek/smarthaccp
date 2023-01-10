/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 재고현황 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE;
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
   	         url: ["stock","getStockMaster"],
   	         data: $.extend({pcYn:"Y",zeroStock:"N"}, getSerializeArrayToJson("#searchView0")),
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
        		parent.ppmboot.modal.callback(list);
        	}else{
        		parent[param.callBack](list);
        	}
        } else {
            alert(LANG("ax.script.requireselect"));
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
    CODE = this; // this는 call을 통해 수집된 데이터들.
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();        
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
    }
});

/**
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            frozenColumnIndex: 0,
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "slipCd", label:"구매번호"},
                {key: "custNm",label:"입고처"},
                {key: "itemCd"},
                {key: "itemNm"},     
                //{key: "partNo"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "spec"},
                {key: "whCd"},
                {key: "unit"},
                {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                {key: "pdUnit"},
                {key: "pdTransQty", label: "매입환산재고", width: 110, formatter:"number", align: "right"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    //ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
    }
});



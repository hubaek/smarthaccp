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
        ppmboot.ajax({
            type: "GET",
            url: ["item"],
            data: $.extend({itemTypeGroup:"P"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });

        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView02.getData();        
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list);
        	}else{            		
        		parent[param.callBack](list);      
        	}
        }
    },
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
        .call({
            type: "GET",
            url:  ["bom", "bomDetailList"],
            data: "itemCd=" + data.itemCd,
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
 * gridView01	품목정보목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
	
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                 {key: "itemCd"},
                 {key: "itemNm"},
                 //{key: "partNo"},
                 //{key: "itemType"},
                 {key: "spec"},
                 {key: "routCd"},
                 {key: "bomQty", width:80, label: "하위수량",formatter:"number", align: "right"},
                 {key: "routQty", width:80, label: "하위공정",formatter:"number", align: "right"},
                 {key: "itemQty",width:80, label: "생산기준수량",formatter:"number", align: "right"},
                 //{key: "unit"},
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
                return this.itemCd;
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "parentItemCd", label: "모품번", width:100, align: "center"},
                {key: "unit"},     
                {key: "routCd"},
                {key: "bomQty",label:"소요량",width:80 ,formatter:"number", align: "right"},                  
                {key: "lossQty",label:"LOSS",width:80 ,formatter:"number", align: "right"},                    
                {key: "reqQty",label:"총소요량",width:80 ,formatter:"number", align: "right"},         
                {key: "useYn"}
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


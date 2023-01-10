/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  		: 전준룡
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 거래처별 구매단가현황
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
            url:  ["price","pcPrice"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });   	 
        return false;
    },
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("구매매단가현황_"+getNowDate()+".xls");
    },    
    /*
    ITEM_CLICK: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        ppmboot.ajax({  
            type: "GET",
            url:  ["price","pcPriceHistory"],
            data: {custCode:list[0].custCode,itemCode:list[0].itemCode},
            callback: function (res) {  
                caller.gridView02.setData(res);
            }
        });
    },*/ 
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
    //_this.gridView02.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
};

fnObj.pageResize = function () {};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
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
    }
});

/**
 * gridView01 구매처별 단가
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "partNo"},
                {key: "pcPrice", label:"구매 기준단가", formatter:"number" , align:"right"},
                {key: "custCd", label: "거래처코드", width: 100, align: "center"},
                {key: "custNm", label: "거래처명", width: 100, align: "center"},
                {key: "regDt", label: "최종등록일", width: 100, align: "center"},
                {key: "unitPrice", label:"구매단가"},
                {key: "useYn", label:"사용여부", width: 70, align: "center"},
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
                return this.itemCode;
            });
        } else {
            list = _list;
        }
        return list;
    }
});


/**
 * gridView02 단가이력

fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "regDt", label: "변경일", width: 100, align: "center"},
                {key: "unitPrice", label:"구매단가"},
                {key: "useYn", label:"사용여부", width: 70, align: "center"}
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    }
});
 */

/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  		: 전준룡
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 구매단가등록
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
            url: ["item"],
            data: $.extend({itemTypeGroup:"I"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });   	 
        return false;
    },        
    PAGE_SAVE: function (caller, act, data) {
        var dData = [].concat(caller.gridView01.getData());
        sData = dData.concat(caller.gridView01.getData("modified"));
        ppmboot
            .call({
                type: "PUT", 
                url: ["item","saveItemOptions"], 
                data: JSON.stringify(sData),
                callback: function (res) {
                }
            })
            .done(function () {
                axToast.push("저장 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            });
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("구매단가등록.xls");
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
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCode: "ITEM_GROUP"},
        callback: function (res) {        		
            this.ITEM_GROUP = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    });
};

fnObj.pageResize = function () {};
fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
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
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26, 
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},   
                {key: "itemType"},   
				//{key: "itemGroup", formatter: function formatter() { return CONVERT_CODE["ITEM_GROUP"].map[this.value];}},
                {key: "spec"},   
                {key: "unit"},
                {key: "custNm",width:150},
                {key: "pcPrice", label:"구매 기준단가", formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"}
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
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
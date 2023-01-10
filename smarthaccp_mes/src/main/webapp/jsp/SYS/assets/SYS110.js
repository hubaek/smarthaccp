/**
 * 0. Project	: DPIN ERP
 * 1. 작성자  	: 국
 * 2. 작성일		: 2019.06.11
 * 3. Comment 	: 품목마스터 관리
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
            url: ["key","work"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	
        var dData = [].concat(caller.gridView01.getData("modified"));   
        dData = dData.concat(caller.gridView01.getData("deleted"));    

		ppmboot
        .call({
            type: "PUT", 
            url: ["key","work"],
            data: JSON.stringify(dData),
            callback: function (res) {
            }
        })
        .done(function () {
            axToast.push("저장 되었습니다.");
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
    },
    ITEM_ADD: function (caller, act, data) {
    	caller.gridView01.addRow();
    },
    ITEM_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
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
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "codeType", label: "유형코드", width: 120, align: "center", editor: "text",styleClass: "grid-cell-blue"},
                {key: "codeDt", label: "생성월", width: 120, align: "center", editor: "text",styleClass: "grid-cell-blue"},
                {key: "seq", label: "SEQ", width: 100, align: "right", editor: "number",styleClass: "grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            }
        });
         
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_DEL);
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);
        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.codeType && this.codeDt;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true, company:getSerializeArrayToJson("#searchView0").company}, "first");
    }
});

/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
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
            url: ["company","cp100"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	var sData = getSerializeArrayToJson("#searchView0");
        var dData = [].concat(caller.gridView01.getData("modified"));   
        dData = dData.concat(caller.gridView01.getData("deleted"));    
        dData.forEach(function (n) {
            n.company = nvl(sData.company,'*');
        });
		ppmboot
        .call({
            type: "PUT", 
            url:  ["company", "cp100"],
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
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "deptCd", label: "부서코드", width: 120, align: "center", editor: "text",styleClass: "grid-cell-blue",formatter:function(){
                	return this.value;
                }},
                {key: "deptNm", label: "부서명", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},      
                {key: "deptNmKo", label: "부서명(KO)", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},    
                {key: "deptNmEn", label: "부서명(EN)", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},    
                {key: "deptNmZh1", label: "부서명(CHS)", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},    
                {key: "deptNmZh2", label: "부서명(CHT)", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"}, 
                {key: "remark", label: "비고", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "sort", width: 133, align: "center", editor: "number",styleClass: "grid-cell-blue"},
                {key: "useYn", width: 140, label: "사용여부", editor: "checkYn",styleClass: "grid-cell-blue"},        
            ],
            body: {
                onClick: function () {
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
        //엑셀 붙여넣기
        document.getElementById("gridView01").addEventListener('paste', function(e){
        	handlePasteGridView(e, fnObj.gridView01.target, "Y");  	//event ,target, addYn 
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
                return this.deptCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function () {    	
        this.target.addRow({__created__: true, useYn: "Y"}, "first");
    }
});
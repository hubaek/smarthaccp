/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 불량항목 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
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
            url:  ["qcManage","getQcBadList"],
            data: {slipCd:param.slipCd},
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView01.getData();            
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list,param.idx);
        	}else{        		
        		parent[param.callBack](list,param.idx);
        	}
        }
    },
    ITEM_BAD_ADD: function (caller, act, data) {
    	caller.gridView01.addRow(param.slipCd);
    },
    ITEM_BAD_DEL: function (caller, act, data) {
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
    param = ax5.util.param(ax5.info.urlUtil().param);
    ppmboot
	    .call({
	        type: "GET",
            url: ["rout","bad"], 
	        data: {routCd:"QCHE", useYn: "Y"},
	        callback: function (res) {        
	        	res.list.forEach(function (n) {
	                n.subCd = n.badCd;
	                n.subNm = n.badNm;
	            });
	            this.BAD_CD = res.list;
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
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
				{key:"badCd", label: "불량코드",width:150, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.BAD_CD
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["BAD_CD"].map[this.value];
					},styleClass:"grid-cell-select"
				},				
                {key: "badQty", label: "불량수량", width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass:"grid-cell-select"},
                {key: "remark", label: "비고", width: 200, align: "left", editor: "text" ,styleClass:"grid-cell-select"}
            ],
            body: {
            }
        });

        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_BAD_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_BAD_DEL);
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
                return this.badCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function (slipCd) {
        this.target.addRow({__created__: true,slipCd:slipCd}, "last");
    }
});
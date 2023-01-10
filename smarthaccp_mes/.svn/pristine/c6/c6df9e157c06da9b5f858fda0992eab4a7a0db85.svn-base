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
		parent.customModal.close();
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
	        
	        param = ax5.util.param(ax5.info.urlUtil().param);
	        
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
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
				{key:"badCd", label: "불량코드",width:150, align: "center",
        			formatter: function formatter() {
		    					return CONVERT_CODE["BAD_CD"].map[this.value];
					}
				},				
                {key: "badQty", label: "불량수량", width: 100, formatter:"number", align: "right"},
                {key: "remark", label: "비고", width: 200, align: "left"}
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
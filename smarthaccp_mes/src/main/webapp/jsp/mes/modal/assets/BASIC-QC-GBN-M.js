/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 불량 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var mainCd = "QC_GBN";
var codeLabel = "코드"
var valueLabel = "검사종류명"
	
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
            url:  ["basic", "detail"],
            data: $.extend({mainCd:mainCd}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
    	if (typeof param.callBack === "undefined"){
    		parent.ppmboot.modal.callback(data,param);
    	}else{        		
    		parent[param.callBack](data,param);
    	}
    	axToast.push(data.subNm+"");
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
	   data: {mainCd: "QC_TYPE"},
	   callback: function (res) {        		
	       this.QC_TYPE = res.list;
	   }
	})
	.done(function () {
	   CODE = this;
	   CONVERT_CODE = convertCommonCode(CODE);
	   _this.pageButtonView.initView();
	   _this.searchView.initView();
	   _this.gridView01.initView();    
	
	   param = ax5.util.param(ax5.info.urlUtil().param);    
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
            showRowSelector: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
				{key:"data1", label: "검사유형",width:120, align: "center"
					, formatter: function formatter() {
    					return CONVERT_CODE["QC_TYPE"].map[this.value];
					}
				},      
                {key: "subCd", label: codeLabel, width: 80, align: "center"},
                {key: "subNm", label: valueLabel, width: 120, align: "left"},                     
                {key: "remark", label: "비고", width: 200, align: "left"},                
                {key: "sort", label: "정렬", formatter: "number"},
                {key: "useYn", label: "사용여부"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
    }
});
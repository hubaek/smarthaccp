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

var mainCd = "BAD_CD";
var codeLabel = "불량코드"
var valueLabel = "불량명"
var pArray = new Array();
var param;

var pList;
var pArray = new Array();

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
    	
    	if(nvl(param.gridNm,'') != ''){
    		parentList = eval("parent.fnObj."+param.gridNm+".getData();");
        	if(parentList.length > 0){
        		parentList.forEach(function (n) {         
        			pArray.push(eval("n." + param.keyNm));
                });
        	}
    	}
    	
    	ppmboot.ajax({
            type: "GET",
            url:  ["basic", "detail"],
            data: $.extend({mainCd:mainCd}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
            	res.list.forEach(function (n) {         
        			if(pArray.indexOf(n.subCd) != -1){
        				n.extYn = "Y";
        			}else{
        				n.extYn = "N";
        			}
                });
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
    	if(nvl(data.extYn,'N') == 'N'){
    		var idx = data.__index;
        	fnObj.gridView01.target.setValue(idx,"extYn", "Y");

        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(data);
        	}else{        		
        		parent[param.callBack](data);
        	}
        	axToast.push(data.subCd + "::" + data.subNm + "::불량정보를 불러왔습니다.");
            fnObj.gridView01.target.repaint();
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

    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();    

    param = parent.ppmboot.modal.getData();
	if (typeof param === "undefined"){
	    param = ax5.util.param(ax5.info.urlUtil().param);
	}
	
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
                {key: "subCd", label: codeLabel, width:100, align: "center",formatter:function(){
                 	return this.value;
                 }},
                {key: "subNm", label: valueLabel, width: 200, align: "left"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
                trStyleClass: function(){
                	if(nvl(this.item.extYn,'N') == "Y"){
                		return "grid-cell-important1";
                	}
                }
            }
        });
    }
});
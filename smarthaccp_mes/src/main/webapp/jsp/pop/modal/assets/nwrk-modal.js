/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 비가동
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
            url: ["/api/v1/pop2/getNwrkTypeList"],
            data: {routCd:param.order.routCd,useYn:"Y"},
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        if (list.length > 0) {
        	param.order.orderSt = "NWRK";
        	param.order.nwrkCd = list[0].nwrkCd;
            var obj = {
            	workMaster: param.order,
        		workNwrk: param.order
            };
            
            ppmboot.ajax({
            	type: "PUT", 
            	url: ["/api/v1/pop2/saveWorkNwrk"], 
            	data: JSON.stringify(obj),
                callback: function (res) {         
            		parent.ppmboot.modal.callback();
            		parent.ppmboot.modal.close();
                }
            });	 
        } else {
            alert(LANG("ax.script.requireselect"));
        }
    },
    ITEM_CLICK: function (caller, act, data) {
        ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
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
        data: {mainCd: "NWRK_CD", useYn:"Y"},
        callback: function (res) {        		
            this.NWRK_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
        param = parent.ppmboot.modal.getData();
        
        _this.pageButtonView.initView();
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
            multipleSelect: false,
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 25},
            columns: [
                {key: "nwrkNm", label:"비가동명", width:400, align:"left"},
            ],
            body: {
                columnHeight: 60,
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});
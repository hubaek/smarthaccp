/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 품목 적용 팝업
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
            url: ["item","popItemList"],
            data: $.extend({itemTypeGroup:nvl(param.itemTypeGroup,''), useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
    	
    	var mData = caller.gridView01.getData("selected");
    	if(mData == undefined || mData == null || mData.length == 0){
    		axDialog.alert({
                theme: "primary",
                width:500,
                msg: "등록할 품목을 선택해주세요."
            });
            return false;
    	}
    	if (typeof param.callBack === "undefined"){
    		parent.ppmboot.modal.callback(mData);
    	}else{        		
    		parent[param.callBack](mData);
    	}
    	ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
    },
    //선택
    /* PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");     
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list);
        	}else{            		
        		parent[param.callBack](list);      
        	}
        }
        axToast.push("["+list.length+"] 건의 품목정보를 불러왔습니다.");
    }, */
    INIT_SEARCH: function (caller, act, data) {    
    	
    	var itemTypeGroup = param.itemTypeGroup;
    	
   		if(nvl(itemTypeGroup,'') != ''){
   	    	$("#itemType option").remove();
   			ppmboot.ajax({
   		        type: "GET",
   		        url:  ["basic", "detail"],
   		        data: {mainCd: "ITEM_TYPE",data1:itemTypeGroup},
   		        callback: function (res) {        		
   		        	$("#itemType").append("<option value=''>전체</option>");
   		        	res.list.forEach(function (n) {
   	                	$("#itemType").append("<option value='"+n.subCd+"'>"+n.subNm+"</option>")
   		        	});	
   		        }
   		    });
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
	
    if(nvl(param.routType,"") != ""){
    	$("#routType").val(param.routType);
    }
    
    ACTIONS.dispatch(ACTIONS.INIT_SEARCH);
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
            "apply": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
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
            frozenColumnIndex: 0,
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            scroller: {size: 35},
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm", width: 420},
                //{key: "stockCd", width: 150},
                //{key: "stockQty"},
                //{key: "wlotNo"},
                //2020-07-27 p/n 숨김 처리 최정욱
                //{key: "partNo"},   
                {key: "itemType"},   
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},   
                //{key: "unit"},
                //{key: "qcWay"},
            ],
            /*
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
            */
        });
    }
});



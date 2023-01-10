/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 품목 적용 팝업 - 단건
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
        		parent.ppmboot.search_modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {  
        ppmboot.ajax({
            type: "GET",
            url: ["item"],
            data: $.extend({useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });

        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
    	if (typeof param.callBack === "undefined"){
    		parent.ppmboot.search_modal.callback(data,param);
    	}else{            		
    		parent[param.callBack](data,param);      
    	}
    },
    SETUP_ITEM_TYPE: function (caller, act, data) {         
    	var itemTypeGroup = param.whereValue;
   		if(nvl(itemTypeGroup,'') != ''){
   	    	$("#itemType option").remove();   	    	
   			ppmboot.ajax({
   		        type: "GET",
   		        url:  ["basic", "detail"],
   		        data: {mainCd: "ITEM_TYPE",dataAllOr:itemTypeGroup},
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

    param = parent.ppmboot.search_modal.getData();
	if (typeof param === "undefined"){
	    param = ax5.util.param(ax5.info.urlUtil().param);
	}

    if(nvl(param.routType,"") != ""){
    	$("#routType").val(param.routType);
    }
    
    if(nvl(param.itemCd,"") != ""){
    	$("#itemCd").val(param.itemCd);
    }

    if(nvl(param.itemNm,"") != ""){
    	$("#itemNm").val(param.itemNm);
    }
    
    ACTIONS.dispatch(ACTIONS.SETUP_ITEM_TYPE);
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
            showRowSelector: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},  
                //{key: "partNo"},   
                {key: "itemType"},   
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},   
                {key: "unit"}, 
                {key: "qcWay"},
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



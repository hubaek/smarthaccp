/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
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
            url: ["item","getRoutingItemList"],
            data: $.extend({routingYn:nvl(param.routingYn,""),useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
    	if (typeof param.callBack === "undefined"){
    		parent.ppmboot.modal.callback(data);
    	}else{        		
    		parent[param.callBack](data);
    	}
    	axToast.push(data.itemCd+"::"+data.itemNm+"::품목정보를 불러왔습니다.");
    },
    SETUP_ITEM_TYPE: function (caller, act, data) {         
    	var itemTypeGroup = param.itemTypeGroup;
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
    ppmboot
    .call({
        type: "GET",
        url: ["rout","routingMaster"],
        data: {useYn: "Y"},
        callback: function (res) {
        	res.list.forEach(function (n) {   
    			n.subCd = n.routingCd;   
    			n.subNm = n.routingNm;
    		});            	
            this.ROUTING_CD = res.list;
        }
    })  
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();    

        param = ax5.util.param(ax5.info.urlUtil().param);
        
        if(nvl(param.routType,"") != ""){
        	$("#routType").val(param.routType);
        }
        
        ACTIONS.dispatch(ACTIONS.SETUP_ITEM_TYPE);
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
            showRowSelector: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "itemType"},
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},              
                {key: "unit"},
                {key: "qcWay"},
				{key: "routingCd", formatter: function formatter() { return CONVERT_CODE["ROUTING_CD"].map[this.value];}},
                {key: "whCd" , label:"기본창고"},
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
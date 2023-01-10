/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 재고현황 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE;
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
  	         url: ["stock","stockGroupByAll"],
   	         data: $.extend({groupByType:"barcode",whType:nvl(param.whType,''),whCd:nvl(param.whCd,''),zeroStock:"N"}, getSerializeArrayToJson("#searchView0")),
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
    
    INIT_SEARCH: function (caller, act, data) {      

    	var whType = param.whType;    	
    	var whCd = param.whCd;
    	
   		if(nvl(whType,'') != ''){
   	    	$("#whCd option").remove();   	    	
   			ppmboot.ajax({
   		        type: "GET",
   		        url:  ["whCd"],
   		        data: {whType: whType},
   		        callback: function (res) {        		
   		        	$("#itemType").append("<option value=''>전체</option>");
   		        	res.list.forEach(function (n) {
   	                	$("#whCd").append("<option value='"+n.whCd+"'>"+n.whNm+"</option>")
   		        	});	
   		        }
   		    });
   		} 		

   		if(nvl(whCd,'') != ''){
   			$("#whCd").val(whCd);
   			$("#whCd").prop('disabled', true)
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
    
    param = ax5.util.param(ax5.info.urlUtil().param);              
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
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},    
                //{key: "partNo"},
                {key: "spec"},    
                {key: "unit"},  
                {key: "whCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "routCd"},
                {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
            ], 
            footSum: [
                [  
                    {label: "합계", colspan: 9, align: "center"},   
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
    }
});



/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 장기재고현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {    	    	
    	ppmboot
	   	 .call({
	   	     	type: "GET",
		   	     url: ["stock","stockGroupByAll"],
	  	         data: $.extend({groupByType:"barcode",zeroStock:"N"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })
	     .done(function () {
	       	
	     });   
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

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
        });
    }
});

fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
};

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });          
        ppmboot.buttonClick(this, "data-page-btn", {      

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
            sortable: true, 
            multiSort: false,
            showRowSelector: false, 
            multipleSelect: false,
            multiSort:false,  
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [     
                {key: "stockDt"},
                {key: "itemCd"},
                {key: "itemNm"}, 
                //{key: "partNo"},
                {key: "safetyQty"},
                {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                {key: "unit"},  
                {key: "whCd"},
                {key: "routCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "qcWay"},    
                {key: "qcFlag"},
            ],      
            footSum: [
                [  
                    {label: "합계", colspan: 5, align: "center"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                ]],
                body: {
                },
        });        
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.slipCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
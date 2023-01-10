/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 자재창고부족재고
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
	   	         data: $.extend({groupByType:"whCd",safetyYn:"Y"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {	   	        	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })
	     .done(function () {	       	
	     });   
    },    
  //Excel 다운로드  추가 최정욱 2020-07-13
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.searchView0.target.exportExcel("부족재고_품목별 리스트.xls");
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
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
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
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},   
                //{key: "partNo"},
                {key: "spec"},
                {key: "safetyQty"},    
                {key: "whCd"},
                {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                {key: "deficientQty", label:"<font color=red>부족재고</font>", width: 100, formatter:"number", align: "right"},
                {key: "unit"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 5, align: "center"},     
                    {key: "safetyQty", collector: "", formatter:"number", align: "right"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "deficientQty", collector: "sum", formatter:"number", align: "right"},
                ]]
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

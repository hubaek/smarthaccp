/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하창고출고현황
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
	   	     	url: ["stock","getStockOutList"],
	            data: $.extend({whType:"20",zeroStock:"Y"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {			        	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })       
	     .done(function () {     
	       	
	     });   
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("제품 줄하현황.xls");
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

fnObj.pageResize = function () {

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
            frozenColumnIndex: 0,
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "refSlipCd" ,label:"수주번호", width: 120},
                {key: "etcYn", label: "예외여부", width: 100,  align: "center"},
                {key: "outDt", width: 100,label:"출하일자"},
                {key: "custNm", width: 160},
                {key: "itemCd", width: 140},
                {key: "itemNm", width: 200},    
                //{key: "partNo"},
                {key: "itemQty", label: "출하수량", width: 100, formatter:"number", align: "right"},
                {key: "unit", width: 100},
                {key: "lotNo", width: 120},
                {key: "barcode", width: 120},
                {key: "whCd", width: 120},
                {key: "updatedAt", width: 150},
                {key: "updatedBy"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},     
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: { 
            }
        });        
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.inoutDt&inoutSeq;
            });
        } else {
            list = _list;
        }
        return list;
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

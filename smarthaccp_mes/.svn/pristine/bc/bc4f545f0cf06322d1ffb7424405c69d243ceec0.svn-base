/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하창고재고현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var whType = "20";

//모달 재정의 Start
var customModal = new ax5.ui.modal({
   absolute: true,
   onStateChanged: function onStateChanged() {
       if (this.state === "open") {
           window.axMask.open();
       } else if (this.state === "close") {
           window.axMask.close();
       }  
   }
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
	
	PAGE_CLOSE: function (caller, act, data) {
		parent.ppmboot.modal.close();
    },	
	
	PAGE_SEARCH: function (caller, act, data) {    	
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["stock","stockGroupByAll"],
	   	         data: $.extend({groupByType:"whCd",whType:whType}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {	   	        	 
	   	            caller.gridView01.setData(res); 
	   	         }
	   	 })
	     .done(function () {	       	
	     });   
    },    
   /* //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {

    	var sData = getSerializeArrayToJson("#searchView0");
    	
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["stock","stockGroupByAll"],
	   	         data:{groupByType:"lot",whCd:data.whCd,itemCd:data.itemCd,zeroStock:sData.zeroStock},
	   	         callback: function (res) {	   	        	 
	   	            caller.gridView02.setData(res);
	   	         }
	   	 })
	   	 .call({
	   	     	type: "GET",
	   	         url: ["stock","stockGroupByAll"],
	   	         data:{groupByType:"barcode",whCd:data.whCd,itemCd:data.itemCd,zeroStock:sData.zeroStock},
	   	         callback: function (res) {	   	        	 
	   	            caller.gridView03.setData(res);
	   	         }
	   	 })
	   	 .call({
	   	     	type: "GET",
	   	     	url: ["stock","getStockHistory"],
	            data: {whCd:data.whCd,itemCd:data.itemCd},
	   	        callback: function (res) {			        	 
	   	            caller.gridView04.setData(res);
	   	        }
	   	 })       
	     .done(function () {	       	
	     });   
    }, */   
    //엑셀 다운로드
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("자재창고재고_품목별 리스트.xls");
    	caller.gridView02.target.exportExcel("자재창고재고_LOT별 리스트.xls");
    	caller.gridView03.target.exportExcel("자재창고재고_바코드별 리스트.xls");
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
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
                {key: "itemCd",width: 140},
                {key: "itemNm",width: 500}, 
                //{key: "partNo"},
                {key: "safetyQty",width: 140},   
                {label: "이력", columns: [
	                    {key: "inQty", label: " 입고(+)", width: 120, formatter:"number", align: "right"},
	                    {key: "outQty", label: "출고(-)", width: 120, formatter:"number", align: "right"},
	                    {key: "modQty", label: "조정", width: 120, formatter:"number", align: "right"},
	                ]
	            },
	            {key: "stockQty", label: "<font color='orange'>현재고</font>", width: 140, formatter:"number", align: "right"},
                {key: "unit"},  
                {key: "qcWay",width: 170},   
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 3, align: "center"},     
                    {key: "inQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "outQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: { 
                /*onClick: function () {
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },*/
            }
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




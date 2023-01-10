/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산창고재고현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var whType = "30";

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
	   	        	console.log(res);
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
            scroller: {size: 35},
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
		                {key: "itemCd" ,width: 150},
		                {key: "itemNm", width: 405}, 
		                {key: "spec", align: "right", width: 145}, 
		                {key: "routCd", hidden:true},
		                //2020-07-27 p/n 숨김 처리 최정욱
		                /*{key: "partNo"},*/
		                {key: "safetyQty"},   
		                {key: "wipYn", hidden:true},
		                /*
		                {label: "이력", 
		                		columns: 	[
							                    {key: "inQty", label: "입고(+)"  	,align: "right" },
							                    {key: "outQty", label: "출고(-)" 	,align: "right" },
							                    {key: "modQty", label: "조정"   	,align: "right" },
					                    	], 
			            },
			            */
			            {key:"stockQty", label: "<font color='orange'>현재고</font>", width: 110, align: "right",  formatter:"number"},
		                {key: "unit"},  
		                {key: "qcWay"},   
		              ],
			            footSum: [
			                [  
			                    {label: "합계", colspan: 4, align: "center"},     
			                    //{key: "inQty", collector: "sum", formatter:"number", align: "right"},
			                    //{key: "outQty", collector: "sum", formatter:"number", align: "right"},
			                    //{key: "modQty", collector: "sum", formatter:"number", align: "right"},
			                    {key: "stockQty", collector: "sum", formatter:"number", align: "right" ,width: 150},
			                    {key: "safeQty", collector: "sum", formatter:"number", align: "right" ,width: 150},
			                    
			                ]],
            body: { 
//                onClick: function () {
//                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
//                },
//                trStyleClass: function(){
//                	if(nvl(this.item.wipYn,'N')=='Y'){
//                		return "grid-cell-important1";
//                	}
//                }
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

/**
 * gridView02
 */
//fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
//    initView: function () {
//        var _this = this;
//        this.target = ppmboot.gridBuilder({
//            showLineNumber: true,
//            sortable: true, 
//            multiSort: false,
//            showRowSelector: false, 
//            multiSort:false,
//            lineNumberColumnWidth: 40,
//            rowSelectorColumnWidth: 26,
//            frozenColumnIndex: 0,
//            target: $('[data-ax5grid="grid-view-02"]'),
//            columns: [     {
//                label: "이력", columns: [
//	                    {key: "inQty", label: " 입고(+)", width: 80, formatter:"number", align: "right"},
//	                    {key: "outQty", label: "출고(-)", width: 80, formatter:"number", align: "right"},
//	                    {key: "modQty", label: "조정", width: 80, formatter:"number", align: "right"},
//	                ]
//	            },
//	            {key: "stockQty", label: "<font color='orange'>현재고</font>", width: 80, formatter:"number", align: "right"},
//                {key: "unit"},  
//                {key: "lotNo"},
//                {key: "qcFlag"},
//            ],      
//            footSum: [
//                [  
//                    {key: "inQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "outQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
//                ]],
//                body: {
//                },
//        });        
//    },
//    getData: function (_type) {
//        var list = [];
//        var _list = this.target.getList(_type);
//
//        if (_type == "modified" || _type == "deleted") {
//            list = ax5.util.filter(_list, function () {
//                return this.slipCd;
//            });
//        } else {
//            list = _list;
//        }
//        return list;
//    }
//});
//
///**
// * gridView03
// */
//fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
//    initView: function () {
//        var _this = this;
//        this.target = ppmboot.gridBuilder({
//            showLineNumber: true,
//            sortable: true, 
//            multiSort: false,
//            showRowSelector: false, 
//            multiSort:false,
//            lineNumberColumnWidth: 40,
//            rowSelectorColumnWidth: 26,
//            frozenColumnIndex: 0,
//            target: $('[data-ax5grid="grid-view-03"]'),
//            columns: [     
//                {label: "이력", columns: [
//	                    {key: "inQty", label: " 입고(+)", width: 80, formatter:"number", align: "right"},
//	                    {key: "outQty", label: "출고(-)", width: 80, formatter:"number", align: "right"},
//	                    {key: "modQty", label: "조정", width: 80, formatter:"number", align: "right"},
//	                ]
//	            },
//	            {key: "stockQty", label: "<font color='orange'>현재고</font>", width: 80, formatter:"number", align: "right"},
//                {key: "unit"},  
//                {key: "lotNo"},
//                {key: "barcode"},
//                {key: "qcFlag"},
//            ],      
//            footSum: [
//                [  
//                    {key: "inQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "outQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
//                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
//                ]],
//                body: {
//                },
//        });        
//    },
//    getData: function (_type) {
//        var list = [];
//        var _list = this.target.getList(_type);
//
//        if (_type == "modified" || _type == "deleted") {
//            list = ax5.util.filter(_list, function () {
//                return this.slipCd;
//            });
//        } else {
//            list = _list;
//        }
//        return list;
//    }
//});
//
//
///**
// * gridView04
// */
//fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {
//    initView: function () {
//        var _this = this;
//        this.target = ppmboot.gridBuilder({
//            frozenColumnIndex: 0,
//            showLineNumber: true,
//            sortable: true, 
//            multiSort: false,
//            showRowSelector: false,
//            multipleSelect: false,
//            lineNumberColumnWidth: 40,
//            rowSelectorColumnWidth: 26,
//            target: $('[data-ax5grid="grid-view-04"]'),
//            columns: [
//                {key: "inoutTypeDetail"},
//                {key: "inoutDt",label: "입출고일"},
//                {key: "inoutSeq"},  
//                {key: "itemQty", label: "수량", width: 80, formatter:"number", align: "right"},
//                {key: "updatedAt"},
//                {key: "updatedBy"},
//            ],
//            footSum: [
//                [  
//                    {label: "합계", colspan: 3, align: "center"},     
//                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
//                ]],
//            body: { 
//            }
//        });        
//        
//    },
//    getData: function (_type) {
//        var list = [];
//        var _list = this.target.getList(_type);
//
//        if (_type == "modified" || _type == "deleted") {
//            list = ax5.util.filter(_list, function () {
//                return this.inoutDt&inoutSeq;
//            });
//        } else {
//            list = _list;
//        }
//        return list;
//    }
//});
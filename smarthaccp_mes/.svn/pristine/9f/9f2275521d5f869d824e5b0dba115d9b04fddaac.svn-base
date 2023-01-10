/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 기간별생산현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var master;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["worderList" ,"orderList1"],
	   	         data: $.extend({orderSt:"END"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {    	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })  
	       .done(function () {
	       });   
    },   
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("기간별생산현황.xls");
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

fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    
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
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
        });
    }
});

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
                {key: "startDt", label: "작업시작",width: 120, align: "center"},
                {key: "orderNo",width: 120},
                {key: "routCd",width: 110, align: "center"}, 
            	{key: "equipCd",width: 110, align: "center"},
                {key: "itemCd",width: 110, align: "center"},
                {key: "itemNm",width: 310,},
               
                {
                    label: "생산수량", columns: [
                        {key: "orderQty", label: "지시수량",width: 90, formatter:"number", align: "right"},
                        {key: "prodQty", label: "생산수량",width: 90, formatter:"number", align: "right"},
                        {key: "goodQty", label: "양품수량",width: 90, formatter:"number", align: "right"},
                        {key: "badQty", label: "불량수량",width: 90, formatter:"number", align: "right"},
                        {key: "orderPer", label: "생산율(%)",width: 90, formatter:"number", align: "right"},
                        {key: "yyPercent" , label:"양품율(%)" , width:100, formatter:"number", align: "right"},
                    ]
                },
               
                {
                    label: "KPI", columns: [
                    	{key: "hourQty" , label:"시간당 생산량" , width:100, formatter:"number", align: "right"},
                    	{key: "badPer", label: "불량율(%)",width: 100, formatter:"number", align: "right"},
                    	
                    ]
                },
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "orderQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "prodQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "goodQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "badQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "orderPer", collector: "avg", formatter:"number", align: "right"},
                    {key: "yyPercent", collector: "avg", formatter:"number", align: "right"},
                  
                    {key: "hourQty", collector: "avg", formatter:"number", align: "right"},
                    {key: "badPer", collector: "avg", formatter:"number", align: "right"},
                   
                ]],
            body: {
            	onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
            }
        });

    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    }
});
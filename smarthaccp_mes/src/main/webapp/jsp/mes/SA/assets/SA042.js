/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 매출미마감
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
	   	         url: ["order","itemList"],
	   	         data: $.extend({remainYn:"Y",searchType:"S"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })      
	    .done(function () {
	     	
	    });   
    },    
    //조회
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: "SA030M",
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"slipCd" : data.slipCd
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });    	
    },
    //엑셀 다운로드
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("_전체 리스트.xls");
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


//== view 시작
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
                {key: "slipDt"},
                {key: "slipCd",label:"수주번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "remainYn",label:"수주/판매"},
                {key: "custNm"},
                {key: "userNm"},
                {key: "saOrderDt", label: "수주일자", width: 80, align: "center"},
                {key: "saDeliveryDt", label: "납기일자", width: 80, align: "center"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"}, 
                {key: "unit"}, 
                {
                    label: "수량정보", columns: [
                        {key: "itemQty" , label:"수주수량"},
                        {key: "useQty" , label:"매출수량"},
                        {key: "endQty"},
                        {key: "remainQty" , label:"<font color=yellow>미납수량</font>",formatter:"number", align: "right"},
                    ]
                },
                {key: "surtaxYn"},
                {key: "unitAmt"},
                {key: "supplyAmt"},
                {key: "surtaxAmt"},
                {key: "totalAmt"},
                {key: "itemRemark"}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 15, align: "center"},
                    {key: "remainQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "", collector: "sum", formatter:"number", align: "right"},
                    {key: "unitAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "supplyAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "surtaxAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "slipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
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
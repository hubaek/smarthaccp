/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 매출(매출)현황
 * 4. 변경이력  : 
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
	   	         url: ["sales","itemList"],
	   	         data: $.extend({}, getSerializeArrayToJson("#searchView0")),
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
            modalType: "SA040M",
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
            sortable: true, 
            multiSort: false,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "slipDt"},
                {key: "slipCd",label:"매출번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "custNm"},
                {key: "saDt", label: "매출일자", width: 80, align: "center"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "surtaxYn"},
                {key: "itemQty" , label:"매출수량"},
                {key: "unitAmt"},
                {key: "supplyAmt"},
                {key: "surtaxAmt"},
                {key: "totalAmt"},
                {key: "itemRemark"}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 9, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
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
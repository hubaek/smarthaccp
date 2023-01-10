
var fnObj = {};
var param;
var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_CLOSE: function (caller, act, data) { 
        if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal3.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["estimate","itemList"],
	   	         data: $.extend({remainYn:"Y"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })
	     .done(function () {
	       	
	     });   
        return false;
    },    
    PAGE_CHOICE: function (caller, act, data) {    	
    	var list = caller.gridView01.getData("selected");
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal3.callback(list);
        	}else{
        		parent[param.callBack](list);
        	}
        } else {
            alert(LANG("ax.script.requireselect"));
        }
    },
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {    	
    	 ppmboot
		 .call({
		     	type: "GET",
		         url: ["estimate","itemList"],
		     	data: {slipCd: data.slipCd},
		         callback: function (res) {
  
		            caller.gridView02.setData(res);
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
	param = parent.ppmboot.modal3.getData();
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
            sortable: true, 
            multiSort: false,
            showRowSelector: true, 
            multipleSelect: true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "slipDt"},
                {key: "slipCd",label:"견적번호"},
                {key: "remainYn",label:"견적상태"},
                {key: "custNm"},
                {key: "deliveryDt", label: "납기일자", width: 80, align: "center"},
                {key: "userNm"},
                {key: "validity"},
                {key: "paymentTerms"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"},  
                {key: "unit"},  
            	{
                    label: "수량정보", columns: [
                        {key: "itemQty" , label:"견적수량"},
                        {key: "useQty" , label:"수주수량"},
                        {key: "endQty"},
                        {key: "remainQty" , label:"<font color=yellow>견적잔량</font>",formatter:"number", align: "right"},
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
                    {label: "합계", colspan: 12, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "useQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "endQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "remainQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "", collector: "sum", formatter:"number", align: "right"},
                    {key: "unitAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "supplyAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "surtaxAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {    
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
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 수주대비 출하현황
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
	   	         data: $.extend({searchType:"S"}, getSerializeArrayToJson("#searchView0")),
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
 * gridView01	수주목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    page: {
        pageNumber: 0,
        pageSize: 20
    },
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
                {key: "remainYn2",label:"수주/출하"},
                {key: "custNm"},
                {key: "saOrderDt", label: "수주일자", width: 80, align: "center"},
                {key: "saDeliveryDt", label: "납기일자", width: 80, align: "center"},
                {key: "diffDt", label: "경과일", width: 80, align: "center" , formatter:function(){
                	if(this.value > 0){
                		return "<font color=red>"+this.value+"</font>";
                	}else{
                		return this.value;
                	}
                }},    
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "spec"}, 
                {key: "unit"}, 
            	{
                    label: "수량정보", columns: [
                        {key: "itemQty" , label:"수주수량"},
                        {key: "useQty2" , label:"출하수량"},
                        {key: "remainQty2" , label:"<font color=yellow>출하잔량</font>",formatter:"number", align: "right"},
                    ]
                },
                {key: "itemRemark"}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 12, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "useQty2", collector: "sum", formatter:"number", align: "right"},
                    {key: "remainQty2", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "slipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
                },
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
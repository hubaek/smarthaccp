/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 구매입고현황
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
	   	         url: ["purchase","itemList"],
	   	         data: $.extend({}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
		   	     	for(var i = 0; i < res.list.length; i++){
			   	     	let surtaxYn = nvl(res.list[i].surtaxYn,'N');
		   	        	let exchangeRate = nvl(res.list[i].exchangeRate,1);
		   	        	let toFixed = 0;
		   	        	
		   	     		res.list[i].totalQty = Number(res.list[i].itemQty) - Number(res.list[i].cancelQty);
		   	     		res.list[i].supplyAmt= (Number(res.list[i].totalQty) * Number(res.list[i].unitAmt) * Number(exchangeRate)).toFixed(toFixed);
		   	     		if(surtaxYn == "N"){ 
		   	     			res.list[i].surtaxAmt = 0;
		   	     		}else{
		   	     			res.list[i].surtaxAmt = (Number(res.list[i].supplyAmt) * 0.1).toFixed(toFixed);
		   	     		}
		   	     		res.list[i].totalAmt = (Number(res.list[i].supplyAmt) + Number(res.list[i].surtaxAmt)).toFixed(toFixed);
		   	     	}
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })  
	    .done(function () {
	     	
	    });   
    },    
    //조회
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: "PC030M",
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
    VIEW_REF_FORM: function (caller, act, data) {
    	if(nvl(data.refSlipCd,'') == ''){
    		return false;
    	}
    	ppmboot.modal.open({  
            modalType: "PC020M",
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"slipCd" : data.refSlipCd
                };
            },
            callback: function (data) {
            }
        });    	
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("원재료 입고현황.xls");
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
                {key: "slipDt"},
                /*{key: "refSlipCd",label:"발주번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},*/
            	{key: "slipCd", label: "구매번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "remainYn",label:"구매마감", hidden:true},
                {key: "custNm"},
                {key: "itemCd"},
                {key: "itemNm", width:"*"},
                {key: "spec"},
                //{key: "partNo"},
                {key: "whCd",label: "입고창고"},
                {key: "lotNo"},
                //{key: "barcodeQty"},
                //{key: "qcWay"},
                
                {key: "pdUnit"},
            	{
                    label: "수량정보", columns: [
                        {key: "itemQty" , label:"구매수량"},
                        {key: "cancelQty" , label:"취소수량"},
                        {key: "totalQty" , label:"취소수량"},
                        //{key: "useQty" , label:"매입마감"},
                    ]
                },
                {key: "surtaxYn"},
                {key: "unitAmt"},
                {key: "supplyAmt"},
                {key: "surtaxAmt"},
                {key: "totalAmt"},
                //{key: "itemRemark"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 13, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "cancelQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "useQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "", collector: "sum", formatter:"number", align: "right"},
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

                	if(this.column.key == "refSlipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_REF_FORM,this.item);
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
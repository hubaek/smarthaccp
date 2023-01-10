/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 구매입고
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "PC030M";
var CANCEL_MODAL = "PC040M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["purchase","header"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        });
        return false;
    },    
    //상세조회
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["purchase","itemList"],
	   	     	data: {slipCd: data.slipCd},
	   	         callback: function (res) {
	   	        	let mlist = caller.gridView01.getData("selected");
	   	        	let surtaxYn = nvl(mlist[0].surtaxYn,'N');
	   	        	let exchangeRate = nvl(mlist[0].exchangeRate,1);
	   	        	let toFixed = 0;
	   	        	let idx=0;
		   	     	
		   	     	for(var i = 0; i < res.list.length; i++){
		   	     		res.list[i].totalQty = Number(res.list[i].itemQty) - Number(res.list[i].cancelQty);
		   	     		res.list[i].supplyAmt= (Number(res.list[i].totalQty) * Number(res.list[i].unitAmt) * Number(exchangeRate)).toFixed(toFixed);
		   	     		if(surtaxYn == "N"){ 
		   	     			res.list[i].surtaxAmt = 0;
		   	     		}else{
		   	     			res.list[i].surtaxAmt = (Number(res.list[i].supplyAmt) * 0.1).toFixed(toFixed);
		   	     		}
		   	     		res.list[i].totalAmt = (Number(res.list[i].supplyAmt) + Number(res.list[i].surtaxAmt)).toFixed(toFixed);
		   	     	}
	   	     	   
	   	            caller.gridView02.setData(res);
	   	         }
	   	 	})    
	   	 	.call({
				type: "GET",
				url: ["purchaseReturn","itemList"],
				data: {refSlipCd: data.slipCd},
				callback: function (res) {
					caller.gridView03.setData(res);
				}
			})  
	       .done(function () {
	       });  
    },   
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "add"
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    //입고취소 작성
    CANCEL_FORM: function (caller, act, data) {
    	var mlist = caller.gridView01.getData("selected");
    	var mlist2 = caller.gridView01.getData("selected");
    	mlist2[0].slipCd = "";
    	
        if(mlist.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
        	axDialog.confirm({
                msg: "[입고취소] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {
                	ppmboot.modal.open({  
                        modalType: CANCEL_MODAL,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "add",
                            	"slipCd" : mlist[0].slipCd,
                            	"mlist" : mlist2
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });
                	
                }
            });
        }
    },
    //수정
    MOD_FORM: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
        	
        	/*axDialog.alert({
                theme: "primary",
                msg: "완료건은 수정할 수 없습니다."
            });
        	return false;*/
        	
        	axDialog.confirm({
                msg: "[수정] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {

                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "mod",
                            	"company" : list[0].company,
                            	"slipCd" : list[0].slipCd
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });  
                	
                }
        	});
        }
    },
    /*//조회
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
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
    },*/
     
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
    CODE = this;
    
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();
    
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
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.CANCEL_FORM);
            },
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
 * gridView01	구매서목록
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
                {key: "slipDt",width: 140},
                {key: "slipCd",width: 128,label:"구매번호"},
                {key: "custNm",width: 250},
                {key: "whCd", label: "입고창고",width: 120},
                {key: "userNm", align: "center"},
                //{key: "surtaxYn",width: 190},
                {key: "sumItemQty",width: 140},
                //{key: "sumSupplyPrice",width: 200},
                //{key: "sumSurtax",width: 200},
                //{key: "sumTotalPrice",width: 200},
                //{key: "updatedAt",width: 160},
                //{key: "updatedBy",width: 170},
                {key: "remark",width: "*"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 5, align: "center"},
                    {key: "sumItemQty", collector: "sum", formatter:"number", align: "right"},
                    //{key: "sumSupplyPrice", collector: "sum", formatter:"number", align: "right"},
                    //{key: "sumSurtax", collector: "sum", formatter:"number", align: "right"},
                    //{key: "sumTotalPrice", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key != "slipCd") {  
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    }
                },
                /*onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "slipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
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

/**
 * gridView02 구매입고 상세목록
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "refSlipCd",label:"발주번호", hidden:true,formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "remainYn",label:"구매마감", hidden:true},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd", width:150},
                        {key: "itemNm", width:"*"},
                        //{key: "partNo"},
                        {key: "spec"},
                        {key: "unit"},
                        
                    ]
                },
                {
                    label: "입고정보", columns: [
                        {key: "lotNo", width:100},
                        //{key: "barcode", width:100},
                        //{key: "qcWay"},
                        {key: "itemQty" , label:"입고수량", width:120},
                        {key: "cancelQty" , label:"취소수량", width:120},
                        {key: "totalQty" , label:"총수량", width:120},
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "unitAmt", width:120},
                        {key: "supplyAmt", width:120},
                        {key: "surtaxAmt", width:120},
                        {key: "totalAmt", width:120},
                    ]
                },
                //{key: "itemRemark",width: 330}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "cancelQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "unitAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "supplyAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "surtaxAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {
                /*onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "refSlipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_REF_FORM,this.item);
                	}
                },*/
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

/**
 * gridView03 구매취소 상세목록
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "slipCd",label:"취소번호", width:150},
                //{key: "remainYn",label:"구매마감", hidden:true},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd", width:150},
                        {key: "itemNm", width:305},
                        //{key: "partNo"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                }, 
                {
                    label: "입고정보", columns: [
                        //{key: "whCd", label: "입고창고",width: 100},
                        {key: "lotNo", width:100},
                        {key: "barcode", width:100},
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "itemQty",label:"취소수량", width:120},
                        {key: "unitAmt", width:120},
                        {key: "supplyAmt", width:120},
                        {key: "surtaxAmt", width:120},
                        {key: "totalAmt", width:120},
                    ]
                }
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 7, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
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
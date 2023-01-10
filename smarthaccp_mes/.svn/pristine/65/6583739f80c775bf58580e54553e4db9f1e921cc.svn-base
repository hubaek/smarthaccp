/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 매입마감등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "PC050M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["purchaseEnd","header"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        });
        return false;
    },    

    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	axDialog.confirm({
            msg: "[신규등록] 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
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
            	
            }
        });
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
    //복사
    COPY_FORM: function (caller, act, data) {
    	var list = caller.gridView01.getData("selected");
        if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
    		
        	axDialog.confirm({
                msg: "[복사등록] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {

                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "copy",
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
    //조회
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
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["purchaseEnd","itemList"],
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
            return false;
        }
    }
});

fnObj.pageStart = function () {
    var _this = this;

    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();

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
        		//신규 추가
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
        		// 수정
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
            "fn3": function () {
        		// copy
                ACTIONS.dispatch(ACTIONS.COPY_FORM);
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
 * gridView01	매입마감서목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [

                {key: "slipDt", width: 180},
            	{key: "slipCd", width: 180, label: "마감번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "custNm", width: 200},
                {key: "userNm", width: 120},
                {key: "pcDt", label: "매입일자", width: 100, align: "center"},
                {key: "surtaxYn", width: 100},
                {key: "sumItemQty", width: 158},
                {key: "sumSupplyPrice", width: 160},
                {key: "sumSurtax", width: 200},
                {key: "sumTotalPrice", width: 200},
//                {key: "updatedAt", width: 160},
//                {key: "updatedBy", width: 158},
            ],
            footSum: [
                [  
                    {label: "합계", colspan:6, align: "center"},
                    {key: "sumItemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumSupplyPrice", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumSurtax", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumTotalPrice", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key != "slipCd") {  
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    }
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "slipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                	}
                },
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
 * gridView02 상세목록
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
                {key: "refSlipCd",label:"구매번호",width:160},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd"},
                        {key: "itemNm"},
                        //{key: "partNo"},
                        {key: "spec", editor: "text"},
                        {key: "unit"},
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "itemQty"},
                        {key: "unitAmt"},
                        {key: "supplyAmt"},
                        {key: "surtaxAmt"},
                        {key: "totalAmt"},
                    ]
                },
                {key: "itemRemark",width:510}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
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
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 재고실사등록_자재
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */


var fnObj = {};
 var whType = "10";	//자재창고
 var wipYn = "N"; 	//재공여부

 var ACTIONS = ppmboot.actionExtend(fnObj, {
     PAGE_SEARCH: function (caller, act, data) {
     	ppmboot.ajax({
             type: "GET",
             url: ["modify"],
             data: $.extend({whType:whType,wipYn:wipYn}, getSerializeArrayToJson("#searchView0")),
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
            msg: "신규 재고실사를 등록 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	ppmboot.modal.open({  
                    modalType: "ST110M",
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
    MOD_FORM: function (caller, act, data) {
    	axDialog.alert({
            theme: "primary",
            msg: "완료건은 수정할 수 없습니다."
        });
    	return false;
    },
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["modify","itemList"],
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
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
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
 * gridView01	실사목록
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
                {key: "slipCd",label:"실사번호",width:200},
                {key: "slipDt",width:200},
                {key: "whCd",width:298},
                {key: "modifyType",width:300},
                {key: "userNm",width:300},
                {key: "sumItemQty",width:300},
//                {key: "updatedAt",width:200},
//                {key: "updatedBy",width:198},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
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
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd",width:200},
                        {key: "itemNm",width:230},
                        //{key: "partNo"},
                        {key: "spec",width:200},
                        {key: "unit",width:200},
                    ]
                },
            	{
                    label: "재고정보", columns: [
                        {key: "lotNo",width:160},
                        {key: "barcode",width:160}
                    ]
                },
            	{
                    label: "수량정보", columns: [
                        {key: "preItemQty",label: "이전재고",width:160},   
                        {key: "modQty", label: "실사수량",width:160}, 
                        {key: "itemQty",label: "조정수량",width:160}, 
                    ]
                },
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "preItemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "modQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
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
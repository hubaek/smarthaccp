/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산일보
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
	   	            caller.gridView02.setData([]); 
		            caller.gridView03.setData([]);
		            caller.gridView04.setData([]);
		            caller.gridView05.setData([]);
		            caller.gridView06.setData([]);
	   	         }
	   	 })  
	       .done(function () {
	       });   
    },    
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	master = data;
    	ppmboot
	        //자재출고목록	
	        .call({
	                type: "GET",
	                url:  ["worderList","outgoingList"],
		            data: {wlotNo:data.wlotNo, discardYn:"N"},
	                callback: function (res) {
	                    caller.gridView02.setData(res);
	                }
	        })
	        //불량유형	
	        .call({
	                type: "GET",
	                url:  ["worderList","badList"],
		            data: {wlotNo:data.wlotNo},
	                callback: function (res) {
	                    caller.gridView03.setData(res);
	                }
	        })
	        //비가동	
	        .call({
	                type: "GET",
		   	         	url: ["worderList" ,"nwrkList"],
		            data: {wlotNo:data.wlotNo},
	                callback: function (res) {
	                    caller.gridView04.setData(res);
	                }
	        })
	        //작업자정보
	        .call({
	            type: "GET",
	            url:  ["worderList","workManList"],
	            data: {wlotNo:data.wlotNo},
	            callback: function (res) {
	            	console.log(res);
	                caller.gridView05.setData(res);
	            }
	        })
	        //작업자정보
	        .call({
	            type: "GET",
	   	        url: ["worderList" ,"incomingList"],
	            data: {wlotNo: data.wlotNo},
	            callback: function (res) {
	                caller.gridView06.setData(res);
	            }
	        })
	        .done(function () {
	        });
	    
	    return false;
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
    _this.gridView03.initView();
    _this.gridView04.initView();
    _this.gridView05.initView();
    _this.gridView06.initView();
    
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
        ppmboot.buttonClick(this, "data-searchview-btn", {
            "cust_modal": function () {
                ACTIONS.dispatch(ACTIONS.CUST_MODAL_OPEN)
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
                {key: "startDt", label: "작업시작",width: 80, align: "center"},
                {key: "orderNo"},
                {key: "routCd"}, 
            	{key: "equipCd",width: 150},
                //{key: "orderSt"},
                //{key: "routQcYn"},
                //{key: "outYn"},
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},
                {key: "startDtm"},
                {key: "endDtm"},
                {key: "cycleTime", label: "C/T(초)",width: 80, formatter:"number", align: "right"},
                {key: "cavity", label: "C/V",width: 80, formatter:"number", align: "right"},
                {key: "routUnitAmt", label: "공정단가",width: 80, formatter:"number", align: "right"},
                {
                    label: "생산수량", columns: [
                        {key: "orderQty", label: "지시수량",width: 80, formatter:"number", align: "right"},
                        {key: "prodQty", label: "생산수량",width: 80, formatter:"number", align: "right"},
                        {key: "goodQty", label: "양품수량",width: 80, formatter:"number", align: "right"},
                        {key: "badQty", label: "불량수량",width: 80, formatter:"number", align: "right"},
                        {key: "badPer", label: "불량율(%)",width: 80, formatter:"number", align: "right"},
                        {key: "orderPer", label: "생산율(%)",width: 80, formatter:"number", align: "right"},
                    ]
                },

                {
                    label: "가동내역", columns: [
                    	{key: "jobTm" , label:"부하시간(분)" , width:100, formatter:"number", align: "right"},
                    	{key: "stdTm" , label:"표준시간(분)" , width:100, formatter:"number", align: "right"},
                    	{key: "nwrkTm" , label:"비가동(분)" , width:100, formatter:"number", align: "right"},
                    	//{key: "planNwrkTm" , label:"계획비가동(분)" , width:100, formatter:"number", align: "right"}
                    ]
                },
                {
                    label: "생산성", columns: [
                    	{key: "ggPercent" , label:"설비가동율(%)" , width:100, formatter:"number", align: "right"},
                    	{key: "ppPercent" , label:"성능가동율(%)" , width:100, formatter:"number", align: "right"},
                    	{key: "yyPercent" , label:"양품가동율(%)" , width:100, formatter:"number", align: "right"},
                    	{key: "ttPercent" , label:"설비종합효율(%)" , width:100, formatter:"number", align: "right"}
                    ]
                },
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 19, align: "center"},
                    {key: "badPer", collector: "avg", formatter:"number", align: "right"},
                    {key: "orderPer", collector: "avg", formatter:"number", align: "right"},
                    
                    {key: "jobTm", collector: "sum", formatter:"number", align: "right"},
                    {key: "stdTm", collector: "sum", formatter:"number", align: "right"},
                    {key: "nwrkTm", collector: "sum", formatter:"number", align: "right"},
                    {key: "planNwrkTm", collector: "sum", formatter:"number", align: "right"},

                    {key: "ggPercent", collector: "avg", formatter:"number", align: "right"},
                    {key: "ppPercent", collector: "avg", formatter:"number", align: "right"},
                    {key: "yyPercent", collector: "avg", formatter:"number", align: "right"},
                    {key: "ttPercent", collector: "avg", formatter:"number", align: "right"},
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

/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [

                {key: "itemCd",width:120, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
                {key: "itemNm",width:200, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
            	{
                    label: "불출(소요단위)", columns: [
                        {key: "lotNo", width: 120},
                        {key: "barcode", width: 120},
                        {key: "bomItemQty", label: "투입수량", width: 120, formatter:"number", align: "right"},
                        {key: "transConsumQty", label: "소모수량", width: 120, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                    ]
                },	
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
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
 * gridView03	불량
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "badDtm", label: "발생시간",width: 130, align: "center", formatter:function(){
                	return convertStringToTimestamp(this.value)
                }},
                {key: "badCd"}, 
                {key: "badItemQty", label: "불량수량", width: 80, formatter:"number", align: "right"},
                {key: "unit"},
                
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
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
                return this.badSeq;
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
 * gridView04	비가동
 */
fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-04"]'),
            columns: [
                {key: "nwrkCd",width:200},
                { 
                    label: "시작", columns: [
                        {key: "nwrkDt", label: "시작일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"nwrkHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"nwrkMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
                { 
                    label: "종료", columns: [
                        {key: "nwrkedDt", label: "종료일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"nwrkedHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"nwrkedMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
            ],
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
                return this.nwrkSeq;
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
 * gridView05	작업자
 */
fnObj.gridView05 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-05"]'),
            columns: [
                {key: "userCd", label: "사용자ID", width:100, align: "center"},
                {key: "userNm", label: "사용자명", width:100, align: "center"},
                { 
                    label: "시작", columns: [
                        {key: "wrkDt", label: "시작일", width: 80, align: "center"},
        				{key:"wrkHour", label: "시간",width:60, align: "center"},       
        				{key:"wrkMinute", label: "분",width:60, align: "center"},   
                    ]
                },
                { 
                    label: "종료", columns: [
                        {key: "wrkedDt", label: "종료일", width: 80, align: "center"},
        				{key:"wrkedHour", label: "시간",width:60, align: "center"},       
        				{key:"wrkedMinute", label: "분",width:60, align: "center"},   
                    ]
                },
                {key: "prodQty", label: "생산수량", width: 80, formatter:"number", align: "right"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
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
                return this.userSeq;
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
 * gridView06 생산실적
 */
fnObj.gridView06 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-06"]'),
            columns: [
                {key: "lotNo"},
                {key: "barcode"},
                {key: "itemQty"},
                {key: "unit"},
                {key: "updatedAt",label:"실적시간",width:200}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
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
                return this.woSeq;
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
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 비가동현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	console.log(getSerializeArrayToJson("#searchView0"));
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["worderList" ,"nwrkList"],
	   	         data: $.extend({}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {    	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })  
	       .done(function () {
	       	
	       });   
    },  
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("비가동현황.xls");
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
                {key: "equipCd"},
                {key: "itemCd"},
                {key: "itemNm"},  
                {key: "nwrkCd", width:200},
                {key: "nwrkDtm", label: "시작일시",width: 130, align: "center", formatter:function(){
                    	return convertStringToTimestamp(this.value)
                }},
                {key: "nwrkedDtm", label: "종료일시",width: 130, align: "center", formatter:function(){
                	return convertStringToTimestamp(this.value)
                }},
            	{key: "nwrkTm" , label:"비가동시간(분)" , width:100, formatter:"number", align: "right"}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 9, align: "center"},
                    {key: "nwrkTm", collector: "sum", formatter:"number", align: "right"}
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
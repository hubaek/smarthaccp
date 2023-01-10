/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산계획등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
	
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	
    	var planDt = getSerializeArrayToJson("#searchView0").planDt;
    	var planDts = planDt.split("-");
    	var planYy = planDts[0];
    	var planMm = planDts[1];
    	var planDd = planDts[2];
    	
    	ppmboot.ajax({
            type: "GET",
            url:  ["workPlan","month"],
            data: $.extend({itemTypeGroup:"P",planYy:planYy,planMm:planMm}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
            	var planDt = getSerializeArrayToJson("#searchView0").planDt;
            	if(nvl(planDt,'') != ''){
                	
                	var lastDay = ( new Date( planYy, planMm, 0) ).getDate();
                	var colGroup = new Array();           	
                	var addData; 
                	for(i = Number(planDd) ; i <= lastDay ; i++){
        				addData = {key:"day"+i+"Qty", label: i
                				,width:70,  align: "right",formatter: "number" ,styleClass:"grid-cell-blue", editor: {type: "number"}
                		}
                		colGroup.push(addData); 
                	}
            		var defaultColumnCnt = 8;
            		var cIdx = 8;                	
            		if(caller.gridView01.target.columns.length > defaultColumnCnt){
                		caller.gridView01.target.removeColumn(cIdx);
                	}
            		caller.gridView01.target.addColumn( { label: planMm + "월 생산계획", columns: colGroup }, cIdx);    
                    caller.gridView01.setData(res);
            	}else{
                	axDialog.alert({
                        theme: "primary",
                        msg: "계획일자를 입력하세요."
                    });
                	return false;
            	}
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	var planDt = getSerializeArrayToJson("#searchView0").planDt;
    	var planDts = planDt.split("-");
    	var planYy = planDts[0];
    	var planMm = planDts[1];
    	var planDd = planDts[2];
    	
    	var lastDay = ( new Date( planYy, planMm, 0) ).getDate();
    	
        var dData = [].concat(caller.gridView01.getData("modified"));    
        var aJsonArray = new Array();
        var aJson = new Object();
        
        dData.forEach(function (n) {
        	
        	for (var i = Number(planDd); i <= lastDay; i++)
    		{
        		var aJson = new Object();
            	aJson.company = "1000";
            	aJson.itemCd = n.itemCd;
            	aJson.planYy = planYy;
            	aJson.planMm = pad(planMm, 2);
            	aJson.planDd = pad(i, 2);
            	aJson.planDt = planYy+"-"+pad(planMm, 2)+"-"+pad(i, 2);
            	aJson.planQty = nvl(eval('n.day' + i + "Qty"), 0);
                aJsonArray.push(aJson);
    		}
        });
        
        console.log(aJsonArray);
        
        
 	    ppmboot
         .call({
	           type: "PUT",
	           url: ["workPlan"],
	           data: JSON.stringify(aJsonArray),
            callback: function (res) {
            }
        })
        .done(function () {
            axToast.push("저장 되었습니다.");
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("생산계획등록.xls");
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
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
        
        $("#planDt").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},   
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "unit"},
                {key: "safetyQty"},
                {key: "stockQty", label: "현재고"},
                {key: "totalPlanQty", label: "월합계", formatter:"number", align: "right",width:80},
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function () {    	
        this.target.addRow({__created__: true, useYn: "Y"}, "last");
    }
});
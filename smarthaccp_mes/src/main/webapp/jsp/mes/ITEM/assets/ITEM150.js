/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  	: 팔피엠_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산자재기준정보
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["item"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });   	 
        return false;
    },        
    PAGE_SAVE: function (caller, act, data) {
        var dData = [].concat(caller.gridView01.getData("modified"));
        ppmboot
            .call({
                type: "PUT", 
                url: ["item","saveItemOptions"], 
                data: JSON.stringify(dData),
                callback: function (res) {
                }
            })
            .done(function () {
                axToast.push("저장 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            });
    },
    CHANGE_UNIT: function (caller, act, data){
    	var dindex = data.dindex;   
    	calcUnit(dindex);
    },
  //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("생산품목 기준정보.xls");
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
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "UNIT",useYn:"Y"},
        callback: function (res) {        		
            this.UNIT = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
        
        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    });
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
    }
});

/**
 * gridView01	품목정보목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
        	showLineNumber: true,
        	sortable: true, 
        	multiSort: false,
        	showRowSelector: true,
        	multipleSelect: false,
        	frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "spec"},
                //{key: "partNo"},     
                {key: "itemType"},
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},      
                {key: "stockQty", label:"재고"},
                {key: "safetyQty", editor: {type: "number"} ,styleClass: "grid-cell-blue"} ,     
                {key: "autoFifoYn", label: "자동선출", editor: "checkYn",align:"center", width:100,styleClass: "grid-cell-blue"},  
           //     {key: "fifoYn", label: "선입선출", editor: "checkYn",align:"center", width:100,styleClass: "grid-cell-blue"},    
				{key: "unit", label: "수불단위",width:100, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.UNIT
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["UNIT"].map[this.value];
					},styleClass:"grid-cell-select"
				},				
            	{
                    label: "소요(수불>소요)", columns: [
        				{key: "bomUnit", label: "소요단위",width:80, align: "center",
                			editor: {type: "select", 
            					config: {columnKeys: {
                   	    					optionValue: "subCd", optionText: "subNm"
           	    						}, options: CODE.UNIT
            					}
        					}, formatter: function formatter() {
        		    					return CONVERT_CODE["UNIT"].map[this.value];
        					},styleClass:"grid-cell-select"
        				},	
                        {key: "bomTrans",label:"소요단위수량",formatter:"number",width:90, align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"}
                    ]
                },			
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                },
		        onDataChanged: function () {  	
		        	if(this.key == "unit" || this.key == "bomUnit") {
		                ACTIONS.dispatch(ACTIONS.CHANGE_UNIT,this);
                    }
		        }
            }
        });        
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
    }
});

/*
 * 전체계산
 */
function calcUnit(dindex){  
	var obj = fnObj.gridView01;	
	var list = obj.getData();  
	var idx = 0 ;
	if(list.length > 0){
		list.forEach(function (n) {
			if((dindex == idx || dindex == 999)){
				n.bomUnit = nvl(n.bomUnit,n.unit);
	
				if((n.unit == 'KG' && n.bomUnit == 'GR') || n.unit == 'MT' && n.bomUnit == 'CM'){
					n.bomTrans = 1000;
				}else if (n.unit == 'MT' && n.bomUnit == 'CM'){
					n.bomTrans = 100;					
				}else{
					if(n.unit == n.bomUnit){
						n.bomTrans = 1;					
					}else{
						n.bomTrans = '';
					}
				}
			}
			idx++;
	    }); 
	}
	obj.setData(list);  	
}
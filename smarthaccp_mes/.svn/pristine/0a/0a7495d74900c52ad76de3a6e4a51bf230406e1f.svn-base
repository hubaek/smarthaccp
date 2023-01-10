/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하창고 입고등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var whType = "30";

var prdUseYn = "N";
var zeroStock = "N";
var itemTypeGroup = "P"; //  'P' ( 공통코드 ITEM_TYPE : option1) 
var wipYn = "N";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {    	    	
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["stock","stockGroupByAll"],
	   	         data: $.extend({groupByType:"barcode",prdUseYn:prdUseYn,zeroStock :zeroStock,itemTypeGroup:itemTypeGroup,wipYn:wipYn}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {			        
	   	        	res.list.forEach(function (n) {
	   	        		n.itemQty = n.stockQty;
	                });	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })       
	     .done(function () {     
	       	
	     });   
    },
    PAGE_SAVE: function (caller, act, data) {
         axDialog.confirm({
             theme: "danger",
             msg: "<font color=red>출하창고 입고처리 하시겠습니까?</font>"
         }, function () {
         	if(this.key == "ok")
         	{
	       	  	 var dData = [].concat(caller.gridView01.getData("selected"));   
	       	  	 var itemQtyCnt1 = 0;
	       	  	 var itemQtyCnt2 = 0;
		         var detailSize = dData.length;
		        
		         dData.forEach(function (n) {
		        	if (nvl(n.itemQty,0) == 0){
		        		itemQtyCnt1++;
		        		return false;
		        	}  
		        	if (nvl(n.toWarehouse,'') == ''){
		        		itemQtyCnt2++;
		        		return false;
		        	}  
		        	
		        	n.inoutDt = getNowDt();
		        });
		         
		        if(itemQtyCnt1 > 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "입고 수량이 0 입니다."
		             });	          
		        }
		        else if(itemQtyCnt2 > 0){
		         	 axDialog.alert({
		                 theme: "warning",
		                 msg: "입고창고를 입력하세요."
		           });
		        }else if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "선택된  품목정보가 없습니다."
		             });
		          	 return false;
		        }else{  
		        	ppmboot.ajax({
	    		     	type: "PUT",
	    		     	url: ["stock","salesInItem"],
	    		     	data: JSON.stringify(dData),
	    		         callback: function (res) {       
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        }	    	     
             }
         });
    },
    SELECT_ALL_WAREHOUSE: function (caller, act, data) {
  	  	var sData = [].concat(caller.gridView01.getData("selected"));   
        var detailSize = sData.length;
        
        if(detailSize == 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "선택된  품목정보가 없습니다."
         	 });
         	 return false;
        	
        }else{
        	var dData = [].concat(caller.gridView01.getData());   
      	  	var toWarehouse = $("#toWarehouse").val();
      	  	
            dData.forEach(function (n) {
            	if(n.__selected__ == true)
            		n.toWarehouse = toWarehouse;
    	    });  
            caller.gridView01.setData(dData);
        }
    },    
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("제품입고등록.xls");
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
	        url: ["whCd"],
	        data: {whType: "20" , useYn:"Y"},
	        callback: function (res) {        		
	        	res.list.forEach(function (n) {   
	    			n.subCd = n.whCd;   
	    			n.subNm = n.whNm;
	    		});            	
	            this.WH_CD = res.list;
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
                {key: "itemCd"},
                {key: "itemNm"},    
                //{key: "partNo"},
                {key: "routCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "unit"},  
            	{ 
                    label: "현재정보", columns: [
                        {key: "stockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                        {key: "whCd"},  
                    ]
                },
            	{ 
                    label: "입고정보", columns: [
                        {key: "itemQcWay"},  
        				{key: "toWarehouse", label: "입고창고",width:100, align: "center",
                			editor: {type: "select", 
            					config: {columnKeys: {
                   	    					optionValue: "subCd", optionText: "subNm"
           	    						}, options: CODE.WH_CD
            					}
        					}, formatter: function formatter() {
        		    					return CONVERT_CODE["WH_CD"].map[this.value];
        					},styleClass:"grid-cell-select"
        				},				
                        {key: "itemQty", label: "입고수량", width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"}
                    ]
                },
            ],      
            body: { 
                onClick: function () {  
                	this.self.select(this.dindex);
                }
            },
            footSum: [
                [  
                    {label: "현재고 합계", colspan: 6, align: "center"},
                    {key: "stockQty", collector: "sum", formatter:"number", align: "right"},
                    {label: "입고 합계", colspan: 3, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                ]]
        });        

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "select-whCd": function () {
            	ACTIONS.dispatch(ACTIONS.SELECT_ALL_WAREHOUSE);
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
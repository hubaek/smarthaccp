var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_CLOSE: function (caller, act, data) { 
    	if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
  	         url: ["stock","stockGroupByAll"],
	         data: $.extend({groupByType:"barcode",zeroStock:"N",prdUseYn:"N"}, getSerializeArrayToJson("#searchView0")),
             callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },        
    SELECT_ITEM: function (caller, act, data) {  
    	if (typeof param.callBack === "undefined"){
    		parent.ppmboot.modal.callback(data);
    	}else{            		
    		parent[param.callBack](data);      
    	}
    },
    //공정분류 변경
    CHANGE_ROUT_TYPE: function (caller, act, data) {    
    	
    	var routType = data.routType;
    	var routCd = data.routCd;
    	
    	$("#routType").val(routType);    	
    	$("#routCd option").remove();
    	
   		if(nvl(routType,'') == ''){
           	$("#routCd").append("<option value=''>공정 선택</option>")
   		}else{
   			
   			ppmboot.ajax({
   		    	type: "GET",
   	            url:  ["rout"],
   	            data: "routType=" + routType ,
   		        callback: function (res) {        
   	            	$("#routCd").append("<option value=''>전체</option>");
   		        	res.list.forEach(function (n) {
   	                	$("#routCd").append("<option value='"+n.routCd+"'>"+n.routNm+"</option>")
   		        	});	

   		        	if(nvl(routCd,'') != ''){
   			        	$("#routCd").val(routCd).attr("selected", "selected");
   		        	}else{
   		    			$("#routCd option:eq(0)").attr("selected","selected");	
   		        	}
   		        }
   		    });
   		}
   		
   		ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   		
    },
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            // 직접코딩
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
        data: {mainCd: "ORDER_ST"},
        callback: function (res) {        		
            this.ORDER_ST = res.list;
        }
    })
    .call({
        type: "GET",
        url: ["rout"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.routCd;   
    			n.subNm = n.routNm;
    		});            	
        	res.list.push({subCd:"",subNm:"전체"});
            this.ROUT_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
        
        $("#routType").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,{routType:$(this).val(),routCd:""});
        }); 
        
        $("#routCd").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        }); 
        

        param = parent.ppmboot.modal.getData();
    	if (typeof param === "undefined"){
    	    param = ax5.util.param(ax5.info.urlUtil().param);
    	}

        _this.searchView.initView();
        _this.gridView01.initView();
    	ACTIONS.dispatch(ACTIONS.PAGE_INIT);   
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   
    });
};

fnObj.pageResize = function () {
};


//== view 시작
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
            sortable: false, 
            multiSort: false,
            showRowSelector: false, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [ 
                {key: "itemNm",width:200},
                //{key: "partNo",width:120,label:"P/N", align: "center"},
				{key: "routCd", label: "공정",width:120, align: "center",formatter: function formatter() {
						return CONVERT_CODE["ROUT_CD"].map[this.value];
					}
				},	
                {key: "spec",width:120},
                {key: "unit",width:100},
                {key: "lotNo",width:120},
                {key: "barcode",width:120},
                {key: "stockQty",width:120},
                {key: "selectItem", label:"선택",width:120, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>선택</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    if(this.column.key == "selectItem") {  
                    	this.item.stockQty = this.item.barcodeQty;
                        ACTIONS.dispatch(ACTIONS.SELECT_ITEM,this.item);
                    }

                }
            },
            page: {
                display: false
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "search-barcode": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "full-size": function () {
            	openFullScreenMode();
            },
            "small-size": function () {
            	closeFullScreenMode();
            },
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
                return this.barcode;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
});

var docV = document.documentElement;
//전체화면 설정
function openFullScreenMode() {
 if (docV.requestFullscreen)
     docV.requestFullscreen();
 else if (docV.webkitRequestFullscreen) // Chrome, Safari (webkit)
     docV.webkitRequestFullscreen();
 else if (docV.mozRequestFullScreen) // Firefox
     docV.mozRequestFullScreen();
 else if (docV.msRequestFullscreen) // IE or Edge
     docV.msRequestFullscreen();
}
//전체화면 해제
function closeFullScreenMode() {
 if (document.exitFullscreen)
     document.exitFullscreen();
 else if (document.webkitExitFullscreen) // Chrome, Safari (webkit)
     document.webkitExitFullscreen();
 else if (document.mozCancelFullScreen) // Firefox
     document.mozCancelFullScreen();
 else if (document.msExitFullscreen) // IE or Edge
     document.msExitFullscreen();
}
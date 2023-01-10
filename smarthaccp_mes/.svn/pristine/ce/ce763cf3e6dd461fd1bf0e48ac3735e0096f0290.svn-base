var fnObj = {};
var setupInfo;

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_CLOSE: function (caller, act, data) {
        window.open('about:blank','_self').self.close();  // IE에서 묻지 않고 창 닫기
	},        
	//페이지 세로고침
    PAGE_INIT: function (caller, act, data) {
    	ppmboot
			.call({
		     	type: "GET",  
				 url: ["/api/v1/pop2/getSetup"],
				 data: {},
		         callback: function (data) {
		        	setupInfo = data;		      
		        	//공정분류,공정 셋팅.
	               	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,setupInfo);       
		         }
		    })  
	        .done(function () {
	        });   
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
    MENU_MODAL: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-MENU",
            param: "",
            sendData: function(){
            	return {
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });
    },    
    PRINT_BARCODE: function (caller, act, data) {      	
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>바코드 인쇄 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data;

        		item.boxYn = "N";
        		item.printCnt = 1;
        		item.printCd = setupInfo.printCd;
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["barcodePrint"], 
    		     	data: JSON.stringify([item]),
    		         callback: function (res) {       
    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    		         }
	        	});
            }
        });   
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

   		if(setupInfo.routType != ''){
   			$("#routType").attr("disabled","disabled");   			
   		}else{
   			$("#routType").removeAttr("disabled");
   		}

   		if(setupInfo.routCd != ''){
   			$("#routCd").attr("disabled","disabled");   			
   		}else{
   			$("#routCd").removeAttr("disabled");
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

        _this.searchView.initView();
        _this.gridView01.initView();
    	ACTIONS.dispatch(ACTIONS.PAGE_INIT);   
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   
    });
    

    document.title = "POP_바코드재발행" ;
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
                {key: "itemNm",width:220},
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
                {key: "printBarcode", label:"바코드인쇄",width:120, align:"center", formatter:function(){
                	return "<button type='button' class='btn btn-success W70'>인쇄</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    if(this.column.key == "printBarcode") {  
                    	this.item.stockQty = this.item.barcodeQty;
                        ACTIONS.dispatch(ACTIONS.PRINT_BARCODE,this.item);
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
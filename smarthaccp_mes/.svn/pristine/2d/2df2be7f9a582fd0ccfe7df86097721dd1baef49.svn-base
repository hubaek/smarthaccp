/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 자재불출팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

var customModal = new ax5.ui.modal({
	  absolute: true,
	  onStateChanged: function onStateChanged() {
	      // mask
	      if (this.state === "open") {
	          window.axMask.open();
	      } else if (this.state === "close") {
	          window.axMask.close();
	      }  
	  }
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_CLOSE: function (caller, act, data) { 
        if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal2.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },   
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getStockBomList"],
	            data: {wlotNo: param.order.wlotNo,routCd: param.order.routCd,routSeq: param.order.routSeq},
	            callback: function (res) {
	                caller.gridView01.setData(res);
	                caller.gridView02.setData([]);
	                if(res.length > 0){
	 		            caller.gridView01.target.select(0);
	                }
	            }    
	        })
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getOutgoingList"],
	            data: {wlotNo: param.order.wlotNo, discardYn:"N",wipYn:"N"},
	            callback: function (res) {
	                caller.gridView03.setData(res);
	            }    
	        })
		    .done(function () {
		    });   
	        return false;
    },    
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {

    	var routCd = "";
    	
    	//로뜨투입인 자재일 경우에는 공정코드 조건 추가
    	if(data.wipYn== "Y"){
    		routCd = data[0].routCd;
    	}
    	
    	ppmboot
	        .call({
	            type: "GET",	   
	  	         url: ["stock","stockGroupByAll"],
 	   	        data: {groupByType:"barcode",itemCd:data.itemCd,zeroStock:"N",prdUseYn:"N",routCd:routCd},
	            callback: function (res) {
	                caller.gridView02.setData(res);
	            }    
	        })
	       .done(function () {
	       });  
    },    
    //자재출고
    OUTGOING_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>선택된 자재를 출고처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
	       	  	 var dData = [].concat(caller.gridView02.getData("modified"));   
	       	  	 var itemQtyCnt1 = 0;
	       	  	 var itemQtyCnt2 = 0;
		         var detailSize = dData.length;
		        
		         dData.forEach(function (n) {
		        	if (nvl(n.itemQty,0) == 0){
		        		itemQtyCnt1++;
		        		return false;
		        	}  		     
		        });
		         
		        if(itemQtyCnt1 > 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "출고 수량이 0 입니다."
		             });	          
		        }else if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "출고수량을 입력하세요."
		             });
		          	 return false;
		        }else{  

		        	dData.forEach(function (n) {
			        	n.wlotNo = param.order.wlotNo;
			        });        
					
		        	var actionNm = "saveConsum";
		        	
		        	if(param.outType == "OUT"){
		        		actionNm = "savePrdItem";
		        	}
		        	
		        	ppmboot.ajax({
	    	        	type: "PUT", 
	    	        	url: ["worderMaster" , actionNm], 
	    		     	data: JSON.stringify(dData),
	    		         callback: function (res) {       
	    		        	 parent.ppmboot.modal2.callback("");
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        }	    	     
            }
        });        
    },
    //자재폐기
    DISCARD_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>선택된 자재를 폐기처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
	       	  	 var dData = [].concat(caller.gridView02.getData("modified"));   
	       	  	 var discardQtyCnt1 = 0;
		         var detailSize = dData.length;
		        
		         dData.forEach(function (n) {
		        	if (nvl(n.discardQty,0) == 0){
		        		discardQtyCnt1++;
		        		return false;
		        	}  		     
		        });
		         
		        if(discardQtyCnt1 > 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "폐기 수량이 0 입니다."
		             });	          
		        }else if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "폐기수량을 입력하세요."
		             });
		          	 return false;
		        }else{  
		        	
		        	dData.forEach(function (n) {
			        	n.wlotNo = param.order.wlotNo;
			        	n.discardYn = "Y";
			        	n.bomItemQty = n.discardQty;
			        });        
					
		        	ppmboot.ajax({
	    	        	type: "PUT", 
	    	        	url: ["worderMaster" ,"saveDiscard"], 
	    		     	data: JSON.stringify(dData),
	    		         callback: function (res) {       
	    		        	 parent.ppmboot.modal2.callback("");
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        }	    	     
            }
        });        
    }, 
    //자재환입
    RETURN_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>선택된 자재를 환입처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
	       	  	 var dData = [].concat(caller.gridView03.getData("modified"));   
	       	  	 var itemQtyCnt1 = 0;
	       	  	 var itemQtyCnt2 = 0;
		         var detailSize = dData.length;
		        
		         dData.forEach(function (n) {
		        	 
			        	if (nvl(n.returnQty,0) == 0){
			        		itemQtyCnt1++;
			        		return false;
			        	}  		        

			        	if (nvl(n.returnQty,0) > nvl(n.bomItemQty,0)){
			        		itemQtyCnt2++;
			        		return false;
			        	}  		        
			        	
		        	n.bomItemQty = n.returnQty;
		        });
		           
		        if(itemQtyCnt1 > 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "환입 수량이 0 입니다."
		             });	          
		        }else if(itemQtyCnt2 > 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "소모수량보다 환입수량이 많습니다."
		             });
		          	 return false;
		        }else if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "선택된 품목정보가 없습니다."
		             });
		          	 return false;
		        }else{
		        	
		        	var actionNm = "saveReturnConsum";
		        	
		        	if(param.outType == "OUT"){
		        		actionNm = "cancelPrdItem";
		        	}
		        	
		        	ppmboot.ajax({
	    	        	type: "PUT", 
	    	        	url: ["worderMaster" ,actionNm], 
	    		     	data: JSON.stringify(dData),
	    		         callback: function (res) {       
	    		        	 parent.ppmboot.modal2.callback("");
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        	
		        }	    	     
            }
        });        
    }, 
    //자재검색
    STOCK_MODAL_OPEN: function (caller, act, data) {
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/STOCK-SEL-M.jsp", 
                param: "callBack=customStockModalCallback1"
            }
        });    	
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
        data: {mainCd: "DISCARD_TYPE",useYn:"Y"},
        callback: function (res) {        		
            this.DISCARD_TYPE = res.list;
        }
    })
    .done(function () {
    	CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
    	
        _this.pageButtonView.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();
        _this.gridView03.initView();

        param = parent.ppmboot.modal2.getData();
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
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "search-item": function () {
                ACTIONS.dispatch(ACTIONS.STOCK_MODAL_OPEN);
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
            sortable: false, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "routCd",width:120},
            	{
                    label: "BOM", columns: [
		                {key: "bomQty",label:"소요량",width:80, formatter:"number", align: "right"},         
		                {key: "lossQty",label:"LOSS",width:80 ,formatter:"number", align: "right"},         
		                {key: "reqQty",label:"총소요량",width:100 ,formatter:"number", align: "right"},  
                    ]
                },			
                {key: "totalQty",label:"오더대비소요량",width:100 ,formatter:"number", align: "right"},  
                {key: "goodTotalQty",label:"양품대비소요량",width:100 ,formatter:"number", align: "right"},  
                {key: "bomUnit",label:"소요단위",width:80, align: "center"},
                {key: "unit"},
                //{key: "routCd" , width:120},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
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
                {key: "itemCd"},
                {key: "itemNm"},    
                {key: "whCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "transStockQty", label: "현재고", width: 100, formatter:"number", align: "right"},
                //{key: "unit", width: 80},  
                {key: "itemQty", label: "출고수량", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "bomUnit",label:"소요단위",width:80, align: "center"},
                {key: "discardType", label: "폐기유형",width:120, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.DISCARD_TYPE
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["DISCARD_TYPE"].map[this.value];
					},styleClass:"grid-cell-select"
				},
				{key: "discardQty", label: "폐기수량",width:80, editor: {type: "number"},styleClass: "grid-cell-blue"},
                
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
       	 	"out-item": function () {
                ACTIONS.dispatch(ACTIONS.OUTGOING_ITEM);
            },
            "discard-item": function () {
                ACTIONS.dispatch(ACTIONS.DISCARD_ITEM);
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
                return this.barcode;
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
 * gridView03
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},    
            	{
                    label: "불출(소요단위)", columns: [
                        {key: "lotNo", width: 100},
                        {key: "barcode", width: 100},
                        {key: "bomItemQty", label: "투입수량", width: 100, formatter:"number", align: "right"},
                        //{key: "transConsumQty", label: "예상소모수량", width: 100, formatter:"number", align: "right"},
                        //{key: "transRemainQty", label: "예상남은수량", width: 100, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                    ]
                },	
                {key: "returnQty", label: "환입수량", formatter:"number", align: "right",editor: {type: "number"},styleClass: "grid-cell-blue"}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
       	 	"return-item": function () {
                ACTIONS.dispatch(ACTIONS.RETURN_ITEM);
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

//자재적용
function customStockModalCallback1(data){

	var rowList = new Array();
	rowList.push(data);
	fnObj.gridView02.setData(rowList);
	
	/*ppmboot
    .call({
        type: "GET",
        url: ["stock","stockGroupByAll"],
	    data: {groupByType:"barcode",zeroStock:"N",barcode:data.barcode,routCd:data.routCd,prdUseYn:"N",qcFlag:"Y"},
        callback: function (res) {
        	console.log(res);	
        	fnObj.gridView02.setData(res);
        }    
    })
   .done(function () {
   });*/
	
}
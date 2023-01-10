/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 수입검사등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var mask;
var qcType = "10"//수입검사
	
var CODE;
var CONVERT_CODE;

var customModal = new ax5.ui.modal({
  absolute: true,
  onStateChanged: function onStateChanged() {
      if (this.state === "open") {
          window.axMask.open();
      } else if (this.state === "close") {
          window.axMask.close();
      }  
  }
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	            url: ["qcManage","getQcMasterList"],
	   	         data: $.extend({qcType:qcType}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
		   	         res.list.forEach(function (n) {
		   	        	 n.qcDt = getNowDt();
		   	        	 n.qcFlag = "Y";
		   	         });
		   	         caller.gridView01.setData(res);
	   	         }
	   	 })
	     .done(function () {
	    	 
	     });   
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
    	
        var dData = [].concat(caller.gridView01.getData("modified"));
        var itemQtyCnt1 = 0;
        var itemQtyCnt2 = 0;
        var itemLength = dData.length;
        
        dData.forEach(function (n) {
        	n.endFlag = "N";
        	if (nvl(n.qcDt,'') == ''){
        		itemQtyCnt1++;
        		return false;
        	}  
        	if (nvl(n.qcWay,'') == ''){
        		itemQtyCnt2++;
        		return false;
        	}  
        });

        if(itemQtyCnt1 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg: "검사일자를 입력하세요."
            });
         	 return false;
        }else if(itemQtyCnt2 > 0){
        	 axDialog.alert({
                 theme: "warning",
                 msg: "검사결과를 입력하세요."
           });
        	 return false;
       }else{
        	ppmboot.ajax({
	        	type: "PUT", 
	        	url: ["qcManage","saveQcResultMaster"], 
	        	data: JSON.stringify(dData),
	            callback: function (res) {
	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	            }
	        });
        }
    },          
    QC_IN: function (caller, act, data) {    	
        axDialog.confirm({
            msg: "검사완료 처리 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	
                var dData = caller.gridView01.getData("selected");
                
                console.log(dData);
                
                var itemQtyCnt1 = 0;
                var itemQtyCnt2 = 0;
                var itemLength = dData.length;
                
                dData.forEach(function (n) {
                	n.endFlag = "Y";
                	if (nvl(n.qcDt,'') == ''){
                		itemQtyCnt1++;
                		return false;
                	}  
                	if (nvl(n.qcWay,'') == ''){
                		itemQtyCnt2++;
                		return false;
                	}  
                });
                
                if(itemQtyCnt1 > 0){
                 	 axDialog.alert({
                          theme: "warning",
                          msg: "검사일자를 입력하세요."
                    });
                 	 return false;
                }else if(itemQtyCnt2 > 0){
                 	 axDialog.alert({
                          theme: "warning",
                          msg: "검사결과를 입력하세요."
                    });
                 	 return false;
                }else if(itemLength == 0){
        	       	 axDialog.alert({
        	             theme: "warning",
        	             msg: "입고 대상이 없습니다."
        	       	 });
        	    	 return false;
                }else{
                	
                	ppmboot.ajax({
        	        	type: "PUT", 
        	        	url: ["qcManage","saveQcResultMaster"], 
        	        	data: JSON.stringify(dData),
        	            callback: function (res) {
        	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	            }
        	        });
                }
            }
        });
        
    },          
    CALC_QC: function (caller, act, data){
    	var dindex = data.dindex;
    	calculateQc(dindex);   	   
    },    
    OPEN_BAD_MODAL: function (caller, act, data) {   
    	var idx = data.dindex;
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-BAD-M.jsp", 
                param: "callBack=qcBadModalCallback&slipCd="+data.item.slipCd +"&qcType="+qcType +"&idx="+idx
            }
        });    	
    },
    OPEN_QC_DETAIL_MODAL: function (caller, act, data) {  
    	var idx = data.dindex;
    	customModal.open({
            width: 1360,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-DETAIL-M.jsp", 
                param: "callBack=qcDetailModalCallback&slipCd="+data.item.slipCd +"&qcType="+qcType+"&itemCd="+data.item.itemCd +"&idx="+idx
            }
        });    	
    },
    OPEN_QC_DOC_MODAL: function (caller, act, data) {  
    	var idx = data.dindex;
    	customModal.open({
            width: 900,
            height: 300,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-DOC-M.jsp", 
                param: "callBack=qcDocModalCallback&slipCd="+data.item.slipCd +"&qcType="+qcType+"&itemCd="+data.item.itemCd +"&itemNm="+data.item.itemNm +"&idx="+idx
            }
        });    	
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("수입검사등록.xls");
    },
	DOWNLOAD_DOC: function (caller, act, data) {
    	if(nvl(data.docId,0) != 0){
			location.href = "/api/v1/files/download?id=" +data.docId;
		}
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
	        url: ["basic", "detail"],
	        data: {mainCd:"QC_FLAG", useYn: "Y"},
	        callback: function (res) {        
	            this.QC_FLAG = res.list;
	        }
	    })
        .done(function () {
            CODE = this; // this는 call을 통해 수집된 데이터들.            
            _this.pageButtonView.initView();
            _this.searchView.initView();
            _this.gridView01.initView();
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	        CONVERT_CODE = convertCommonCode(CODE);
        });
};


fnObj.pageResize = function () {};


fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
            "search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE,"N");
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
    }
});

/**
 * gridView
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
            frozenColumnIndex: 0, 
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "inDt" , label:"입고일"},  
                {key: "itemCd"},
                {key: "itemNm"},   
                {key: "spec"},
                {key: "custNm"},     
                {key: "whCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "unit"},  
                {key: "qcWay"},
                {key: "qcDt", label: "검사일자", width: 100, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }
                        }
                    },
                    disabled: function () {
                        return this.item.qcFlag == "Y";
                    }
                } ,styleClass: "grid-cell-blue"},
                {key:"qcFlag", label: "검사결과",width:100, align: "center", hidden : true,
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.QC_FLAG
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["QC_FLAG"].map[this.value];
					},styleClass:"grid-cell-select"
				},
				{key: "qcFlagNm", label: "검사결과", width: 100, align: "center"},
                {key: "inQty", label: "입고수량", width: 80, formatter:"number", align: "right"},
	            {key: "badQty",label:"불량수량",width: 80,styleClass: "grid-cell-purple"},
                {key: "itemQty", label: "합격수량", width: 80, formatter:"number", align: "right"},
	            {key: "qcDetailYn",label:"검사내역",width: 80, align: "center",styleClass: "grid-cell-purple"},
	            {key: "qcDocYn",label:"성적서",width: 80, align: "center",styleClass: "grid-cell-purple"},
                {key: "updatedBy",label:"검사자"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);

                	if(this.column.key == "download" && nvl(this.item.docId,0) != 0) {
                        ACTIONS.dispatch(ACTIONS.DOWNLOAD_DOC, this.item);
                	}
                	
		        	if(this.column.key == "badQty") {
		        		if(this.item.qcDt == null){
		        			axDialog.alert({
	                          theme: "warning",
	                          msg: "검사일자를 입력하세요."
		        			});
		        			return false;
		        		}
		        		if(this.item.qcFlag == null){
		        			axDialog.alert({
	                          theme: "warning",
	                          msg: "검사결과를 입력하세요."
		        			});
		        			return false;
		        		}
                    	ACTIONS.dispatch(ACTIONS.OPEN_BAD_MODAL,this);
                    }
		        	if(this.column.key == "qcDetailYn") {
		        		if(this.item.qcDt == null){
		        			axDialog.alert({
	                          theme: "warning",
	                          msg: "검사일자를 입력하세요."
		        			});
		        			return false;
		        		}
		        		if(this.item.qcFlag == null){
		        			axDialog.alert({
	                          theme: "warning",
	                          msg: "검사결과를 입력하세요."
		        			});
		        			return false;
		        		}
                    	ACTIONS.dispatch(ACTIONS.OPEN_QC_DETAIL_MODAL,this);
                    }
		        	if(this.column.key == "qcDocYn") {
		        		if(this.item.qcDt == null){
		        			axDialog.alert({
	                          theme: "warning",
	                          msg: "검사일자를 입력하세요."
		        			});
		        			return false;
		        		}
                    	ACTIONS.dispatch(ACTIONS.OPEN_QC_DOC_MODAL,this);
                    }
                },
		        onDataChanged: function () {  	
		        	if(this.key == "badQty") {
                    	ACTIONS.dispatch(ACTIONS.CALC_QC,this);
                    }
		        }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "qc-in": function () {
                ACTIONS.dispatch(ACTIONS.QC_IN);
            },
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

/*
 * 전체계산
 */
function calculateQc(dindex){
    var data = new Object() ;
	var obj = fnObj.gridView01;

	var list = obj.getData();  
	var idx=0;
	list.forEach(function (n) {
		if(dindex == idx || dindex == 999){
			n.itemQty = Number(nvl(n.inQty,0)) - Number(nvl(n.badQty,0));
		}
		idx++;
    });        	
	obj.setData(list);  	
}

function qcBadModalCallback(data,idx){	
	var badQty = 0;
	data.forEach(function (n) {
    	badQty = badQty + nvl(n.badQty,0);
    });

	fnObj.gridView01.target.setValue(idx,"badQty", badQty);
	fnObj.gridView01.target.setValue(idx,"badList", data);
	ACTIONS.dispatch(ACTIONS.PAGE_SAVE,"N");
	customModal.close();
}

function qcDetailModalCallback(data,idx){	
	fnObj.gridView01.target.setValue(idx,"detail", "OK");
	fnObj.gridView01.target.setValue(idx,"qcDetail", data);
	ACTIONS.dispatch(ACTIONS.PAGE_SAVE,"N");
	customModal.close();
}

function qcDocModalCallback(data,idx){	
	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	customModal.close();
}
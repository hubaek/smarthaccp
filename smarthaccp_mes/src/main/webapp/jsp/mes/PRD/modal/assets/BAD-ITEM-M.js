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
	            url: ["/api/v1/pop2/getBadTypeList"],
	            data: {routType:param.order.routType, routCd:param.order.routCd,useYn:"Y"},
	            callback: function (res) {

			        res.forEach(function (n) {
			        	 n.badDt = param.order.orderDt;
			        });
	                caller.gridView01.setData(res);  
	            }  
	        })
	        .call({
	            type: "GET",
	   	        url: ["worderList" ,"badList"],
	            data: {wlotNo: param.order.wlotNo},
	            callback: function (res) {
	                caller.gridView02.setData(res);
	            }
	        })
		    .done(function () {
		    });   
	        return false;
    },    
    //불량등록
    BAD_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>불량처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
	       	  	 var dData = [].concat(caller.gridView01.getData("modified"));   
	       	  	 
	       	  	 var itemQtyCnt1 = 0;
	       	  	 var itemQtyCnt2 = 0;
	             var badDtm;
		         var detailSize = dData.length;
		        
		         dData.forEach(function (n) {

		        	n.badHour = pad(nvl(n.badHour,''),2);
		        	n.badMinute = pad(nvl(n.badMinute,''),2);
		        	
		         	badDtm = nvl(n.badDt,'') + nvl(n.badHour,'') + nvl(n.badMinute,'');
		         	badDtm = badDtm.replace(/-/gi, "");
		         	
		         	if (nvl(n.badQty,0) == 0){
		         		itemQtyCnt1++;
		         		return false;
		         	}  

		         	if (badDtm.length != 12){
		         		itemQtyCnt2++;
		         		return false;
		         	}  
		         	
		         	n.company = "1000";
		         });
		         
		        if(itemQtyCnt1 > 0){
		         	 axDialog.alert({
		                  theme: "warning",
		                  msg: "불량수량을 입력하세요."
		             });
		         	 return false;
		        }else if(itemQtyCnt2 > 0){
		         	 axDialog.alert({
		                 theme: "warning",
		                 msg: "발생시간을 입력하세요"
		           });
		        	 return false;
		        }else if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "선택된 불량정보가 없습니다."
		             });
		          	 return false;
		        }else{				  
		        	
		        	
		        	dData.forEach(function (n) {
			            n.wlotNo = param.order.wlotNo;
			            n.badType = "P";
			        });        
		        	
		        	
    	        	var obj = {wlotNo:param.order.wlotNo,lastFlag:param.order.lastFlag,bads:dData}    	        	
    	        	    	        	
		        	ppmboot.ajax({
	    	        	type: "PUT", 
			        	url: ["worderMaster","saveWorkBad"], 
	    		     	data: JSON.stringify(obj),
	    		         callback: function (res) {       
	    		        	 parent.ppmboot.modal2.callback("");
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        }	    	     
            }
        });        
    },  
    //불량취소
    CANCEL_BAD: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>불량취소 처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
                 caller.gridView02.delRow("selected");
	       	  	 var dData = [].concat(caller.gridView02.getData("deleted"));   
		         var detailSize = dData.length;

		        dData.forEach(function (n) {
		        	n.badQty = n.badItemQty;
			    });        
		         
		        if(detailSize == 0){
		          	 axDialog.alert({
		                   theme: "warning",
		                   msg: "선택된  불량정보가 없습니다."
		             });
		          	 return false;
		        }else{  
    	        	var obj = {wlotNo:param.order.wlotNo,lastFlag:param.order.lastFlag,bads:dData}
		        	ppmboot.ajax({
	    	        	type: "PUT", 
			        	url: ["worderMaster","cancelWorkBad"], 
	    		     	data: JSON.stringify(obj),
	    		         callback: function (res) {       
	    		        	 parent.ppmboot.modal2.callback("");
	    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	    		         }
		        	});
		        }	    	     
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
	        url: ["basic", "detail"],
	        data: {mainCd:"HOUR", useYn: "Y"},
	        callback: function (res) {        
	            this.HOUR = res.list;
	        }
	    })
	    .call({
	        type: "GET",
	        url: ["basic", "detail"],
	        data: {mainCd:"MINUTE", useYn: "Y"},
	        callback: function (res) {        
	            this.MINUTE = res.list;
	        }
	    })
        .done(function () {
            CODE = this;
	        CONVERT_CODE = convertCommonCode(CODE);
	        _this.pageButtonView.initView();
	        _this.gridView01.initView();
	        _this.gridView02.initView();

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
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "badCd"},
                {key: "badDt", label: "발생일자", width: 80, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }
                        }
                    }
                },styleClass: "grid-cell-blue"},

				{key:"badHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
				{key:"badMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},
                {key: "badQty", label: "불량수량", width: 80, formatter:"number", align: "right", editor: {type: "number"},styleClass:"grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
       	 	"out-item": function () {
                ACTIONS.dispatch(ACTIONS.BAD_ITEM);
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
                return this.badCd;
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
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "badDtm", label: "발생시간",width: 130, align: "center", formatter:function(){
                	return convertStringToTimestamp(this.value)
                }},
                {key: "badCd"}, 
                {key: "badItemQty", label: "불량수량", width: 80, formatter:"number", align: "right"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
       	 	"return-item": function () {
                ACTIONS.dispatch(ACTIONS.CANCEL_BAD);
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
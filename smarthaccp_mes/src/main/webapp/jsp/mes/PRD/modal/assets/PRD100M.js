/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 작업지시등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var CODE;
var actionType = "worder";
var actionName = "작업지시서";
var CODE;
var CONVERT_CODE;

//모달 재정의 Start
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
    		parent.ppmboot.modal.close();
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
        .call({
            	type: "GET",
	            url: [actionType,"header"],
	        	data: {slipCd: param.slipCd},
                callback: function (res) {
                	if(param.mode =="copy"){
                        res.list[0].slipCd = "";
                        res.list[0].slipDt = getNowDt();
                	}
	                caller.formView01.setData(res.list[0]);
                }
        })
    	.call({
                type: "GET",
   		        url: [actionType,"itemList"],
   		     	data: {slipCd: param.slipCd},
                callback: function (res) {
                	if(param.mode =="copy"){
                    	res.list.forEach(function (n) {
                    		n.refSlipCd = "";
                    		n.orderNo = "";
                            n.slipCd = "";
                            n.orderSeq = "";
                            n.orderDt = getNowDt();
                            n.remainYn = "N";
                        });
                	}
 		            caller.gridView01.setData(res);
                }
        })
        .done(function () {

        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
    	var orderQtyCnt = 0;
    	var itemOrderDtCnt = 0;
    	var routSeqCnt = 0;
    	
    	 if (caller.formView01.validate()) {
	    	var mData = caller.formView01.getData();
	    	
     		 var alertMsg = "'저장'하시겠습니까?";
     		 
            axDialog.confirm({
                theme: "danger",
                msg: alertMsg
            }, function () {
            	if(this.key == "ok"){
            		var dData = [].concat(caller.gridView01.getData());
        	        
        	        var detailSize = dData.length;	        
        	        var itemQtyCnt1 = 0;	        
        	        var itemQtyCnt2 = 0;	        
        	        var itemQtyCnt3 = 0;	        
        	        
        	        dData.forEach(function (n) {

        	        	if (nvl(n.orderQty,0) == 0){
        	        		itemQtyCnt1++;        		
        	        		return false;
        	        	}

        	        	if (nvl(n.routCd,'') == ''){
        	        		itemQtyCnt2++;        		
        		       		return false;
        		       	}        	
        	        	if (nvl(n.orderDt,'') == ''){
        	        		itemQtyCnt3++;        		
        	        		return false;
        	        	}        	
        	        });
        	        
        	        if(itemQtyCnt1 > 0){
                    	 axDialog.alert({
                             theme: "warning",
                             msg: "지시수량이 0 입니다."
                    	 });             	 
                    	 return false;
        	        	
        	        }else if(itemQtyCnt2 > 0){
                    	axDialog.alert({
                            theme: "warning",
                            msg: "공정을 선택하세요."
        	            });                          	 
                   	 	return false;	 
        	        	
        	        }else if(itemQtyCnt3 > 0){
                    	 axDialog.alert({
                             theme: "warning",
                             msg: "지시일자를 선택하세요."
                    	 });                  	 
                    	 return false;   	
        	        }else if(detailSize == 0){
        	          	 axDialog.alert({
        	                   theme: "warning",
        	                   msg: "등록된 품목정보가 없습니다."
        	             });
        	          	 return false;        	
        	        }else{
        	        	
        		        dData.forEach(function (n) {
        		            n.company = mData.company;
        		            n.slipCd = mData.slipCd;
        		        });

        		        var obj = {
        		    		header: mData,
        		            itemList: dData
        		        };
        		        
        		        ppmboot.ajax({
        		        	type: "PUT", url: [actionType], data: JSON.stringify(obj),
        		            callback: function (res) {         
        		            	param.slipCd = res.slipCd;
        		            	param.mode = "mod";	                
        		                parent.ppmboot.modal.callback("");	 
    			                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        		            }
        		        });	
        	        }
            	}
	        });	
	        
	    }
    	 
    },
    PAGE_DEL: function (caller, act, data) {    	    	
    	var mData = caller.formView01.getData();	 	    
        
        ppmboot.ajax({
        	type: "DELETE", 
        	url: [actionType], 
        	data: JSON.stringify(mData),
            callback: function (res) {         
            	param.slipCd = res.slipCd;
            	param.mode = "mod";	            	           
                parent.ppmboot.modal.callback("");	    
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
        
    },
    //수주적용
    SA030R_MODAL: function (caller, act, data) {
    	customModal.open({
            width: 1100,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/SA/ref-modal/SA030R.jsp",
                param: "callBack=customFormModalCallback"
            }
        });
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    },
    USER_MODAL_OPEN: function (caller, act, data) {    	
    	customModal.open({
            width: 600,
            height: 600,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/USER-ONE-M.jsp",
                param: "callBack=customUserModalCallback"
            }
        });
    },
    //품목 선택정보적용
    ITEM_SELECT_MODAL_OPEN: function (caller, act, data) {
	    	customModal.open({
	            width: 1100,
	            height: 700,
	            iframe: {
	                method: "get",
	                url: "/jsp/mes/modal/ROUTING-ITEM-M.jsp", 
	                param: "callBack=customItemModalCallback&itemTypeGroup=P&routingYn=Y"
	            }
	        });    	
    },    
    EQUIP_GRID_MODAL_OPEN: function (caller, act, data) {
    	var obj = data;
    	var idx = data.dindex;
    	var list = obj.list[idx];
    	
    	caller.gridView01.target.setValue(idx,"equipCd", "");
    	caller.gridView01.target.setValue(idx,"equipNm", "");		
    	
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/RT-EQ-SEL-M.jsp",
                param: "callBack=customEquipModalCallback&idx="+idx + "&routCd="+list.routCd
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
	        url: ["whCd"],
	        data: {whType: "30",useYn:"Y"},
	        callback: function (res) {        		
	        	res.list.forEach(function (n) {   
	    			n.subCd = n.whCd;   
	    			n.subNm = n.whNm;
	    		});            	
	            this.WH_CD = res.list;
	        }
	    })
        .call({
            type: "GET",
            url: ["equip"],
            data: {activeFlag: "A"},
            callback: function (res) {
	        	res.list.forEach(function (n) {   
	    			n.subCd = n.equipCd;   
	    			n.subNm = n.equipNm;
	    		});            	
	            this.EQUIP_CD = res.list;
            }
        })
        .call({
            type: "GET",
            url: ["rout","routingMaster"],
            data: {useYn: "Y"},
            callback: function (res) {
	        	res.list.forEach(function (n) {   
	    			n.subCd = n.routingCd;   
	    			n.subNm = n.routingNm;
	    		});            	
	            this.ROUTING_CD = res.list;
            }
        })  
        .call({
            type: "GET",
            url:  ["basic", "detail"],
            data: {mainCd: "ROUT_TYPE",useYn:"Y"},
            callback: function (res) {        		
                this.ROUT_TYPE = res.list;
            }
        })
        .done(function () {
	        CODE = this;
	        CONVERT_CODE = convertCommonCode(CODE);
            param = parent.ppmboot.modal.getData();
            
            _this.pageButtonView.initView();
            _this.gridView01.initView();
            _this.formView01.initView();
            
            if(param.mode == "add"){        
                _this.formView01.setDefaultUser(SCRIPT_SESSION);
            }else{
            	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
                axDialog.confirm({
                    theme: "danger",
                    msg: "'전체삭제'하시겠습니까?"
                }, function () {
                	if(this.key == "ok"){
                        ACTIONS.dispatch(ACTIONS.PAGE_DEL);
                    }                	
                });
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
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "orderNo", label: "지시번호", width: 120, align: "center"},
                {key: "orderDt", label: "지시일자", width: 100, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }
                        }
                    }
                } ,styleClass: "grid-cell-blue"},
            	{
                    label: "품목정보", columns: [
                    	{key: "itemCd"},
                        {key: "itemNm"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
				{key: "whCd", label: "공정창고",width:100, align: "center", formatter: function formatter() { return CONVERT_CODE["WH_CD"].map[this.value];}},
            	{
                    label: "공정정보", columns: [
        				{key: "routingCd", formatter: function formatter() { return CONVERT_CODE["ROUTING_CD"].map[this.value];}},
        				{key: "routType", formatter: function formatter() { return CONVERT_CODE["ROUT_TYPE"].map[this.value];}},
                        {key: "routCd"},            
                        {key: "equipUseYn"}, 
                        {key: "outscFlag"},
                        {key: "routSeq", label: "공정순번", width: 70, align: "center"},
                    ]
                },
				{key: "equipCd",label: "설비", width: 130, align: "center", formatter: function formatter() { return CONVERT_CODE["EQUIP_CD"].map[this.value];}},
                {key: "popupBtn1"},
                {key: "orderQty", label: "지시수량",width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 15, align: "center"},
                    {key: "orderQty", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
                	if(this.column.key == "popupBtn1") {
                    	ACTIONS.dispatch(ACTIONS.EQUIP_GRID_MODAL_OPEN, this);
                    } 
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },  
            "item-all": function () {
            	ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN);
            },
        	"ref-item-call1": function () {
        		ACTIONS.dispatch(ACTIONS.SA030R_MODAL);
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
                return this.orderSeq;
            });
        } else {  
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addParentRow: function (data) {
    	addParentRow(this.target,data);
    },
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {		
    	var today = getNowDt();
        return $.extend({}, ppmboot.formView.defaultData, {slipDt:today,orderDt:today});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작        
        this.initEvent();        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });        
        
        
        ppmboot.buttonClick(this, "data-form-view-01-btn", {   
        	"user_modal": function () {
        		ACTIONS.dispatch(ACTIONS.USER_MODAL_OPEN)
            }
        });
    },
    initEvent: function () {
        var _this = this;
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();  
        if (rs.error) {
        	 axDialog.alert({
                 theme: "warning",
                 msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
             });
            rs.error[0].jquery.focus();
            return false;
        }  
        return true;
    },
    clear: function () {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);        
    	
        this.model.setModel(this.getDefaultData());
    },
    setDefaultUser:function(data){
        this.model.set("userCd", data.userCd);
        this.model.set("userNm", data.userNm);
    },
});


//품목선택 적용
function customItemModalCallback(data){
	fnObj.gridView01.addParentRow(data);
}

//품목//거래내역/ref Form 적용로 품목추가 적용로 품목추가 (항목명때문)
function addParentRow(obj,data){
	var routType = nvl(fnObj.formView01.getData().routType,"");
	//공정 자동 적용
	ppmboot.ajax({
        type: "GET",
        url:  ["rout", "step"],
    	data: {routingCd:data.routingCd,itemCd:data.itemCd,routType:data.routType},
        callback: function (res) {
        	if(res.list.length > 0){
	    		obj.addRow({__created__: true,
	    			itemCd:data.itemCd,  
	    			itemNm:data.itemNm,  
	    			whCd:res.list[0].whCd,  
	    			routType:res.list[0].routType,  
	    			routingCd:res.list[0].routingCd,  
	    			equipUseYn:res.list[0].equipUseYn,
	    			routCd:res.list[0].routCd,  
	    			routSeq:res.list[0].routSeq,
	    			outscFlag:res.list[0].outscFlag,  
	    			equipCd:res.list[0].equipCd,  
	    			spec:data.spec,
	    			unit:data.unit,
	    			orderDt:nvl(data.orderDt , getNowDt()),     
	    			}, "last");
	    		
        	}else{
        		axDialog.alert({
                    theme: "warning",
                    msg: "등록된 라우팅이 없습니다."
                }); 
        	}
        }
    });
}

//수주적용
function customFormModalCallback(data){
	data.forEach(function (n) {
		n.refSlipCd=n.slipCd;
		n.refSlipSeq=n.slipSeq;  	
		fnObj.gridView01.addParentRow(n);
	});
	axDialog.alert("적용가 완료 되었습니다.");
	customModal.close();
}

//사용자 목록
function customUserModalCallback(data){
	fnObj.formView01.setDefaultUser(data);
	customModal.close();
}

//설비가져오기
function customEquipModalCallback(data,param){	
	var idx = param.idx;	
	fnObj.gridView01.target.setValue(idx,"equipCd", data.equipCd);
	fnObj.gridView01.target.setValue(idx,"equipNm", data.equipNm);		
	customModal.close();     
}  
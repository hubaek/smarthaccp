/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 매입마감
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var CODE;

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
	            url: ["purchaseEnd","header"],
	        	data: {company:param.company,slipCd: param.slipCd},
                callback: function (res) {
                	if(param.mode =="copy"){
                        res.list[0].slipCd = "";
                        res.list[0].userCd = SCRIPT_SESSION.userCd;
                        res.list[0].userNm = SCRIPT_SESSION.userNm;
                	}
	                caller.formView01.setData(res.list[0]);
                }
        })
    	.call({
                type: "GET",
   		        url: ["purchaseEnd","itemList"],
   		     	data: {company:param.company,slipCd: param.slipCd},
                callback: function (res) {
                	if(param.mode =="copy"){
                    	res.list.forEach(function (n) {
                    		n.refSlipCd = "";
                            n.slipCd = "";
                            n.remainYn = "N";
                        });
                	}

 		            caller.gridView01.setData(res);
                }
   
        })
        .done(function () {
        	setAuthBtn();
        });
    	
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
   	 	if (caller.formView01.validate()) {
	    	var mData = caller.formView01.getData();	    	
	    	
	        var dData = [].concat(caller.gridView01.getData());
	        var itemQtyCnt = 0;
	        var detailSize = dData.length;

	        dData.forEach(function (n) {
	        	if (nvl(n.itemQty,0) == 0){
	        		itemQtyCnt++;
	        		return false;
	        	}  
	        });
	        
	        if(itemQtyCnt > 0){
	          	 axDialog.alert({
	                   theme: "warning",
	                   msg: "품목의 수량이 0 이상이어야 합니다."
	             });
	        }else{      	

                axDialog.confirm({
                    theme: "danger",
                    msg: "'저장'하시겠습니까?"
                }, function () {
                	if(this.key == "ok"){
                		var saveList = [].concat(caller.gridView01.getData());
        	            saveList = saveList.concat(caller.gridView01.getData("deleted"));
        	            
        		        mData.itemDetail = saveList;	
        		        
        		        ppmboot.ajax({
        		        	type: "PUT", url: ["purchaseEnd"], data: JSON.stringify(mData),
        		            callback: function (res) {         
        		            	param.slipCd = res.slipCd;
        		            	param.mode = "mod";	            	
        		                parent.ppmboot.modal.callback("");	        
        		                
        		                if(mData.slipStatus == "C"){
        		                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
        		                }else{
        			                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        		                }
        		                
        		            }
        		        });	
                	}
                });
	        }
	         	 
	    }
    },
    PAGE_DEL: function (caller, act, data) {    	  
        axDialog.confirm({
            theme: "danger",
            msg: "'전체삭제'하시겠습니까?"
        }, function () {
        	if(this.key == "ok"){
            	var mData = caller.formView01.getData();	 	    
                ppmboot.ajax({
                	type: "DELETE", 
                	url: ["purchaseEnd"], 
                	data: JSON.stringify(mData),
                    callback: function (res) {         
                    	param.slipCd = res.slipCd;
                    	param.mode = "mod";	            	           
                        parent.ppmboot.modal.callback("");	    
                        ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
                    }
                });
            }                	
        });
    },
    //삭제
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    },
    //품목 선택정보적용
    ITEM_SELECT_MODAL_OPEN: function (caller, act, data) {		
    	var itemTypeGroup = "I";	//부자재,원자재     	        	
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/ITEM-SEL-M.jsp", 
                param: "callBack=customItemModalCallback&obj&itemTypeGroup=" + itemTypeGroup
            }
        });    
    },    
    //REF 적용 구매입고
    PC030R_MODAL: function (caller, act, data) {    
    	customModal.open({
            width: 1200,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/PC/ref-modal/PC030R.jsp", 
                param: "callBack=customFormModalCallback1"
            }
        });
    },
    //REF 적용 구매취소
    PC040R_MODAL: function (caller, act, data) {
    	customModal.open({
            width: 1200,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/PC/ref-modal/PC040R.jsp", 
                param: "callBack=customFormModalCallback2"
            }
        });
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
    CODE = this; // this는 call을 통해 수집된 데이터들.
    param = parent.ppmboot.modal.getData();
    
    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.formView01.initView();
    
    if(param.mode == "add"){
        _this.formView01.setDefaultUser(SCRIPT_SESSION);
        setAuthBtn();
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
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
                ACTIONS.dispatch(ACTIONS.PAGE_DEL);
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
                {key: "refSlipCd"},
            	{
                    label: "품목정보", columns: [
                    	{key: "itemCd"},
                        {key: "itemNm"},
                        //{key: "partNo"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "itemQty", editor: {type: "number"},styleClass: "grid-cell-blue"},
                        {key: "unitAmt", editor: {type: "number"},styleClass: "grid-cell-blue"},
                        {key: "supplyAmt", editor: {type: "number"},styleClass: "grid-cell-blue"},
                        {key: "surtaxAmt", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
                        {key: "totalAmt"},
                    ]
                },
                {key: "itemRemark", label: "비고", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},  
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 6, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "unitAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "supplyAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "surtaxAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
		        },
		        onDataChanged: function () {  	
		        	calcItemDetail(this);
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
        	"ref-item-call1": function () {
        		ACTIONS.dispatch(ACTIONS.PC030R_MODAL);
            },
        	"ref-item-call2": function () {
        		ACTIONS.dispatch(ACTIONS.PC040R_MODAL);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },
            "item-all": function () {
            	ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN);
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
                return nvl(this.slipSeq,randomStringCd(20));
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
        return $.extend({}, ppmboot.formView.defaultData, {slipDt:today,pcDt:today,surtaxYn:"Y"});
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
    },
    initEvent: function () {
        var _this = this;
        this.model.onChange("surtaxYn", function () {
        	calcItemDetail(999);
        }); 
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
    setDefaultCust:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
        this.model.set("surtaxYn", nvl(data.surtaxYn,'Y'));
    },
});

//REF 적용1
function customFormModalCallback1(data){
	var idx = 0;
	data.forEach(function (n) {  
		
		n.refSlipCd=n.slipCd;
		n.refSlipSeq=n.slipSeq;  	
		n.pcAmt = n.unitAmt;
		
		fnObj.gridView01.addParentRow(n);

		if(idx == 0){
			fnObj.formView01.setDefaultCust(n);
		}
		idx++;		
	});

	axDialog.alert({
		theme: "danger",
		msg: "'적용완료 되었습니다 "
	}, 	function () {
		if(this.key == "ok"){	    
			customModal.close();
      	}                	
	});
}

//REF 적용2
function customFormModalCallback2(data){
	var idx = 0;
	data.forEach(function (n) {  
		
		n.refSlipCd=n.slipCd;
		n.refSlipSeq=n.slipSeq;  	

		n.pcAmt = Number(n.unitAmt) * -1;
		n.supplyAmt = Number(n.supplyAmt) * -1;
		n.surtaxAmt = Number(n.surtaxAmt) * -1;
		n.totalAmt = Number(n.totalAmt) * -1;
		
		fnObj.gridView01.addParentRow(n);

		if(idx == 0){
			fnObj.formView01.setDefaultCust(n);
		}
		idx++;		
	});

	axDialog.alert({
		theme: "danger",
		msg: "'적용완료 되었습니다 "
	}, 	function () {
		if(this.key == "ok"){	    
			customModal.close();
      	}                	
	});
}

//품목선택 적용
function customItemModalCallback(data){
	fnObj.gridView01.addParentRow(data);
}

//품목//거래내역/ref Form 적용로 품목추가 적용로 품목추가 (항목명때문)
function addParentRow(obj,data){	
	getItemMaster(data,function(data){		
		obj.addRow({__created__: true,
  		itemCd:data.itemCd,  
  		itemNm:data.itemNm,
  		spec:data.spec,
		unit:data.unit,
  		stockQty:nvl(data.stockQty,0),
  		surtaxYn:nvl(data.surtaxYn,'N'),
  		itemQty:nvl(data.remainQty,0),
  		unitAmt:nvl(data.pcAmt,0),
  		supplyAmt:nvl(data.supplyAmt,0),
  		surtaxAmt:nvl(data.surtaxAmt,0),
  		totalAmt:nvl(data.totalAmt,0),
  		refSlipCd:data.slipCd,
  		refSlipSeq:data.slipSeq,
  		}, "last");
	});
}

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.slipCd,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	}else{
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}
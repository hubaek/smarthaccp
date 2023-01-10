/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 구매취소등록
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
	            url: ["purchaseReturn","header"],
	        	data: {company:param.company,slipCd: param.slipCd},
                callback: function (res) {
	                caller.formView01.setData(res.list[0]);
                }
        })
    	.call({
                type: "GET",
   		        url: ["purchaseReturn","itemList"],
   		     	data: {company:param.company,slipCd: param.slipCd},
                callback: function (res) {
 		            caller.gridView01.setData(res);
                }
   
        })
        .done(function () {
        	setAuthBtn();
        });
    	
        return false;
    },
    PAGE_ADD: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
   	         url: ["stock","getStockMaster"],
   	         data: $.extend({pcYn:"Y",zeroStock:"N",slipCd:param.slipCd}, getSerializeArrayToJson("#searchView0")),
             callback: function (res) {	 
            	 customFormModalCallback(res.list);
             }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
    	 if (caller.formView01.validate()) {
    		 var mData = caller.formView01.getData();	 	
      		 var alertMsg = "'저장'하시겠습니까?";
      		 
             axDialog.confirm({
                 theme: "danger",
                 msg: alertMsg
             }, function () {
             	if(this.key == "ok"){
             		var dData = [].concat(caller.gridView01.getData());
        	        var itemQtyCnt = 0;
        	    	var itemNm;
        	    	var itemWarehouseCnt = 0;    		
        	        var detailSize = dData.length;
        	        
        	        dData.forEach(function (n) {
        	        	if (nvl(n.itemQty,0) == 0){
        	        		itemQtyCnt++;
        	        		itemNm = n.itemNm;
        	        		return false;
        	        	}  
        	        });
        	        
        	        if(itemQtyCnt > 0){
        	          	 axDialog.alert({
        	                   theme: "warning",
        	                   msg: itemNm + "품목의 수량이 0 이상이어야 합니다."
        	             });	          
        	        }
        	        else if(itemWarehouseCnt > 0){
        	         	 axDialog.alert({
        	                 theme: "warning",
        	                 msg: itemNm + "의 입고창고를 입력하세요."
        	           });
        	        }else{     
        	        	var saveList = [].concat(caller.gridView01.getData());
        	            saveList = saveList.concat(caller.gridView01.getData("deleted"));
    	        		
        		        mData.itemDetail = saveList;	
    	    	        
    	    	        ppmboot.ajax({
    	    	        	type: "PUT", 
    	    	        	url: ["purchaseReturn"], 
    	    	        	data: JSON.stringify(mData),
    	    	            callback: function (res) {         
    	    	            	param.slipCd = res.slipCd;
    	    	            	param.mode = "mod";	                          
        		                parent.ppmboot.modal.callback("");	 
    			                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
    	    	            }
    	    	        });	
        	        }
             	}
 	        });	  
	    	
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
                	url: ["purchaseReturn"], 
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
    STOCK_MODAL_OPEN: function (caller, act, data) {
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/PC/ref-modal/PC-LOT-M.jsp", 
                param: "callBack=customFormModalCallback&whType=10"
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
	
	param = parent.ppmboot.modal.getData();            
    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.formView01.initView();
    
    if(param.mode == "add"){
        //_this.formView01.setDefaultUser(SCRIPT_SESSION);
    	_this.formView01.setData(param.mlist[0]);
        setAuthBtn();
        ACTIONS.dispatch(ACTIONS.PAGE_ADD);
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
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {	
    getDefaultData: function () {		
    	var today = getNowDt();
        return $.extend({}, ppmboot.formView.defaultData, {slipDt:today,surtaxYn:"Y"});
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
                {key: "refSlipCd",label:"구매번호", hidden: true},
            	{
                    label: "품목정보", columns: [
                    	{key: "itemCd"},
                    	{key: "itemNm"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
                {
                    label: "입고정보", columns: [
                        //{key: "whCd"},
                        {key: "lotNo"},
                        //{key: "barcode"},
                        {key: "stockQty",label:"재고수량"}
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "itemQty",label:"취소수량",width:100, editor: {type: "number"},styleClass: "grid-cell-blue"},
                        {key: "unitAmt"},
                        {key: "supplyAmt"},
                        {key: "surtaxAmt"},
                        {key: "totalAmt"},
                    ]
                },
                //{key: "itemRemark", label: "비고", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},  
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 9, align: "center"},
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
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },
            "stock-all": function () {
            	ACTIONS.dispatch(ACTIONS.STOCK_MODAL_OPEN);
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



//품목//거래내역/ref Form 적용로 품목추가 적용로 품목추가 (항목명때문)
function addParentRow(obj,data){
	obj.addRow({__created__: true,
  		stockCd:data.stockCd,  
  		itemCd:data.itemCd,  
  		itemNm:data.itemNm,
  		spec:data.spec,
		unit:data.unit,
		pdUnit:data.pdUnit,
		pdTrans:data.pdTrans,
  		stockQty:nvl(data.pdTransQty,0),
  		itemQty:nvl(data.pdTransQty,0),
  		unitAmt:nvl(data.unitAmt,0),
  		supplyAmt:nvl(data.supplyAmt,0),
  		surtaxAmt:nvl(data.surtaxAmt,0),
  		totalAmt:nvl(data.totalAmt,0),
  		lotNo:data.lotNo,
  		barcode:data.barcode,
  		whCd:nvl(data.whCd,""),
  		refSlipCd:data.slipCd,
  		refSlipSeq:data.slipSeq,  	    		
  		}, "last");
}



//REF 적용
function customFormModalCallback(data){
	var idx = 0;
	var list = fnObj.gridView01.getData();
	data.forEach(function (n) {  
		var ckCnt = 0 ;
		list.forEach(function (n2) {	  
			if(n.barcode == n2.barcode){
				ckCnt++;
			}
		});
		
		if(ckCnt == 0){
			fnObj.gridView01.addParentRow(n);
		}

		if(idx == 0){
			fnObj.formView01.setDefaultCust(n);
		}
		idx++;		
	});

	/*axDialog.alert({
        theme: "danger",
        msg: "'적용완료 되었습니다 "
    }, function () {
    	if(this.key == "ok"){	    
    		customModal.close();
        }                	
    });*/
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
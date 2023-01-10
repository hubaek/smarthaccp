/**
 * 0. Project	: 팔피엠 CMMS
 * 1. 작성자  	: 팔피엠
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: BOM등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
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
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
    	.call({
            type: "GET",
            url:  ["bom", "bomMasterList"],
            data: {company:param.company, itemCd:param.itemCd,revisionNo:nvl(param.revisionNo,'')},
            callback: function (res) {   
            	caller.formView01.setData(res.list[0]);
            }
        })   
        .call({
            type: "GET",
            url:  ["bom", "bomDetailList"],
            data: {company:param.company, itemCd:param.itemCd,revisionNo:nvl(param.revisionNo,'')},
            callback: function (res) {
                caller.gridView01.setData(res);
            }    
         })
		 .done(function () {
			 setAuthBtn();
		 });
        return false
    }, 
    PAGE_SAVE: function (caller, act, data) {    	   
    	if (caller.formView01.validate()) { 	
    		
	    	var mData = caller.formView01.getData();      
	    	
            var bData = [].concat(caller.gridView01.getData());
            bData = bData.concat(caller.gridView01.getData("deleted"));
            mData.bomDetail = bData;
                
            if(param.revisionYn == "Y"){
            	mData.revisionNo = "";
            }
            
            console.log(mData);
            
            
            ppmboot
            .call({
                type: "PUT", 
                url: ["bom"],
                data: JSON.stringify(mData),
                callback: function (res) {
                	param.company = res.company;
                	param.itemCd = res.itemCd;
                	param.revisionNo = res.revisionNo;
                	param.revisionYn = "N";
                	param.mode = 'mod';
	                parent.ppmboot.modal.callback("");	      
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH); 
                }
            }) 
            .done(function () {
                axToast.push("저장 되었습니다.");
            });
		}
	},
	ITEM_BOM_DEL: function (caller, act, data) {
	    caller.gridView01.delRow("selected");
	},
	//url 수정 MES --> mes 2020-07-13 최정욱
	ITEM_COPY_OPEN: function (caller, act, data) {   
		var data = caller.formView01.getData();       
	    if (nvl(data.itemCd,"") == ""){
	    	axDialog.alert("품목을 선택하세요.");
	    }else{
	    	customModal.open({
	            width: 1200,
	            height: 700,
	            iframe: {
	                method: "get",
	                url: "/jsp/mes/BOM/ITEM-COPY-M.jsp", 
	                param: "callBack=bomCopyModalCallback"
	            }
	        });    	
	    }
	},
	//품목 선택정보적용
	//url 수정 MES --> mes 2020-07-13 최정욱
	ITEM_SELECT_MODAL_OPEN: function (caller, act, data) {
		var data = caller.formView01.getData();       
	    if (nvl(data.itemCd,"") == ""){
	    	axDialog.alert("품목을 선택하세요.");
	    }else{
	    	customModal.open({
	            width: 1100,
	            height: 700,
	            iframe: {
	                method: "get",
	                url: "/jsp/mes/modal/ITEM-SEL-M.jsp", 
	                param: "callBack=customItemSelelctModalCallback&obj"
	            }
	        });    	
	    }        
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
	    data: {useYn: "Y"},
	    callback: function (res) {      	
        	res.list.forEach(function (n) {   
    			n.subCd = n.routCd;   
    			n.subNm = n.routNm;
    		});            	
            this.ROUT_CD = res.list;
	    }
	})
	.done(function () {
		CODE = this;
	    CONVERT_CODE = convertCommonCode(CODE);
	    
	    _this.pageButtonView.initView();    
	    _this.formView01.initView();
	    _this.gridView01.initView();
	    
	    param = parent.ppmboot.modal.getData();
		if (typeof param === "undefined"){
		    param = ax5.util.param(ax5.info.urlUtil().param);
		}
		
	    if(param.mode == "add"){      
	        setAuthBtn();
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_DEL);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {itemQty:"1"});
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
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        data.itemQty = nvl(data.itemQty, 0);        
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();    	
        data = $.extend({}, data); 
        data.itemQty = nvl(data.itemQty,1);
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
        this.model.setModel(this.getDefaultData());
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
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "spec"},
                //{key: "partNo"},
                {key: "unit"}, 
				{key: "bomUnit"},
                {key: "bomQty",label:"소요량",width:80, align: "right",formatter:"number", editor: {type: "number"},styleClass: "grid-cell-blue"},  
                {key: "lossPer",label:"LOSS(%)",width:80, align: "right",formatter:"number", editor: {type: "number"},styleClass: "grid-cell-blue"}, 
                {key: "lossQty",label:"LOSS",width:80, align: "right",formatter:"number", editor: {type: "number"},styleClass: "grid-cell-blue"},                  
                {key: "reqQty",label:"총소요량",width:80, align: "right",formatter:"number"},     
				{key: "routCd", label: "사용공정",width:100, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.ROUT_CD
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["ROUT_CD"].map[this.value];
					},styleClass:"grid-cell-select"
				},				
                {key: "useYn", editor: "checkYn",styleClass: "grid-cell-blue"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                },
		        onDataChanged: function () {  	
		        	if(this.key == "bomQty" || this.key == "lossQty" || this.key == "lossPer") {
		        		calcBomDetail(this.key);
                    }
		        }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
             "item-remove": function () {
                 ACTIONS.dispatch(ACTIONS.ITEM_BOM_DEL);
             },
             "item-all": function () {
            	 ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN);
             },
             "item-copy": function () {
            	 ACTIONS.dispatch(ACTIONS.ITEM_COPY_OPEN);
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
                return nvl(this.bomSeq,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function (data) {        	
        this.target.addRow({__created__: true,
    		company:data.company,  
    		itemCd:data.itemCd,  
    		itemNm:data.itemNm,
    		unit:data.unit,  
    		bomUnit:data.bomUnit,
    		spec:data.spec,  
    		//partNo:data.partNo,  
    		useYn:"Y",  
    		routCd:data.routCd,  
    		bomQty:data.bomQty,  
    		lossQty:data.lossQty,  
    		reqQty:data.reqQty,  
    		parentItemCd:data.parentItemCd
    		}, "last");
    }
});

function bomCopyModalCallback(data){	
	data.forEach(function (n) {
		n.parentItemCd = fnObj.formView01.getData().itemCd;
		fnObj.gridView01.addRow(n);
	 });  
	customModal.close();
}

//품목선택 적용
function customItemSelelctModalCallback(item){
	var data = fnObj.formView01.getData();
	item.parentItemCd = data.itemCd;
	item.routCd = data.routCd;
	
	if(item.parentItemCd != item.itemCd){
		fnObj.gridView01.addRow(item);
	}
}

/*
 * 전체계산
 */
function calcBomDetail(key){  
	var obj = fnObj.gridView01;	
	var list = obj.getData();  
	
	if(list.length > 0){
		list.forEach(function (n) {
			n.bomQty = Number(nvl(n.bomQty,0));
			if(key == 'lossPer'){
				n.lossQty = Number(nvl(n.bomQty,0)) * Number(nvl(n.lossPer,0)) /  100;
			}else{
				n.lossPer = 0;
				n.lossQty = Number(nvl(n.lossQty,0));
			}			
			n.reqQty = Number(nvl(n.bomQty,0)) + Number(nvl(n.lossQty,0));
	    }); 
	}
	obj.setData(list);  	
}

function setAuthBtn(){	
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	
	if(mode != 'view'){
        $("#save").show();
	}else{
        $("#save").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}
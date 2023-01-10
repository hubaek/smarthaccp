/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 라우팅등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};

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
        ppmboot.ajax({
            type: "GET",
            url: ["rout", "routingMaster"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
                caller.gridView03.setData([]);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {

	    	var validationRoutCnt1 = 0;
	    	var validationRoutCnt2 = 0;
	    	var validationRoutCnt3 = 0;
	    	var validationRoutCnt4 = 0;
	    	var validationRoutCnt5 = 0;
	    	var validationRoutCnt6 = 0;
	    	
            var mData = caller.formView01.getData();
	    	var dData = caller.gridView02.getData();
	    	var dDataLength = dData.length;
	    	
	    	dData.forEach(function (n1) {        	                
	             if(nvl(n1.routSeq,'')==''){
	             	validationRoutCnt1++;
	             	return false;
	             }
	             if(nvl(n1.routCd,'')==''){
	             	validationRoutCnt2++;
	             	return false;
	             }
	             
	             if(nvl(n1.lastFlag,'N')=='Y'){
	              	validationRoutCnt4++;
	              }
	             
	             dData.forEach(function (n2) {        	
	                 if(n1.routSeq == n2.routSeq){
	                  	validationRoutCnt3++;
	                  }  	   
	             });  
	
	             if(validationRoutCnt3 > 1){
	            	 return false;
	             }else{
	            	 validationRoutCnt3 = 0;
	             }

	
	         });   
	    	
	    	if(validationRoutCnt1 > 0){
	         	 axDialog.alert({
	                  theme: "warning",
	                  msg: "공정순서를 입력하세요."
	            });
	         	 return false;
	        }else if(validationRoutCnt2 > 0){
	         	 axDialog.alert({
	                  theme: "warning",
	                  msg: "공정을 입력하세요."
	            });
	         	 return false;
	        }else if(validationRoutCnt3 > 1){
	        	 axDialog.alert({
	                 theme: "warning",
	                 msg: "동일한 공정 순서는 입력할 수 없습니다."
	           });
	        	 return false;
	        }else if(validationRoutCnt4 > 1){
		       	 axDialog.alert({
		                theme: "warning",
		                msg: "최종공정은 두개 이상 선택 할 수 없습니다."
		          });
		       	 return false;
	        }else if(validationRoutCnt4 == 0 && dDataLength != 0){
		       	 axDialog.alert({
		                theme: "warning",
		                msg: "최종공정을 선택하세요."
		          });
		       	 return false;
	        }else{

		        var bData = [].concat(caller.gridView02.getData("created"));   
		        bData = bData.concat(caller.gridView02.getData("modified"));   
		        bData = bData.concat(caller.gridView02.getData("deleted")); 

		        var cData = [].concat(caller.gridView03.getData("created"));   
		        cData = cData.concat(caller.gridView03.getData("modified"));   
		        cData = cData.concat(caller.gridView03.getData("deleted")); 
		        
		        
	        	ppmboot
                .call({
                    type: "PUT", url: ["rout", "routingMaster"], data: JSON.stringify(mData),
                    callback: function (res) {                    	
                    }
                })
                .call({
                    type: "PUT", url: ["rout", "routingDetail"], data: JSON.stringify(bData),
                    callback: function (res) {
                    }
                })
                .call({
                    type: "PUT", url: ["rout", "routingItem"], data: JSON.stringify(cData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
	        }
            
        }

    },
    FORM_CLEAR: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear();
                caller.gridView02.clear();
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
        
    	ppmboot
        .call({
            url:  ["rout", "routingDetail"],
            data: {routingCd:data.routingCd},
            callback: function (res) {                    	
                caller.gridView02.setData(res);
            }
        })
        .call({
            url:  ["rout", "routingItem"],
            data: {routingCd:data.routingCd},
            callback: function (res) {                    	
                caller.gridView03.setData(res);
            }
        })
        .done(function () {
        });
    	
    },
    ITEM_ROUT_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
    },    
    ITEM_ITEM_DEL: function (caller, act, data) {
        caller.gridView03.delRow("selected");
    },    
    //공정 선택정보적용
    ROUT_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var data = caller.formView01.getData();       
        if (nvl(data.routingCd,"") == ""){
        	axDialog.alert("라우팅을 선택하세요.");
        	return false;
        }else{
        	customModal.open({
                width: 800,
                height: 600,
                iframe: {
                    method: "get",
                    url: "/jsp/mes/modal/RT-SEL-M.jsp", 
                    param: "callBack=customRoutSelelctModalCallback"
                }
            });    	
        }        
    },    
    //품목 선택정보적용
    ITEM_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var data = caller.formView01.getData();       
        if (nvl(data.routingCd,"") == ""){
        	axDialog.alert("라우팅을 선택하세요.");
        }else{
        	customModal.open({
                width: 1100,
                height: 800,
                iframe: {
                    method: "get",
                    url: "/jsp/mes/modal/ITEM-SEL-M.jsp", 
                    param: "callBack=customItemSelelctModalCallback&itemTypeGroup=P"
                }
            });    	
        }        
    }, 
    ITEM_SELECT_MODAL_OPEN_M: function (caller, act, data) {
    	var data = caller.formView01.getData();       
        if (nvl(data.routingCd,"") == ""){
        	axDialog.alert("라우팅을 선택하세요.");
        }else{
        	customModal.open({
                width: 1100,
                height: 800,
                iframe: {
                    method: "get",
                    url: "/jsp/mes/modal/ITEM-SEL-M-MULTI.jsp", 
                    param: "callBack=customItemSelelctModalCallbackMulti&itemTypeGroup=P"
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

    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();
    _this.formView01.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
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

        this.target.find('[data-ax-path="routingCd"]').attr("readonly", "readonly");
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();
        if (rs.error) {
       	 	axDialog.alert({
                theme: "warning",
                msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
            },function(){
                rs.error[0].jquery.focus();
            });
            return false;
        }
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
        this.target.find('[data-ax-path="routingCd"]').removeAttr("readonly");
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "routingCd", label: "라우팅코드", width: 140, align: "center"},
                {key: "routingNm", label: "라우팅명", width: 220, align: "left"},
                {key: "useYn", width: 137}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.subCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true}, "last");
    }
});

/**
 * gridView02	공정절차
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: true,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "routSeq",label:"공정순서",formatter:"number",align: "right", width:170, editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "routCd",width:435},
//                {key: "routNm",width:150, label: "공정", align: "left"},
                {key: "lastFlag", label:"최종", width: 190, align: "center", editor: "checkYn",styleClass: "grid-cell-blue"},
                {key: "useYn", label:"사용여부", width: 190, align: "center", editor: "checkYn",styleClass: "grid-cell-blue"}
            ],  
            body: { 
                onClick: function () {  
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "rout-all": function () {
                ACTIONS.dispatch(ACTIONS.ROUT_SELECT_MODAL_OPEN);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ROUT_DEL);
            },
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.regSeq,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,
        	company:data.company,
        	routingCd:data.routingCd,
        	regSeq:nvl(data.regSeq,Number(this.target.list.length) + 1),
    		routSeq:nvl(data.routSeq,Number(this.target.list.length) + 1),
        	routCd:data.routCd,
        	stdUph:data.stdUph,
        	stdCt:data.stdCt,
        	apyUph:data.apyUph,
        	apyCt:data.apyCt,
        	lastFlag:data.lastFlag,
        	useYn:nvl(data.useYn,"Y"),
        	}, "last");
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
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "itemCd", width: 180},
                {key: "itemNm", width: 325},
                {key: "spec", width: 160}, 
                {key: "unit", width: 160}, 
                {key: "useYn", width: 160, editor: "checkYn",styleClass: "grid-cell-blue"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                },
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
             "item-remove": function () {
                 ACTIONS.dispatch(ACTIONS.ITEM_ITEM_DEL);
             },
             "item-all": function () {
            	 ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN);
             },
             "item-all-m": function () {
            	 ACTIONS.dispatch(ACTIONS.ITEM_SELECT_MODAL_OPEN_M);
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
                return nvl(this.itemCd,randomStringCd(20));
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
    		routingCd:data.routingCd,  
    		itemCd:data.itemCd,  
    		itemNm:data.itemNm,
    		unit:data.unit,  
    		spec:data.spec,  
    		useYn:"Y"
    		}, "last");
    }
});

//공정선택 적용
function customRoutSelelctModalCallback(item){
	var data = fnObj.formView01.getData();
	item.company = data.company;
	item.routingCd = data.routingCd;
	fnObj.gridView02.addRow(item);
}

//품목선택 적용
function customItemSelelctModalCallback(item){
	
	var itemCnt = 0;
	var dData = fnObj.gridView03.getData();	
	
	dData.forEach(function (n) {        	                
         if(nvl(n.itemCd,'') == item.itemCd){
        	 itemCnt++;
         	return false;
         }
     });   
	
	if(itemCnt > 0){
	   	 axDialog.alert({
	         theme: "warning",
	         msg: "이미 등록된 품목이 존재합니다."
		 });
		 return false;		
		
	}else{
		var data = fnObj.formView01.getData();	
		item.company = data.company;
		item.routingCd = data.routingCd;
		fnObj.gridView03.addRow(item);		
	}
	
}

//품목선택 적용 (멀티)
function customItemSelelctModalCallbackMulti(itemList){
	
	var data = fnObj.formView01.getData();	

	itemList.forEach(function (n2) {
		n2.company = data.company;
		n2.routingCd = data.routingCd;
		fnObj.gridView03.addRow(n2);		
	});  
	
}
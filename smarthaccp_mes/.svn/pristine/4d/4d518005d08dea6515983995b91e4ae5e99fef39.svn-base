/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: PN적용 팝업
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
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView01.getData();            
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list);
        	}else{        		
        		parent[param.callBack](list);
        	}
        }
    },
    //ADD
    ITEM_SUB_ADD: function (caller, act, data) {	
    	caller.gridView01.addRow();
    },
    //삭제
    ITEM_SUB_DEL: function (caller, act, data) {
    	caller.gridView01.delRow("selected");
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
    _this.gridView01.initView();    
    param = parent.ppmboot.modal.getData();
	if (typeof param === "undefined"){
	    param = ax5.util.param(ax5.info.urlUtil().param);
	}
    ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
};


fnObj.pageResize = function () {
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
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
            sortable: true, 
            multiSort: false,  
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                //{key: "partNo",editor:"text" ,styleClass: "grid-cell-blue"},   
                {key: "saOrderDt", label: "수주일자", width: 80, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }
                        }
                    }
                } ,styleClass: "grid-cell-blue"},
                {key: "deliveryDt", label: "납기일자", width: 80, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }   
                        }
                    }
                } ,styleClass: "grid-cell-blue"},
                {key: "itemQty", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
             //   {key: "unitAmt", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd"},
                        {key: "itemNm"},
                        //{key: "partNo"},
                        {key: "spec"},   
                        {key: "unit"},
                    ]
                },
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });

        //엑셀 붙여넣기
       document.getElementById("gridView01").addEventListener('paste', function(e){
    	   handlePasteGridView(e, fnObj.gridView01.target, "Y");  	//event ,target, addYn 
       });
       
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },
            "item-call": function () {
            	callItem();
            },
        });
    }
});

function callItem(){
	
    var dData = fnObj.gridView01.getData();    
    dData.forEach(function (n) {
        n.itemType = "10";
    });
    
    ppmboot
    .call({
        type: "PUT",
        url: ["item", "getItemMasterInfo"],
        data: JSON.stringify(dData),
        callback: function (res) {      
        	fnObj.gridView01.setData(res); 
        }
    })
    .done(function () {
    });
}
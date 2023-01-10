/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 설비등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var setupInfo;
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
    PAGE_SEARCH: function (caller, act, data) {    
    	ppmboot
			.call({
	            type: "GET",
	            url: ["rout","equip"],
	            //data: {routCd:param.order.routCd,refYn:"N",useYn:"Y",equipAuthYn:param.setupInfo.equipAuthYn,userCd:param.setupInfo.userCd},
	            data: {routCd:param.order.routCd,refYn:"N",useYn:"Y",equipAuthYn:"N",userCd:param.setupInfo.userCd},
	            callback: function (res) {
	                caller.gridView01.setData(res);
	                var equipCodeIdx = 0;
	     		   	res.list.forEach(function (n) {   
		           		if(n.equipCd == nvl(param.order.equipCd,'')){
		 	        	   caller.gridView01.target.select(equipCodeIdx);
		 	        	   return false;
		           		}		           		
		           		equipCodeIdx++;
		       		});     
            	}
		    })  
			.call({
	            type: "GET",
	            url: ["rout","equip"],
	            //data: {routCd:param.order.routCd,prdEquipUseYn:"N",refYn:"Y",useYn:"Y"},
	            data: {routCd:param.order.routCd,refYn:"Y",useYn:"Y"},
	            callback: function (res) {
	                caller.gridView02.setData(res);
	                var equipCodeIdx = 0;
	     		   	res.list.forEach(function (n) {   
		           		if(n.equipCd == nvl(param.order.refEquipCd,'')){
		 	        	   caller.gridView02.target.select(equipCodeIdx);
		 	        	   return false;
		           		}		           		
		           		equipCodeIdx++;
		       		});     
	            }
		    })  
	        .done(function () {
	        });   
        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>설비를 등록 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
                var list1 = caller.gridView01.getData("selected");
                var list2 = caller.gridView02.getData("selected");
                
                if (list1.length > 0) {
                	param.order.equipCd = list1[0].equipCd;
                	param.order.equipNm = list1[0].equipNm;

                    if (list2.length > 0) {
                    	param.order.refEquipCd = list2[0].equipCd;
                    	param.order.refEquipName = list2[0].equipNm;
                    }else{
                    	param.order.refEquipCd = "";
                    	param.order.refEquipName = "";
                    }
                	
                	if(param.order.orderSt=='ORDER'){
                		parent.ppmboot.modal.callback(param.order);
                		parent.ppmboot.modal.close();
                	}else{
                        ppmboot.ajax({
                        	type: "PUT", 
                        	url: ["/api/v1/pop2/updateEquip"], 
                        	data: JSON.stringify(param.order),
                            callback: function (res) {         
                        		parent.ppmboot.modal.callback();
                        		parent.ppmboot.modal.close();
                            }
                        });	 
                	}
                } else {
                    alert(LANG("ax.script.requireselect"));
                }
            }
        });            
    },
    ITEM_CLICK: function (caller, act, data) {
        ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
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
        data: {mainCd: "NWRK_CD", useYn:"Y"},
        callback: function (res) {        		
            this.NWRK_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
        param = parent.ppmboot.modal.getData();
        
        _this.pageButtonView.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();
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
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});

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
            showRowSelector: true,
            frozenColumnIndex: 0,
            multipleSelect: false,
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 25},
            columns: [
                {key: "routCd",width:130},
                {key: "equipNm", label: "설비명", width: 330, align: "left"},
                {key: "equipSpec", label: "사양", width: 100, align: "center"}
            ],
            body: {
                columnHeight: 60,
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
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
            showRowSelector: true,
            frozenColumnIndex: 0,
            multipleSelect: false,
            target: $('[data-ax5grid="grid-view-02"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "routCd",width:130},
                {key: "equipNm", label: "설비명", width: 330, align: "left"},
                {key: "equipSpec", label: "사양", width: 100, align: "center"}
            ],
            body: {
                columnHeight: 60,
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});
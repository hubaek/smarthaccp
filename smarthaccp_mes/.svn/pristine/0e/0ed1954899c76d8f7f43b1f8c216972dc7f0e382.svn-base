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

//모달 재정의 Start
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
	             url:  ["workPlan"],
	             data: $.extend({itemTypeGroup:"P"}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
	   	            caller.gridView01.setData(res);
	   	            caller.gridView02.setData([]);
	   	            caller.gridView03.setData([]);
	   	         }
	   	 	})        
	       .done(function () {
	       }); 
	    return false;
    },    
    PAGE_SAVE: function (caller, act, data) {    	
        var dData = [].concat(caller.gridView03.getData("modified"));
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
        	
        }else{            
            dData = dData.concat(caller.gridView03.getData("deleted"));
            ppmboot
                .call({
                    type: "PUT", 
                    url: ["worderMaster","master"], 
                    data: JSON.stringify(dData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
            return false;
        }
    },   
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
        .call({
            type: "GET",
            url:  ["bom", "bomRoutingDetailList"],
            data: {company:data.company,itemCd:data.itemCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }    
        })
        .call({
            type: "GET",
            url: ["worderMaster","master"], 
            data: {company:data.company,planItemCd:data.itemCd,planDt:data.planDt},
            callback: function (res) {
                caller.gridView03.setData(res);
            }    
        })
        .done(function () {
        });
    },
    ADD_ORDER: function (caller, act, data) {
    	var list1 = caller.gridView01.getData("selected");
    	var list2 = caller.gridView02.getData("selected");
    	
    	var errCnt = 0;
    	var bomLv = 0;
    	var orderCnt = 0;
    	list2.forEach(function (n) {   
    		
    		if(orderCnt == 0){
    			bomLv = n.bomLv;
    		}else{
    			if(bomLv != n.bomLv){
    				errCnt = 1;
    			}
    		}
    		
    		orderCnt++;
        });

    	if(errCnt == 0){
        	var tempOrderNo = randomStringCd(20);
        	list2.forEach(function (n) {   		
    			n.orderQty = Number(nvl(list1[0].planQty,1)) * Number(nvl(n.reqQty,1)) ;
    			n.planDt = nvl(list1[0].planDt,"");
    			n.planItemCd = nvl(list1[0].itemCd,"");
    	    	n.tempOrderNo = tempOrderNo;    	    	
    			customRoutModalCallback(n);
            });
    	}else{
        	axDialog.alert({
                theme: "warning",
                msg: "동일한 레벨만 작업 편성 가능합니다."
            });                          	 
       	 	return false;	 
    	}
    },
    ITEM_SUB_DEL: function (caller, act, data) {
    	
        var dData = caller.gridView03.getData("selected");
        
        var itemQtyCnt1 = 0;
        var itemQtyCnt2 = 0;
        var itemQtyCnt3 = 0;
        var itemQtyCnt4 = 0;
        
        dData.forEach(function (n) {
        	
        	if (n.orderSt == 'RUN'){
        		itemQtyCnt1++;        		
        		return false;
        	}

        	if (n.orderSt == 'END'){
        		itemQtyCnt2++;        		
        		return false;
        	}

        	if (n.orderSt == 'NWRK'){
        		itemQtyCnt3++;        		
        		return false;
        	}

        	if (n.orderSt == 'CLOSE'){
        		itemQtyCnt4++;        		
        		return false;
        	}
        	
        });
        
        if(itemQtyCnt1 > 0){
        	 axDialog.alert({
                 theme: "warning",
                 msg: "진행중인 작업지시는 삭제 할수 없습니다."
        	 });             	 
        	 return false;
        	
        }else if(itemQtyCnt2 > 0){
        	axDialog.alert({
                theme: "warning",
                msg: "작업완료된 작업지시는 삭제 할수 없습니다."
            });                          	 
       	 	return false;	 
        	
        }else if(itemQtyCnt3 > 0){
        	 axDialog.alert({
                 theme: "warning",
                 msg: "비가동중인 작업지시는 삭제 할수 없습니다."
        	 });                  	 
        	 return false;   	
        }else if(itemQtyCnt4 > 0){
	       	 axDialog.alert({
	             theme: "warning",
	                msg: "마감된 작업지시는 삭제 할수 없습니다."
	    	 });                  	 
	    	 return false;   	
        }else{
            caller.gridView03.delRow("selected");
        }
    },
    
    //품목 - 공정 선택정보적용
    ROUT_SELECT_MODAL_OPEN: function (caller, act, data) {
    	caller.gridView01.setData([]);
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/ROUT-ITEM-M.jsp", 
                param: "callBack=customRoutModalCallback&itemTypeGroup=P"
            }
        });    	
    },    
    
    //품목 - 라우팅 선택정보적용
    ROUTING_SELECT_MODAL_OPEN: function (caller, act, data) {
    	caller.gridView01.setData([]);
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/ROUTING-ITEM-M.jsp", 
                param: "callBack=customRoutingModalCallback&itemTypeGroup=P"
            }
        });    	
    },    
    
    //품목 - BOM 적용
    BOM_SELECT_MODAL_OPEN: function (caller, act, data) {
    	caller.gridView01.setData([]);
    	customModal.open({
            width: 1400,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/BOM-ITEM-M.jsp", 
                param: "callBack=customBomModalCallback&itemTypeGroup=P"
            }
        });    	
    },    
    
    EQUIP_GRID_MODAL_OPEN: function (caller, act, data) {
    	var obj = data;
    	var idx = data.dindex;
    	var list = obj.list[idx];

        var itemQtyCnt1 = 0;    	
    	if (list.orderSt == 'RUN' || list.orderSt == 'END' || list.orderSt == 'NWRK' || list.orderSt == 'CLOSE'){
    		itemQtyCnt1++;        	
    	}
    	
    	itemQtyCnt1 = 0;
    	
    	if(itemQtyCnt1 > 0){
	       	 axDialog.alert({
	                theme: "warning",
	                msg: "진행된 작업지시는를 설비 변경 할 수 없습니다."
	       	 });                  	 
        }else{
    	    caller.gridView01.target.setValue(idx,"equipCd", "");
       		caller.gridView01.target.setValue(idx,"equipNm", "");		
       	
       		customModal.open({
               width:1000,
               height: 700,
               iframe: {
                   method: "get",
                   url: "/jsp/mes/modal/RT-EQ-SEL-M.jsp",
                   param: "callBack=customEquipModalCallback&idx="+idx + "&routCd="+list.routCd + "&refYn=N"
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

        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
                {key: "planQty", label: "계획수량", formatter:"number", align: "right",width:80},
                {key: "planOrderQty", label: "오더수량", formatter:"number", align: "right",width:80},
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
                return this.tempOrderNo && this.tempOrderNo;
            });
        } else {  
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRoutRow: function (data) {
    	addRoutRow(this.target,data);
    },
    addRoutingRow: function (data) {
    	addRoutingRow(this.target,data);
    },
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
                {key: "bomLv", label: "레벨", width: 50, align: "center"},
				{key: "routingNm"},
                {key: "routSeq",label:"공정순서",formatter:"number",align: "right", width:80},
				{key: "routCd"},
                {key: "itemCd"},
                {key: "itemNm", width:200, align: "left"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "unit"},            
                {key: "reqQty",label:"총소요량",width:80, align: "right",formatter:"number"},     
            ],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
		        }
            }
        });
        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "add-order": function () {
                ACTIONS.dispatch(ACTIONS.ADD_ORDER);
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
                return this.tempOrderNo && this.tempOrderNo;
            });
        } else {  
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
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
                {key: "orderNo", label: "지시번호", width: 80, align: "center"},
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
                {key: "orderSt"},
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
                    label: "공정정보", columns: [
        				{key: "routingNm"},
                        {key: "routCd"},            
                        {key: "equipUseYn"}, 
                        {key: "lastFlag"},
                        {key: "routSeq", label: "공정순번", width: 70, align: "center"},
                    ]
                },
				{key: "equipNm",label: "설비", width: 130, align: "center"},
				{key: "popupBtn1", width: 20, label: "", align: "center", formatter:function(){
	                	if(nvl(this.item.equipUseYn,'N') == "Y"){
	                    	return "<i class='cqc-magnifier'></i>";
	                	}else{
	                    	return "<i class='cqc-cancel3'></i>";
	                	}
	            	},styleClass:function(){
	            		if(nvl(this.item.equipUseYn,'N') == "Y"){
	                    	return "grid-cell-red";
	                	}else{
	                    	return "";
	                	}
	            	}
	            },

                {key: "orderQty", label: "지시수량",width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
                {key: "sort", label: "우선순위",width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
            ],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
                	if((this.column.key == "popupBtn1" || this.column.key == "equipCd") && nvl(this.item.equipUseYn,'N') == "Y") {
                    	ACTIONS.dispatch(ACTIONS.EQUIP_GRID_MODAL_OPEN, this);
                    } 
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },  
            "item-rout": function () {
            	ACTIONS.dispatch(ACTIONS.ROUT_SELECT_MODAL_OPEN);
            },
            "item-routing": function () {
            	ACTIONS.dispatch(ACTIONS.ROUTING_SELECT_MODAL_OPEN);
            },
            "item-bom": function () {
            	ACTIONS.dispatch(ACTIONS.BOM_SELECT_MODAL_OPEN);
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
                return this.tempOrderNo && this.tempOrderNo;
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
    		tempOrderNo:data.tempOrderNo,  
    		itemCd:data.itemCd,  
    		itemNm:data.itemNm,  
    		whCd:data.whCd,  
    		routType:data.routType,  
    		routingCd:data.routingCd,  
    		routingNm:data.routingNm,  
    		equipUseYn:nvl(data.equipUseYn,'N'),
    		routCd:data.routCd,  
    		routSeq:data.routSeq,
    		outscFlag:data.outscFlag,  
    		equipCd:data.equipCd,  
    		spec:data.spec,
    		//partNo:data.partNo,
    		unit:data.unit,
    		lastFlag:nvl(data.lastFlag,'N'),
    		orderDt:nvl(data.orderDt , getNowDt()),     
    		scheduleDt:nvl(data.scheduleDt , getNowDt()),     
    		orderSt:"",
    		orderQty:data.orderQty,
    		planDt:nvl(data.planDt,''),
    		planItemCd:nvl(data.planItemCd,'')
    		}, "last");
    }
});

//공정 적용
function customRoutModalCallback(data){
	if(nvl(data.tempOrderNo,'') == ''){
		data.tempOrderNo = randomStringCd(20);
	}
	fnObj.gridView03.addRow(data);
}

//라우팅 적용
function customRoutingModalCallback(data){	
	ppmboot.ajax({
	    type: "GET",
	    url:  ["rout", "step"],
		data: {routingCd:data.routingCd,itemCd:data.itemCd,routType:data.routType},
	    callback: function (res) {
	    	if(res.list.length > 0){
            	var tempOrderNo = randomStringCd(20);
	        	res.list.forEach(function (n) {
	        		n.tempOrderNo = tempOrderNo;
	        		customRoutModalCallback(n);
	    		});            	
	    	}else{
	    		axDialog.alert({
	                theme: "warning",
	                msg: "등록된 라우팅이 없습니다."
	            }); 
	    	}
	    }
	});
}

//BOM 적용
function customBomModalCallback(data){
	data.forEach(function (n) {
		customRoutModalCallback(n);
    });
	customModal.close();     
}

//설비가져오기
function customEquipModalCallback(data,param){	
	var idx = param.idx;	
	fnObj.gridView03.target.setValue(idx,"equipCd", data.equipCd);
	fnObj.gridView03.target.setValue(idx,"equipNm", data.equipNm);		
	customModal.close();     
}  

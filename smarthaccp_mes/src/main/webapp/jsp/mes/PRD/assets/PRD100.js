/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
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
	             url: ["worderMaster","master"], 
	             data: $.extend({}, getSerializeArrayToJson("#searchView0")),
	   	         callback: function (res) {
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
        }else{            
            dData = dData.concat(caller.gridView01.getData("deleted"));
            
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
    ITEM_SUB_DEL: function (caller, act, data) {
        var dData = caller.gridView01.getData("selected");
        
        dData.forEach(function (n) {

        	if (n.orderSt == 'RUN'){
        		axDialog.alert({
                    theme: "warning",
                    msg: "진행중인 작업지시는 삭제 할수 없습니다."
           	 	});         		
        		return false;
        	}else if (n.orderSt == 'END'){
        		if(n.prodQty > 0){
        			axDialog.alert({
                        theme: "warning",
                        msg: "생산된 양품이 존재하는 작업지시는 삭제 할 수 없습니다."
                    });
        		}else {
        			caller.gridView01.delRow("selected");
        		} 		
        		return false;
        	}else if (n.orderSt == 'NWRK'){
        		axDialog.alert({
                    theme: "warning",
                    msg: "비가동중인 작업지시는 삭제 할수 없습니다."
           	 	});        		
        		return false;
        	}else if (n.orderSt == 'CLOSE'){
        		axDialog.alert({
   	             theme: "warning",
   	                msg: "마감된 작업지시는 삭제 할수 없습니다."
   	    	 	});        		
        		return false;
        	}else {
        		caller.gridView01.delRow("selected");
        	}
        	
        });
    },
    /*ITEM_SUB_DEL: function (caller, act, data) {
        var dData = caller.gridView01.getData("selected");
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
            caller.gridView01.delRow("selected");
        }
    },*/
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
    //품목적용 - 라우팅 선택정보적용
    ROUTING_SELECT_MODAL_OPEN: function (caller, act, data) {
    	caller.gridView01.setData([]);
    	customModal.open({
            width: 1200,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/ROUTING-ITEM-M.jsp", 
                param: "callBack=customRoutingModalCallback&itemTypeGroup=P&routingYn=Y"
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
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("작업지시등록.xls");
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
	        data: {whType: "20",useYn:"Y"},		//생산창고(30) - > 출하창고(20)으로 변경
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
	        _this.pageButtonView.initView();
	        _this.searchView.initView();
	        _this.gridView01.initView();
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
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
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "orderNo", label: "지시번호", width: 100, align: "center"},
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
                /*
                {key: "scheduleDt", label: "완료예정일", width: 100, align: "center", editor: {
                    type: "date",
                    config: {
                        content: {       
                            config: {
                                mode: "day", selectMode: "day"
                            }
                        }
                    }
                } ,styleClass: "grid-cell-blue"},
                */
                {key: "orderSt"},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd"},
                        {key: "itemNm", width: 170},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
            	/*{
                    label: "공정정보", columns: [
        				{key: "routingCd", formatter: function formatter() { return CONVERT_CODE["ROUTING_CD"].map[this.value];}},
                        {key: "routCd"},            
                        {key: "equipUseYn"}, 
                        {key: "lastFlag"},
                        {key: "routSeq", label: "공정순번", width: 70, align: "center"},
                    ]
                },*/
				{key: "equipCd",label: "설비", width: 130, align: "center", formatter: function formatter() { return CONVERT_CODE["EQUIP_CD"].map[this.value];}},
				{key: "popupBtn1", width: 24, label: "", align: "center", formatter:function(){
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

                {key: "orderQty", label: "지시수량",width: 220, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
                //{key: "sort", label: "우선순위",width: 100, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"},
            ],
            body: {
                mergeCells: ["orderNo"],
            	onClick: function () {  
                    this.self.select(this.dindex);
                	if((this.column.key == "popupBtn1" || this.column.key == "equipCd") && nvl(this.item.equipUseYn,'N') == "Y") {
                    	ACTIONS.dispatch(ACTIONS.EQUIP_GRID_MODAL_OPEN, this);
                    } 
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
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
    addRoutRow: function (data) {
    	addRoutRow(this.target,data);
    },
    addRoutingRow: function (data) {
    	addRoutingRow(this.target,data);
    },
});

//공정 적용
function customRoutModalCallback(data){
	fnObj.gridView01.addRoutRow(data);
}

//라우팅 적용
function customRoutingModalCallback(data){
	fnObj.gridView01.addRoutingRow(data);
}

//BOM 적용
function customBomModalCallback(data){
	data.forEach(function (n) {
    	fnObj.gridView01.addRoutRow(n);
    });
	customModal.close();     
}

//공정 적용
function addRoutRow(obj,data){
	var tempOrderNo = randomStringCd(20);
	
	obj.addRow({__created__: true,
		company:data.company,  
		tempOrderNo:tempOrderNo,  
		itemCd:data.itemCd,  
		itemNm:data.itemNm,  
		whCd:data.whCd,  
		routType:data.routType,  
		routingCd:data.routingCd,  
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
		orderSt:""
		}, "last");
}

//라우팅 적용
function addRoutingRow(obj,data){
	var tempOrderNo = randomStringCd(20);
	//공정 자동 적용
	ppmboot.ajax({
	    type: "GET",
	    url:  ["rout", "step"],
		data: {routingCd:data.routingCd,itemCd:data.itemCd,routType:data.routType},
	    callback: function (res) {
	    	if(res.list.length > 0){
	        	res.list.forEach(function (n) {   
		    		obj.addRow({__created__: true,
		    			company:n.company,  
		    			tempOrderNo:tempOrderNo,  
		    			itemCd:data.itemCd,  
		    			itemNm:data.itemNm,  
		    			whCd:n.whCd,  
		    			routType:n.routType,  
		    			routingCd:n.routingCd,  
		    			equipUseYn:nvl(n.equipUseYn,'N'),
		    			routCd:n.routCd,  
		    			routSeq:n.routSeq,
		    			outscFlag:n.outscFlag,  
		    			//equipCd:data.equipCd,  
		    			//equipNm:data.equipNm,
		    			spec:data.spec,
		    			unit:data.unit,
		    			lastFlag:nvl(n.lastFlag,'N'),
		    			orderDt:nvl(data.orderDt , getNowDt()),     
		    			orderSt:""
		    			}, "last");
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

//설비가져오기
function customEquipModalCallback(data,param){	
	var idx = param.idx;	
	fnObj.gridView01.target.setValue(idx,"equipCd", data.equipCd);
	fnObj.gridView01.target.setValue(idx,"equipNm", data.equipNm);		
	customModal.close();     
}  

/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 생산실적수정
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var master;

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
    	master = "";
    	ppmboot
		.call({
	     	type: "GET",
			 url: ["worderList" ,"workOrderList"],
			 data: $.extend({orderSt:"END"}, getSerializeArrayToJson("#searchView0")),
	         callback: function (res) {
	            caller.gridView01.setData(res);
	            caller.gridView02.setData([]);
	            caller.gridView03.setData([]);
	            //caller.gridView04.setData([]);
	            caller.gridView05.setData([]);
	            caller.gridView06.setData([]);
	         }
	    })  
        .done(function () {
        });   
   	 
        return false;
    },    
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	master = data;
    	ppmboot
	        //자재출고목록	
	        .call({
	                type: "GET",
	                url:  ["worderList","outgoingList"],
		            data: {wlotNo:data.wlotNo, discardYn:"N"},
	                callback: function (res) {
	                    caller.gridView02.setData(res);
	                }
	        })
	        //불량유형	
	        .call({
	                type: "GET",
	                url:  ["worderList","badList"],
		            data: {wlotNo:data.wlotNo},
	                callback: function (res) {
	                    caller.gridView03.setData(res);
	                }
	        })
	        /*//비가동	
	        .call({
	                type: "GET",
		   	         	url: ["worderList" ,"nwrkList"],
		            data: {wlotNo:data.wlotNo},
	                callback: function (res) {
	                    caller.gridView04.setData(res);
	                }
	        })*/
	        //작업자정보
	        .call({
	            type: "GET",
	            url:  ["worderList","workManList"],
	            data: {wlotNo:data.wlotNo},
	            callback: function (res) {
	            	console.log(res);
	                caller.gridView05.setData(res);
	            }
	        })
	        //작업자정보
	        .call({
	            type: "GET",
	   	        url: ["worderList" ,"incomingList"],
	            data: {wlotNo: data.wlotNo},
	            callback: function (res) {
	                caller.gridView06.setData(res);
	            }
	        })
	        .done(function () {
	        });
    	return false;
    },   
    //자재적용
    OUT_STOCK_MODAL: function (caller, act, data) {
    	if (nvl(master,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "자재 적용할 실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	ppmboot.modal2.open({  
            modalType: "OUT-STOCK-M",
            param: "",
            sendData: function(){
            	return {
                    "order" : master,
                    "outType" : "USE",
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    //불량적용
    BAD_ITEM_MODAL: function (caller, act, data) {
    	if (nvl(master,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "불량 적용할 실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	ppmboot.modal2.open({  
            modalType: "BAD-ITEM-M",
            param: "",
            sendData: function(){
            	return {
                    "order" : master
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
  //생산실적 추가
    ADD_PRD: function (caller, act, data) {
    	if (nvl(master,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "실적추가할 생산실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	
    	axDialog.prompt({
            input: {
                itemQty: {label: "추가실적수량", type: "number", value: "", required: true}
            }
        }, function () {
            if (this.key == "ok") {
            	
            	var itemQty = this.input.itemQty;

            	if(nvl(itemQty,0) > 0){

                    var dData = caller.gridView01.getData("selected");
                    var n = dData[0];
                    
                	var obj = {workMaster:n,itemQty:nvl(itemQty,0)};  
                	axDialog.confirm({
                        theme: "danger",
                        msg: "<font color=red>생산 실적을 수정 하시겠습니까?</font>"
                    }, function () {
                    	if(this.key == "ok")
                    	{
                    		
                    		ppmboot
	            	            .call({
	            	           	type: "PUT", 
	            	           	url: ["worderMaster","updateWorkMaster"], 
	            	               data: JSON.stringify(obj),
	            	               callback: function (res) {         	
	            	                   axToast.push("저장 되었습니다.");
	            	               }
	            	            })
	            	            .done(function () {
	            	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	            	            });
	            	            
                    		}
                    });      
            	}
            }
        });
    },
    //생산실적 삭제
    DEL_PRD: function (caller, act, data) {
    	var list6 = caller.gridView06.getData("selected");
    	if (list6.length == 0){
    		axDialog.alert({
                theme: "warning",
                msg: "삭제할 실적이 선택되지 않았습니다."
            });
	       	return false;
    	}
    	
    	axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>생산 실적을 삭제 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		ppmboot
        	        .call({
        	       	type: "PUT", 
        	       	url: ["worderMaster","deleteWorkMaster"], 
        	           data: JSON.stringify(list6),
        	           callback: function (res) {  
        	        	   ppmboot.ajax({
                               type: "PUT",
                               url: ["/api/v1/pop2/cancelWorkProdQty"],
                                data: JSON.stringify(list6[0]),
                               callback: function (res) {      
                               }
        	        	   });
        	           }
        	        })
        	        .done(function () {
        	        	axToast.push("저장 되었습니다.");
        	            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	        });
        	}
        });      
    },
    //작업자 적용
    USER_SELECT_MODAL_OPEN: function (caller, act, data) {
    	if (nvl(master,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "작업자 적용할 실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/USER-SEL-M.jsp", 
                param: "callBack=workManSelectCallback"
            }
        });          
    },  
    //작업자저장
    WORKMAN_SAVE: function (caller, act, data) {    	

    	var sData = getSerializeArrayToJson("#searchView0");
        var dData = [].concat(caller.gridView05.getData());  
        	dData = dData.concat(caller.gridView05.getData("deleted"));
        var wrkDtm;
        var wrkedDtm;
        var itemQtyCnt1 = 0;	          	
        var itemQtyCnt2 = 0;	          	
        var itemQtyCnt3 = 0;	        
        var detailSize = dData.length;

        dData.forEach(function (n) {

        	n.company = sData.company;
        	n.wrkHour = pad(nvl(n.wrkHour,''),2);
        	n.wrkMinute = pad(nvl(n.wrkMinute,''),2);
        	n.wrkedHour = pad(nvl(n.wrkedHour,''),2);
        	n.wrkedMinute = pad(nvl(n.wrkedMinute,''),2);
        	
        	
        	wrkDtm = nvl(n.wrkDt,'') + nvl(n.wrkHour,'') + nvl(n.wrkMinute,'');
        	wrkedDtm = nvl(n.wrkedDt,'') + nvl(n.wrkedHour,'') + nvl(n.wrkedMinute,'');
        	wrkDtm = wrkDtm.replace(/-/gi, "");
        	wrkedDtm = wrkedDtm.replace(/-/gi, "");
        	
        	if (wrkDtm.length != 12){
        		itemQtyCnt1++;
        		return false;
        	}  

        	if (wrkedDtm.length != 12){
        		itemQtyCnt2++;
        		return false;
        	}  
        	
        	if (wrkDtm >= wrkedDtm){
        		itemQtyCnt3++;
        		return false;
        	}  
        });

        if(itemQtyCnt1 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg: "시작시간을 입력하세요"
             });
         	 return false;
        }else if(itemQtyCnt2 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "종료시간을 입력하세요"
           });
        	 return false;
        }else if(itemQtyCnt3 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "시작시간이 종료시간보다 큽니다."
           });
        	 return false;
        }else if(detailSize == 0){
          	 axDialog.alert({
                   theme: "warning",
                   msg: "등록된 작업자정보가 없습니다."
             });
          	 return false;
        }else{
        	axDialog.confirm({
                theme: "danger",
                msg: "<font color=red>작업자 정보들 등록 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{
            		ppmboot
	   		         .call({
	   		        	type: "PUT", 
	   		        	url: ["worderMaster","saveWorkMan"], 
	   		            data: JSON.stringify(dData),
	   		            callback: function (res) {         	
	   		                axToast.push("저장 되었습니다.");
	   		            }
	   		         })
	   		         .done(function () {
	   		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	   		         });
            	}
            });      
			
        }
    },
    //작업자 삭제
    WORKMAN_DELETE: function (caller, act, data) {
        caller.gridView05.delRow("selected");
    },
    
    
    /*PAGE_SAVE: function (caller, act, data) {    	
        var n = master;
        
        var startDtm;
        var endDtm;
        var itemQtyCnt1 = 0;	          	
        var itemQtyCnt2 = 0;	          	
        var itemQtyCnt3 = 0;
        

    	n.startHour = pad(nvl(n.startHour,''),2);
    	n.startMinute = pad(nvl(n.startMinute,''),2);

    	n.endHour = pad(nvl(n.endHour,''),2);
    	n.endMinute = pad(nvl(n.endMinute,''),2);
    	
        startDtm = nvl(n.startDt,'') + nvl(n.startHour,'') + nvl(n.startMinute,'');
        endDtm = nvl(n.endDt,'') + nvl(n.endHour,'') + nvl(n.endMinute,'');
        
        
    	startDtm = startDtm.replace(/-/gi, "");
    	endDtm = endDtm.replace(/-/gi, "");
    	
    	
    	if (startDtm.length != 12){
    		itemQtyCnt1++;
    	}  

    	if (endDtm.length != 12){
    		itemQtyCnt2++;
    	}  
    	
    	if (startDtm > endDtm){
    		itemQtyCnt3++;
    	}  
    	
    	
        if(itemQtyCnt1 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg: "시작시간을 입력하세요"
             });
         	 return false;
        }else if(itemQtyCnt2 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "종료시간을 입력하세요"
           });
        	 return false;
        }else if(itemQtyCnt3 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "시작시간이 종료시간보다 큽니다."
         	 });
        	 return false;
        }else{
        	
        	var obj = {workMaster:n,itemQty:nvl(n.itemQty,0)};  
        	
        	axDialog.confirm({
                theme: "danger",
                msg: "<font color=red>생산 실적을 수정 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{
            		ppmboot
    	            .call({
    	           	type: "PUT", 
    	           	url: ["worderMaster","updateWorkMaster"], 
    	               data: JSON.stringify(obj),
    	               callback: function (res) {         	
    	                   axToast.push("저장 되었습니다.");
    	               }
    	            })
    	            .done(function () {
    	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    	            });
            	}
            });      
        }
    },
    PAGE_DEL: function (caller, act, data) {
    	var list1 = caller.gridView01.getData("selected");
    	if (list1.length == 0){
    		axDialog.alert({
                theme: "warning",
                msg: "취소할 실적이 선택되지 않았습니다."
            });
	       	return false;
    	}
    	
    	axDialog.confirm({
            theme: "danger",
            msg: "<font color=red>생산 실적을 취소 하시겠습니까?[작업지시 대기상태로 전환]</font>"
        }, function () {
        	if(this.key == "ok")
        	{
            	ppmboot
        	        .call({
        	       	type: "PUT", 
        	       	url: ["/api/v1/pop2/updateWorkCancelAll"], 
        	           data: JSON.stringify(list1),
        	           callback: function (res) {         	
        	               axToast.push("저장 되었습니다.");
        	           }
        	        })
        	        .done(function () {
        	            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	        });
        	}
        });      
    },
    //비가동저장
    NWRK_SAVE: function (caller, act, data) {    	
    	
    	var sData = getSerializeArrayToJson("#searchView0");
        var dData = [].concat(caller.gridView04.getData());  
        
        var nwrkDtm;
        var nwrkedDtm;
        var itemQtyCnt1 = 0;	          	
        var itemQtyCnt2 = 0;	          	
        var itemQtyCnt3 = 0;	        
        var detailSize = dData.length;

        dData.forEach(function (n) {
         	n.company = sData.company;

        	n.nwrkHour = pad(nvl(n.nwrkHour,''),2);
        	n.nwrkMinute = pad(nvl(n.nwrkMinute,''),2);
        	n.nwrkedHour = pad(nvl(n.nwrkedHour,''),2);
        	n.nwrkedMinute = pad(nvl(n.nwrkedMinute,''),2);
        	
        	nwrkDtm = nvl(n.nwrkDt,'') + nvl(n.nwrkHour,'') + nvl(n.nwrkMinute,'');
        	nwrkedDtm = nvl(n.nwrkedDt,'') + nvl(n.nwrkedHour,'') + nvl(n.nwrkedMinute,'');
        	
        	
        	nwrkDtm = nwrkDtm.replace(/-/gi, "");
        	nwrkedDtm = nwrkedDtm.replace(/-/gi, "");
        	
        	if (nwrkDtm.length != 12){
        		itemQtyCnt1++;
        		return false;
        	}  

        	if (nwrkedDtm.length != 12){
        		itemQtyCnt2++;
        		return false;
        	}  
        	
        	if (nwrkDtm > nwrkedDtm){
        		itemQtyCnt3++;
        		return false;
        	}  
        });

        if(itemQtyCnt1 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg: "시작시간을 입력하세요"
             });
         	 return false;
        }else if(itemQtyCnt2 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "종료시간을 입력하세요"
           });
        	 return false;
        }else if(itemQtyCnt3 > 0){
         	 axDialog.alert({
                 theme: "warning",
                 msg: "시작시간이 종료시간보다 큽니다."
           });
        	 return false;
        }else if(detailSize == 100){
          	 axDialog.alert({
                   theme: "warning",
                   msg: "등록된 비가동정보가 없습니다."
             });
          	 return false;
        }else{
        	dData = dData.concat(caller.gridView04.getData("deleted"));
        	
        	axDialog.confirm({
                theme: "danger",
                msg: "<font color=red>비가동현황을 등록 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{
            		ppmboot
	   		         .call({
	   		        	type: "PUT", 
	   		        	url: ["worderMaster","saveWorkNwrk"], 
	   		            data: JSON.stringify(dData),
	   		            callback: function (res) {         	
	   		                axToast.push("저장 되었습니다.");
	   		            }
	   		         })
	   		         .done(function () {
	   		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	   		         });
            	}
            });      
        }
    },
    NWRK_DELETE: function (caller, act, data) {
        caller.gridView04.delRow("selected");
    },
    //비가동 선택정보적용
    NWRK_SELECT_MODAL_OPEN: function (caller, act, data) {
    	if (nvl(master,'') == '' || nvl(master.routCd,'') == ''){
    		axDialog.alert({
                theme: "warning",
                msg: "비가동 적용할 실적을 상단에서 선택하십시요."
            });
	       	return false;
    	}
    	
    	customModal.open({
            width: 900,
            height: 500,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/NWRK-M.jsp", 
                param: "callBack=nwrkSelectCallback&routCd="+master.routCd
            }  
        });    	
    },*/
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
            _this.gridView03.initView();
            //_this.gridView04.initView();
            _this.gridView05.initView();
            _this.gridView06.initView();
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
            /*"save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "fn1": function () {
            	ACTIONS.dispatch(ACTIONS.PAGE_DEL);
            },*/
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

        ppmboot.buttonClick(this, "data-page-btn", {      
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
        });
    }
});

/**
 * gridView01	생산실적
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
                {key: "orderDt", width: 100},
                {key: "wlotNo", width: 100},
                {key: "itemCd", label: "품목코드", width: "*", align: "center"},
                {key: "itemNm", label: "품목명", width: 150, align: "center"},
                //{key: "partNo"},
                {key: "spec", width: 150},
                //{key: "routCd"},
                //{key: "routSeq", label: "공정순번", width: 60, align: "center"},
                { 
                    label: "시작", columns: [
                        {key: "startDt", label: "시작일", width: 100, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"startHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"startMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
                    ]
                },
                { 
                    label: "종료", columns: [
                        {key: "endDt", label: "종료일", width: 100, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"endHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"endMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},     
                    ]
                },
                {key: "orderQty", label: "지시수량", width:80, formatter:"number", align: "right"},
                {key: "prodQty", label: "생산수량", width:80, align: "center", formatter:"number", align: "right"},
                {key: "badQty", label: "불량수량", width:80, align: "center", formatter:"number", align: "right"},
                {key: "goodQty", label: "양품수량", width:80, align: "center", formatter:"number", align: "right"},
                //{key: "orderSt", label: "작업상태"},
                //{key: "routQcYn"},
                {key: "outYn"},
            ],       
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
                onDataChanged: function () {  	
		        	if(this.key == "startDt" || this.key == "startHour" || this.key == "startMinute" || this.key == "endDt" || this.key == "endHour" || this.key == "endMinute") {
                    	ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
                    }
		        }
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
                return this.wlotNo;
            });
        } else {
            list = _list;
        }
        return list;
    },
});

/**
 * gridView02 자재출고
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [

                {key: "itemCd",width:120, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
                {key: "itemNm",width:200, formatter:function(){
                	if(this.item.remainQty < 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	if(this.item.consumQty > 0){
                    		return "<font color='blue'>"+this.value+"</font>";
                    	}else{
                    		return this.value;
                    	}
                	}
                }},
            	{
                    label: "불출(소요단위)", columns: [
                        {key: "lotNo", width: 120},
                        {key: "barcode", width: 120},
                        {key: "bomItemQty", label: "투입수량", width: 120, formatter:"number", align: "right"},
                        {key: "transConsumQty", label: "소모수량", width: 120, formatter:"number", align: "right"},
                        {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                    ]
                },	
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
       	 	"out-stock": function () {
                ACTIONS.dispatch(ACTIONS.OUT_STOCK_MODAL);
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
                return this.itemCd;
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
 * gridView03	불량
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "badDtm", label: "발생시간",width: 130, align: "center", formatter:function(){
                	return convertStringToTimestamp(this.value)
                }},
                {key: "badCd"}, 
                {key: "badItemQty", label: "불량수량", width: 80, formatter:"number", align: "right"},
                {key: "unit"},
                
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });        
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
	       	 "bad-all": function () {
	             ACTIONS.dispatch(ACTIONS.BAD_ITEM_MODAL);
	         }, 
	         "del-bad": function () {
	             ACTIONS.dispatch(ACTIONS.RETURN_ITEM);
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

/**
 * gridView04	비가동
 */
fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-04"]'),
            columns: [
                {key: "nwrkCd",width:200},
                { 
                    label: "시작", columns: [
                        {key: "nwrkDt", label: "시작일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"nwrkHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"nwrkMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
                { 
                    label: "종료", columns: [
                        {key: "nwrkedDt", label: "종료일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},
        				{key:"nwrkedHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"nwrkedMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
            ],
            body: {
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-04-btn", {
        	 "nwrk-all": function () {
                 ACTIONS.dispatch(ACTIONS.NWRK_SELECT_MODAL_OPEN);
             },   
             "item-remove": function () {
                 ACTIONS.dispatch(ACTIONS.NWRK_DELETE);
             }, 
             "item-save": function () {
                 ACTIONS.dispatch(ACTIONS.NWRK_SAVE);
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
                return this.nwrkSeq;
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
        	nwrkCd:data.nwrkCd,company:data.company,wlotNo:data.wlotNo,
        	nwrkDt:master.orderDt,nwrkedDt:master.orderDt
        	}, "last");
    }
});

/**
 * gridView05	작업자
 */
fnObj.gridView05 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-05"]'),
            columns: [
                {key: "userCd", label: "사용자ID", width:100, align: "center"},
                {key: "userNm", label: "사용자명", width:100, align: "center"},
                { 
                    label: "시작", columns: [
                        {key: "wrkDt", label: "시작일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},

        				{key:"wrkHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"wrkMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
                { 
                    label: "종료", columns: [
                        {key: "wrkedDt", label: "종료일", width: 80, align: "center", editor: {
                            type: "date",
                            config: {
                                content: {       
                                    config: {
                                        mode: "day", selectMode: "day"
                                    }
                                }
                            }
                        },styleClass: "grid-cell-blue"},

        				{key:"wrkedHour", label: "시간",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},       
        				{key:"wrkedMinute", label: "분",width:60, align: "center",editor: {type: "text"},styleClass:"grid-cell-select"},   
                    ]
                },
                {key: "prodQty", label: "생산수량", width: 80, formatter:"number", align: "right", editor: {type: "number"},styleClass:"grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-05-btn", {
        	 "workman-all": function () {
                 ACTIONS.dispatch(ACTIONS.USER_SELECT_MODAL_OPEN);
             },   
             "item-remove": function () {
                 ACTIONS.dispatch(ACTIONS.WORKMAN_DELETE);
             }, 
             "item-save": function () {
                 ACTIONS.dispatch(ACTIONS.WORKMAN_SAVE);
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
                return this.userSeq;
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
        this.target.addRow({__created__: true,userCd:data.userCd,
        	userNm:data.userNm,company:data.company,wlotNo:data.wlotNo,
        	wrkDt:master.orderDt,wrkedDt:master.orderDt,
        	}, "last");
    }
});

/**
 * gridView06 생산실적
 */
fnObj.gridView06 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-06"]'),
            columns: [
                {key: "lotNo"},
                {key: "barcode"},
                {key: "itemQty"},
                {key: "unit"},
                {key: "updatedAt",label:"실적시간",width:200}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-06-btn", {
        	 "add-prd": function () {
                 ACTIONS.dispatch(ACTIONS.ADD_PRD);
             },   
             "del-prd": function () {
                 ACTIONS.dispatch(ACTIONS.DEL_PRD);
             }, 
             /*"save-prd": function () {
                 ACTIONS.dispatch(ACTIONS.SAVE_PRD);
             }, */
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
                return this.woSeq;
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
        this.target.addRow({__created__: true,userCd:data.userCd,
        	userNm:data.userNm,company:data.company,wlotNo:data.wlotNo,
        	wrkDt:master.orderDt,wrkedDt:master.orderDt,
        	}, "last");
    }
});

//작업자적용
function workManSelectCallback(item){
	item.wlotNo = master.wlotNo;
	fnObj.gridView05.addRow(item);
}

// 비가동 적용
function nwrkSelectCallback(item){
	item.wlotNo = master.wlotNo;
	fnObj.gridView04.addRow(item);
}
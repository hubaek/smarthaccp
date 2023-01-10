/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: POP메인
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */


var fnObj = {};
var wlotNo;
var wlotNoIdx;
var setupInfo;
var equipCd;
var MODAL_NAME = "PC030M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
	
	//페이지 세로고침	로그인 사용자별 POP 권한 가져오기
    PAGE_REFRESH: function (caller, act, data) {
    	ppmboot
			.call({
		     	type: "GET",
				 url: ["/api/v1/pop2/getSetup"],
				 data: {},
		         callback: function (data) {
		        	//가져온 권한 전역 변수 셋팅.
		        	setupInfo = data;		      
		        	//공정분류,공정 셋팅.
	               	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,setupInfo);       
		         }
		    })  
	        .done(function () {
	        });   
    },        
	//RUNNING 중인 오더 목록 가져오기.
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
        	type: "GET",
			url: ["/api/v1/pop2/getWorkOrderList"],
			data: {orderSt:$("#orderType").val(),routType:$("#routType").val(),routCd:$("#routCd").val(),equipAuthYn:setupInfo.equipAuthYn,userCd:setupInfo.userCd},
	        callback: function (res) {
	           caller.gridView01.setData(res);
	           if(res.length > 0){
	        	   wlotNoIdx = 0;
	        	   if(nvl(wlotNo,'') != ''){
	        		   res.forEach(function (n) {   
			           		if(n.wlotNo == wlotNo){
			 	        	   caller.gridView01.target.select(wlotNoIdx);
				               ACTIONS.dispatch(ACTIONS.ORDER_CLICK,res[wlotNoIdx]);
			 	        	   return false;
			           		}		           		
			           		wlotNoIdx++;
			       		});     
	        	   }else{
	 	        	   caller.gridView01.target.select(wlotNoIdx);
		               ACTIONS.dispatch(ACTIONS.ORDER_CLICK,res[wlotNoIdx]);
	        	   }
	           }else{
	        	   caller.gridView02.setData([]);
	               caller.gridView03.setData([]);
	               caller.gridView05.setData([]);
	               caller.gridView06.setData([]);
	               buttonControl("","");
	            }
	         }
        });	 
    },        
    ORDER_CLICK: function (caller, act, data) {    	 
    	wlotNo = nvl(data.wlotNo,'');    	
    	equipCd = nvl(data.equipCd,'');    	
    	if(wlotNo != ''){
        	ppmboot
    		.call({
    	     	type: "GET",
    			 url: ["/api/v1/pop2/getWorkOrderManList"],
    			 data: {wlotNo:wlotNo},
    	         callback: function (res) {
    	            caller.gridView02.setData(res);
    	         }
    	    })  
            .call({
                type: "GET",
                url:  ["/api/v1/pop2/getOutgoingList"],
                data: {wlotNo: wlotNo},
                callback: function (res) {
                    caller.gridView03.setData(res);
                }    
            })
            .call({
                type: "GET",
                url:  ["/api/v1/pop2/getWorkBadList"],
                data: {wlotNo: wlotNo},
                callback: function (res) {
                    caller.gridView05.setData(res);
                }    
            })
	   	   	.call({
	   	     	type: "GET",
	   	        url: ["worderList" ,"incomingList"],
	            data: {wlotNo: wlotNo},
	   	        callback: function (res) {
	   	           caller.gridView06.setData(res);
	   	        }
		   	 })  
            .done(function () {
            	buttonControl(data.orderSt,data);
            });   
    	}
    },
    START_ORDER: function (caller, act, data) {    	    	
    	
    	var mData = caller.gridView01.getData("selected");    	
    	
    	if(nvl(mData[0].equipUseYn,'N') == 'Y' && nvl(mData[0].equipCd,'') == ''){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "설비를 등록하세요."
            });
        	return false;
    	}else{
    		var d1Data = caller.gridView02.getData();  
        	var alertMsg = "";

    		alertMsg = "작업을 시작 하시겠습니까?";
        	
        	axDialog.confirm({
                theme: "danger",
                width:500,
                msg: "<font color=red>"+alertMsg+"</font>"
            }, function () {
            	if(this.key == "ok")
            	{
                    
                    if(mData[0].orderSt == 'NWRK'){
                    	mData[0].orderSt = "RUN";
            	        ppmboot.ajax({
            	        	type: "PUT", 
            	        	url: ["/api/v1/pop2/updateWorkNwrk"], 
            	        	data: JSON.stringify(mData[0]),
            	            callback: function (res) {         
            	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            	            }
            	        });	 
                    }else{
                    	 var obj = {
                    	    		workMaster: mData[0],
                    	    		workMan: d1Data
                	        	};
                    	        
            	        ppmboot.ajax({
            	        	type: "PUT", 
            	        	url: ["/api/v1/pop2/updateWorkStart"], 
            	        	data: JSON.stringify(obj),
            	            callback: function (res) {    
            	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            	            }
            	        });
                    }
                }
            });  
    	}
    },
    END_ORDER: function (caller, act, data) {    	
    	var mData = caller.gridView01.getData("selected");
    	
    	/*if(nvl(mData[0].routQcYn,'N') == 'N'){
    		alertMsg = "등록된 공정검사실적이 없습니다. 작업을 종료 하시겠습니까?";
    	}*/
    	if(nvl(mData[0].prodQty,0) == 0){
    		alertMsg = "등록된 실적이 없습니다. 작업을 취소 하시겠습니까?";
    	}else{
    		alertMsg = "작업을 종료 하시겠습니까?";
    	}
    	
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>"+alertMsg+"</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		if(nvl(mData[0].prodQty,0) == 0){
            		var list3 = caller.gridView03.getData(); // 자재투입
            		
            		if (list3.length > 0){
            			axDialog.alert({
                            theme: "primary",
                            width:500,
                            msg: "작업취소:투입된 자재를 먼저 환입하세요."
                        });
            			return false;
            		}
            		            		
            		ppmboot.ajax({
                    	type: "PUT", 
                    	url: ["/api/v1/pop2/updateWorkCancel"], 
                    	data: JSON.stringify(mData[0]),
                        callback: function (res) {   
        	            	wlotNo = "";
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });
        			
        		}else{
        			ppmboot.ajax({
                    	type: "PUT", 
                    	url: ["/api/v1/pop2/updateWorkEnd"], 
                    	data: JSON.stringify(mData[0]),
                        callback: function (res) {   
        	            	wlotNo = "";
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });
        			ppmboot.ajax({
        				type: "GET",
        				url: ["/api/v1/pop2/updateWorkEnd2"],
        				data: {wlotNo : mData[0].wlotNo},
        				callback: function(res){
        					wlotNo = "";
        					ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        				}
        			});
        			ppmboot.ajax({
        				type: "GET",
        				url: ["/api/v1/pop2/updateWorkEnd3"],
        				data: {wlotNo : mData[0].wlotNo},
        				callback: function(res){
        					wlotNo = "";
        					ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        				}
        			});
        		}
            }
        });   
    },
    SEARCH_ORDER: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: "POP-SEARCH-ORDER",
            param: "",
            sendData: function(){
            	return {
                    "setupInfo" : setupInfo
                };
            },
            callback: function (data) {
        	   caller.gridView02.setData([]);
               caller.gridView03.setData([]);
               caller.gridView05.setData([]);
               caller.gridView06.setData([]);
               
               addWorkOrder(data);
            	
               wlotNo = "";
               equipCd = "";
            	
               buttonControl(data.orderSt,data);
               this.close();
            }
        });
    },
    SEARCH_NWRK: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-SEARCH-NWRK",
            param: "",
            sendData: function(){
            	return {
                    "order" : mData[0]
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    //2020-09-22 재고현황
    ST_SEARCH: function (caller, act, data) {
    	
    	
    	ppmboot.modal.open({  
            modalType: "POP-ST-SEARCH",
            param: "",
            sendData: function(){
            	return {
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });
        
    },
    
    //2020-09-22 재고 실사
    ST_ADD_FORM: function (caller, act, data) {

            	ppmboot.modal.open({  
                    modalType: "ST130M",
                    param: "",
                    sendData: function(){
                        return {
                        	"mode" : "add"
                        };
                    },
                    callback: function (data) {
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                    }
	        });
	    },
	    
	  //2021-01-06 재고현황(출하창고)
	    SA_SEARCH: function (caller, act, data) {	    	
	    	ppmboot.modal.open({  
	            modalType: "POP-SA-SEARCH",
	            param: "",
	            sendData: function(){
	            	return {
	                };
	            },
	            callback: function (data) {
	                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
	            }
	        });
	        
	    },
	    
	    //2021-01-06 재고실사(출하창고)
	    SA_ADD_FORM: function (caller, act, data) {

	            	ppmboot.modal.open({  
	                    modalType: "ST120M",
	                    param: "",
	                    sendData: function(){
	                        return {
	                        	"mode" : "add"
	                        };
	                    },
	                    callback: function (data) {
	                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	                    }
		        });
		    },
    
	    //2020-11-12 원재료입고 등록
	    RMT_ADD_FORM: function (caller, act, data) {
	    	axDialog.confirm({
	            msg: "[신규등록] 하시겠습니까?"
	        }, function () {
	            if (this.key == "ok") {
	            	ppmboot.modal.open({  
	                    modalType: "POP-PC030M",
	                    param: "",
	                    sendData: function(){
	                        return {
	                        	"mode" : "add"
	                        };
	                    },
	                    callback: function (data) {
	                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	                    }
	                });
	            	
	            }
	        });
	    },
	    
	    //2020-11-12 원재료 출고 등록
	    RMT_OUT_FORM: function (caller, act, data) {

	            	ppmboot.modal.open({  
	                    modalType: "POP-PC090M",
	                    param: "",
	                    sendData: function(){
	                        return {
	                        };
	                    },
	                    callback: function (data) {
	                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	                    }
	                });

	    },
  //입출고 등록
    POP_IN_OUT_MODAL: function (caller, act, data) {
    	
    	window.open('/jsp/pop/modal/pop-in-out-modal.jsp', 'inout-modal','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1400,height=950,scrollbars=yes')
    },
    
    // 2020-12-17 설비등록 변경
    CHANGE_EQUIP: function (caller, act, data) {
        var mData = caller.gridView01.getData("selected");
        ppmboot.modal.open({  
             modalType: "POP-EQUIP",
             param: "",
             sendData: function(){
                return {
                     "order" : mData[0],
                     "setupInfo" : setupInfo,
                     "refYn" : "N"
                 };
             },
             callback: function (data) {
                 if (typeof data === "undefined"){
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                 }else{
                    equipCd = data.equipCd;
                    fnObj.gridView01.target.setValue(mData[0].__index,"equipCd", data.equipCd);
                    fnObj.gridView01.target.setValue(mData[0].__index,"equipNm", data.equipNm);      
                    fnObj.gridView01.target.setValue(mData[0].__index,"refEquipCd", data.refEquipCd);
                    fnObj.gridView01.target.setValue(mData[0].__index,"refEquipName", data.refEquipName);      
                    buttonControl(data.orderSt,data);
                 }
             }
         });
     },
    
//  kjm
    POP_IN_OUT_MODAL2: function (caller, act, data) {  
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-NUM-PAD-PROD2",
            param: "",
            sendData: function(){
            	return {
                    "wlotNo" : mData[0].wlotNo
                };
            },
            callback: function (data) {
            	currentIdx = fnObj.gridView01.target.selectedDataIndexs[0];
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    }, 
    SETUP_MODAL: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-SETUP",
            param: "",
            sendData: function(){
            	return {
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });
    },
    MENU_MODAL: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-MENU",
            param: "",
            sendData: function(){
            	return {
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });
    },
    OUT_STOCK: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-OUT-STOCK",
            param: "",
            sendData: function(){
            	return {
                    "order" : mData[0]
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    NUMBER_IN_PAD_MODAL: function (caller, act, data) {  
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-NUM-PAD-PROD",
            param: "",
            sendData: function(){
            	return {
                    "wlotNo" : mData[0].wlotNo
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    //작업표준서
    WO_DOC: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-WO-DOC",
            param: "",
            sendData: function(){
            	return { 
                    "order" : mData[0]
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },
    //불량
    BAD_MODAL: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");    	
        	ppmboot.modal.open({  
                modalType: "POP-BAD",
                param: "",
                sendData: function(){
                	return { 
                        "order" : mData[0]
                    };
                },
                callback: function (data) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });
    },
    //바코드
    BARCODE_MODAL: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");

		ppmboot.modal.open({  
            modalType: "POP-BARCODE",
            param: "", 
            sendData: function(){
            	return { 
                    "order" : mData[0],
                    "setupInfo" : setupInfo
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    	
    	/*
    	if(nvl(mData[0].lastFlag,'N') != 'Y'){
        	axDialog.alert({
                theme: "primary",
                msg: "최종공정만 바코드 발행 가능합니다."
            });
        	return false;
    	}else{
    		ppmboot.modal.open({  
	            modalType: "POP-BARCODE",
	            param: "", 
	            sendData: function(){
	            	return { 
	                    "order" : mData[0],
	                    "setupInfo" : setupInfo
	                };
	            },
	            callback: function (data) {
	                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	            }
	        });
    	}
    	*/
    },
    BARCODE_PRINT: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	if(nvl(mData[0].goodQty,0) == 0){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "발행 가능한 수량이 없습니다."
            });
        	return false;
    	}else{	
	    	axDialog.confirm({
	            theme: "danger",
                width:500,
	            msg: "<font color=red>현재 생산 실적으로 바코드 인쇄 하시겠습니까?</font>"
	        }, function () {
	        	if(this.key == "ok")
	        	{
	        		var item = mData[0];
	        		item.printCnt = 1;
	        		item.stockQty = item.barcodeQty;	//출고가능수량 데이터 생성
	        		sendBarcodeList(item);
	            }
	        });   
    	}	    	
    },    
    ADD_WORKMAN: function (caller, act, data) {
    	
    	var mData = caller.gridView01.getData("selected");
    	var wData = new Array();
    	var list2 = caller.gridView02.getData();
    	
    	if(mData.length > 0){

        	ppmboot.modal.open({  
                modalType: "POP-SEARCH-MAN",
                param: "",
                sendData: function(){
                	return {
                        "routCd" : mData[0].routCd
                    };
                },
                callback: function (data) {
        	    	axDialog.confirm({
        	            theme: "danger",
                        width:500,
        	            msg: "<font color=red>작업자를 추가하시겠습니까?</font>"
        	        }, function () {
        	        	if(this.key == "ok")
        	        	{
        	        	    if(nvl(wlotNo,'') != ''){
        	        	    	
            	            	data.forEach(function (n) {
            	            		n.wlotNo = wlotNo;
            	            		
            	        	    	var chkCnt = 0;
            	            		list2.forEach(function (n2) {            
            	            			if(nvl(n2.wrkDtm,'') != '' && nvl(n2.wrkedDtm,'') == '' && n.userCd == n2.userCd){
            	            				chkCnt++;
            	            				return false;
            	            			}			
            	            	    });
            	            		
            	            		if(chkCnt==0){
        	            				wData.push(n);
            	            		}
            	                });
            	            	
            	            	if(wData.length > 0){
            	    	        	ppmboot.ajax({
            	        	        	type: "PUT", 
            	        	        	url: ["/api/v1/pop2/addWorkMan"], 
            	        		     	data: JSON.stringify(wData),
            	        		         callback: function (res) {       
            	        		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            	        		         }
            	    	        	});	     
            	            	}
        	        	    }else{
            	            	addWorkMan(data);
        	        	    }
        	            }
        	        });   
                	this.close();
                }
            });
    	}else{
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "작업지시 선택후, 작업자 등록 할 수 있습니다."
            });
        	return false;
    	}
    },
    DEL_WORKMAN: function (caller, act, data) {  
        var list = caller.gridView02.getData("selected");
        var ck1 = 0;
        
        list.forEach(function (n) {
        	if(nvl(n.wrkDtm,'') != ''){
        		ck1++;
        	}
        });
        
        if(ck1 > 0){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "이미 시작된 작업자는 삭제할 수 없습니다.'작업종료' 처리하세요."
            });
        	return false;
        }else{
            caller.gridView02.delRow("selected");
        }
    	
    },  
    END_WORKMAN: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 작업자를 '작업종료' 처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/endWorkMan"], 
    		     	data: JSON.stringify(data),
    		         callback: function (res) {       
    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    		         }
	        	});	     
            }
        });        
    },  
    //공정분류 변경
    CHANGE_ROUT_TYPE: function (caller, act, data) {           	

    	var routType = data.routType;
    	var routCd = data.routCd;
    	
    	$("#routType").val(routType);    	
    	
    	$("#routCd option").remove();
   		if(nvl(routType,'') == ''){
           	$("#routCd").append("<option value=''>공정 선택</option>")
   		}else{
   			
   			ppmboot.ajax({
   		    	type: "GET",
   	            url:  ["rout"],
   	            data: "routType=" + routType ,
   		        callback: function (res) {        
   	            	$("#routCd").append("<option value=''>전체</option>");
   		        	res.list.forEach(function (n) {
   	                	$("#routCd").append("<option value='"+n.routCd+"'>"+n.routNm+"</option>")
   		        	});	

   		        	if(nvl(routCd,'') != ''){
   		        		//$('#routCd option[value='+routCd+']').attr('selected','selected');
   			        	$("#routCd").val(routCd).attr("selected", "selected");
   		        	}else{
   		    			$("#routCd option:eq(0)").attr("selected","selected");	
   		        	}
   		        }
   		    });
   		}

   		if(setupInfo.routType != ''){
   			$("#routType").attr("disabled","disabled");   			
   		}else{
   			$("#routType").removeAttr("disabled");
   		}

   		if(setupInfo.routCd != ''){
   			$("#routCd").attr("disabled","disabled");   			
   		}else{
   			$("#routCd").removeAttr("disabled");
   		}

   		if(nvl(setupInfo.authYn,'N') == 'Y'){
   			$("#setup-modal").removeAttr("disabled");		
   		}else{
   			$("#setup-modal").attr("disabled","disabled");   	
   		}
   		
   		ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);   		
    },
    //입출고 등록
    INOUT_MODAL: function (caller, act, data) {
    	/*var mData = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: "POP-INOUT",
            param: "",
            sendData: function(){
            	return {
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
            }
        });*/
    	window.open('/jsp/pop/modal/inout-modal.jsp', 'inout-modal','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1400,height=950,scrollbars=yes')
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

/**
* searchView
*/
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
  initView: function () {
      this.target = $(document["searchView0"]);
      this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
  }
});


fnObj.pageStart = function () {
    var _this = this;
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "ORDER_ST"},
        callback: function (res) {        		
            this.ORDER_ST = res.list;
        }
    })
    .call({
        type: "GET",
        url: ["rout"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.routCd;   
    			n.subNm = n.routNm;
    		});            	
        	res.list.push({subCd:"",subNm:"전체"});
            this.ROUT_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();
        _this.gridView03.initView();
        _this.gridView05.initView();
        _this.gridView06.initView();

        $("#routType").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.CHANGE_ROUT_TYPE,{routType:$(this).val(),routCd:""});
        }); 
        
        $("#orderType").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
        
        $("#routCd").change(function(){ 
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        }); 

    	ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);       
    	
    	setInterval("refreshPage()", 600000); // 600000 ms(10분)가 경과하면 refreshPage() 함수를 실행합니다.
    });
    
    document.title = "POP_메인화면" ;
};

fnObj.pageResize = function () {
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);
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
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_REFRESH);");
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
            showRowSelector: false, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            scroller: {size: 35},
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            columns: [
                {key: "orderDt",width:150},
              //  {key: "orderNo",width:120},
                {key: "itemCd",width:150},
                {key: "itemNm",width:220, formatter:function(){
                	if(nvl(this.item.barcodePrintQty,0) <= 0){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                		return "<font color='blue'>"+this.value+"</font>";
                	}
                }},
				{key: "routCd", label: "공정",width:150, align: "center",formatter: function formatter() {
						return CONVERT_CODE["ROUT_CD"].map[this.value];
					}
				},	
                {key: "orderSt",
                    width: 80, label: "상태", align: "center", formatter: function formatter() { 
                    	if(this.item.orderSt == 'RUN'){
                    		return "<div class='worder-circle2'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'NWRK'){
                    		return "<div class='worder-circle1'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'END'){
                    		return "<div class='worder-circle4'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'PAUSE'){
                    		return "<div class='worder-circle5'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else if(this.item.orderSt == 'LOCK'){
                    		return "<div class='worder-circle3'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}else{
                    		return "<div class='worder-circle6'>"+CONVERT_CODE["ORDER_ST"].map[this.value] +"</div>";
                    	}
                    }},
                {key: "unit"},
                {key: "orderQty"},
                {key: "prodQty"},
                {key: "badQty", hidden: "true"},
                {key: "goodQty"},
                {key: "outYn",width:80},
                {key: "equipNm", label:"설비", width:200},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    if(nvl(wlotNo,'') != ''){
                        this.self.select(this.dindex);
                        ACTIONS.dispatch(ACTIONS.ORDER_CLICK,this.item);
                    }else{
                    	axDialog.alert({
                            theme: "primary",
                            width:500,
                            msg: "지시대기 상태인 작업지시가\n있습니다.\n[작업시작]을 선택하세요."
                        });
                    	return false;
                    }
                }
            },
            page: {
                display: false
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "search-order": function () {
                ACTIONS.dispatch(ACTIONS.SEARCH_ORDER);
            },
            "search-man": function () {
                ACTIONS.dispatch(ACTIONS.ADD_WORKMAN);
            },
            "start-order": function () {
                ACTIONS.dispatch(ACTIONS.START_ORDER);
            },
            "search-nwrk": function () {
                ACTIONS.dispatch(ACTIONS.SEARCH_NWRK);
            },
            "out-item": function () {
                ACTIONS.dispatch(ACTIONS.OUT_STOCK);
            },
            "in-item": function () {
                ACTIONS.dispatch(ACTIONS.NUMBER_IN_PAD_MODAL);
            },
            "in-bad-item": function () {
                ACTIONS.dispatch(ACTIONS.BAD_MODAL);
            },
            "end-order": function () {
                ACTIONS.dispatch(ACTIONS.END_ORDER);
            },
            "barcode-out": function () {
                ACTIONS.dispatch(ACTIONS.BARCODE_MODAL);
            },
            "setup-modal": function () {
                ACTIONS.dispatch(ACTIONS.SETUP_MODAL);
            },
            "menu-modal": function () {
                ACTIONS.dispatch(ACTIONS.MENU_MODAL);
            },
            "barcode-print": function () {
                ACTIONS.dispatch(ACTIONS.BARCODE_PRINT);
            },
            "change-equip": function () {
                ACTIONS.dispatch(ACTIONS.CHANGE_EQUIP);
            },
            "full-size": function () {
            	openFullScreenMode();
            },
            "small-size": function () {
            	closeFullScreenMode();
            },
            "wo-doc": function () {
                ACTIONS.dispatch(ACTIONS.WO_DOC);
            },
            "inout-item": function () {
                ACTIONS.dispatch(ACTIONS.INOUT_MODAL);
            },
            //2020-09-22 입고출고 테스트 
            "pop-in-out-item": function () {
                ACTIONS.dispatch(ACTIONS.POP_IN_OUT_MODAL);
            },
            //2020-11-04 입고 (원재료)
            "pop-in-out-item2": function () {
                ACTIONS.dispatch(ACTIONS.RMT_ADD_FORM);
            },
            //2020-11-12 출고 (원재료)
            "pop-in-out-item3": function () {
                ACTIONS.dispatch(ACTIONS.RMT_OUT_FORM);
            },
            //2020-09-22 cju 재고현황
            "st-search": function () {
            	ACTIONS.dispatch(ACTIONS.ST_SEARCH);
            },
          //2020-09-22 cju 재고현황
            "st-add":function () {
            	ACTIONS.dispatch(ACTIONS.ST_ADD_FORM);
            },
            //2021-01-06 kjm 재고현황
            "sa-search": function () {
            	ACTIONS.dispatch(ACTIONS.SA_SEARCH);
            },
            //2021-01-06 kjm 재고현황
            "sa-add":function () {
            	ACTIONS.dispatch(ACTIONS.SA_ADD_FORM);
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
    align: function () {
        this.target.align();
    },
    addRow: function (data) {     	
    	this.target.addRow({__created__: true,
	       	 company:data.company,
	       	 whCd:data.whCd,
	       	 stockCd:data.stockCd,
	       	 lotNo:data.lotNo,
	       	 barcode:data.barcode,
	       	 parentWlotNo:data.parentWlotNo,
	       	 wlotNo:data.wlotNo,
        	 orderDt:data.orderDt,
        	 orderNo:data.orderNo,
        	 orderSeq:data.orderSeq,
        	 routSeq:data.routSeq,
        	 workSeq:data.workSeq,
        	 itemCd:data.itemCd,
        	 unit:data.unit,
        	 itemNm:data.itemNm,
        	 routType:data.routType,
        	 routCd:data.routCd,
        	 equipCd:data.equipCd,
        	 equipNm:data.equipNm,
        	 orderSt:data.orderSt,
        	 orderQty:data.orderQty,
        	 prodQty:data.prodQty,
        	 badQty:data.badQty,
        	 goodQty:data.goodQty,
        	 outYn:data.outYn,
        	 routQcYn:data.routQcYn,
        	 equipUseYn:data.equipUseYn
        	}, "first");
        this.target.select(0);
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
            sortable: false, 
            multiSort: false,
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "userCd", label:"사용자ID", width:150, align:"center"},
                {key: "userNm", label:"사용자명", width:200, formatter:function(){
                	if(nvl(this.item.wrkedDtm,'') != ''){
                		return "<font color='red'>"+this.value+"</font>";
                	}else{
                    	return this.value;
                	}
                }},
                {key: "wrkDtmString", label:"시작시간", width:170 , align:"center"},
                {key: "wrkedDtmString", label:"종료시간", width:170, align:"center"},
                {key: "prodQty", label: "작업수량", width: 120, formatter:"number", align: "right"},
                {key: "endWork", label:"작업종료",width: 150, align:"center", formatter:function(){
                	if(nvl(this.item.wrkDtm,'') != '' && nvl(this.item.wrkedDtm,'') == ''){
                    	return "<button type='button' style='background-color:red' class='btn btn-success W70'>작업종료</button>";
                	}
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "endWork") {  
                    	if(nvl(this.item.wrkDtm,'') != '' && nvl(this.item.wrkedDtm,'') == ''){
                            ACTIONS.dispatch(ACTIONS.END_WORKMAN, this.item);
                    	}
                    }
                }
            },
            page: {
                display: false
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "add-workman": function () {
                ACTIONS.dispatch(ACTIONS.ADD_WORKMAN);
            },
            "del-workman": function () {
                ACTIONS.dispatch(ACTIONS.DEL_WORKMAN);
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
                return this.userCd;
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
	       	 wlotNo:data.wlotNo,
        	 userCd:data.userCd,
        	 userNm:data.userNm,
        	}, "last");
        
        this.target.select(0);
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
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-03"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "itemCd",width:150, formatter:function(){
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
                {key: "itemNm",width:220, formatter:function(){
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
                {key: "spec", width: 150},
                {key: "whCd", width: 120},
                {key: "lotNo", width: 120},
                {key: "barcode", width: 120},
                {key: "bomItemQty", label: "투입수량", width: 120, formatter:"number", align: "right"},
                //{key: "transConsumQty", label: "예상소모수량", width: 120, formatter:"number", align: "right"},
                //{key: "transRemainQty", label: "예상남은수량", width: 120, formatter:"number", align: "right"},
                {key: "bomUnit",label:"소요단위",width:100, align: "center"},
                
                //{key: "itemQty", label: "투입수량", width: 100, formatter:"number", align: "right"},
                //{key: "consumQty", label: "예상소모수량", width: 100, formatter:"number", align: "right"},
                //{key: "remainQty", label: "예상남은수량", width: 100, formatter:"number", align: "right"},
                //{key: "unit", width: 100},
                //{key: "updatedAt",label:"투입시간",width:200},
                /*
                {key: "", label:"자재환입", align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>자재환입</button>";
                }},
                */  
                
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.RETURN_ITEM, this.item);
                }
            },
            page: {
                display: false
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
 * gridView05
 */
fnObj.gridView05 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-05"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "badNm", label:"불량명", width:300, align:"left"},
                {key: "badQty", label: "불량수량", width: 120, formatter:"number", align: "right"},
                {key: "unit", width: 120},
                {key: "badDtm", label:"불량시간", width:150 , align:"center"},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex); 
                }
            },
            page: {
                display: false
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
 * gridView06
 */
fnObj.gridView06 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-06"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "lotNo",width:150},
                {key: "barcode",width:150},
                {key: "itemQty",width: 150},
                {key: "unit"},
                {key: "updatedAt",label:"실적시간",width:200},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                }
            },
            page: {
                display: false
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


//작업지시 적용
function addWorkOrder(data){	
	equipCd = nvl(data.equipCd,'');    	  
	fnObj.gridView01.addRow(data);
	$('[data-ax5layout="ax1"]').ax5layout("tabOpen", 0);
}

//작업자 적용
function addWorkMan(data){
	
	var wData = new Array();
	var list = fnObj.gridView02.getData();
	
	data.forEach(function (n) {
		
		var chkCnt = 0;		
		list.forEach(function (n2) {            
			if(nvl(n2.wrkDtm,'') != '' && nvl(n2.wrkedDtm,'') == '' && n.userCd == n2.userCd){
				chkCnt++;
				return false;
			}			
	    });

		if(chkCnt == 0){
			wData.push(n);
		}
		
    });
	
	if(wData.length > 0){
		wData.forEach(function (n) {	
			fnObj.gridView02.addRow(n);
			
			buttonControl("ORDER",n);
			$('[data-ax5layout="ax1"]').ax5layout("tabOpen", 0);
	    });
		
	}
}

function buttonControl(orderSt,data){

	var equipNm = nvl(data.equipNm,'설비없음');
	var nwrkNm = nvl(data.nwrkNm,'');
	var startDtm = convertStringToTimestamp(nvl(data.startDtm,''));
	var nwrkDtm = convertStringToTimestamp(nvl(data.nwrkDtm,''));
	
	if(nvl(data.equipUseYn,'N') == 'N'){
		$("#change-equip").attr("disabled","disabled");
	}else{
		$("#change-equip").removeAttr("disabled");
	}
	
	$("#out-item").removeAttr("disabled");
	$("#wo-doc").removeAttr("disabled");
	
	$("#move-item").removeAttr("disabled");
	$("#in-item").removeAttr("disabled");
	$("#in-bad-item").removeAttr("disabled");
	$("#start-order").removeAttr("disabled");

	$("#search-man").removeAttr("disabled");
	$("#search-order").removeAttr("disabled");
	$("#pause-order").removeAttr("disabled");
	$("#search-nwrk").removeAttr("disabled");
	$("#barcode-out").removeAttr("disabled");
	$("#barcode-print").removeAttr("disabled");
	$("#end-order").removeAttr("disabled");
	$("#pause-order").attr("disabled","disabled");
	
	$("#inout-item2").removeAttr("disabled");

	//양품수량없으면 바코드인쇄/발행불가능.., 작업종료 불가능
	if(nvl(data.goodQty,0) == 0){
		$("#barcode-out").attr("disabled","disabled");
		$("#barcode-print").attr("disabled","disabled");
	}else{
		$("#barcode-out").removeAttr("disabled");
		$("#barcode-print").removeAttr("disabled");
	}
	
	if(orderSt == "NWRK"){
		$("#end-order").attr("disabled","disabled");
		$("#search-nwrk").attr("disabled","disabled");

		$("#pageHeader").css("background-color","red");		
		$("#headerString").html("비 가 동::"+equipNm+"::"+nwrkNm+"::" + nwrkDtm + " ~" );
		
	}else if(orderSt == "RUN"){
		$("#start-order").attr("disabled","disabled");
		
		$("#pageHeader").css("background-color","#0080ff");		
		$("#headerString").html("가 동 중::"+equipNm+"::" + startDtm + " ~" );
		
		$("#inout-item2").removeAttr("disabled");

		
	}else if(orderSt == "ORDER"){

		$("#pageHeader").css("background-color","black");	
		var manLength = fnObj.gridView02.getData().length;
		if(manLength > 0){
			$("#headerString").html("작업을 시작하세요.");
		}else{	
			$("#headerString").html("작업자선택 하세요.");
		}
		
		$("#end-order").attr("disabled","disabled");
		$("#search-nwrk").attr("disabled","disabled");
		$("#out-item").attr("disabled","disabled");
		$("#wo-doc").attr("disabled","disabled");
		
		$("#move-item").attr("disabled","disabled");
		$("#in-item").attr("disabled","disabled");
		$("#in-bad-item").attr("disabled","disabled");
		$("#barcode-out").attr("disabled","disabled");
		$("#barcode-print").attr("disabled","disabled");
		$("#search-order").attr("disabled","disabled");
	}else if(orderSt == "LOCK"){

		$("#pageHeader").css("background-color","black");	
		$("#headerString").html("이전공정 종료후 진행가능합니다.");

		$("#start-order").attr("disabled","disabled");
		$("#end-order").attr("disabled","disabled");
		$("#search-nwrk").attr("disabled","disabled");
		$("#out-item").attr("disabled","disabled");
		$("#wo-doc").attr("disabled","disabled");
		$("#move-item").attr("disabled","disabled");
		$("#in-item").attr("disabled","disabled");
		$("#in-bad-item").attr("disabled","disabled");
		$("#barcode-out").attr("disabled","disabled");
		$("#barcode-print").attr("disabled","disabled");
		$("#search-order").attr("disabled","disabled");
	}else if (orderSt == "END"){
		$("#in-item").attr("disabled","disabled");
		$("#start-order").attr("disabled","disabled");
		$("#end-order").attr("disabled","disabled");
		$("#in-bad-item").attr("disabled","disabled");
	}else{
		$("#pageHeader").css("background-color","black");	
		$("#headerString").html("작업지시를 선택하세요.");

		$("#search-man").attr("disabled","disabled");
		$("#out-item").attr("disabled","disabled");
		$("#wo-doc").attr("disabled","disabled");

		
		
		$("#move-item").attr("disabled","disabled");
		$("#in-item").attr("disabled","disabled");
		$("#in-bad-item").attr("disabled","disabled");
		$("#start-order").attr("disabled","disabled");
		$("#pause-order").attr("disabled","disabled");
		$("#search-nwrk").attr("disabled","disabled");
		$("#barcode-out").attr("disabled","disabled");
		$("#barcode-print").attr("disabled","disabled");
		$("#end-order").attr("disabled","disabled");
	}
}

function refreshPage(){
	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
}



var docV = document.documentElement;
//전체화면 설정
function openFullScreenMode() {
 if (docV.requestFullscreen)
     docV.requestFullscreen();
 else if (docV.webkitRequestFullscreen) // Chrome, Safari (webkit)
     docV.webkitRequestFullscreen();
 else if (docV.mozRequestFullScreen) // Firefox
     docV.mozRequestFullScreen();
 else if (docV.msRequestFullscreen) // IE or Edge
     docV.msRequestFullscreen();
}

//전체화면 해제
function closeFullScreenMode() {
 if (document.exitFullscreen)
     document.exitFullscreen();
 else if (document.webkitExitFullscreen) // Chrome, Safari (webkit)
     document.webkitExitFullscreen();
 else if (document.mozCancelFullScreen) // Firefox
     document.mozCancelFullScreen();
 else if (document.msExitFullscreen) // IE or Edge
     document.msExitFullscreen();
}
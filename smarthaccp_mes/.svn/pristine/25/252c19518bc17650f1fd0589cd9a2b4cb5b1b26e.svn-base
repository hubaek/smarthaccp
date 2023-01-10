/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.12.18
 * 3. Comment 	: 여과공정CCP2-P
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};
var MODAL_NAME = "HACCP400M";
var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {    	
		var searchParam = getSerializeArrayToJson("#searchView0");
		searchParam.fromDate =  searchParam.fromDate.replace(/-/gi,"");
		searchParam.toDate =  searchParam.toDate.replace(/-/gi,"");
		
		ppmboot.ajax({
	        type: "GET",
	        url: ["dailyreport","masterList"],
	        data: searchParam,
	        callback: function (res) {
	        	caller.gridView01.setData(res);
	        	axDialog.alert({
	                theme: "primary",
	                msg: res.list.length + "건의 데이터가 조회 되었습니다."
	            });	
	        }
	    });
    },
    
    //상세
    VIEW_FORM: function (caller, act, data) {
    	var searchParam = getSerializeArrayToJson("#searchView0");   
    	var templateId = searchParam.templateId;
    	
    	ppmboot.modal.open({  
    		modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode"         		: "view",
                	"company" 	   		: data.company,
                	"inspectionDate" 	: data.inspectionDate,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },
    
  //신규 작성
    ADD_FORM: function (caller, act, data) {
    	var searchParam = getSerializeArrayToJson("#searchView0");   
    	var templateId = searchParam.templateId;
    	
    	ppmboot.modal.open({  
    		modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "add",
                	"templateId" : templateId
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },    
    //수정
    MOD_FORM: function (caller, act, data) {
    	var list =  caller.gridView01.getData("selected");
    	
    	if(fnObj.approvalCheck(caller)){
    		if(list.length!=1){
            	axDialog.alert({
                    theme: "primary",
                    msg: "대상을 선택하세요."
                });
            	return false;
            }else{
            	ppmboot.modal.open({  
                    modalType: MODAL_NAME,
                    param: "",
                    sendData: function(){
                        return {
                        	"mode" : "mod",
                        	"company" : list[0].company,
                        	"inspectionDate"  : list[0].inspectionDate,
                        };
                    },
                    callback: function (data) {
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                    }
                });	 
            }
    	}
    },    
    PAY_MENT : function(caller, act, data) {
    	axDialog.confirm({
    		theme: "primary",
            msg: data+" 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	var list;
            	list = caller.gridView01.getData("selected");
            	var status = list[0].status;
            	if(list.length == 0){
            		axDialog.alert({
                        theme: "primary",
                        msg: "대상을 선택하세요."
                    });
            		return false;	
            	}
            	switch (data) {
	        		case "상신":
	        			if(status == "20") {//상신
	    				   axDialog.alert({
	    				        	theme: "primary",
	    				       	msg: "이미 상신된 상태입니다."
	    					});
	    				   return false;
	    				}
	        			else if(status == "40"){// 승인상태
	    				     axDialog.alert({
	    				        	theme: "primary",
	    				       	msg: "이미 승인된 상태입니다."
	    					});   
	    				     return false;
	    				}
	        			else if(status == "50"){// 반려
	    				    axDialog.alert({
	    				        	theme: "primary",
	    				       	msg: "반려된 상태입니다.\n"+"저장후 상신해주세요."
	    					});   
	    				     return false;
	    				}
	        			else{
	    					list[0].status = "20";
	        			}
	    			break;
        		
	        		case "승인":
        				if(status == "10"){
        					axDialog.alert({
      				        	theme: "primary",
      				       	msg: "상신을 먼저 진행해 주세요."
        					});
        					return false;
        				
 	     				}
        				else if(status == "40"){// 승인상태
 	     				     axDialog.alert({
 	     				        	theme: "primary",
 	     				       	msg: "이미 승인된 상태입니다."
 	     					});   
 	     				     return false;
 	     				}
        				else if(status == "50"){// 반려
 	     				     axDialog.alert({
 	     				        	theme: "primary",
 	     				       	msg: "반려된 상태입니다.\n"+"저장후 상신해주세요."
 	     					});   
 	     				     return false;
 	     				}
        				else{
 	     					list[0].status = "40";
 	     				}
        				list[0].approver = SCRIPT_SESSION.userNm;
        			break;
        		
	        	   case "반려":
	        		   if(status == "10"){
	       					axDialog.alert({
	     				        	theme: "primary",
	     				       	msg: "상신을 먼저 진행해 주세요."
	       					});
       					return false;
       				
	     				}else if(status == "40"){// 승인상태
 	     				     axDialog.alert({
 	     				        	theme: "primary",
 	     				       	msg: "이미 승인된 상태입니다."
 	     					});   
 	     				     return false;
	 	     			}else if(status == "50"){// 반려
	 	     				     axDialog.alert({
	 	     				        	theme: "primary",
	 	     				       	msg: "반려된 상태입니다.\n"+"저장후 상신해주세요."
	 	     					});   
	 	     				     return false;
	 	     			}else{
	 	     				list[0].status = "50";
	        			}
	        			list[0].approver = SCRIPT_SESSION.userNm;
        			break;
            	}
            	ppmboot
                .call({
                    type: "PUT", url: ["filter", "master"], data: JSON.stringify([list[0]]),
                    callback: function (res) {                    	
                    }
                })
                .done(function () {
                    axToast.push(data+"되었습니다.");
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
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

fnObj.pageButtonView = ppmboot.viewExtend({
	initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "cre":function(){
            	ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "mod":function(){
            	ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.PAY_MENT,"상신");
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.PAY_MENT,"검토완료");
            },
            "fn3": function () {
                ACTIONS.dispatch(ACTIONS.PAY_MENT,"검토반려");
            },
            "fn4": function () {
                ACTIONS.dispatch(ACTIONS.PAY_MENT,"승인");
            },
            "fn5": function () {
                ACTIONS.dispatch(ACTIONS.PAY_MENT,"반려");
            }
        });
    }
});

fnObj.approvalCheck = function(caller){

	var mData = caller.gridView01.getData("selected");
	if(mData[0].status == "20"){
    	axDialog.alert({
            theme: "primary",
            msg: "상신상태 입니다. 수정이 불가합니다."
        });
		return false;
    }else if(mData[0].status == "30"){
    	axDialog.alert({
            theme: "primary",
            msg: "검토상태 입니다. 수정이 불가합니다."
        });
    	return false;
    }else if(mData[0].status == "40"){
    	axDialog.alert({
            theme: "primary",
            msg: "승인이 완료된 상태입니다."
        });
    	return false;
    }
	return true;
}

fnObj.pageStart = function () {
    var _this = this;
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "STATUS",useYn:"Y"},
        callback: function (res) {        		
            this.STATUS = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
    });
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    

    
};


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
            showRowSelector: true,
            multiSort: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
	             {key: "inspectionDate", styleClass: "grid-cell-purple",label: "점검일자<span style='color:red'>*</span>", width: 200, type: "date", align: "center", formatter:function(){
	                  	return "<font style='cursor:pointer'><u>"+nvl(convertStringToDateFormat(this.value),'')+"</u></font>";
	                }},
            	 {key: "remark1"     , label:"이탈내용" , width: 520 , align: "left" },
            	 {key: "remark2"     , label:"개선조치 및 결과" , width: 520 , align: "left" },
                 {key: "writer"      , label:"작성자"  , width: 100 , align: "center" },
                 {key: "approver"    , label:"승인자"  , width: 100 , align: "center" },
                 {key: "status"    , label:"상태"   , width: 100 , align: "center" ,formatter: function formatter() {return CONVERT_CODE["STATUS"].map[this.value];}},
                 
            ],
            body: {
            	//mergeCells: ["remark1", "remark2", "writer"],
            	onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "inspectionDate") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "inspectionDate") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
                },
            }
        });
    },
    
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
            	list.push(this.company);
            	list.push(this.inspectionDate);
            	return list;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
    	this.target.addRow({__created__: true,}, "last");
    }
});


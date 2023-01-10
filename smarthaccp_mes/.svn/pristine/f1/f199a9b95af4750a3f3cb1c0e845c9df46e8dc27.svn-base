/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 
 * 4. 변경이력 :   
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};
var MODAL_NAME = "REPORT023M";
var TEMPLATE_ID = "REPORT023";

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["dailyreport","masterList"],
            data: $.extend({templateId:TEMPLATE_ID}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
            	caller.gridView01.setData(res);
            }
        });
        return false;
    },
    //신규
    ADD_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "add",
                	"company" : $("#company").val(),
                	"templateId" : TEMPLATE_ID,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },    
    //수정
    MOD_FORM: function (caller, act, data) {
    	let list =  caller.gridView01.getData("selected");
    	
    	if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }
    	
    	switch(list[0].status){
    		case '20' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 상신이 된 검사입니다."
	    		});
	    		return false;
    		break;
    		case '40' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 승인이 된 검사입니다."
	    		});
	    		return false;
    		break;
    	}
        	ppmboot.modal.open({  
                modalType: MODAL_NAME,
                param: "",
                sendData: function(){
                    return {
                    	"mode" : "mod",
                    	"company" : list[0].company,
                    	"templateId" : list[0].templateId,
                    	"reportDate" : list[0].reportDate,
                    	"mseq" : list[0].mseq
                    };
                },
                callback: function (data) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });	 
    },
  //조회
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"templateId" : data.templateId,
                	"startDate" : data.startDate,
                	"reportDate" : data.reportDate,
                	"mseq" : data.mseq,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },
    PAGE_REPORT: function (caller, act, data){
    	let mData = caller.gridView01.getData('selected');
    	let status = mData[0].status;
    	
    	switch(status){
    		case '50' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "저장을 하셔야 합니다."
	    		});
	    		break;
    		case '20' :
				axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 상신이 된 검사입니다."
	    		});
				break;
    		case '40' : 
    			axDialog.alert({
        			theme: "primary",
        			msg: "이미 승인이 된 검사입니다."
        		});
    			break;
    		default :
    			axDialog.confirm({
            		theme: "primary",
            		msg: "상신 하시겠습니까?"
            	}, function(){
            		if(this.key == "ok"){
        	            mData[0].status = "20";
        	            ppmboot
        	                .call({
        	                    type: "PUT", url: ["dailyreport", "saveMaster"], data: JSON.stringify(mData),
        	                    callback: function (res) {                    	
        	                    }
        	                })
        	                .done(function () {
        	                    axToast.push("상신 되었습니다.");
        	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	                });
            		}
            	});
    	}
    },
    PAGE_APPROVE: function (caller, act, data){
    	let mData = caller.gridView01.getData('selected');
    	let status = mData[0].status;
    	
    	switch(status){
    		case '40' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "승인 된 검사입니다."
	    		});
	    		break;
    		case '10' :
    		case '50' : 
    			axDialog.alert({
        			theme: "primary",
        			msg: "상신되지 않은 항목입니다."
        		});
    			break;
    		default :
    			axDialog.confirm({
            		theme: "primary",
            		msg: "승인 하시겠습니까?"
            	}, function(){
            		if(this.key == "ok"){
        	            mData[0].status = "40";
        	            mData[0].approver = SCRIPT_SESSION.userNm;
        	            ppmboot
        	                .call({
        	                    type: "PUT", url: ["dailyreport", "saveMaster"], data: JSON.stringify(mData),
        	                    callback: function (res) {                    	
        	                    }
        	                })
        	                .done(function () {
        	                    axToast.push("승인 되었습니다.");
        	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	                });
            		}
            	});
    	}
    },
    PAGE_RETURN: function (caller, act, data){
    	let mData = caller.gridView01.getData('selected');
    	let status = mData[0].status;
    	
    	switch(status){
    		case '40' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "승인 된 검사입니다."
	    		});
	    		break;
    		case '50' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 반려 된 검사입니다."
	    		});
	    		break;
    		default :
    			axDialog.confirm({
            		theme: "primary",
            		msg: "반려 하시겠습니까?"
            	}, function(){
            		if(this.key == "ok"){
            			mData[0].mainCode ="CCP_HG";
        	            mData[0].status = "50";
        	            ppmboot
        	                .call({
        	                    type: "PUT", url: ["dailyreport", "saveMaster"], data: JSON.stringify(mData),
        	                    callback: function (res) {                    	
        	                    }
        	                })
        	                .done(function () {
        	                    axToast.push("반려 되었습니다.");
        	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        	                });
            		}
            	});
    	}
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
  
fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    /*
    ppmboot
    	.call({
    		type: "GET",
    		url: ["basic", "detail"],
    		data: {mainCd: "STATUS"},
    		callback: function(res){
    			this.STATUS = res.list;
    		}
    	})
    	.done(function(){
    		CODE = this;
    		CONVERT_CODE = convertCommonCode(CODE);
    	});
    */
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
            "cre": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "mod": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_REPORT);
            },
            "fn4": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_APPROVE);
            },
            "fn5": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_RETURN);
            },
        });
    }
});

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
	 getDefaultData: function () {
	        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $(document["searchView0"]);
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작	
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
    },
    setDefaultRout:function(data){
        this.model.set("routCd", data.routCd);
        this.model.set("routNm", data.routNm);
        $("#hiddenRoutCd").val(data.routCd);
    },
});

/**
 * gridView01	설비정보목록
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
                {key: "reportDate", label: "점검일자", width: 200,align: "center", formatter:function(){
                  	return "<font style='cursor:pointer'><u>"+ "" + ax5.util.date("" + nvl(this.value,''), { "return": 'yyyy-MM-dd' })+"</u></font>";
                }},
                {key: "writer", label: "작성자", width: 200, align: "center"},
                {key: "approver", label: "승인자", width: 200, align: "center"},
                {key: "remark1", label: "부적합사항", editor: {type: "textarea"}, width: 400, align: "center"},
                {key: "remark2", label: "조치사항", editor: {type: "textarea"}, width: 400, align: "center"},
                {key: "status", label:"상태", width: 194, align: "center", formatter: function formatter() {return parent.COMMON_CODE["STATUS"].map[this.value];}} 
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "reportDate") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}
                },
		        onDBLClick: function () {
		            this.self.select(this.dindex);
		        	if(this.column.key == "reportDate") {
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
                list.push(this.reportDate);
                list.push(this.mseq);
                return list;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
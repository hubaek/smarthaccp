/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 결재관리
 * 4. 변경이력 :   
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["approval", "master"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    VIEW_FORM: function (caller, act, data) {
    	console.log('VIEW_FORM : '+data);
    	let MODAL_NAME = data.documentClassifyCd + 'M';
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
    //승인
    PAGE_APPROVE: function (caller, act, data){
    	let mData = caller.gridView01.getData('selected');
    	let status = mData[0].status;
    	
    	switch(status){
    		case '40' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 승인된 결재입니다."
	    		});
	    		break;
    		case '50' : 
    			axDialog.alert({
        			theme: "primary",
        			msg: "반려된 결재입니다."
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
    //반려
    PAGE_RETURN: function (caller, act, data){
    	let mData = caller.gridView01.getData('selected');
    	let status = mData[0].status;
    	
    	switch(status){
    		case '40' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "승인된 결재입니다."
	    		});
	    		break;
    		case '50' :
	    		axDialog.alert({
	    			theme: "primary",
	    			msg: "이미 반려된 결재입니다."
	    		});
	    		break;
    		default :
    			axDialog.confirm({
            		theme: "primary",
            		msg: "반려 하시겠습니까?"
            	}, function(){
            		if(this.key == "ok"){
        	            mData[0].status = "50";
        	            mData[0].approver = SCRIPT_SESSION.userNm;
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
            "fn4": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_APPROVE);
            },
            "fn5": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_RETURN);
            }
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
            	{key: "reportDtm", label: "점검일자", width: 200, align: "center"},
            	{key: "documentTitle", label: "문서구분", width: 400, align: "center", formatter:function(){
                  	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                }},
            	{key: "drafterId", label: "기안자", width: 200, align: "center"},
                {key: "draftDtm", label: "기안일자", width: 200,align: "center"},
                {key: "approverId", label: "승인자", width: 200, align: "center"},
                {key: "approvalDtm", label: "승인일자", width: 200, align: "center"},
                {key: "approvalStateCd", label:"결재상태", width: 194, align: "center", formatter: function formatter() { 
	                	if(nvl(this.item.approvalStateCd,'상신') == '상신'){
	                		return "<div class='worder-circle1'>상신</div>";
	                	}else if(this.item.approvalStateCd == '반려'){
	                		return "<div class='worder-circle5'>반려</div>";
	                	}else{
	                		return "<div class='worder-circle4'>승인</div>";
	                	}
                	}
                } 
            ],
            body: { 
            	onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "documentTitle") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM, this.item);
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
    }
});
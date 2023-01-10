
/**
 * 0. Project	: 코주부HACCP MES
 * 1. 작성자  	: 윤광준
 * 2. 작성일	: 2020.08.04
 * 3. Comment 	: 주기관리 모달 js
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var mode; 
var inFlag;
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
    CHECK_ID: function(caller, act, data){
    	const ccpCd = $("select[data-ax-path='ccpCd']").val();
    	if(nvl(ccpCd, '')== ''){
    		axDialog.alert({
    			theme: "warning",
    			msg: "주기명을 선택하세요."
    		});
    	}else{
    		ppmboot
    		.call({
    			type	:	"GET",
    			url		:	["cycle", "master"],
    			data	:	{ccpCd:ccpCd},
    			callback:	function(res){
    				if(res.list.length > 0){
    					axDialog.alert({
    						theme	:	"primary",
    						msg		:	"이미 등록된 주기명 입니다."
    					});
    					inFlag = false;
    					$("input:checkbox[id='chk']").prop("checked", false);
    				}else{
    					axDialog.alert({
							theme	:	"primary",
							msg		:	"등록가능한 주기명 입니다."
    					});
    					inFlag = true;
    					$("input:checkbox[id='chk']").prop("checked", true);
    				}
    			}	
    		})
    		.done(function(){
    			//필요시 기능 추가
    		});
    	}
    },
    PAGE_SEARCH: function (caller, act, data) {		
    	ppmboot
    	.call({
            type: "GET",
            url: ["cycle", "master"],
            data: {ccpCd:param.ccpCd},
            callback: function (res) {
            	caller.formView01.setData(res);
            }
        })
        .done(function () {
        	setAuthBtn();
        });
        return false;
    },	
    PAGE_ADD: function (caller, act, data) {
    	setAuthBtn();
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	if (caller.formView01.validate()) {
    		if(mode == "add"){
	   			if(!inFlag){
	   				axDialog.alert({
	   	                theme: "primary",
	   	                msg: "중복체크를 해주세요."
	   	            });
	   	    		return false;
				}
	 		}
            mData = caller.formView01.getData();
        	axDialog.confirm({
        		theme: "primary",
        		msg: "저장하시겠습니까?"
        	}, function(){
        		if(this.key =="ok"){
        			let ccpNm;
        			let fullDate = mData.ccpDate.replaceAll('-','');
        			let year = fullDate.substr(0,4);
        			let month = fullDate.substr(4,2)-1;
        			let day = fullDate.substr(6,2);
        			let date = new Date(year,month,day);
        			let historyDate = new Date(date - (3600000 * 24 * mData.ccpCycle));
        			switch(mData.ccpCd){
        				case 'HACCP050':
        					mData.ccpNm = '공정관리점검일지';
        					break;
        				case 'HACCP060':
        					mData.ccpNm = '설비이력카드';
        					break;
        				case 'HACCP070':
        					mData.ccpNm = '자체위생점검일지';
    						break;
        				case 'HACCP080':
        					mData.ccpNm = '원료육입고검사대장';
        					break;
        				case 'HACCP090':
        					mData.ccpNm = '부자재/재료 입고검사대장';
    						break;
        				case 'HACCP100':
        					mData.ccpNm = '차량운행 및 위생점검일지';
    						break;
        				case 'HACCP110':
    						mData.ccpNm = '완제품 검사대장'
    						break;
        			}
        			year = historyDate.getFullYear();
        			month = String(historyDate.getMonth()+1);
        			day = String(historyDate.getDate());
        			if(month.length == 1){
        				month = "0" + month;
        			}
        			if(day.length == 1){
        				day = "0" + day;
        			}
        			mData.ccpHistoryDate = year + "-" + month + "-" + day;
	            	ppmboot
		                .call({
		                    type: "PUT", url: ["cycle", "master"], data: JSON.stringify([mData]),
		                    callback: function (res) {                    	
		                    }
		                })
		                .done(function () {
		                    axToast.push("저장 되었습니다.");
		                    dateValidated = false;
		                    parent.ppmboot.modal.callback("");
		                });
            	}else{
        			return false;
        		}
        	});
        }
    },
    PAGE_DELETE: function (caller, act, data) {    	
		axDialog.confirm({
            theme: "danger",
            msg: "삭제하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
       	        ppmboot.ajax({
       	        	type: "DELETE", 
       	            url:  ["cycle"],
       	        	data: JSON.stringify({
       	        		"ccpCd" : param.ccpCd
       	        	}),
       	            callback: function (res) {     	
       	            	parent.ppmboot.modal.callback("삭제 되었습니다.");	      
	                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
       	            }
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

fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.formView01.initView();
    param = parent.ppmboot.modal.getData();   
    switch(param.mode){
	    case "add" : 
	    	ACTIONS.dispatch(ACTIONS.PAGE_ADD);
	    	break;
	    case "mod" :
	    	inFlag = true;
	    default : 
	    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_DELETE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
        this.target.find('[data-ax5picker="basic"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date',
            }
        });   
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
        	"checkId": function(){
        		ACTIONS.dispatch(ACTIONS.CHECK_ID);
        	}
        });
        this.initEvent();     
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
        
        if(nvl(data.list[0].ccpDate,'') != ''){
        	$("#ccpDate").attr("readonly","readonly");
        }else{
        	$("#ccpDate").removeAttr("readonly");        	
        }
        
        this.model.setModel(data.list[0]);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();
        if (rs.error) {
            alert(LANG("ax.script.form.validate", rs.error[0].jquery.attr("title")));
            rs.error[0].jquery.focus();
            return false; 
        }
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
    },
    
    
});

function setAuthBtn(){
	mData = fnObj.formView01.getData();
	mode = param.mode;
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.ccpDate,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	}else{
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}

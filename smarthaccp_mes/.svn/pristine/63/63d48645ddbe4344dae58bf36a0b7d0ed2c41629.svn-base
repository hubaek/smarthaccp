/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2022.07.13
 * 3. Comment 	: 자료실(회사) Modal JavaScript
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var CODE;
var tempFileCd;
var PAGE_NAME = "자료실(회사)";
var BOARD_TYPE = "NOTICE_COMP";

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
	PAGE_CLOSE: function (caller, act, data) { 
		if (parent) {
    		window.close();
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	var rowObj = data;
	    ppmboot.call({
	        	type: "GET",
		        url: ["board","selectBoardTypeComp"],
		    	data: {"company": SCRIPT_SESSION["company"], "seq" : rowObj["seq"]},
	            callback: function (res) {
		            caller.formView01.setData(res[0]);
		            tempFileCd = nvl(res[0].fileTargetId,'');
	            }
	    }).done(function () {
	    
	    });
	    return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
   	 	if (caller.formView01.validate()) {
	     	var mData = caller.formView01.getData();
	     	mData.mode = param.mode;
	     	mData.boardtype = BOARD_TYPE;
	     	mData.fileTargetId = tempFileCd;
	     		
	   		var confirmMsg = "저장 하시겠습니까?";
	   		axDialog.confirm({
	            theme: "danger",
	            msg: confirmMsg
	        }, function () {
	            if(this.key == "ok"){
		   	        ppmboot.ajax({
		   		     	type: "POST", 
		   		     	url: ["board","saveBoardType"], 
		   		     	data: JSON.stringify(mData),
		   		        callback: function (res) {         
		   		        	if(res.status == 0){
		   		        		ppmboot.popup.callback(window.opener.fnObj, "PAGE_SEARCH", null);
			   		        	window.close();
		   		        	}else{
		   		        		axDialog.alert("처리 중 문제가 발생하였습니다.\n 시스템 관리자에게 문의하세요.");
		   		        	}
		   		        }
		   		    });	
	            }                	
	        });
	    }
   },
   PAGE_DELETE: function (caller, act, data) {    	
  	 	if (caller.formView01.validate()) {
    	    var mData = caller.formView01.getData();
  		    var confirmMsg = "삭제 하시겠습니까?";
  		    
  		    axDialog.confirm({
                theme: "danger",
                msg: confirmMsg
            }, function () {
            	if(this.key == "ok"){
            		ppmboot.ajax({
  		         	type: "DELETE", 
  		         	url: ["board","deleteBoardTypeComp"], 
  		         	data: JSON.stringify(mData),
  		             callback: function (res) {         
  		            	if(res.status == 0){
	   		        		ppmboot.popup.callback(window.opener.fnObj, "PAGE_SEARCH", null);
		   		        	window.close();
	   		        	}else{
	   		        		axDialog.alert("처리 중 문제가 발생하였습니다.\n 시스템 관리자에게 문의하세요.");
	   		        	}
  		             }
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
    CODE = this;
    
    //Modal Or Popup
    param = parent.ppmboot.modal.getData();
    /*** Modal이 아닌경우는 param이 undefined => Pop으로 간주하고 처리*/
    if(param == undefined){
        var sch = location.search.substring(1);
        param = ppmboot.getJSONPopupURLparam(sch);
    };
    
    _this.pageButtonView.initView();
    _this.formView01.initView();
    
    if(param.mode == "add"){      
        _this.formView01.setDefaultUser(SCRIPT_SESSION);
        tempFileCd = randomStringCd(20);
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH, param);
    }
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "save": function () {
            	ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
            	ACTIONS.dispatch(ACTIONS.PAGE_DELETE);
            }
        });
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {	
    getDefaultData: function () {		
    	var today = getNowDt();
        return $.extend({}, ppmboot.formView.defaultData, {regDt:getNowDt()});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작        
        this.initEvent();        
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
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
        if(nvl(data.fileTargetId,'') != ''){
    		searchFile(data.fileTargetId);
        }
        
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();  
        if (rs.error) {
        	 axDialog.alert({
                 theme: "warning",
                 msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
             },function(){
                 rs.error[0].jquery.focus();
             });
            return false;
        }  
        return true;
    },
    clear: function () {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);            	
        this.model.setModel(this.getDefaultData());
    },
    setDefaultUser:function(data){
        this.model.set("userCd", data.userCd);
        this.model.set("userNm", data.userNm);
    }
});
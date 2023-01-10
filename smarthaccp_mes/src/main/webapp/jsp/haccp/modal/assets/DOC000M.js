/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: HACCP기준서관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var tempFileCd;

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
            url:  ["haccp", "detail"],
            data: {
            	company : param.company,
            	mainCode : param.mainCode,
            	subCode : param.subCode
            	},
            callback: function (res) {
            	caller.formView01.setData(res.list[0]);            	
            }
        })
    	.done(function () {
        	setAuthBtn();
        });
        return false;
    },    
    PAGE_SAVE: function (caller, act, data) { 
    	 if (caller.formView01.validate()) {
    		 
	    	var mData = caller.formView01.getData();	   
			mData.tempFileCd = tempFileCd;	        	
			mData.mainCode = "DOC000";
			ppmboot.ajax({	        	
				type: "PUT", 
				url:  ["haccp","docSave"], 
				data: JSON.stringify(mData),
			    callback: function (res) {
			    	param.mode = "mod";	   
			    	param.company = res.comapny;
	            	param.mainCode = res.mainCode;
	            	param.subCode = res.subCode;
	            	param.data1 = res.data1;
	                axToast.push("저장 되었습니다.");
	                parent.ppmboot.modal.callback("");	      
	                
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
        		var mData = caller.formView01.getData();	
       	        ppmboot.ajax({
       	        	type: "DELETE", 
       	            url:  ["haccp","docDelete"],
       	        	data: JSON.stringify(mData),
       	            callback: function (res) {
       	            	ppmboot.ajax({
       	       	        	type: "DELETE", 
       	       	            url:  ["files","delete"],
       	       	        	data: JSON.stringify(mData),
       	       	            callback: function (res) {
       			                parent.ppmboot.modal.callback("");	      
       		                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
       	       	            }
       	       	        });	 
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
    if(param.mode == "add"){      
        $("#mainCode").val("DOC000");
    	setAuthBtn();
    	//첨부파일용 key 조회
    	getDocKey();
    	
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
    
    tempFileCd = randomStringCd(20);
        
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
        
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
           
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
        
        searchFile(nvl(data.data1, tempFileCd));
        
        this.model.setModel(data);
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
    }
});

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.mainCode,'') == ''){
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

function getDocKey(){
	ppmboot
	.call({
        type: "GET",
        url:  ["haccp", "docKey"],
        data: {
        	company : "1000",
        	mainCode : "DOC000"
        	},
        callback: function (res) {
        	//console.log(res.list[0]);   
        	$("#data1").val(res.list[0].data1); 
        }
    })
	.done(function () {

    });
}



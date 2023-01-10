/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공지사항
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var CODE;
var tempFileCd;
var PAGE_NAME = "공지사항";
var BOARD_TYPE = "NOTICE";

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
    		parent.ppmboot.modal.close();
        }
    },
    PAGE_SEARCH: function (caller, act, data) {    	
    	ppmboot
        .call({
            	type: "GET",
	            url: ["board","view"],
	        	data: {boardCd:param.boardCd},
                callback: function (res) {
	                caller.formView01.setData(res.list[0]);
	                
	                if(SCRIPT_SESSION.userCd != res.list[0].userCd){
	                	$("#mod").hide();
	                }
                }
        })
        .done(function () {
        });    	
        return false;
    },
    MOD_PAGE: function (caller, act, data) {    	
  		var mData = caller.formView01.getData();
    	axDialog.confirm({
            msg: "수정 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	ppmboot.modal.open({  
                    modalType: "BOD010M",
                    param: "",
                    sendData: function(){
                        return {
                        	"mode" : "add",
                        	"boardCd" : mData.boardCd
                        };
                    },
                    callback: function (data) {
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
    CODE = this;
    param = parent.ppmboot.modal.getData();
    _this.pageButtonView.initView();
    _this.formView01.initView();
	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    tempFileCd = randomStringCd(20);
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "mod": function () {
            	ACTIONS.dispatch(ACTIONS.MOD_PAGE);
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

		searchFile(data.boardCd);
    	
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
    },
});
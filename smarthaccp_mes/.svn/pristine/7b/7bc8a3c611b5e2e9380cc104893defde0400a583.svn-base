var fnObj = {};
var param;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_CLOSE: function (caller, act, data) { 
        if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal3.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["users"],
            data: {userCd: param.userCd},
            callback: function (res) { 
                caller.formView01.setData(res);
            }
        });
        return false;
    },
    CHANGE_PW: function (caller, act, data) {
    	var mData = caller.formView01.getData();
    	var userPs = nvl(mData.userPs,'');
    	var userPs_chk = nvl(mData.userPs_chk,'');
    	
    	if(userPs == ''){
        	 axDialog.alert({
                 theme: "warning",
                 msg: "비밀번호를 입력하세요."
             });   
    		
    	}else{
        	if(userPs_chk == ''){

           	 	axDialog.alert({
                    theme: "warning",
                    msg: "비밀번호확인을 입력하세요."
                });   
        	}else{
        		if(userPs != userPs_chk){
               	 	axDialog.alert({
                        theme: "warning",
                        msg: "비밀번호가 틀립니다."
                    });   
        		}else{
        			if (mData.userPs.length < 6){
        				axDialog.alert({
                            theme: "warning",
                            msg: "비밀번호는 최소 6자리 이상 입력해야 합니다."
                        });
        			}else{
	        			axDialog.confirm({
	        	            msg: "비밀번호를 변경 하시겠습니까?"
	        	        }, function () {
	        	        	
	        	        	 ppmboot.ajax({
	        	                 type: "PUT",
	        	                 url: ["users","changePw"],
	        	                 data: JSON.stringify(caller.formView01.getData()),
	        	                 callback: function (res) {
	        	    	        	parent.ppmboot.modal3.callback(mData);
	        	                 }
	        	             });
	
	        	        });  
        			
        			}
        		}
        	}
    	}
    	
    },
    CHANGE_LANG: function (caller, act, data) {
    	var mData = caller.formView01.getData();
    	axDialog.confirm({
            msg: "사용자 언어를 변경 하시겠습니까?로그인을 다시하면 반영됩니다."
        }, function () {
        	 ppmboot.ajax({
                 type: "PUT",
                 url: ["users","changeLanguage"],
                 data: JSON.stringify(caller.formView01.getData()),
                 callback: function (res) {
    	        	parent.ppmboot.modal3.callback(mData);
                 }
             });
        });  
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

var CODE = {};

// fnObj 기본 함수 스타트와 리사이즈
fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.formView01.initView();
    param = parent.ppmboot.modal3.getData();   
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
};

fnObj.pageResize = function () {

};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {  
            "save": function () {
                ACTIONS.dispatch(ACTIONS.CHANGE_PW);
            },
            "save2": function () {
                ACTIONS.dispatch(ACTIONS.CHANGE_LANG);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});




/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {
        });
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.initEvent();
    },
    initEvent: function () {
        var _this = this;
        this.model.onChange("password_change", function () {
            if (this.value == "Y") {
                _this.target.find('[data-ax-path="userPs"]').removeAttr("readonly");
                _this.target.find('[data-ax-path="userPs_chk"]').removeAttr("readonly");
            } else {
                _this.target.find('[data-ax-path="userPs"]').attr("readonly", "readonly");
                _this.target.find('[data-ax-path="userPs_chk"]').attr("readonly", "readonly");
            }
        });
        
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.   
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);
        
        data.userPs = "";
        data.password_change = "";
        this.target.find('[data-ax-path="userPs"]').attr("readonly", "readonly");
        this.target.find('[data-ax-path="userPs_chk"]').attr("readonly", "readonly");
        
        if(nvl(data.userCd,'') != ''){
            this.target.find('[data-ax-path="userCd"]').attr("readonly", "readonly");
            this.target.find('[data-ax-path="userNm"]').attr("readonly", "readonly");
       //     this.target.find('[data-ax-path="email"]').attr("readonly", "readonly");
       //     this.target.find('[data-ax-path="hpNo"]').attr("readonly", "readonly");
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
    }
});


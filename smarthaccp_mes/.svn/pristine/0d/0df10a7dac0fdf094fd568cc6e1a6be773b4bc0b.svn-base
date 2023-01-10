var fnObj = {};
var param;
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
		             url: ["programHelp"],
		             data: {progCd:param.progCd},
			         callback: function (res) {
			        	 
			        	if(res.list.length==0){
			        		 axDialog.alert({
			        	            msg: "'해당 화면에 대한 도움말은 준비중입니다. 관리자에게 문의 하세요.'"
			        	        }, function () {
			        	            if (this.key == "ok") {
			        	            	
			        	            	ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
			        	            }
			        	        });
			        		 
			                 
			        		
			        	}else{
			        		caller.formView01.setData(res.list[0]);
			        	}
		                
			         }
			 }) 
	         .done(function () {
	         });   	 
    	 
    	 
        return false;
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

fnObj.pageStart = function () {
    var _this = this;

    _this.pageButtonView.initView();
    _this.formView01.initView();
    
    param = ax5.util.param(ax5.info.urlUtil().param);
    
    if (typeof param.callBack === "undefined"){
    	param = parent.ppmboot.modal.getData();
    }else{
        param = ax5.util.param(ax5.info.urlUtil().param);
    }
    
    
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
    
};

fnObj.pageResize = function () {

};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
          
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
        return $.extend({}, ppmboot.formView.defaultData, {});
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
        
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        data.toMessage = data.smsContent;
        return $.extend({}, data);
    },
    setData: function (data) {

        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);
		searchFile(data.progCd);
		
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
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
    GO_MENU: function (caller, act, data) {
    	if(data == "M1"){
    		window.open('/jsp/pop/barcode-main.jsp', 'barcode-main','location=no, directories=no,resizable=yes,status=no,toolbar=no,menubar=no, width=1400,height=950,scrollbars=yes')
        }
    	
        ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
    param = parent.ppmboot.modal.getData();   
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
        return $.extend({}, ppmboot.formView.defaultData, {
        });
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
        	"menu1": function () {
                ACTIONS.dispatch(ACTIONS.GO_MENU,"M1");
            },
            "menu2": function () {
                ACTIONS.dispatch(ACTIONS.GO_MENU,"M2");
            },
            "menu3": function () {
                ACTIONS.dispatch(ACTIONS.GO_MENU,"M3");
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
/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 창고등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var mask;
var tempFileCd;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["whCd"],
            data: $.extend({},getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
                caller.formView01.maskOnOff("on");
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	 if (caller.formView01.validate()) {
	    	var mData = caller.formView01.getData();	    	
	    	mData.tempFileCd = tempFileCd;	        	
	    	
            ppmboot.ajax({
                 type: "PUT",
                 url: ["whCd"],
                 data: JSON.stringify(mData),
                 callback: function (res) {
                     ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                 }
             });
         }
    },    
    FORM_CLEAR: function (caller, act, data) {
        axDialog.confirm({
            msg: "신규 창고를 등록하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear();
                caller.formView01.setData({});
            }
        });
    },    
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
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
    _this.formView01.initView();

    tempFileCd = randomStringCd(20);
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
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
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
    }
});

/**
 * gridView
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
                {key: "whCd", label: "창고코드", width: 100, align: "center",formatter:function(){
                	return this.value;
                }},
                {key: "whNm", label: "창고명", width: 140, align: "center"},
                {key: "whType", label: "창고유형",width: 140},
                {key: "remark", label: "비고",width: 250},
                {key: "useYn",width: 115},  
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.whCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true}, "last");
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    maskOnOff:function(status){    	
    	if(status=="off"){
    		if(mask.status=="on"){
    			mask.close();
    		}
    	}else{
    		if(mask.status=="off"){
    			mask.open();
    		}
    	}    	
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        
        mask = new ax5.ui.mask({
            theme: "form-mask",
            target: $('#split-panel-form'),
            content: "왼쪽 창고목록 선택 또는 신규 버튼을 눌러주세요."
        });
        
        this.maskOnOff("on");        
        this.initEvent();
        
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
            },
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
        this.maskOnOff("off");
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);

        if(nvl(data.whCd,'') != ''){
        	$("#whCd").attr("readonly","readonly");
        }else{
        	$("#whCd").removeAttr("readonly");        	
        }
        
        searchFile(nvl(data.whCd,tempFileCd));
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
        this.maskOnOff("off");
        this.model.setModel(this.getDefaultData());
    },
    setDefaultCust:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
    },
});
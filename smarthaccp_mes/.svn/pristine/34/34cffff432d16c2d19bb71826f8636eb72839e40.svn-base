/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 권한마스터
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

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
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["authGroup", "group"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res); 	
                caller.gridView02.setData([]);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {
            var mData = caller.formView01.getData();            
            var dData = [].concat(caller.gridView02.getData("modified"));
            dData = dData.concat(caller.gridView02.getData("deleted"));
            dData.forEach(function (n) {
                n.company = mData.company;
                n.grpAuthCd = mData.grpAuthCd;
            });
            ppmboot
                .call({
                    type: "PUT", 
                    url: ["authGroup", "group"], 
                    data: JSON.stringify(mData),
                    callback: function (res) {                    	
                    }
                })
                .call({
                    type: "PUT", 
                    url: ["authGroup", "user"], 
                    data: JSON.stringify(dData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");

                    if(nvl(mData.grpAuthCd,'') == ''){
                    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                    }
                });
        }
    },
    ITEM_ADD: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear();
                caller.gridView02.clear();
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url:  ["authGroup", "authUser"],
            data: {company:data.company, grpAuthCd:data.grpAuthCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
    },
    USER_MODAL: function (caller, act, data) {
    	customModal.open({
            width: 1100,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/USER-SEL-M.jsp", 
                param: "callBack=customUserModalCallback&gridNm=gridView02"
            }
        });   
    },    
    USER_REMOVE: function (caller, act, data) {
        caller.gridView02.delRow("selected");
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
    _this.gridView02.initView();
    _this.formView01.initView();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    $("#company").change(function(){ 
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }); 
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
        return $.extend({}, ppmboot.formView.defaultData, {defaultYn:"N"});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
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
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
    }
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
                {key: "company"},
                {key: "grpAuthCd", label: "권한코드", width: 150, align: "center"},
                {key: "grpAuthNm", label: "권한명", width: 200, align: "left"},
                {key: "defaultYn", label: "기본권한", width: 79, align: "center"},
                {key: "useYn", width: 70}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_MAIN_DEL);
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.userCd;
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
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "userCd", label: "사용자ID", width: 100, align: "center"},
                {key: "userNm", label: "사용자명", width: 100, align: "left"},      
                {key: "deptCd"},      
                {key: "email", label: "메일주소", width: 200},
                {key: "useYn", label: "사용여부", width: 200, editor: "checkYn",styleClass: "grid-cell-blue"},    
                {key: "remark", label: "비고", width: 246, align: "left", editor: "text",styleClass: "grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.USER_MODAL);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.USER_REMOVE);
            }
        });
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.userCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function (data) {    	
        this.target.addRow({__created__: true,userCd:data.userCd,userNm:data.userNm,email:data.email,deptCd:data.deptCd,useYn: "Y"}, "last");
    }
});

function customUserModalCallback(item){
    var list = fnObj.gridView02.getData();     
    var addYn = "Y";
    list.forEach(function (n) {
    	if(n.userCd == item.userCd){
    		addYn = "N";
    		return false; 
    	}
    });
    if(addYn == "Y"){
		fnObj.gridView02.addRow(item);		
    }
}
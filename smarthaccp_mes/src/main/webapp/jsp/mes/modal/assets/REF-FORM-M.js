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
        ppmboot.ajax({
            type: "GET",
            url: [param.actionType,"refFormList"],
	        data: {slipCd: param.slipCd},
            callback: function (res) {               	
                caller.gridView01.setData(res);
            	if (res.list.length == 0) {
                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            	}
            }
        });
        return false;
    },    
    PAGE_CHOICE: function (caller, act, data) {    	
        var list = caller.gridView01.getData("selected");
        if (list.length > 0) {
        	ppmboot.ajax({
            	type: "PUT", 
            	url: ["refStatus","updateFormStatus"], 
            	data: JSON.stringify(list),
                callback: function (res) {       
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                	axDialog.alert("종결처리 완료 되었습니다.닫기를 눌러주세요");
                }
            });
        } else {
            alert(LANG("ax.script.requireselect"));
        }
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
    _this.gridView01.initView();
    
    param = ax5.util.param(ax5.info.urlUtil().param);
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
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});


/**
 * gridView01	양식목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            showRowSelector: true,
            multipleSelect: true, 
            multiSort: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "refSlipCd", label: "번호"},
                {key: "updatedAt"},
                {key: "updatedBy"},
            ],
            body: { 
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.refSlipCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
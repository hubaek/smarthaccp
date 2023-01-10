/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공통코드 관리
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
            url: ["basic", "master"], 
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) { 
            	console.log(res);
                caller.gridView01.setData(res);
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
                n.mainCd = mData.mainCd;
            });
            ppmboot
            .call({
                type: "PUT", url: ["basic", "master"], data: JSON.stringify([mData]),
                callback: function (res) {                    	
                }
            })
            .call({
                type: "PUT", url: ["basic", "detail"], data: JSON.stringify(dData),
                callback: function (res) {
                }
            })
            .done(function () {
                axToast.push("저장 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
            	caller.formView01.setManageUser(SCRIPT_SESSION);
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url:  ["basic", "detail"],
            data: {mainCd:data.mainCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
    },
    ITEM_SUB_ADD: function (caller, act, data) {
    	var dData = caller.gridView01.getData("selected");
    	if(dData.length > 0){    		
        	caller.gridView02.addRow();
    	}else{
    		axDialog.alert({
                theme: "warning",
                msg: "대상을 선택하세요."
    		});
    		return false;
    	}
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
    },    
    //담당자
    USER_MODAL_OPEN: function (caller, act, data) {    	
    	caller.formView01.setManageUser({});
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/USER-ONE-M.jsp",
                param: "callBack=customUserModalCallback"
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
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.formView01.initView();

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
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "user_modal": function () {
        		ACTIONS.dispatch(ACTIONS.USER_MODAL_OPEN)
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

        this.target.find('[data-ax-path="mainCd"]').attr("readonly", "readonly");
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
        this.target.find('[data-ax-path="mainCd"]').removeAttr("readonly");
    },
    setManageUser:function(data){
        this.model.set("userCd", data.userCd);
        this.model.set("userNm", data.userNm);
    },
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
                {key: "mainCd", label: "대분류코드", width: 320, align: "center"},
                {key: "mainNm", label: "대분류명", width: 327, align: "left"},
           //     {key: "pgModuleCd"},
           //     {key: "cdType"},
               // {key: "useYn"}
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
                return this.subCd;
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
                {key: "subCd", label: "소분류코드", width: 100, align: "center", editor: "text",styleClass: "grid-cell-blue"},
                {key: "subNm", label: "소분류명(KO)", width: 120, align: "left", editor: "text",styleClass: "grid-cell-blue"},      
              //  {key: "subNmEn", label: "소분류명(EN)", width: 120, align: "left", editor: "text",styleClass: "grid-cell-blue"},      
              //  {key: "subNmZh", label: "소분류명(CHS)", width: 120, align: "left", editor: "text",styleClass: "grid-cell-blue"},     
                {key: "sort", label: "정렬", editor: "number",styleClass: "grid-cell-blue"},  
                {key: "useYn", label: "사용여부", editor: "checkYn",styleClass: "grid-cell-blue"},        
                {key: "remark", label: "비고", width: 150, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "data1", label: "Option1", width: 70, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "data2", label: "Option2", width: 70, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "data3", label: "Option3", width: 70, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "data4", label: "Option4", width: 70, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "data5", label: "Option5", width: 70, align: "left", editor: "text",styleClass: "grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            }
        });
        //엑셀 붙여넣기
       document.getElementById("gridView02").addEventListener('paste', function(e){
    	   handlePasteGridView(e, fnObj.gridView02.target, "Y");  	//event ,target, addYn 
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
                return this.subCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function () {    	
        this.target.addRow({__created__: true, useYn: "Y"}, "last");
    }
});
//사용자 목록조회
function customUserModalCallback(data){
	fnObj.formView01.setManageUser(data);
	customModal.close();
}

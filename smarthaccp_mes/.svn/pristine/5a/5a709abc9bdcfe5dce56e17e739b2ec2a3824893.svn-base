/**
 * 0. Project	: 스마트HACCP CMMS
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일	: 2020.01.06
 * 3. Comment 	: 품목분류관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["item", "itemMain"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
                caller.formView01.clear();
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {        	
        	
            var mData = caller.formView01.getData();
            var dData = [].concat(caller.gridView02.getData("modified"));
            dData = dData.concat(caller.gridView02.getData("deleted"));
            
            /*                  
			20.07.13 김재민 
			신규 formView 와 gridView02가 함께 저장 되게끔 수정
            */
            ppmboot.ajax({
                    type: "PUT", 
                    url: ["item", "itemMain"],
                    data: JSON.stringify(mData),
                    callback: function (res) {
                    	dData.forEach(function (n){
                    		n.company = res.company;
                            n.itemMainCd = res.itemMainCd;
                    	}); 
                    	ppmboot.ajax({
                    		type: "PUT", 
                            url: ["item", "itemSub"],
                            data: JSON.stringify(dData),
                            callback:function(){ 
                            	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                            }
                    	});
                    }
                });
        }
    },
    PAGE_DELETE: function (caller, act, data) {
    	var dData = caller.gridView01.getData("selected");
    	
    	if(dData.length > 0){
        	axDialog.confirm({
                theme: "danger",
                msg: "품목분류를 '삭제'하시겠습니까?"
            }, function () {
            	if(this.key == "ok"){
           	        ppmboot.ajax({
           	        	type: "DELETE", 
                        url: ["item", "itemMain"],
           	        	data: JSON.stringify(dData[0]),
           	            callback: function (res) {     	
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH); 
           	            }
           	        });	  
                }
            });
    	}else{
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
    	}
    },
    ITEM_ADD: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear();
                caller.gridView02.clear();
                caller.formView01.setData({});
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url: ["item", "itemSub"],
            data:{company:data.company,itemMainCd:data.itemMainCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
    },
    ITEM_SUB_ADD: function (caller, act, data) {
        var mData = caller.formView01.getData();
    	caller.gridView02.addRow(mData);
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
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
            "del": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_DELETE);
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
                //{key: "itemMainCd", label: "대분류코드", width: 100, align: "center"},
                {key: "itemMainNm", label: "대분류명", width: 260, align: "left"},           
                {key: "sort", label: "정렬", width: 140, align: "right", formatter:"number"},          
                {key: "useYn", width: 179, label: "사용여부"}, 
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
                return this.itemMainCd;
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
                //{key: "itemSubCd", label: "소분류코드", width: 90, align: "center"},
                {key: "itemSubNm", label: "소분류명", width: 260, align: "left", editor: "text",styleClass: "grid-cell-blue"},      
                {key: "sort", label: "정렬", width: 100, editor: "number",styleClass: "grid-cell-blue", align: "right", formatter:"number"},  
                {key: "useYn", width: 100, label: "사용여부", editor: "checkYn",styleClass: "grid-cell-blue"},   
                {key: "remark", label: "비고", width: 465, align: "left", editor: "text",styleClass: "grid-cell-blue"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
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
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.itemSubCd,randomStringCd(20));
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
        this.target.addRow({__created__: true, useYn: "Y"}, "last");
    }
});
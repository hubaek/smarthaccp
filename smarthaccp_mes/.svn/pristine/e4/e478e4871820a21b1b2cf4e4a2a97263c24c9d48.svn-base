/**
 * 0. Project	: KOMICO CMMS
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 권한별메뉴
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
            url: ["authGroup", "group"],
            data: $.extend({useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {       
                caller.gridView01.setData(res); 	
                caller.gridView02.setData([]);
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
    	if(mData.length == 0 ){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
    	}else{
    		var dData = [].concat(caller.gridView02.getData("modified"));
            dData = dData.concat(caller.gridView02.getData("deleted"));
            
            dData.forEach(function (n) {
                n.company = mData[0].company;
                n.grpAuthCd = mData[0].grpAuthCd;
            });
            
            ppmboot
                .call({
                    type: "PUT", 
                    url: ["menu", "auth"],
                    data: JSON.stringify(dData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
                });
    	}
    },
    ITEM_CLICK: function (caller, act, data) {    	
    	var dData = caller.gridView01.getData("selected");
    	
    	if(dData.length == 0 ){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
    	}else{
    		data = dData[0];
    		
    		var menuGrpCd = $("#menuGrpCd").val();    	
        	
        	ppmboot.ajax({
                type: "GET",
                url:  ["authGroup", "authMenu"],
                data: {company:data.company, grpAuthCd:data.grpAuthCd,menuGrpCd:menuGrpCd},
                callback: function (res) {
                    caller.gridView02.setData(res);
                }
            });
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
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);

    $("#company").change(function(){ 
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }); 


    $("#menuGrpCd").change(function(){ 
    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
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

//== view 시작
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
                {key: "company"},
                {key: "grpAuthCd", label: "권한코드", width: 150, align: "center"},
                {key: "grpAuthNm", label: "권한명", width: 200, align: "left"},
                {key: "defaultYn", label: "기본권한", width: 69, align: "center"},
                {key: "useYn"}
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
                return this.grpAuthCd;
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
                {key: "menuNm", label: "메뉴명", width: 225},
                {key: "useYn", label: "사용", width: 70, editor: "checkYn"},
                {key: "schAh", label: COL("ax.admin.menu.auth.inquery"), width: 70, align: "center"
                	, editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.schAhProg,'N') == "N";
                    }}},
                {key: "savAh", label: COL("ax.admin.menu.auth.save"), width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.savAhProg,'N') == "N";
                    }}},
                {key: "exlAh", label: COL("ax.admin.menu.auth.excel"), width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.exlAhProg ,'N') == "N";
                    }}},
                {key: "delAh", label: COL("ax.admin.menu.auth.delete"), width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.delAhProg,'N') == "N";
                    }}},
                {key: "fn1Ah", label: "FN1", width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.fn1AhProg,'N') == "N";
                    }}},
                {key: "fn2Ah", label: "FN2", width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.fn2AhProg,'N') == "N";
                    }}},
                {key: "fn3Ah", label: "FN3", width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.fn3AhProg,'N') == "N";
                    }}},
                {key: "fn4Ah", label: "FN4", width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.fn4AhProg,'N') == "N";
                    }}},
                {key: "fn5Ah", label: "FN5", width: 70, align: "center", editor :{ type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
                    disabled: function disabled() {
                        return nvl(this.item.fn5AhProg,'N') == "N";
                    }}},
            ],
            body: {
                onClick: function () {
                }
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
                return this.menuCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
});
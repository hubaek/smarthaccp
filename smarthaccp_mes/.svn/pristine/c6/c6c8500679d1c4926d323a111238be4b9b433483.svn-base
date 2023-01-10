/**
 * 0. Project	: HACCP MES
 * 1. 작성자  	: 윤광준
 * 2. 작성일		: 2020.07.09
 * 3. Comment 	: 한계기준정보
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "LMT000M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["limit"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "add"
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });
    },    
    //수정
    MOD_FORM: function (caller, act, data) {
    	var list =  caller.gridView01.getData("selected");
    	if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
        	ppmboot.modal.open({  
                modalType: MODAL_NAME,
                param: "",
                sendData: function(){
                    return {
                    	"mode" : "mod",
                    	"company" : list[0].company,
                    	"prcsslmtId" : list[0].prcsslmtId,
                    };
                },
                callback: function (data) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });	 
        }
    },    
    //상세
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"prcsslmtId" : data.prcsslmtId,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
        });
    }
});

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
	 getDefaultData: function () {
	        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $(document["searchView0"]);
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작	
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
    },
    setDefaultRout:function(data){
        this.model.set("routCd", data.routCd);
        this.model.set("routNm", data.routNm);
        $("#hiddenRoutCd").val(data.routCd);
    },
});

/**
 * gridView01	한계기준목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                 {key: "prcsslmtId", label: "한계기준ID", width:200, align: "center",formatter:function(){
                 	return this.value;
                 }},
                 {key: "prcsslmtNm", label: "한계기준명", width: 200, formatter:function(){
                  	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                 }},
                 {key: "prcsslmtSgn", label: "한계기준단위", width: 100, align: "center"},
                 {key: "prcsslmtMin", label: "한계기준범위최저값", width: 200, align: "center"},
                 {key: "prcsslmtMax", label: "한계기준범위최고값", width: 200, align: "center"},
                 {key: "remark", label: "비고", width: "*", align: "left"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "prcsslmtNm") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}
                },
		        onDBLClick: function () {
		            this.self.select(this.dindex);
		        	if(this.column.key == "prcsslmtNm") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}
		        },
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                list.push(this.company);
                list.push(this.routCd);
                list.push(this.prcsslmtId);
                return list;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 센서정보등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *								
 */
var fnObj = {};
var MODAL_NAME = "SNSR000M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {
       
		ppmboot.ajax({
            type: "GET",
            url: ["snsr"],
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
                    	"snsrId" : list[0].snsrId,
                    	"routCd" : list[0].routCd,
                    };
                },
                callback: function (data) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });	 
        }
    },    
    //조회
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"snsrId" : data.snsrId,
                	"routCd": data.routCd,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("센서정보.xls");
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
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
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
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작	
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
    },
    setDefaultRout:function(data){
        this.model.set("routCd", data.routCd);
        this.model.set("routNm", data.routNm);
        $("#hiddenRoutCd").val(data.routCd);
    }
});

/**
 * gridView01	설비정보목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                 {key: "snsrId", label: "센서ID", width:80, align: "center"},
                 {key: "snsrCd", label: "센서코드", width:100, align: "center"},
                 {key: "snsrNm", label: "센서명", width: 200, formatter:function(){
                  	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                 }},
                 {key: "snsrMdlNm", label: "센서모델명", width: 200, align: "left"},
                 {key: "snsrMnf", label: "제조사", width: 150, align: "left"},
                 {key: "snsrUsg", label: "센서용도", width: 200, align: "left"},
                 {key: "snsrPrdDt", label: "구매일", width: 100, align: "center"},
                 {key: "snsrInsDt", label: "설치일", width: 100, align: "center"},
                 {key: "snsrDataFrm", label: "수집데이터속성", width: 100, align: "center"},
                 {key: "remark", label: "비고", width: 230, align: "left"},
            ],
            body: {
            	onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "snsrNm") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "snsrNm") {
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
            	list.push(this.snsrId);
            	list.push(this.prcssId);
            	return list;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
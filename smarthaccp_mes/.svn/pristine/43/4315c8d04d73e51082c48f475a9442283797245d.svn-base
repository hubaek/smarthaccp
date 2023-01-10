/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 품목정보등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "ITEM100M";

var ACTIONS = ppmboot.actionExtend(fnObj, {	
	PAGE_SEARCH: function (caller, act, data) {		
    	ppmboot.ajax({
            type: "GET",
            url: ["item"],
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
                    	"itemCd" : list[0].itemCd,
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
                	"itemCd" : data.itemCd,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },   
    //엑셀 다운로드
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("품목마스터관리_"+getNowDt()+".xls");
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
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
    }
});

/**
 * gridView01 품목정보
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
                 {key: "itemCd"},
                 {key: "itemNm", width: 200, formatter:function(){
                 	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                 }},
                 //{key: "partNo"},   
                 {key: "itemType"},   
				 {key: "itemMainNm", width: 250},
				 {key: "itemSubNm", width: 180},
                 {key: "spec", width: 160},   
                 {key: "unit"},
                 //{key: "saAmt"},
                 //{key: "bomUnit"},
                 //{key: "pcAmt"},
                 //{key: "lotYn"},
                 {key: "expirationDate", label : "유통기한", width: 140, align:"center"},
                 {key: "remark", label : "비고", width: 333, align:"center"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    
                    if(this.column.key == "itemNm") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                	}
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "itemNm") {
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
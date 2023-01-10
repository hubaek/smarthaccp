/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: BOM등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};   
var MODAL_NAME = "BOM010M";

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
    	ppmboot
        .call({
            type: "GET",
            url:  ["bom", "bomMasterList"],
            data: $.extend({itemTypeGroup:"P"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        }) 
        .call({
        	type: "GET",
        	url: ["bom", "bomListAll"],
        	data: $.extend({}, getSerializeArrayToJson("#searchView0")),
        	callback: function (res){
        		caller.gridView03.setData(res);
        	}
        })
        .done(function () {
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
                    	"revisionNo" : list[0].revisionNo,
                    	"revisionYn" : data,
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
    	var list =  caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : list[0].company,
                	"itemCd" : list[0].itemCd,
                	"revisionNo" : list[0].revisionNo,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
        .call({
            type: "GET",
            url:  ["bom", "bomDetailList"],
            data: {company:data.company,itemCd:data.itemCd,revisionNo:data.revisionNo},
            callback: function (res) {
                caller.gridView02.setData(res);
            }    
        })
        .done(function () {
            
        });
    },
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView03.target.exportExcel("BOM_리스트.xls");
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
    _this.gridView03.initView();
    
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
            "excel":function (){
            	ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            },
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM,"N");
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM,"Y");
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
    }
});


/**
 * gridView01	품목정보목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "itemCd"},
                {key: "itemNm", width: 300, formatter:function(){
                	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "revisionNo"},
//                {key: "partNo"},
                {key: "itemType"},
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},
                {key: "unit"},
                {key: "bomCnt",width: 80, label: "BOM(수)", formatter:"number", align: "right"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key != "itemNm") {
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    }
                    if(this.column.key == "itemNm") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}
                },
		        onDBLClick: function () {
		            this.self.select(this.dindex);
		        	/*if(this.column.key == "itemNm") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}*/
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
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
//                {key: "partNo"},
                {key: "spec"},
                {key: "unit"}, 
				{key: "bomUnit"},
                {key: "bomQty",label:"소요량",width:80, align: "right",formatter:"number"},  
                {key: "lossPer",label:"LOSS(%)",width:80, align: "right",formatter:"number"}, 
                {key: "lossQty",label:"LOSS",width:80, align: "right",formatter:"number"},                  
                {key: "reqQty",label:"총소요량",width:80, align: "right",formatter:"number"},     
                {key: "routCd"},
                {key: "useYn"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                },
            }
        });        
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
});
/**
 * gridView03	품목정보목록
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [  
                {key: "parentItemCd", label:"품목 코드"},
                {key: "parentItemNm", width: 300, label:"품목명"},
                {key: "itemType", width: 300, label:"품목 유형"},
                {key: "itemMainNm", width: 300, label:"품목 대분류"},
                {key: "itemSubNm", width: 300, label:"품목 소분류"},
                {key: "parentSpec", width: 300, label:"규격"},
                {key: "parentUnitNm", width: 300, label:"수불단위"},
                {key: "itemCd", width: 300, label:"BOM 품목 코드"},
                {key: "itemNm", width: 300, label:"BOM 품목명"},
                {key: "spec", width: 300, label:"BOM 규격"},
                {key: "unitNm", width: 300, label:"BOM 수불단위"},
                {key: "bomUnit", width: 300, label:"BOM 소요단위"},
                {key: "bomQty", width: 300, label:"소요량"}
            ],
            body: { 
                onClick: function () {
                },
		        onDBLClick: function () {
		            this.self.select(this.dindex);
		        	/*if(this.column.key == "itemNm") {
		                ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
		        	}*/
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

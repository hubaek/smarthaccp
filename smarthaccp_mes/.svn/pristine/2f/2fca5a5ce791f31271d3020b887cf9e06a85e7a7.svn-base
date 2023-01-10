/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 품목별 공정상세현황 
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var tempFileCd;
var mask;

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
            url: ["item","getRoutingItemList"],
            data: $.extend({itemTypeGroup:"P",routingYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
                caller.gridView03.setData([]);
            }
        })   
        .done(function () {
        });
    },        
    ITEM_CLICK: function (caller, act, data) {
    	
    	ppmboot
        .call({
            type: "GET",
            url: ["rout","routItemInfo"],
            data: {company:data.company,itemCd:data.itemCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }    
        })
        .call({
            type: "GET",
            url:  ["bom", "bomDetailList"],
            data: {company:data.company,itemCd:data.itemCd},
            callback: function (res) {
                caller.gridView03.setData(res);
            }    
        })
        .done(function () {
            
        });
    },
    PAGE_SAVE: function (caller, act, data) {    	
        var bData = [].concat(caller.gridView02.getData("modified"));   
        ppmboot.ajax({
        	type: "PUT",
            url: ["rout","routItemInfo"],
        	data: JSON.stringify(bData),
            callback: function (res) {         
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
 * gridView01	품목정보목록
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
                {key: "itemNm"},
                //{key: "partNo"},       
                {key: "itemType"},   
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},              
                {key: "unit"},
                {key: "qcWay"},
				{key: "routingCd", formatter: function formatter() { return CONVERT_CODE["ROUTING_CD"].map[this.value];}},
                {key: "whCd" , label:"기본창고"},
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});

/**
 * gridView02	공정절차
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: false, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "routingNm"},
                {key: "routSeq"},
                {key: "routCd"},      
                {key: "cycleTime",label:"C/T",formatter:"number",align: "right", width:80, editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "cavity",label:"CAVITY",formatter:"number",align: "right", width:80, editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "routUnitAmt",label:"공정단가",formatter:"number",align: "right", width:80, editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "remark",label: "비고",width: 200,editor: {type: "text"},styleClass: "grid-cell-blue"},              
            ],  
            body: { 
                onClick: function () {  
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
            "rout-all": function () {
                ACTIONS.dispatch(ACTIONS.ROUT_SELECT_MODAL_OPEN);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ROUT_DEL);
            },
            "item-copy": function () {
           	 	ACTIONS.dispatch(ACTIONS.ROUT_COPY_OPEN);
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.routSeq;
            });
        } else {
            list = _list;
        }
        
        return list;
    },
});



/**
 * gridView03
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "itemCd"},
                {key: "itemNm"},
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
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.bomSeq;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    }
});
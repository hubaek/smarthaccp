/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: BOM라우팅 적용 팝업
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
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
    	ppmboot
        .call({
            type: "GET",
            url: ["item"],
            data: $.extend({itemTypeGroup:"P",useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
            }
        })   
        .done(function () {
        }); 
    },
    ITEM_CLICK: function (caller, act, data) {
     	ppmboot
         .call({
             type: "GET",
             url:  ["bom", "bomRoutingDetailList"],
             data: {itemCd:data.itemCd},
             callback: function (res) {
                 caller.gridView02.setData(res);
             }    
         })        
         .done(function () {
         });    	
    },
    PAGE_CHOICE: function (caller, act, data) {
    	var list = caller.gridView02.getData("selected");
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list);
        	}else{        		
        		parent[param.callBack](list);
        	}
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
    ppmboot
    .call({
        type: "GET",
        url: ["rout","routingMaster"],
        data: {useYn: "Y"},
        callback: function (res) {
        	res.list.forEach(function (n) {   
    			n.subCd = n.routingCd;   
    			n.subNm = n.routingNm;
    		});            	
            this.ROUTING_CD = res.list;
        }
    })  
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();    
        _this.gridView02.initView();    

        param = ax5.util.param(ax5.info.urlUtil().param);
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
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "bomLv", label: "레벨", width: 50, align: "center"},
				{key: "routingNm"},
                {key: "routSeq",label:"공정순서",formatter:"number",align: "right", width:80},
				{key: "routCd"},
                {key: "itemCd"},
                {key: "itemNm", width:200, align: "left"},
                //{key: "partNo"},
                {key: "spec"},
                {key: "unit"},            
                {key: "reqQty",label:"총소요량",width:80, align: "right",formatter:"number"},        
            ],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
		        }
            }
        });
        

        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "add-order": function () {
                ACTIONS.dispatch(ACTIONS.ADD_ORDER);
            },  
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
                return this.tempOrderNo && this.tempOrderNo;
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
